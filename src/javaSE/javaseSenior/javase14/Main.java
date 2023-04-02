package javaSE.javaseSenior.javase14;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    static void test1() {
        new TimerTaskMe(() -> System.out.println("我是定时器"), 3000).start();
    }

    static void test2() {
        new TimerTaskMe(() -> System.out.println("我是定时器"), 1000).startRun();
    }

    static void test3() {

        /*Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 1000);*/

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                timer.cancel();
            }
        }, 1000);

    }

    public static void main(String[] args) {
        test1();
        //test2();
        //test3();
    }

}
