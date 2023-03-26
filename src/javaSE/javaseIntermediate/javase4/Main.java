package javaSE.javaseIntermediate.javase4;

/**
 * 自定义异常
 * JDK为我们已经提前定义了一些异常了 但是可能对我们来说不够 那么就需要自定义异常:
 *                  public class MyException extends Exception { // 直接继承即可
 *
 *                  }
 *
 *                  public static void main(String[] args) throws MyException {
 *                      throw new MyException(); // 直接使用
 *                  }
 *
 * 也可以使用父类的带描述的构造方法:
 *                  public class MyException extends Exception {
 *
 *                      public MyException(String message) {
 *                          super(message);
 *                      }
 *
 *                  }
 *
 *                  public static void main(String[] args) throws MyException {
 *                      throw new MyException("出现了自定义的错误");
 *                  }
 *
 * 捕获异常指定的类型 会捕获其所有子异常类型:
 *                  try {
 *                      throw new MyException("出现了自定义的错误");
 *                  } catch(Exception e) { // 捕获父异常类型
 *                      System.out.println("捕获到异常");
 *                  }
 *
 * 多重异常捕获和finally关键字
 * 当代码可能出现多种类型的异常时 我们希望能够分不同情况处理不同类型的异常 就可以使用多重异常捕获:
 *                  try {
 *                      // ....
 *                  } catch(NullPointerException e) {
 *
 *                  } catch(IndexOutOfBoundsException e) {
 *
 *                  } catch(RuntimeException e) {
 *
 *                  }
 *
 * 注意: 类似于if-else if的结构 父异常类型只能放在最后
 *                  try {
 *                       // ....
 *                   } catch(RuntimeException e) { // 父类在前 会将子类的也捕获
 *
 *                   } catch(NullPointerException e) { // 永远都不会被捕获
 *
 *                   } catch(IndexOutOfBoundsException e) { // 永远都不会被捕获
 *
 *                   }
 *
 * 如果希望把这些一擦放在一起进行处理:
 *                  try {
 *                      // ....
 *                  } catch (NullPointerException | IndexOutOfBoundsException e) { // 用|隔开每种类型即可
 *
 *                  }
 *
 * 当我们希望 程序运行时无论是否出现异常 都会在最后执行的任务 可以交给finally语句块来处理:
 *                  try {
 *                      // ....
 *                  } catch(Exception e) {
 *
 *                  } finally {
 *                      System.out.println("yxsnb"); // 无论是否出现异常 都会在最后执行
 *                  }
 *
 * try语句块至少要配合catch或finally中的一个:
 *                  try {
 *                      int a = 10;
 *                      a /= 0;
 *                  } finally { // 不捕获异常 程序会终止 但在最后依然会执行下面的内容
 *                      System.out.println("yxsnb");
 *                  }
 *
 * 思考: try catch和finally执行顺序:
 *                  private static int test(int a) {
 *                      try {
 *                          return a;
 *                      } catch (Exception e) {
 *                          return 0;
 *                      } finally {
 *                          a = a + 1;
 *                      }
 *                  }
 */
public class Main {

    public static void main(String[] args) throws MyException {

        //throw new MyException();

        //throw new MyException("出现了自定义的错误");

        try {

        } catch(Exception e) {

        } finally {
            System.out.println("yxsnb");
        }

    }

}
