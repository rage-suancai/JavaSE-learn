线程的优先级

实际上 Java程序中的每个线程并不是平均分配CPU时间的 为了使得线程资分配更加合理 Java采用的是抢占式调度方式 优先级越高的线程
优先使用CPU资源 我们希望CPU花费更多的时间去处理更重要的任务 而不太重要的任务 则可以先让出一部分资源 线程的优先级一般分为以下三种:

    > MIN_PRIORITY 最低优先级
    > MAX_PRIORITY 最高优先级
    > NOM_PRIORITY 常规优先级

                    public static void main(String[] args) {

                        Thread t = new Thread(() -> {
                            System.out.println("线程开始运行");
                        });

                        t.start();
                        t.setPriority(Thread.MIN_PRIORITY);  // 通过使用setPriority方法来设定优先级

                    }

优先级越高的线程 获得CPU资源的概率会越大 并不是说一定优先级越高的线程越先执行

线程的礼让和加入

我们还可以在当前线程的工作不重要时 将CPU资源让位给其他线程 通过使用yield()方法来将当前资源让位给其他同优先级线程:

                    public static void main(String[] args) {

                        Thread t1 = new Thread(() -> {
                            System.out.println("线程1开始运行");
                            for (int i = 0; i < 50; i++) {
                                if(i % 5 == 0) {
                                    System.out.println("让位");
                                    Thread.yield();
                                }
                                System.out.println("1打印: " + i);
                            }
                            System.out.println("线程1结束");
                        });

                        Thread t2 = new Thread(() -> {
                            System.out.println("线程2开始运行");
                            for (int i = 0; i < 50; i++) {
                                System.out.println("2打印: " + i);
                            }
                        });
                        t1.start();
                        t2.start();

                    }

观察结果 我们发现 在让位之后 尽可能多的在执行线程2的内容

当我们希望一个线程等待另一个线程执行完成后再继续进行 我们可以使用join()方法来实现线程的加入:

                    public static void main(String[] args) {

                        Thread t1 = new Thread(() -> {
                            System.out.println("线程1开始运行");
                            for (int i = 0; i < 50; i++) {
                                System.out.println("1打印: " + i);
                            }
                            System.out.println("线程1结束");
                        });

                        Thread t2 = new Thread(() -> {
                            System.out.println("线程2开始运行");
                            for (int i = 0; i < 50; i++) {
                                System.out.println("2打印: " + i);
                                if(i == 10){
                                    try {
                                        System.out.println("线程1加入到此线程");
                                        t1.join(); // 在i==10时 让线程1加入 先完成线程1的内容 在继续当前内容
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });

                        t1.start();
                        t2.start();

                    }

实际上 t2线程只是暂时处于等待状态 当t1执行结束时 t2才开始继续执行 只是在效果上看起来好像是两个线程合并为一个线程在执行而已