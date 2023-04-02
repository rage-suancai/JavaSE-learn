package javaSE.javaseSenior.javase10;

public class Main {

    static void test1() {

        Thread thread = new Thread(() -> {
            System.out.println("线程一开始运行");
        });
        thread.start();
        thread.setPriority(Thread.MIN_PRIORITY);

    }

    static void test2() {

        Thread thread1 = new Thread(() -> {
            System.out.println("线程一开始运行");
            for (int i = 0; i < 50; i++) {
                if (i % 5 == 0) {
                    System.out.println("让位");
                    Thread.yield();
                }
                System.out.println("一打印: " + i);
            }
            System.out.println("线程一结束");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("线程二开始运行");
            for (int i = 0; i < 50; i++) {
                System.out.println("二打印: " + i);
            }
        });
        thread1.start();
        thread2.start();

    }

    static void test3() {

        Thread thread1 = new Thread(() -> {
            System.out.println("线程一开始运行");
            for (int i = 0; i < 50; i++) {
                System.out.println("一打印: " + i);
            }
            System.out.println("线程一结束");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("线程二开始运行");
            for (int i = 0; i < 50; i++) {
                System.out.println("二打印: " + i);
                if (i == 10) {
                    try {
                        System.out.println("线程一加入到此线程");
                        thread1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("线程二结束");
        });
        thread1.start();
        thread2.start();

    }

    static void test4() {

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始运行");
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + " 打印: " + i);
            }
            System.out.println(Thread.currentThread().getName() + "线程结束");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始运行");
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + " 打印: " + i);
                if (i == 10) {
                    try {
                        System.out.println("线程一加入此线程");
                        thread1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread() + "线程结束");
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
