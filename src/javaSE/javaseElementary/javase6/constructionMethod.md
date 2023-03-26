构造方法

构造方法(构造器)没有返回值 也可以理解为 返回的是当前对象的引用 每一个类都默认自带一个无参构造方法:

                 package javaSE.javase6;

                 public class Student {
                     public Student() { // 即使你什么都不编写 也自带一个无参构造方法 只是默认是隐藏的

                     }
                 }

反编译其实就是把我们编译好的class文件变回java源代码

                 Student student = new Student(); // 实际上存在Student()这个的方法 new关键字就是用来创建并得到引用的
                 // new + 你想要使用的构造方法

这种方法没有写明返回值 但是每个类都必须具有这个方法 只有调用类的构造方法 才能创建类的对象

类要在一开始准备的所有东西 都会在构造方法里面执行 完成构造方法的内容后 才能创建出对象

一般最常用的就是给成员属性赋初始值:

                 public class Student {
                     String name;

                     public Student() {
                         name = "伞兵一号";
                     }
                 }

我们可以手动指定有参构造 当遇到名称冲突时 需要用到this关键字:

                 public class Student {
                     String name;

                     public Student(String name) { // 形参和类成员变量冲突了 java会优先使用形式参数定义的变量
                         this.name = name; // 通过this指代当前的对象属性 this就代表当前对象
                     }
                 }

                 // idea 右键快速生成

注意: this只能用于指代当前对象的内容 因此 只有属于对象拥有的部分才可以使用this 也就是说 只能在类的成员方法中使用this 不能在静态方法中使用this关键字

在我们定义了新的有参构造之后 默认的无参构造会被覆盖

                 // 反编译后依然只有我们定义的有参构造

如果同时要有参和无参构造 那么就需要使用到方法的重载 手动再去定义一个无参构造:

                 public class Student {
                     String name;

                     public Student() {
                     }

                     public Student(String name) {
                         this.name = name;
                     }
                 }

成员变量的初始化始终在构造方法执行之前:

                 public class Student {
                     String a = "瑞克";

                     public Student() {
                         System.out.println(a);
                     }
                 }

                 public static void main(String[] args) {
                     Student student = new Student();
                 }