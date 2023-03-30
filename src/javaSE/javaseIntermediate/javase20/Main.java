package javaSE.javaseIntermediate.javase20;

import java.util.*;

/**
 * @author YXS
 * @PackageName: javaSE.javaseIntermediate.javase20
 * @ClassName: Main
 * @Desription:
 * @date 2023/3/30 15:39
 */
public class Main {

    static void test1() {

        Queue<String> queue = new LinkedList<>();

        queue.offer("AAA");
        queue.offer("BBB");
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }

    static void test2() {

        Deque<String> deque = new LinkedList<>();

        deque.push("AAA");
        deque.push("BBB");
        System.out.println(deque.pop());
        System.out.println(deque.pop());

    }

    static void test3() {

        Deque<String> deque = new LinkedList<>();

        deque.addLast("AAA");
        deque.addLast("BBB");

        Iterator<String> descendingIterator = deque.descendingIterator();
        System.out.println(descendingIterator.next());

        Iterator<String> iterator = deque.iterator();
        System.out.println(iterator.next());

    }

    static void test4() {

        Queue<Integer> queue1 = new PriorityQueue<>();
        Queue<Integer> queue2 = new PriorityQueue<>((a, b) -> b - a);

        queue2.offer(10);
        queue2.offer(4);
        queue2.offer(5);
        System.out.println(queue2);
        System.out.println(queue2.poll());
        System.out.println(queue2.poll());
        System.out.println(queue2.poll());

    }

    public static void main(String[] args) {

        //test1();
        //test2();
        //test3();
        test4();

    }

}
