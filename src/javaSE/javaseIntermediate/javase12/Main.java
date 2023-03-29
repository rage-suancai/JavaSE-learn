package javaSE.javaseIntermediate.javase12;

public class Main {

    static LinkedQueue<String> queue = new LinkedQueue<>();

    static void test1() {

        queue.offer("AAA");
        queue.offer("BBB");
        queue.offer("CCC");
        while (!queue.isEmpty())
            System.out.println(queue.poll());

    }

    public static void main(String[] args) {

        test1();

    }

}
