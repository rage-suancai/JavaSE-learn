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

    private static class Node<E> {

        E element; Node<E> next;

        public Node(E element) {
            this.element = element;
        }

    }

}
