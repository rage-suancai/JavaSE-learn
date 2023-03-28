代码块和静态代码块

代码块在对象创建时执行 也是属于类的内容 但是它在构造方法执行之前执行(和成员变量初始值一样) 且每创建一个对象时只执行一次(相当于构造之前的准备工作):

                 public class Student {
                     {
                         System.out.println("我是代码块");
                     }

                     public Student() {
                         System.out.println("我是构造方法");
                     }
                 }

静态代码块和上面的静态方法和静态变量一样 在类刚加载时会调用:

                 public class Student {
                     static int a;

                     static {
                         a = 10;
                     }
                 }

                 public static void main(String[] args) {
                     System.out.println(Student.a);
                 }