文件字符流

字符流不同于字节 字符流是以一个具体的字符进行读取 因此它只适合读纯文本的文件 如果是其他类的文件不适用:

                     try(FileReader reader = new FileReader("javase26.test.txt")) {
                         reader.skip(1); // 现在跳过的是一个字符
                         System.out.println((char) reader.read()); // 现在是按字符进行读取 而不是字节 因此可以直接读取到中文字符
                     } catch (IOException e) {
                         e.printStackTrace();
                     }

同理 字符流只支持char[]类型作为存储:

                     try (FileReader reader = new FileReader("javase26.test.txt")) {
                         char[] str = new char[10];
                         reader.read(str);
                         System.out.println(str); // 直接读取到char[]中
                     } catch (IOException e) {
                         e.printStackTrace();
                     }

既然有了Reader肯定也有Writer:

                     try (FileWriter writer = new FileWriter("output.txt")) {
                         writer.getEncoding(); // 支持获取编码(不同的文本文件可能会有不同的编码类型)
                         writer.write('牛');
                         writer.write('牛'); // 其实功能和writer一样
                         writer.flush(); // 刷新
                     } catch (IOException e) {
                         e.printStackTrace();
                     }

我们发现不仅有writer()方法 还有一个append()方法 但是实际上他们效果一样的 看源码:

                     public Writer append(CharSequence csq) throws IOException {
                         if (csq == null)
                             write("null");
                         else
                             write(csq.toString());
                         return this;
                     }

append()支持SpringBuilder那样的链式调用 返回的是Writer对象本身

练习: 尝试一下用Reader和Writer来拷贝纯文本文件

这里需要额外介绍一下File类 它是专门用于表示一个文件或文件夹 只不过它只是代表这个文件 但并不是这个文件本身 通过File对象 可以更好地管理和操作硬盘上的文件:

                    public static void main(String[] args) {

                        File file = new File("test.txt"); // 直接创建文件对象 可以是相对路径 也可以是绝对路径
                        System.out.println(file.exists()); // 此文件是否存在
                        System.out.println(file.length()); // 获取文件的大小
                        System.out.println(file.isDirectory()); // 是否为一个文件夹
                        System.out.println(file.canRead()); // 是否可读
                        System.out.println(file.canWrite()); // 是否可写
                        System.out.println(file.canExecute()); // 是否可执行

                    }

通过File对象 我们就能快速得到文件的所有信息 如果是文件夹 还可以获取文件夹内部的文件列表等内容:

                    File file = new File("/");
                    System.out.println(Arrays.toString(file.list())); // 快速获取文件夹下的文件名称列表
                    for (File f : file.listFiles()){ // 所有子文件的File对象
                        System.out.println(f.getAbsolutePath()); // 获取文件的绝对路径
                    }

如果我们希望读取某个文件的内容 可以直接将File作为参数传入字节流或是字符流:

                    File file = new File("test.txt");
                    try (FileInputStream inputStream = new FileInputStream(file)){ // 直接做参数
                        System.out.println(inputStream.available());
                    }catch (IOException e){
                        e.printStackTrace();
                    }

练习: 尝试拷贝文件夹下的所有文件到另一个文件夹