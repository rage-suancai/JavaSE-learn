package javaSE.javaseIntermediate.javase12;

/**
 * 队列
 * 队列同样也是受限制的线性表 不过队列就像我们排队一样 只能从尾开始排 从队首出
 *
 * 所以我们要实现以下内容:
 *                  public abstract class AbstractQueue<E> {
 *
 *                      public abstract void affer(E e);
 *
 *                      public abstract E poll();
 *
 *                  }
 */
public class Main {

    public static void main(String[] args) {

        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.affer("A");
        queue.affer("B");
        queue.affer("C");
        queue.poll();
        queue.affer("D");
        System.out.println("debug");

    }

}
