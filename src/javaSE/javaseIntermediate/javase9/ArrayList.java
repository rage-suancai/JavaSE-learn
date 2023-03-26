package javaSE.javaseIntermediate.javase9;

public class ArrayList<E> extends AbstractList<E> {

    private Object[] arr = new Object[1];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e, int index) {

        if (index > size) throw new IllegalArgumentException("非法的插入位置!");
        if (size >= arr.length) {
            Object[] arr = new Object[this.arr.length + 10];
            for (int i = 0; i < this.arr.length; i++) arr[i] = this.arr[i];
            this.arr = arr;
        }

        int i = size - 1;
        while (i >= index) {
            arr[i+1] = arr[i];
            i--;
        }

        arr[index] = e;
        size++;

    }

    @Override
    public E remove(int index) {

        if (index > size - 1) throw new IllegalArgumentException("非法的删除位置!");
        int i = index;
        while (i < size - 1) {
            arr[i] = arr[i+1];
            i++;
        }
        size--;

        E e = (E) arr[index];
        return e;

    }

    @Override
    public E get(int index) {

        if (index >= size) throw new IndexOutOfBoundsException("无法访问到下标位置!");
        return (E) arr[index];

    }

}
