栈

栈遵循先入后出原则 只能在线性表的一端添加和删元素 我们可以把栈看做一个杯子 杯子只有一个口进出 最低处的元素只能等到上面的元素离开杯子后才能离开

向栈中插入一个元素时 称为入栈(压栈) 移除栈顶元素称为出栈 我们需要尝试实现以下抽象类型:

                 public abstract class AbstractStack<E> {

                     public abstract E pop();

                     public abstract void push(E e);

                 }

其实 我们的JVM在处理方法调用时 也是一个栈操作 所以说 如果玩不好递归 就会像这样:

                 public class Main {

                     public static void main(String[] args) {
                         go();
                     }

                     private static void go(){
                         go();
                     }

                 }

                 Exception in thread "main" java.lang.StackOverflowError
                     at com.test.Main.go(Main.java:13)
                     at com.test.Main.go(Main.java:13)
                     at com.test.Main.go(Main.java:13)
                     at com.test.Main.go(Main.java:13)
                     at com.test.Main.go(Main.java:13)
                     at com.test.Main.go(Main.java:13)
                     at com.test.Main.go(Main.java:13)
                     at com.test.Main.go(Main.java:13)
                     ...

栈的深度是有限的 如果达到限制 将会出现StackOverflowError错误(注意: 是错误 说明是JVM出现了问题)