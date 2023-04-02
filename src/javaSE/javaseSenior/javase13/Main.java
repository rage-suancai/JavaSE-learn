package javaSE.javaseSenior.javase13;

public class Main {

    static void test1() {

        ThreadLocal<String> local = new ThreadLocal<>();

        /*Thread thread1 = new Thread(() -> {
            local.set("yxsnb");
            System.out.println("变量值已设定");
            System.out.println(local.get());
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(local.get());
        });
        try {
            thread1.start();
            Thread.sleep(3000);
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Thread thread1 = new Thread(() -> {
            local.set("yxsnb");
            System.out.println("线程一变量值已设定");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程一读取变量值");
            System.out.println(local.get());
        });
        Thread thread2 = new Thread(() -> {
            local.set("yyds");
            System.out.println("线程二变量值已经设定");
            System.out.println("线程二读取变量值");
            System.out.println(local.get());
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

        ThreadLocal<String> local1 = new ThreadLocal<>();
        ThreadLocal<String> local2 = new InheritableThreadLocal<>();

        Thread thread = new Thread(() -> {
            local2.set("yxsnb");
            new Thread(() -> {
                System.out.println(local2.get());
            }).start();
        });
        thread.start();

    }

    public static void main(String[] args) {
        test1();
        //test2();
    }

}
