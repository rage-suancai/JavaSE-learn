package javaSE.javaseIntermediate.javase11;

/**
 * 抽象类型栈 待实现
 * @param <E>
 */
public abstract class AbstractStack<E> {

    /**
     * 出栈操作
     * @return 栈顶元素
     */
    public abstract E pop();

    /**
     * 入栈操作
     * @param e 元素
     */
    public abstract void push(E e);

}
