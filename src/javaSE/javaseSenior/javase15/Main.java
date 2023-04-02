package javaSE.javaseSenior.javase15;

import java.util.Arrays;

public class Main {

    static void test1() {

        /*Thread thread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("程序正常运行中...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        Thread thread1 = new Thread(() -> {
            Thread it = new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("程序正常运行中...");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            it.start();
        });
        thread1.setDaemon(true);
        thread1.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static void test2() {

        /*List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 5, 2, 8, 3, 6, 0));
        list
                .parallelStream()
                .forEach(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));
                //.forEachOrdered(System.out::print);*/

        /*int[] arr = new int[] {1, 4, 5, 2, 9, 3, 6, 0};
        Arrays.parallelSort(arr);
        System.out.println(Arrays.toString(arr));*/

        int[] arr = new int[] {1, 4, 5, 2, 9, 3, 6, 0};
        Arrays.parallelSetAll(arr, i -> {
            System.out.println(Thread.currentThread().getName());
            return arr[i];
        });
        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        //test1();
        test2();
    }

}
