再谈final关键字

我们目前在知道final关键字能够使得一个变量的值不可更改 那么如果在类前面声明final 会发生什么:

                 public final class Student { // 类被声明为终态 那么它还能被继承吗

                 }

类一旦被声明为终态 将无法再被继承 不允许子类的存在 而方法被声明为final呢?

                 public final void study() { // 还能重写吗

                     System.out.println("学习");

                 }

如果类的成员属性被声明为final 那么必须在构造方法中或是在定义时赋初始值:

                 private final String name; // 引用类型不允许再指向其他对象
                 private final int age;// 基本类型值不允许发生改变

                 public void Student(String name, int age) {

                     this.name = name;
                     this.age = age;

                 }

学习完封装继承和多态之后 我推荐在不会再发生改变的成员属性上添加final关键字 JVM会对添加了final关键字的属性进行优化

抽象类

类本身就是一个抽象 而抽象类 比类还要抽象 也就是说 抽象类可以只保留特征 而不保留具体呈现形态
比如方法可以定义好 但是我可以不去实现它 而是交由子类来进行实现:

                 public abstract class Student { // 抽象类

                     public abstract void test(); // 抽象方法

                 }

通过使用abstract关键字来表明一个类是一个抽象类 抽象类可以使用abstract关键字来表明一个方法为抽象方法
也可以定义普通方法 抽象方法不需要编写具体实现(无方法体) 但是必须由子类实现(除非子类也是一个抽象类)

抽象类由于不是具体的类定义 因此无法直接通过new关键字来创建对象:

                 Student s = new Student() { // 只能直接创建带实现的匿名内部类

                     public void test(){}

                 }

因此 抽象类一般只用作继承使用 抽象类使得继承关系之间更加明确:

                 public void study() {

                     System.out.println("给你看点好康的");

                 }