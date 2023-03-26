package javaSE.javaseIntermediate.javase3;

/**
 * 异常的抛出
 * 当别人调用当我们的方法时 如果传入错误的参数导致程序无法正常运行 这时我们就需要手动抛出一个异常来终止程序继续运行下去 同时告知上一级方法执行出现了问题:
 *                  public static void main(String[] args) {
 *
 *                      try {
 *                          test(1, 0)
 *                      } catch (Exception e){ // 捕获方法中会出现的异常
 *                          e.printStackTrace();
 *                      }
 *
 *                  }
 *
 *                  static int test(int a, int b) throws Exception { // 声明抛出的异常类型
 *
 *                      if(b == 0) throw new Exception("0不能做除数"); // 创建异常对象并抛出异常
 *                      return a/b; // 抛出异常会终止代码运行
 *
 *                  }
 *
 * 通过throw关键字抛出异常(抛出异常后 后面的代码不再执行) 当程序运行到这一行时 就会终止执行 并出现一个异常
 *
 * 如果方法中抛出了非运行时异常 但是不希望在此方法内处理 而是交给调用者来处理异常 就需要在方法定义后显示声明抛出的异常类型 如果抛出的是运行时异常 则不需要在方法后面声明异常类型
 * 调用时也无需捕获 但是出现异常时同样会导致程序终止(出现运行时异常同时未被捕获会默认交给JVM处理 也就是直接终止程序并在控制台打印栈追踪信息)
 *
 * 如果想要调用声明编译时异常的方法 但是依然不想去处理 可以同样的在方法上声明throws来继续交给上一级处理
 *                  public static void main(String[] args) throws Exception { // 出现异常就再往上抛 而不是在此方法内处理
 *                      test(1, 0)
 *                  }
 *
 *                  private static int test(int a, int b) throws Exception { // 声明抛出的异常类型
 *                      if(b == 0) throw new Exception("0不能做除数"); // 创建异常对象并抛出异常
 *                      return a/b;
 *                  }
 *
 * 当main方法都声明抛出异常时 出现异常就由JVM进行处理 也就是默认的处理方式(直接终止程序并在控制台打印栈追踪信息)
 *
 * 异常只能被捕获一次 当异常捕获出现嵌套时 只会在最内层被捕获:
 *                  public static void main(String[] args) throws Exception {
 *
 *                      try {
 *                          test(1, 0);
 *                      } catch(Exception e) {
 *                          System.out.println("外层");
 *                      }
 *
 *                  }
 *
 *                  static int test(int a, int b) {
 *
 *                      try {
 *                          if(b == 0) throw new Exception("0不能为除数");
 *                      } catch(Exception e) {
 *                          System.out.println("内层");
 *                          return 0;
 *                      }
 *                      return a/b;
 *
 *                  }
 */
public class Main {

    /*static int test(int a, int b) throws Exception {

        if (b == 0) throw new Exception("0不能做除数");
        return a/b;

    }
    public static void main(String[] args) throws Exception {

        /*try {
            test(1, 0);
        } catch(Exception e) {
            e.printStackTrace();
        }

        test(1, 0);

    }*/

    static int test(int a, int b) {

        try {
            if(b == 0) throw new Exception("0不能做除数");
        } catch(Exception e) {
            System.out.println("内层");
            return 0;
        }
        return a/b;

    }
    public static void main(String[] args) throws Exception{

        try {
            test(1, 0);
        } catch (Exception e) {
            System.out.println("外层");
        }

    }

}
