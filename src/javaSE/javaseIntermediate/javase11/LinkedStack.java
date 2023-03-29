package javaSE.javaseIntermediate.javase11;

import java.util.NoSuchElementException;

/**
 * @author YXS
 * @PackageName: javaSE.javaseIntermediate.javase11
 * @ClassName: LinkedStack
 * @Desription:
 * @date 2023/3/29 0:07
 */
public class LinkedStack<E> {

    private final Node<E> head = new Node<>(null);

    public void push(E element) {

        Node<E> node = new Node<>(element);
        node.next = head.next;
        head.next = node;

    }

    public E pop(){

        if (head.next == null)
            throw new NoSuchElementException("栈为空");
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
