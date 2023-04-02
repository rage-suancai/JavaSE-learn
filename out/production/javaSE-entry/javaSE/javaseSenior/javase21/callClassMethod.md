调用类方法

我们可以通过反射来调用类的方法(本质上还是类的实例进行调用)只是利用反射机制实现了方法的调用 我们在包下创建一个新的类:

                    package com.test;

                    public class Student {

                        public void test(String str){
                            System.out.println("萨日朗" + str);
                        }

                    }

这次我们通过forName(String)来找到这个类并创建一个新的对象:

                    public static void main(String[] args) throws ReflectiveOperationException {

                        Class<?> clazz = Class.forName("com.test.Student");
                        Object instance = clazz.newInstance(); // 创建出学生对象
                        Method method = clazz.getMethod("test", String.class); // 通过方法名和形参类型获取类中的方法
                        
                        method.invoke(instance, "what's up"); // 通过Method对象的invoke方法来调用方法

                    }

通过调用getMethod()方法 我们可以获取到类中所有声明为public的方法 得到一个Method对象
我们可以通过Method对象的invoke()方法(返回值就是方法的返回值 因为这里是void 返回值为null)来调用已经获取到的方法 注意传参:

我们发现 利用反射之后 在一个对象从构造到方法调用 没有任何一处需要引用到对象的实际类型 我们也没有导入Student类
整个过程都是反射在代替进行操作 使得整个过程被模糊了 过多的使用反射 会极大地降低后期维护性:

同构造方法一样 当出现非public方法时 我们可以通过反射来无视权限修饰符 获取非public方法并调用 现在我们将test()方法的权限修饰符改为private:

                    public static void main(String[] args) throws ReflectiveOperationException {

                        Class<?> clazz = Class.forName("com.test.Student");
                        Object instance = clazz.newInstance(); // 创建出学生对象
                        Method method = clazz.getDeclaredMethod("test", String.class); // 通过方法名和形参类型获取类中的方法
                        method.setAccessible(true);
                    
                        method.invoke(instance, "what's up"); // 通过Method对象的invoke方法来调用方法

                    }

Method和Constructor都和Class一样 他们存储了方法的信息 包括方法的形式参数列表, 返回值, 方法的名称等内容 我们可以直接通过Method对象来获取这些信息:

                    public static void main(String[] args) throws ReflectiveOperationException {

                        Class<?> clazz = Class.forName("com.test.Student");
                        Method method = clazz.getDeclaredMethod("test", String.class); // 通过方法名和形参类型获取类中的方法
                        
                        System.out.println(method.getName()); // 获取方法名称
                        System.out.println(method.getReturnType()); // 获取返回值类型

                    }

当方法的参数为可变参数时 我们该如何获取方法呢? 实际上 我们在之前就已经提到过 可变参数实际上就是一个数组 因此我们可以直接使用数组的class对象表示:

                    Method method = clazz.getDeclaredMethod("test", String[].class);

反射非常强大 尤其是我们提到的越权访问 但是请一定谨慎使用 别人将某个方法设置为private一定有他的理由 如果实在是需要使用别人定义为private的方法
就必须确保这样做是安全的 在没有了解别人代码的整个过程就强行越权访问 可能会出现无法预知的错误