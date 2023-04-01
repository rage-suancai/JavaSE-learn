package javaSE.javaseSenior.javase9;

public class Main {

    static void test1(){

        Thread thread = new Thread(() -> {
            System.out.println("我是另一个线程: " + Thread.currentThread().getName());
        });
        thread.start();

    }

    static void test2() {

        Thread thread = new Thread(() -> {
            System.out.println("我是线程: " + Thread.currentThread().getName());
            System.out.println("我正在计算 0-10000 之间所有数的和....");
            int sum = 0;
            for (int i = 0; i < 10000; i++) {
                sum += i;
            }
            System.out.println("结果是: " + sum);
        });
        thread.start();
        System.out.println("我是主线程");

    }

    static void test3() {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                System.out.println("我是一号线程: " + i);
            }
        });
        Thread thread2 = new Thread(() ->{
            for (int i = 0; i < 200; i++) {
                System.out.println("我是二号线程: " + i);
            }
        });
        thread1.start();
        thread2.start();

    }

    static void test4() throws InterruptedException {

        /*System.out.print("Y");
        Thread.sleep(1000);
        System.out.print("X");
        Thread.sleep(1000);
        System.out.print("S");
        Thread.sleep(1000);
        System.out.println("NB");*/

        Thread thread = new Thread(() -> {
            Thread me = Thread.currentThread();
            for (int i = 0; i < 50; i++) {
                System.out.println("打印: " + i);
                if (i == 20) me.stop();
            }
        });
        thread.start();

    }

    private static int value = 0;
    static void test5() throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) value++;
            System.out.println("线程一完成");
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) value++;
            System.out.println("线程二完成");
        });
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        System.out.println(value);

    }

    public static void main(String[] args) {

        //test1();
        //test2();
        //test3();
        try {
            //test4();
            test5();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
