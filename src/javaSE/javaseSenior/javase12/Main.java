package javaSE.javaseSenior.javase12;

public class Main {

    static void test1() {

        Object o1 = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (o1) {
                try {
                    System.out.println("开始等待");
                    o1.wait();
                    System.out.println("等待结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (o1) {
                System.out.println("开始唤醒");
                o1.notify();
                for (int i = 0; i < 50; i++) {
                    System.out.println(i);
                }
            }
        });
        try {
            thread1.start();
            Thread.sleep(1000);
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static void test2() {

        Object o1 = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (o1) {
                try {
                    System.out.println("线程一开始等待");
                    o1.wait();
                    System.out.println("线程二等待结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (o1) {
                try {
                    System.out.println("线程二开始等待");
                    o1.wait();
                    System.out.println("线程二等待结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            synchronized (o1) {
                System.out.println("开始唤醒");
                o1.notifyAll();
                for (int i = 0; i < 50; i++) {
                    System.out.println(i);
                }
            }
        });
        try {
            thread1.start();
            thread2.start();
            Thread.sleep(1000);
            thread3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        test1();
        //test2();
    }

}
