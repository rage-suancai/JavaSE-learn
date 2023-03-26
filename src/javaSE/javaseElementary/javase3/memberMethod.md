成员方法
我们之前的学习中接触过方法(Method)吗 主方法:

                 public static void main(String[] args) {
                     // Body
                 }

方法是语句的集合 是为了完成某件事情而存在的 完成某件事情 可以有结果 也可以做了就做了 不返回结果 比如计算两个数字的和
我们需要得到计算后的结果 所以说方法需要有返回值 又比如 我们只想把数字打印在控制台 只需要打印就行 不用给我结果 所以说方法不需要有返回值

方法的定义和使用

在类中 我们可以定义自己的方法 格式如下:

                 [返回值类型] 方法名称([参数]) {
                     // 方法体
                     return 结果;
                 }

     > 返回值类型: 可以是引用类型和基本类型 还可以是void 表示没有返回值
     > 方法名称: 和标识符的规则一致 和变量一样 规范小写字母开头
     > 参数: 例如方法需要计算两个数的和 那么我们就要把两个数到底是什么告诉方法 那么它们就可以作为参数传入方法
     > 方法体: 方法具体要干的事情
     > 结果: 方法执行的结果通过return返回(如果返回类型为void 可以省略return)

非void方法 return关键字不一定需要放在最后 但是一定要保证方法在任何情况下都具有返回值:

                 int test(int a) {
                     if (a > 0) {
                         // 确实return语句
                     } else {
                         return 1;
                     }
                 }

return也能用来提前结束整个方法 无论此时程序执行到何处 无论return位于哪里 都会立即结束这个方法:

                 public static void main(String[] args) {
                     for(int i = 0; i < 10; ++i) {
                         if(i == 1) return; // 在循环内返回了 和break区别?
                     }
                     System.out.println("淦") // 还会到这里吗
                 }

传入方法的参数 如果是基本类型 会在调用方法的时候 对参数的值进行复制 方法中的参数变量 不是我们传入的变量本身:

                 public class Student {

                     void swap(int a, int b) { // 传递的仅仅是值而已
                         int temp = a;
                         a = b;
                         b = temp;
                     }

                 }

                 public static void main(String[] args) {
                     int a = 10, b = 20;
                     new Student.swap(a, b);
                     System.out.println("a = " + a + ", b = " + b);
                 }

传入方法的参数 如果是引用类型 那么传入的依然是该对象的引用(类似于C语言的指针):

                 public class B {
                     String name;
                 }

                 public class A {
                     void test(B b) { // 传递的是对象的引用 而不是值
                         System.out.println(b.name);
                     }
                 }

                 public static void main(String[] args) {
                     int a = 10, b = 20;
                     B b = new b();
                     b.name = "yxs";
                     new A().test(b);
                     System.out.println("a = " + a + ", b = " + b);
                 }

方法之间可以相互调用:

                 void a() {
                     // xxxx
                 }

                 void b() {
                     a();
                 }

当方法在自己内部调用自己时 称为递归调用(递归很危险 谨慎使用):

                 int a() {
                     return a();
                 }

成员方法和成员变量一样 是属于对象的 只能通过对象去调用