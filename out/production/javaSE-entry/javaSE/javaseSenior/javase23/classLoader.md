类加载器

我们接着来介绍一下类加载器 实际上类加载器就是用于加载一个类的 但是类加载器并不是只有一个

思考: 既然说Class对象和加载的类唯一对应 那如果我们手动创建一个与JDK包名一样 同时类名也保持一致 JVM会加载这个类吗?

                    package java.lang;

                    public class String { // JDK提供的String类也是

                        public static void main(String[] args) {
                            System.out.println("我姓🐴 我叫🐴nb");
                        }

                    }

我们发现 会出现以下报错:

                    错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
                    public static void main(String[] args)

但是我们明明在自己写的String类中定义了main方法啊 为什么会找不到此方法呢? 实际上这是ClassLoader的双亲委派机制在保护Java程序的正常运行:

        https://fast.itbaima.net/2022/10/04/5p6jdXDA8VtCEfN.png

实际上类最开始是由BootstarpClassLoader进行加载 BootstarpClassLoader用于加载JDK提供的类 而我们自己编写的类实际上是AppClassLoader加载的
只有BootstarpClassLoader都没有加载的类 才会让AppClassLoader来加载 因此我们自己编写的同名包同名类不会被加载 而实际要去启动的是真正的String类 也就自然找不到main方法:

                    public class Main {

                        public static void main(String[] args) {

                            System.out.println(Main.class.getClassLoader()); // 查看当前类的类加载器
                            System.out.println(Main.class.getClassLoader().getParent()); // 父加载器
                            System.out.println(Main.class.getClassLoader().getParent().getParent()); // 爷爷加载器
                            System.out.println(String.class.getClassLoader()); // String类的加载器

                        }

                    }


