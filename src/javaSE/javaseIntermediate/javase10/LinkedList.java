package javaSE.javaseIntermediate.javase10;

/**
 * @author YXS
 * @PackageName: javaSE.javaseIntermediate.javase10
 * @ClassName: LinkedList
 * @Desription:
 * @date 2023/3/27 19:39
 */
public class LinkedList<E> {

    private final Node<E> head = new Node<>(null);
    private int size = 0;

    public void add(E element, int index) {

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("插入位置非法 合法的插入位置为: 0 ~ " + size);
        Node<E> prev = head;
        for (int i = 0; i < index; i++) prev = prev.next;
        Node<E> node = new Node<>(element);
        node.next = prev.next;
        prev.next = node; size++;

    }

    public E remove(int index) {

        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("删除位置非法 合法的删除位置为: 0 ~ " + (size - 1));
        Node<E> prev = head;
        for (int i = 0; i < index; i++) prev = prev.next;
        E e = prev.next.element;
        prev.next = prev.next.next; size++;
        return e;

    }

    public E get(int index) {

        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("非法的位置 合法的位置为: 0 ~ " + (size - 1));
        Node<E> node = head;
        while (index-- >= 0) node = node.next;
        return node.element;

    }

    public int size() {
        return size;
    }

    private static class Node<E> {

        private E element; Node<E> next;

        public Node(E element) {
            this.element = element;
        }

    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        Node<E> node = head.next;
        while (node != null) {
            builder.append(node.element).append(" ");
            node = node.next;
        }
        return builder.toString();

    }

}
