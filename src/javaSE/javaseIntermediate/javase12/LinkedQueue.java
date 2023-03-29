package javaSE.javaseIntermediate.javase12;

import java.util.NoSuchElementException;

/**
 * @author YXS
 * @PackageName: javaSE.javaseIntermediate.javase12
 * @ClassName: LinkedQuene
 * @Desription:
 * @date 2023/3/29 0:58
 */
public class LinkedQueue<E> {

    private final Node<E> head = new Node<>(null);

    public void offer(E element) {

        Node<E> last = head;
        while (last.next != null) last = last.next;
        last.next = new Node<>(element);

    }

    public E poll() {

        if (head.next == null)
            throw new NoSuchElementException("队列为空");
        E e = head.next.element;
        head.next = head.next.next;
        return e;

    }

    public boolean isEmpty() {
        return head.next == null;
    }

    private static class Node<E> {

        E element; Node<E> next;

        public Node(E element) {
            this.element = element;
        }

    }

}
