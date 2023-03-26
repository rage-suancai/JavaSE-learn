package javaSE.javaseIntermediate.javase11;

public class ArrayStack<E> extends AbstractStack<E> {

    private Object[] arr = new Object[20]; // 底层数组
    private int size = 0; // 长度

    @Override
    public E pop() {

        return (E) arr[(size--) - 1];

    }

    @Override
    public void push(E e) {

        if (size >= arr.length){
            Object[] arr = new Object[this.arr.length + 10];
            for (int i = 0; i < this.arr.length; i++) arr[i] = this.arr[i];
            this.arr = arr;
        }
        arr[size++] = e;

    }

}
