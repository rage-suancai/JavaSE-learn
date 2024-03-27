package javaSE.ActualCombat5;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final Queue<Object> queue = new LinkedList<>();

    public static void main(String[] args) {

        new Thread(Main::kitchen, "厨师一").start();
        new Thread(Main::kitchen, "厨师二").start();

        new Thread(Main::customer, "消费者一").start();
        new Thread(Main::customer, "消费者二").start();
        new Thread(Main::customer, "消费者三").start();

    }

    private static void kitchen() {

        while (true) {
            try {
                Thread.sleep(3000);
                synchronized (queue) {
                    String name = Thread.currentThread().getName();
                    System.out.println(new Date() + " " + name + " 出餐了!"); queue.offer(new Object());
                    queue.notifyAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private static void customer() {

        while (true) {
            try {
                synchronized (queue) {
                    while (queue.isEmpty()) queue.wait();
                    queue.poll();
                    String name = Thread.currentThread().getName();
                    System.out.println(new Date() + " " + name + "拿到了餐品 正在享用!");
                }
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
