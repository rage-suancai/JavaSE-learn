package javaSE.ThreadAndReflection;

public class Main {

    public static void main(String[] args) {

        // threadTest1();

        threadTest2();

    }

    public static void threadTest1() {

        Thread thread = new Thread(() -> {
            System.out.println("我是另一个线程");
        });
        thread.start();

    }

    public static void threadTest2() {

        /*Thread thread = new Thread(() -> {
            System.out.println("我是线程: " + Thread.currentThread().getName());
            System.out.println("我正在计算 0-10000 之间所有树的和...");
            int sum = 0;
            for (int i = 0; i <= 10000; i++) sum += i;
            System.out.println("结果: " + sum);
        });
        thread.start();
        System.out.println("我是主线程");*/

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i <= 50; i++) System.out.println("我是一号线程: " + i);
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i <= 50; i++) System.out.println("我是二号线程: " + i);
        });
        thread1.start();
        thread2.start();

    }

}
