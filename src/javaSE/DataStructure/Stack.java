package javaSE.DataStructure;

import java.util.NoSuchElementException;

public class Stack<E> {

    private final Node<E> head = new Node<>(null);

    private static class Node<E> {

        E element; Node<E> next;

        public Node(E element) {
            this.element = element;
        }

    }

    public void push(E element) {

        Node<E> node = new Node<>(element);
        node.next = head.next; head.next = node;

    }

    public E pop() {

        if (head.next == null) throw new NoSuchElementException("栈为空");

        E e = head.next.element;
        head.next = head.next.next;
        return e;

    }

    public boolean isEmpty() {
        return head.next == null;
    }

}
