package javaSE.javaseSenior.javase11;

public class Main2 {

    private static int value = 0;

    static void test1() {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (Main2.class) {
                    value++;
                }
            }
            System.out.println("线程一完成");
        });
        Thread thread2 = new Thread(() ->{
            for (int i = 0; i < 10000; i++) {
                synchronized (Main2.class) {
                    value++;
                }
            }
            System.out.println("线程二完成");
        });
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1000);
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static void test2() {

        Main2 main1 = new Main2();
        Main2 main2 = new Main2();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (main1) {
                    value++;
                }
            }
            System.out.println("线程一完成");
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (main2) {
                    value++;
                }
            }
            System.out.println("线程二完成");
        });
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1000);
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static synchronized void add() {
        value++;
    }
    static void test3() {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) add();
                System.out.println("线程一完成");
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) add();
                System.out.println("线程二完成");
        });
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1000);
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static void test4() {

        Object o1 = new Object();
        Object o2 = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (o1) {
                try {
                    Thread.sleep(1000);
                    synchronized (o2) {
                        System.out.println("线程一");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (o2) {
                try {
                    Thread.sleep(1000);
                    synchronized (o1) {
                        System.out.println("线程二");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

    }

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        test4();
    }

}
