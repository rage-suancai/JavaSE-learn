反射

注意: 本章节涉及到JVM相关底层原理 难度会有一些大

反射就是把Java类中的各个成分映射成一个个的Java对象 即在运行状态中 对于任意一个类 都能知道这个类的所有属性和方法 对于任意一个对象
都能调用它的任意一个方法和属性 都能调用它的任意一个方法和属性 这种动态获取信息及动态调用对象方法的功能叫Java的反射机制

简而言之 我们可以通过反射机制 获取到类的一些属性 包括类里面有哪些字段 有哪些方法 继承自哪个类 甚至还能获取到泛型 它的权限非常高 慎重使用

Java类加载机制

在学习Java的反射机制之前 我们需要先了解一下类的加载机制 一个类是如何被加载和使用的:

        https://fast.itbaima.net/2022/10/04/vZ4onhuJWcALHNP.png

在Java程序启动时 JVM会将一部分类(class文件)先加载(并不是所有的类都会在一开始加载) 通过ClassLoader将类加载 在加载过程中 会将类的信息提取出来
(存放在元空间中 JDK1.8之前存放在永久代) 同时也会生成一个Class对象存放在内存(堆内存) 注意: 此Class对象只会存在一个 与加载的类唯一对应

为了方便各位小伙伴理解 你们就直接理解为默认情况下(仅使用默认类加载器) 每类都有且只有一个唯一的Class对象存放在JVM中
我们无论通过什么方式访问 都是始终是那一个对象 Class对象中包含我们类的一些信息 包括类里面有哪些方法 哪些变量等等

Class类详解

通过前面 我们了解了类的加载 同时会提取一个类的信息生成Class对象存放在内存中 而反射机制其实就是利用这些存放的类信息
来获取的信息和操作类 那么如何获取每个类对应的Class对象呢 我们可以通过以下方式:

                    public static void main(String[] args) throws ClassNotFoundException {
                    
                        Class<String> clazz = String.class; // 使用class关键字 通过类名获取
                        Class<?> clazz2 = Class.forName(); // 使用Class类静态方法forName() 通过包名 类名获取 注意返回值是Class<?>
                        Class<?> clazz3 = new String("cpdd").getClass(); // 通过实例对象获取
                    
                    }

注意: Class类也是一个泛型类 只有第一种方法 能够直接获取到对应类型的Class对象 而以下两种方法使用了<?>通配符作为返回值 但是实际上都和第一个返回的是同一个对象:

                    Class<String> clazz = String.class; // 使用class关键字 通过类名获取
                    Class<?> clazz2 = Class.forName("java.lang.String"); // 使用Class类静态方法forName() 通过包名.类名获取 注意返回值是Class<?>
                    Class<?> clazz3 = new String("cpdd").getClass();
                    
                    System.out.println(clazz == clazz2);
                    System.out.println(clazz == clazz3);

通过比较 验证了我们一开始的结论 在JVM中每一个类始终中存在一个Class对象 无论通过什么方法获取 都是一样的 现在我们再来看看这个问题:

                    public static void main(String[] args) {

                        Class<?> clazz = int.class; // 基本数据类型有Class对象吗?
                        System.out.println(clazz);

                    }

迷了 不是每个类才有Class对象吗 基本数据类型又不是类 这也行吗? 实际上 基本数据类型也有对应的Class对象
(反射操作可能需要用到)而且我们不仅可以通过class关键字获取 其实本质上是定义在对应的包装类中的:

                    /**
                     * The {@code Class} instance representing the primitive type
                     * {@code int}.
                     *
                     * @since   JDK1.1
                     */
                     @SuppressWarnings("unchecked")
                     public static final Class<Integer>  TYPE = (Class<Integer>) Class.getPrimitiveClass("int");
                     
                     /*
                      * Return the Virtual Machine's Class object for the named
                      * primitive type
                      */
                      static native Class<?> getPrimitiveClass(String name); // C++实现 并非Java定义

每个包装类中(包括Void) 都有一个获取原始类型Class方法 注意 getPrimitiveClass获取的是原始类型 并不是包装类型 只是可以使用包装类来表示:

                    public static void main(String[] args) {

                        Class<?> clazz = int.class;
                        System.out.println(Integer.TYPE == int.class);

                    }

通过对比 我们发现实际上包装类型都有一个TYPE 其实也就是基本类型的Class 那么包装类的Class和基本类的Class一样吗?

                    public static void main(String[] args) {

                        System.out.println(Integer.TYPE == Integer.class);

                    }

我们发现 包装类型的Class对象并不是基本类型Class对象 数组类型也是一种类型 只是编程不可见 因此我们可以直接获取数组的Class对象:

                    public static void main(String[] args) {

                        Class<String[]> clazz = String[].class;
                        System.out.println(clazz.getName()); // 获取类名称(得到的是包名+类名的完整名称)
                        System.out.println(clazz.getSimpleName());
                        System.out.println(clazz.getTypeName());
                        System.out.println(clazz.getClassLoader()); // 获取它的类加载器
                        System.out.println(clazz.cast(new Integer("10"))); // 强制类型转换

                    }

下章节 我们将开始对Class对象的使用进行讲解