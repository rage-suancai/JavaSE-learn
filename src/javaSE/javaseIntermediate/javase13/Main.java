package javaSE.javaseIntermediate.javase13;

public class Main {

    static TreeNode<Character> a = new TreeNode<>('A');
    static TreeNode<Character> b = new TreeNode<>('B');
    static TreeNode<Character> c = new TreeNode<>('C');
    static TreeNode<Character> d = new TreeNode<>('D');
    static TreeNode<Character> e = new TreeNode<>('E');
    static TreeNode<Character> f = new TreeNode<>('F');

    static void test1() {

        a.left = b; a.right = c; b.left = d; b.right = e;
        System.out.println(a.left.left.element);

    }

    static void test2() {

        a.left = b; a.right = c; b.left = d; b.right = e; c.right = f;
        // preOrder(a);
        // inOrder(a);
        // postOrder(a);
        levelOrder(a);

    }

    public static void main(String[] args) {

        // test1();
        test2();

    }

    private static <T> void preOrder(TreeNode<T> root) {

        if (root == null) return;
        System.out.print(root.element + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    private static <T> void inOrder(TreeNode<T> root) {

        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.element + " ");
        inOrder(root.right);

    }

    private static <T> void postOrder(TreeNode<T> root) {

        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.element + " ");

    }

    private static <T> void levelOrder(TreeNode<T> root) {

        QueueTree<TreeNode<T>> queue = new QueueTree<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            System.out.print(node.element + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

    }

}
