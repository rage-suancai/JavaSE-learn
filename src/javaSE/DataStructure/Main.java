package javaSE.DataStructure;

public class Main {

    public static void main(String[] args) {

        //arrayTest();
        //linkedTest();
        //stackTest();
        //queueTest();
        //binaryTreeTest();
        hashTest();

    }

    private static void arrayTest() {

        Array<Integer> list = new Array<>();

        for (int i = 0; i < 20; i++) list.add(i, i);
        //list.remove(4);
        //System.out.println(list.get(8));
        System.out.println(list.size());

    }

    private static void linkedTest() {

        Linked<Integer> list = new Linked<>();

        list.add(10, 0); list.add(20, 0); list.add(30, 1);
        //list.remove(1);
        //System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.size());

    }

    private static void stackTest() {

        Stack<String> stack = new Stack<>();
        stack.push("AAA"); stack.push("BBB"); stack.push("CCC");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    private static void queueTest() {

        Queue<Object> stack = new Queue<>();
        stack.offer("AAA"); stack.offer("BBB"); stack.offer("DDD");
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());

    }

    private static void binaryTreeTest() {

        BinaryTree<Character> a = new BinaryTree<>('A');
        BinaryTree<Character> b = new BinaryTree<>('B');
        BinaryTree<Character> c = new BinaryTree<>('C');
        BinaryTree<Character> d = new BinaryTree<>('D');
        BinaryTree<Character> e = new BinaryTree<>('E');
        BinaryTree<Character> f = new BinaryTree<>('F');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //BinaryTree.preOrder(a);
        //BinaryTree.inOrder(a);
        //BinaryTree.postOrder(a);
        BinaryTree.levelOrder(a);

    }

    private static void hashTest() {

        Hash<Integer> hash = new Hash<>();
        hash.insert(8);
        System.out.println(hash.contains(8));

    }

}
