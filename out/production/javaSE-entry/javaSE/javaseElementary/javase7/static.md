静态变量和静态方法

静态变量和静态方法是类具有的属性(后面还会提到静态类 静态代码块) 也可以理解为是所有对象共享的内容 我们通过使用static关键字来声明一个变量或一个方法为静态的 一旦被声明为静态
那么通过这个类创建的所有对象 操作的都是同一个目标 也就是说 对象再多 也只有这一个静态的变量或方法 那么 一个对象改变了静态变量的值 那么其他的对象读取的就是被改变的值:

                 public class Student {
                     static String name;
                 }

                 public static void main(String[] args) {

                     Student s1 = new Student();
                     s1.name = "yxs";

                     Student s2 = new Student();
                     System.out.println(s2.name);

                 }

不推荐使用对象来调用 被标记为静态的内容 可以直接通过类名.xxx的形式访问:

                 public static void main(String[] args) {

                     Student.name = "瑞克";
                     System.out.println(Student.name);

                 }

简述类加载机制

类并不是在一开始就加载好 而是在需要时才会去加载(提升速度) 以下情况会加载类:

     > 访问类的静态变量 或者为静态变量赋值
     > new创建类的实例(隐式加载)
     > 调用类的静态方法
     > 子类初始化时
     > 其他的情况 会在讲到时介绍

所有被标记为静态的内容 会在类刚加载的时候就分配 而不是在对象创建的时候分配 所以说静态内容一定会在第一个对象初始化之前完成加载:

                 public class Student {
                     static String name = test(); // 直接调用静态方法 只能调用静态方法

                     public Student() {
                         System.out.println("构造类对象");
                     }

                     static String test() { // 静态方法刚加载时就有了
                         System.out.println("初始化变量name");
                         return "yxs";
                     }
                 }

思考: 下面这种情况下 程序正常运行吗 如果能 会输出什么内容呢:

                 public class Student {
                     static int a = test();

                     static int test() {
                         return a;
                     }
                 }

                 public static void main(String[] args) {
                     System.out.println(Student.a);
                 }

定义和赋值是两个阶段 在定义时会使用默认值(上面讲的 类的成员变量会有默认值) 定义出来之后 如果发现有赋值语句 再进行赋值 而这时 调用了静态方法
所以说会先去加载静态方法 静态方法调用时拿到a 而a这时仅仅是刚定义 所以说还是初始值 最后得到0