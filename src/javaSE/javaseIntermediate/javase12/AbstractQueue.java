package javaSE.javaseIntermediate.javase12;

public abstract class AbstractQueue<E> {

    /**
     * 进队操作
     * @param e
     */
    public abstract void affer(E e);

    /**
     * 出队操作
     * @return
     */
    public abstract E poll();

}
