方法的重载

一个类中可以包含多个同名的方法 但是需要的形式参数不一样(补充: 形式参数是定义方法需要的参数 实际参数就是传入的参数)
方法的返回类型 可以相同 也可以不同 但是仅返回类型不同 是不允许的:

                 public class Test {

                     int a() { // 原本的方法
                         return 1;
                     }

                     int a(int i) { // ok 形参不同
                         return i;
                     }

                     void a(byte i) { // ok 返回类型和形参都不同

                     }

                     void a() { // 错误 仅返回值类型名称不同不能重载

                     }

                 }

现在我们就可以使用不同的参数 但是支持调用同样的方法 执行一样的逻辑:

                 public class Test {

                     int sum(int a, int b) { // 只有int支持 不灵活
                         return a + b;
                     }

                     double sum(double a, double b) { // 重写一个double类型的 就支持小数计算了
                         return  a + b;
                     }

                 }

现在我们有很多种重写的方法 那么传入实参后 到底进了哪个方法呢?

                 void a(int i) {
                     System.out.println("调用了int");
                 }

                 void a(short i) {
                     System.out.println("调用了short");
                 }

                 void a(char i) {
                     System.out.println("调用了char");
                 }

                 void a(double i) {
                     System.out.println("调用了double");
                 }

                 void a(float i) {
                     System.out.println("调用了float");
                 }

                 Test test = new Test();

                 test.a(1); // 直接输入整数
                 test.a(1.0); // 直接输入小数

                 short s = 2;
                 test.a(s); // 会对号入座吗
                 test.a(1.0F);