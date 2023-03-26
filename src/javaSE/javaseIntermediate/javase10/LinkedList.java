package javaSE.javaseIntermediate.javase10;

import javaSE.javase9.AbstractList;

public class LinkedList<E> extends AbstractList<E> {

    private static class Node<E>{
        private E e;
        private Node<E> next;

        public Node(E e) {
            this.e = e;
        }
    }

    private Node<E> head = new Node<>(null);
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e, int index) {

        if (index > size) throw new IllegalArgumentException("非法的插入位置!");
        Node<E> node = head, temp;
        for (int i = 0; i < index; i++) node = node.next;
        temp = node.next;
        node.next = new Node<>(e);
        node.next.next = temp;
        size++;

    }

    @Override
    public E remove(int index) {

        if (index > size - 1) throw new IllegalArgumentException("非法的删除位置!");
        Node<E> node = head, temp;
        for (int i = 0; i < index; i++) node = node.next;
        temp = node.next;
        node.next = node.next.next;
        size--;
        return temp.e;

    }

    @Override
    public E get(int index) {

        if (index >= size) throw new IndexOutOfBoundsException("无法访问到下标位置!");
        Node<E> node = head.next;
        for (int i = 0; i < index; i++) node = node.next;
        return node.e;

    }

}
