java异常机制

在理想的情况下 我们的程序会按照我们的思路去运行 按理说是不会出现问题的 但是 代码实际编写后并不一定是完美的
可能会有完美没有考虑到的情况 如果这些情况能够正常得到一个错误的结果还好 但是如果直接程序运行出现问题了呢?

                 static int test(int a, int b) {
                     return a/b; // 没有任何的判断而直接做计算
                 }

                 public static void main(String[] args) {

                     test(1, 0); // 当b为0的时候 还能正常运行吗

                 }

                 Exception in thread "main" java.lang.ArithmeticException: / by zero

当程序运行出现完美没有考虑到的情况 就有可能出现异常或是错误

异常

完美在开始之前已经接触过了一些异常了 比如数组越界异常 空指针异常 算术异常等 它们其实都是异常类型 我们的每一个异常也是一个类 它们都继承自Exception类
异常类型本质依然是类的对象 但是异常类型支持才程序运行出现问题时抛出(也就是上面出现的红色报错) 也可以提前声明 告知使用者需要处理可能会出现的异常

运行时异常

异常的第一种类型是运行时异常 如上述的例子 在编译阶段无法感知代码是否会出现问题 只有在运行的时候才知道会不会出错(正常情况下是不会出错的)
这样的异常称为运行时异常 所有的运行时异常都继承自RuntimeException

编译时异常

异常的另一种类型是编译时异常 编译时异常是明确会出现的异常 在编译阶段就需要进行处理的异常(捕获异常)
如果不进行处理 将无法通过编译 默认继承自Exception类的异常都是编译时异常:

                 File file = new File("muy.txt");
                 file.createNewFile(); // 要调用此方法 首先需要处理异常

错误

错误比异常更严重 异常就是不同寻常 但不一定会导致致命的问题 而错误是致命问题 一般出现错误可能JVM就无法继续正常运行了
比如OutOfMemoryError就是内存溢出错误(内存占用已经超出限制 无法继续申请内存了):

                 int[] arr = new int[Integer.MAX_VALUE]; // 能创建如此之大的数组吗

运行后得到以下内容:

                 Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit

错误都继承自Error类 一般情况下 程序中只能处理异常 错误是很难进行处理的 Error和Exception都继承自Throwable类
当程序中出现错误或异常时又没有进行处理时 程序(当前线程)将终止运行:

                 int[] arr = new int[Integer.MAX_VALUE];
                 System.out.println("yxsnb"); // 还能正常打印吗