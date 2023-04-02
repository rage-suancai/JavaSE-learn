wait和notify方法

其实我们之前可能就发现了 Object类还有三个方法我们从来没有使用过 分别是wait()、notify()以及notifyAll() 他们其实是需要配合synchronized来使用的
(实际上锁就是依附于对象存在的 每个对象都应该有针对于锁的一些操作 所以说就这样设计了)当然 只有在同步代码块中才能使用这些方法 正常情况下会报错 我们来看看他们的作用是什么:

                    public static void main(String[] args) throws InterruptedException {

                        Object o1 = new Object();

                        Thread t1 = new Thread(() -> {
                            synchronized (o1){
                                try {
                                    System.out.println("开始等待");
                                    o1.wait(); // 进入等待状态并释放锁
                                    System.out.println("等待结束");
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                        Thread t2 = new Thread(() -> {
                            synchronized (o1){
                                System.out.println("开始唤醒");
                                o1.notify(); // 唤醒处于等待状态的线程
                                for (int i = 0; i < 50; i++) {
                                    System.out.println(i);   
                                }
                                // 唤醒后依然需要等待这里的锁释放之前等待的线程才能继续
                            }
                        });

                        t1.start();
                        Thread.sleep(1000);
                        t2.start();

                    }

我们可以发现 对象的wait()方法会暂时使得此线程进入等待状态 同时会释放当前代码块持有的锁 这时其他线程可以获取到此对象的锁 当其他线程调用对象的notify()方法后
会唤醒刚才变成等待状态的线程(这时并没有立即释放锁)注意 必须是在持有锁(同步代码块内部)的情况下使用 否则会抛出异常

notifyAll其实和notify一样 也是用于唤醒 但是前者是唤醒所有调用wait()后处于等待的线程 而后者是看运气随机选择一个