package javaSE.javaseSenior.javase9;

public class Main {

    static void test1() {

        /*Thread thread = new Thread(() -> {
            try {
                System.out.print("N");
                Thread.sleep(1000);
                System.out.println("B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();*/

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            Thread.sleep(3000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static void test2() {

        /*Thread thread = new Thread(() -> {
            System.out.println("线程开始运行");
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
            System.out.println("线程被中断了");
        });
        thread.start();
        try {
            Thread.sleep(5000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Thread thread = new Thread(() -> {
            System.out.println("线程开始运行");
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("发现中断信号中 复位成功继续运行...");
                    Thread.interrupted();
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(3000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static void test3() {

        Thread thread = new Thread(() -> {
            System.out.println("线程开始运行");
            Thread.currentThread().suspend();
            System.out.println("线程继续运行");
        });
        thread.start();
        try {
            Thread.sleep(3000);
            thread.resume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        //test1();
        //test2();
        test3();

    }

}
