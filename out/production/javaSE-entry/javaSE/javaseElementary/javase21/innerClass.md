内部类

类中可以存在一个类 各种各样的长相怪异的代码就是从这里开始出现的

成员内部类

我们的类中可以在嵌套一个类:

                 public class Test {

                     class Inner { // 类中定义的一个内部类

                     }

                 }

成员内部类和成员变量和成员方法一样 都是属于对象的 也就是说 必须存在外部对象 才能创建内部类的对象:

                 public static void main(String[] args) {

                     Test test = new Test();
                     Test.Inner inner = test.new Inner(); // 写法有那么一丝怪异 但是没毛病

                 }

静态内部类

静态内部类其实就和类中的静态变量和静态方法一样 是属于类拥有的 我们可以直接通过类名去访问:

                 public class Test {

                     static class Inner {

                     }

                 }

                 public static void main(String[] args) {

                     Test.Inner inner = new Test.Inner(); // 不用再创建外部类对象了

                 }

局部内部类

对 你没猜错 就是和局部变量一样哒:

                 public class Test {

                     public void test() {

                         class Inner {

                         }

                         Inner inner = new Inner();

                     }

                 }

反正就是没用过 内部类 -> 累不累 -> 反正我累了

匿名内部类

匿名内部类才是我们的重点 也是实现lambda表达式的原理 匿名内部类其实就是正在new的时候 直接对接口或是抽象类的实现:

                 public static void main(String[] args) {

                     Eat eat = new Eat() {

                         @Override
                         public void eat() {
                             // DO something...
                         }

                     };

                 }

我们不用单独去篡创建一个类来实现 而是可以直接在new的时候写对应的实现 但是 这样写 无法实现复用 只能往这里使用(相当于用了就扔的感觉)