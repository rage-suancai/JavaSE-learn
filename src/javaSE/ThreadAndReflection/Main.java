package javaSE.ThreadAndReflection;

import java.util.*;

public class Main {

    private static int value = 0;

    public static void main(String[] args) {

        // threadTest1();

        // threadTest2();

        // threadTest3();

        // threadTest4();

        // threadTest5();

        // threadTest6();

        // threadTest7();

        // threadTest8();

        // threadTest9();

        // threadTest10();

        threadTest11();

    }

    private static void threadTest1() {

        /*Thread thread = new Thread(() -> {
            System.out.println("我是另一个线程");
        });
        thread.start();*/

        /*Thread thread = new Thread(() -> {
            System.out.println("我是线程: " + Thread.currentThread().getName());
            System.out.println("我正在计算 0-10000 之间所有树的和...");
            int sum = 0;
            for (int i = 0; i <= 10000; i++) sum += i;
            System.out.println("结果: " + sum);
        });
        thread.start();
        System.out.println("我是主线程");*/

        /*Thread thread1 = new Thread(() -> {
            for (int i = 0; i <= 50; i++) System.out.println("我是一号线程: " + i);
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i <= 50; i++) System.out.println("我是二号线程: " + i);
        });
        thread1.start(); thread2.start();*/

        /*Thread thread = new Thread(() -> {
            Thread me = Thread.currentThread();
            for (int i = 0; i < 50; i++) {
                System.out.println("打印: " + i);
                if (i == 20) me.stop();
            }
        });
        thread.start();*/

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) value++;
            System.out.println("线程1完成");
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) value++;
            System.out.println("线程2完成");
        });
        thread1.start(); thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(value);

    }

    private static void threadTest2() {

        /*Thread thread = new Thread(() -> {
            try {
                System.out.println("l");
                Thread.sleep(1000);
                System.out.println("b");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();*/

        /*Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        try {
            Thread.sleep(3000);
            thread.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        /*Thread thread = new Thread(() -> {
            System.out.println("线程开始运行");
            while (true) if (Thread.currentThread().isInterrupted()) break;
            System.out.println("线程被中断了");
        });
        thread.start();
        try {
            Thread.sleep(3000); thread.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        Thread thread = new Thread(() -> {
            System.out.println("线程开始运行");
            while (true) if (Thread.currentThread().isInterrupted()) {
                System.out.println("线程被中断了"); Thread.interrupted();
            }
        });
        thread.start();
        try {
            Thread.sleep(3000); thread.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void threadTest3() {

        Thread thread = new Thread(() -> System.out.println("线程开始运行"));
        thread.start();
        thread.setPriority(Thread.MIN_PRIORITY);

    }

    private static void threadTest4() {

        /*Thread thread1 = new Thread(() -> {
            System.out.println("线程一开始运行");
            for (int i = 0; i < 50; i++) {
                if (i % 5 == 0) {
                    System.out.println("让位"); Thread.yield();
                }
                System.out.println("一线程打印: " + i);
            }
            System.out.println("线程一结束");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("线程二开始运行");
            for (int i = 0; i < 50; i++) System.out.println("二线程打印: " + i);
        });
        thread1.start(); thread2.start();*/

        /*Thread thread1 = new Thread(() -> {
            System.out.println("线程一开始运行");
            for (int i = 0; i < 50; i++) System.out.println("一线程打印: " + i);
            System.out.println("线程一结束");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("线程二开始运行");
            for (int i = 0; i < 50; i++) {
                System.out.println("二线程打印: " + i);
                if (i == 10) {
                    try {
                        System.out.println("线程一加入到此线程"); thread1.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.start(); thread2.start();*/

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始运行");
            for (int i = 0; i < 50; i++) System.out.println(Thread.currentThread().getName() + "打印" + i);
            System.out.println("线程二结束");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("线程二开始运行");
            for (int i = 0; i < 50; i++) {
                System.out.println("二线程打印: " + i);
                if (i == 10) {
                    try {
                        System.out.println("线程一加入到此线程"); thread1.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.start(); thread2.start();

    }

    private static void threadTest5() {

        /*Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (Main.class) {
                    value++;
                }
            }
            System.out.println("线程二完成");
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (Main.class) {
                    value++;
                }
            }
            System.out.println("线程二完成");
        });
        thread1.start(); thread2.start();
        try {
            Thread.sleep(1000); System.out.println(value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        /*Main main1 = new Main(); Main main2 = new Main();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (main1) {
                    value++;
                }
            }
            System.out.println("线程二完成");
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (main2) {
                    value++;
                }
            }
            System.out.println("线程二完成");
        });
        thread1.start(); thread2.start();
        try {
            Thread.sleep(1000); System.out.println(value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) add();
            System.out.println("线程一完成");
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) add();
            System.out.println("线程二完成");
        });
        thread1.start(); thread2.start();
        try {
            Thread.sleep(1000); System.out.println(value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    private static synchronized void add() {
        value++;
    }

    private static void threadTest6() {

        Object o1 = new Object(); Object o2 = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized(o1) {
                try {
                    Thread.sleep(1000);
                    synchronized (o2) {
                        System.out.println("线程一");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized(o2) {
                try {
                    Thread.sleep(1000);
                    synchronized (o1) {
                        System.out.println("线程二");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start(); thread2.start();

    }

    private static void threadTest7() {

        Object o1 = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized(o1) {
                try {
                    System.out.println("开始等待");
                    o1.wait();
                    System.out.println("等待结束");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (o1) {
                System.out.println("开始唤醒"); o1.notify();
                for (int i = 0; i < 50; i++) System.out.println(i);
            }
        });
        try {
            thread1.start(); Thread.sleep(1000); thread2.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void threadTest8() {

        /*ThreadLocal<String> local = new ThreadLocal<>();
        Thread thread1 = new Thread(() -> {
            local.set("lbwnb");
            System.out.println("变量值已设定");
            System.out.println(local.get());
        });
        Thread thread2 = new Thread(() -> System.out.println(local.get()));
        try {
            thread1.start(); Thread.sleep(3000); thread2.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        /*ThreadLocal<Object> local = new ThreadLocal<>();
        Thread thread1 = new Thread(() -> {
            local.set("lbwnb");
            System.out.println("线程一变量值已设定");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程一读取变量值: ");
            System.out.println(local.get());
        });
        Thread thread2 = new Thread(() -> {
            local.set("yyds");
            System.out.println("线程二变量值已设定");
        });
        try {
            thread1.start(); Thread.sleep(1000); thread2.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        /*ThreadLocal<String> local = new ThreadLocal<>();
        Thread thread = new Thread(() -> {
            local.set("lbwnb");
            new Thread(() -> System.out.println(local.get())).start();
        });
        thread.start();*/

        ThreadLocal<String> local = new InheritableThreadLocal<>();
        Thread t = new Thread(() -> {
            local.set("lbwnb");
            new Thread(() -> System.out.println(local.get())).start();
        });
        t.start();

    }

    private static void threadTest9() {

        // new TimerTask(() -> System.out.println("我是定时任务"), 3000).start();

        // new TimerLoopTask(() -> System.out.println("我是定时任务"), 3000).start();

        Timer timer = new Timer();
        timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                timer.cancel();
            }
        },1000);

    }
    static class TimerTask {

        private Runnable task;
        private long time;

        public TimerTask(Runnable runnable, long time) {
            this.task = runnable;
            this.time = time;
        }

        public void start() {
            new Thread(() -> {
                try {
                    Thread.sleep(time); task.run();
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

    }
    static class TimerLoopTask {

        private Runnable task;
        private long loopTime;

        public TimerLoopTask(Runnable runnable, long loopTime) {
            this.task = runnable;
            this.loopTime = loopTime;
        }

        public void start() {
            new Thread(() -> {
                try {
                    while(true) {
                        Thread.sleep(loopTime); task.run();
                    }
                }catch(InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

    }

    private static void threadTest10() {

        /*Thread thread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("程序正常运行中...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.setDaemon(true); thread.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }*/

        Thread thread = new Thread(() -> {
            Thread it = new Thread(() -> {
                while(true) {
                    try {
                        System.out.println("程序正常运行中..."); Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            it.start();
        });
        thread.setDaemon(true); thread.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private static void threadTest11() {

        /*List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 5, 2, 9, 3, 6, 0));
        list.parallelStream().forEach(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));*/

        /*List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 5, 2, 9, 3, 6, 0));
        list.parallelStream().forEachOrdered(System.out::print);*/

        /*int[] arr = new int[]{1, 4, 5, 2, 9, 3, 6, 0};
        Arrays.parallelSort(arr);
        System.out.println(Arrays.toString(arr));*/

        /*int[] arr = new int[]{1, 4, 5, 2, 9, 3, 6, 0};
        Arrays.parallelSetAll(arr, i -> {
            System.out.println(Thread.currentThread().getName()); return arr[i];
        });
        System.out.println(Arrays.toString(arr));*/

        /*List<Integer> list = new ArrayList<>();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) list.add(i);
        }).start();
        new Thread(() -> {
            for (int i = 1000; i < 2000; i++) list.add(i);
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list.size());*/

        Vector<Integer> list = new Vector<>();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) list.add(i);
        }).start();
        new Thread(() -> {
            for (int i = 1000; i < 2000; i++) list.add(i);
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list.size());

    }

}
