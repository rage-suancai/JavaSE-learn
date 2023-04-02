package javaSE.javaseSenior.javase11;

public class Main1 {

    private static int value = 0;
    static void test1() {

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
        try {
            Thread.sleep(1000);
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        test1();
    }

}
