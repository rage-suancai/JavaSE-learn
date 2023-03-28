接口

接口甚至比抽象类还要抽象 他只代表某个确切的功能 也就是只包含方法的定义 甚至都不是一个类 接口包含了一些列方法的具体定义 类可以实现这个接口
表示类支持接口代表的功能(类似与一个插件 只能作为一个附属功能加在主体上 同时具体实现还需要由主体类来实现):

                 public interface Eat {

                     void eat();

                 }

通过使用interface关键字来表明是一个接口(注意: 这里class关键字被替换为了interface) 接口只能包含public权限的抽象方法
(java8以后可以有默认实现) 我们可以通过声明default关键字来给抽象方法一个默认实现:

                 public interface Eat {

                     default void eat(){
                         // do something...
                     }

                 }

接口中定义的变量 默认为public static final:

                 public interface Eat {

                     int a = 1;
                     void cat();

                 }

一个类可以实现很多个接口 但是不能理解为多继承(实际上实现接口是附加功能 和继承的概念有一定出入 顶多说是多继承的一种替代方案) 一个类可以附加多个功能:

                 public class SportsStudent extends Student implements Eat, ... {

                     @Override
                     public void eat() {

                     }

                 }

类通过使用implements关键字来声明实现的接口 每个接口之间用逗号隔开

实现接口的类也能通过instanceof关键字判断 也支持向上和向下转型