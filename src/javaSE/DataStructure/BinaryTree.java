package javaSE.DataStructure;

public class BinaryTree<E> {

    public E element;

    public BinaryTree<E> left, right;

    public BinaryTree(E element) {
        this.element = element;
    }

    public static <T> void preOrder(BinaryTree<T> root) {

        if (root == null) return;
        System.out.print(root.element + " ");
        preOrder(root.left); preOrder(root.right);

    }

    public static <T> void inOrder(BinaryTree<T> root) {

        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.element);
        inOrder(root.right);

    }

    public static <T> void postOrder(BinaryTree<T> root) {

        if (root == null) return;
        postOrder(root.left); postOrder(root.right);
        System.out.print(root.element);

    }

    public static <T> void levelOrder(BinaryTree<T> root) {

        Queue<BinaryTree<T>> queue = new Queue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTree<T> node = queue.poll();
            System.out.print(node.element);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

    }

}
