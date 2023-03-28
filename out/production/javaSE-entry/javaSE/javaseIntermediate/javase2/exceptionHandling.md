异常的处理

当程序没有按照我们想要的样子运行而出现异常时(默认会交给JVM来处理 JVM发现任何异常都会立即终止程序运行 并在控制台打印栈追踪信息)
我们希望能够自己处理出现的问题 让程序继续运行下去 就需要对异常进行捕获 比如:

                 int[] arr = new int[5];
                 arr[5] = 1; // 我们需要处理这种情况 保证后面的代码正常运行
                 System.out.println("yxsnb");

我们可以使用 try 和 catch 语句来来处理:

                 int[] arr = new int[5];
                 try{ // 在try块中运行代码
                     arr[5] = 1; // 当代码出现异常时 异常会被捕获 保证后面的代码正常运行
                 } catch (ArrayIndexOutOfBoundsException e) { // 捕获的异常类型
                     System.out.println("线程运行出现异常") // 出现异常时执行
                 }

                 System.out.println("yxsnb"); // 后面的代码会正常运行

当异常被捕获后 就由我们自己进行处理(不再交给JVM处理) 因此就不会导致程序终止运行

我们可以通过使用e.printStackTrace()来打印栈追踪信息 定位我们的异常出现位置:

                 java.lang.ArrayIndexOutOfBoundsException: 5
                 	at javaSE.javase2.Main.main(Main.java:31) // Main类的第31行出现问题
                 线程运行出现异常
                 yxsnb

运行时异常在编译时可以不用捕获 但是编译时异常必须进行处理:

                 File file = new File("my.txt");
                 try {
                     file.createNewFile();
                 } catch (IOException e) { // 捕获声明的异常类型
                     e.printStackTrace();
                 }

可以捕获到类型不止是Exception的子类 只要是继承自Throwable的类 都能被捕获 也就是说 Error也能被捕获 但是不建议这样做 因为错误一般是虚拟机相关的问题 出现Error应该从问题的根源去解决