线程锁和线程同步

在开始讲解线程同步之前 我们需要先了解一下多线程情况下Java的内存管理:

        https://fast.itbaima.net/2022/10/04/ZvI8neF3tdGJwS4.png

线程之间的共享变量(比如之前悬念中的value变量)存储在主内存(main memory)中 每个线程都有一个私有的工作内存(本地内存)
工作内存中存储了该线程以读/写共享变量的副本 它类似于我们在计算机组成原理中学习的多核心处理器高速缓存机制:

        https://fast.itbaima.net/2022/10/04/SKlbIZyvxMnauLJ.png

高速缓存通过保存内存中数据的副本来提供更加快速的数据访问 但是如果多个处理器的运算任务涉及同一块内存区域
就可能导致各自的高速缓存数据不一致 在写回主内存时就会发生冲突 这是引入高速缓存引发的新问题 称之为: 缓存一致性

实际上 Java的内存模型也是这样类似设计的 当我们同时去操作一个共享变量时 如果仅仅是读取还好 但是如果同时写入内容 就会出现问题
好比说一个银行 如果我和我的朋友同时在银行取我账户里面的钱 难道取1000还可能吐2000出来吗? 我们需要一种更加安全的机制来维持秩序 保证数据的安全性:

比如我们可以来看看下面这个问题:

                    private static int value = 0;

                    public static void main(String[] args) throws InterruptedException {

                        Thread t1 = new Thread(() -> {
                        for (int i = 0; i < 10000; i++) value++;
                            System.out.println("线程1完成");
                        });

                        Thread t2 = new Thread(() -> {
                            for (int i = 0; i < 10000; i++) value++;
                            System.out.println("线程2完成");
                        });

                        t1.start();
                        t2.start();
                        Thread.sleep(1000); // 主线程停止1秒 保证两个线程执行完成
                        System.out.println(value);

                    }

实际上 当两个线程同时读取value的时候 可能会同时拿到同样的值 而进行自增操作之后 也是同样的值 再写回主内存后 本来应该进行2次自增操作 实际上只执行了一次:

        https://fast.itbaima.net/2022/10/04/T2l3xfIP17Gr5dw.png

通过synchronized关键字来创造一个线程锁 首先我们来认识一下synchronized代码块 它需要在括号中填入一个内容 必须是一个对象或是一个类 我们在value自增操作外套上同步代码块:

                    private static int value = 0;

                    public static void main(String[] args) throws InterruptedException {

                        Thread t1 = new Thread(() -> {
                            for (int i = 0; i < 10000; i++) {
                                synchronized (Main.class){ // 使用synchronized关键字创建同步代码块
                                    value++;
                            }
                        }
                        System.out.println("线程1完成");
                        });

                        Thread t2 = new Thread(() -> {
                            for (int i = 0; i < 10000; i++) {
                                synchronized (Main.class){
                                    value++;
                            }
                        }
                        System.out.println("线程2完成");
                        });

                        t1.start();
                        t2.start();
                        Thread.sleep(1000); // 主线程停止1秒 保证两个线程执行完成
                        System.out.println(value);

                    }

我们发现 现在得到的结果就是我们想要的内容了 因为在同步代码块执行过程中 拿到了我们传入对象或类的锁(传入的如果是对象 就是对象锁 不同的对象代表不同的对象锁
如果是类 就是类锁 类锁只有一个 实际上类锁也是对象锁 是Class类实例 但是Class类实例同样的类无论怎么获取都是同一个) 但是注意两个线程必须使用同一把锁

当一个线程进入到同步代码块时 会获取到当前的锁 而这时如果其他使用同样的锁的同步代码块也想执行内容 就必须等待当前同步代码块的内容执行完毕 在执行完毕后会自动释放这把锁
而其他的线程才能拿到这把锁并开始执行同步代码块里面的内容(实际上synchronized是一种悲观锁 随时都认为有其他线程在对数据进行修改 后面在JUC篇视频教程中我们还会讲到乐观锁 如CAS算法)

那么我们来看看 如果使用的是不同对象的锁 那么还能顺利进行吗?

                    private static int value = 0;

                    public static void main(String[] args) throws InterruptedException {

                        Main main1 = new Main();
                        Main main2 = new Main();
                        Thread t1 = new Thread(() -> {
                            for (int i = 0; i < 10000; i++) {
                                synchronized (main1){
                                    value++;
                                }
                            }
                        System.out.println("线程1完成");
                        });

                        Thread t2 = new Thread(() -> {
                        for (int i = 0; i < 10000; i++) {
                            synchronized (main2){
                                value++;
                            }
                        }
                        System.out.println("线程2完成");
                        });

                        t1.start();
                        t2.start();
                        Thread.sleep(1000); // 主线程停止1秒 保证两个线程执行完成
                        System.out.println(value);

                    }

当对象不同时 获取到的是不同的锁 因此并不能保证自增操作的原子性 最后也得不到我们想要的结果

synchronized关键字也可以作用于方法上 调用此方法时也会获取锁:

                    private static int value = 0;

                    private static synchronized void add(){
                        value++;
                    }
                    
                    public static void main(String[] args) throws InterruptedException {

                        Thread t1 = new Thread(() -> {
                        for (int i = 0; i < 10000; i++) add();
                            System.out.println("线程1完成");
                        });

                        Thread t2 = new Thread(() -> {
                        for (int i = 0; i < 10000; i++) add();
                            System.out.println("线程2完成");
                        });

                        t1.start();
                        t2.start();
                        Thread.sleep(1000); // 主线程停止1秒 保证两个线程执行完成
                        System.out.println(value);

                    }

我们发现实际上效果是相同的 只不过这个锁不用你去给 如果是静态方法 就是使用的类锁 而如果是普通成员方法 就是使用的对象锁 通过灵活的使用synchronized就能很好地解决我们之前提到的问题了

----

死锁

其实死锁的概念在操作系统中也有提及 它是指两个线程相互持有对方需要的锁 但是又迟迟不释放 导致程序卡住

        https://fast.itbaima.net/2022/10/04/Ja6TPO23wCI8pvn.png

我们发现 线程A和线程B都需要对方的锁 但是又被对方牢牢把握 由于线程被无限期地阻塞 因此程序不可能正常终止 我们来看看以下这段代码会得到什么结果:

                    public static void main(String[] args) throws InterruptedException {

                        Object o1 = new Object();
                        Object o2 = new Object();

                        Thread t1 = new Thread(() -> {
                            synchronized (o1){
                                try {
                                    Thread.sleep(1000);
                                    synchronized (o2){
                                        System.out.println("线程1");
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                        Thread t2 = new Thread(() -> {
                            synchronized (o2){
                                try {
                                    Thread.sleep(1000);
                                    synchronized (o1){
                                        System.out.println("线程2");
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                        t1.start();
                        t2.start();

                    }

所以 我们在编写程序时 一定要注意 不要出现这种死锁的情况 那么我们如何去检测死锁呢? 我们可以利用jstack命令来检测死锁 首先利用jps找到我们的java进程:

                    nagocoler@NagodeMacBook-Pro ~ % jps
                    51592 Launcher
                    51690 Jps
                    14955
                    51693 Main
                    nagocoler@NagodeMacBook-Pro ~ % jstack 51693
                    ...
                    Java stack information for the threads listed above:
                    ===================================================
                    "Thread-1":
                    at com.test.Main.lambda$main$1(Main.java:46)
                    - waiting to lock <0x000000076ad27fc0> (a java.lang.Object)
                    - locked <0x000000076ad27fd0> (a java.lang.Object)
                    at com.test.Main$$Lambda$2/1867750575.run(Unknown Source)
                    at java.lang.Thread.run(Thread.java:748)
                    "Thread-0":
                    at com.test.Main.lambda$main$0(Main.java:34)
                    - waiting to lock <0x000000076ad27fd0> (a java.lang.Object)
                    - locked <0x000000076ad27fc0> (a java.lang.Object)
                    at com.test.Main$$Lambda$1/396873410.run(Unknown Source)
                    at java.lang.Thread.run(Thread.java:748)
                    
                    Found 1 deadlock.

jstack自动帮助我们找到了一个死锁 并打印出了相关线程的栈追踪信息 同样的 使用jconsole也可以进行监测

因此 前面说不推荐使用suspend()去挂起线程的原因 是因为suspend()在使线程暂停的同时 并不会去释放任何锁资源 其他线程都无法访问被它占用的锁 直到对应的线程执行resume()方法后
被挂起的线程才能继续 从而其它被阻塞在这个锁的线程才可以继续执行 但是 如果resume()操作出现在suspend()之前执行 那么线程将一直处于挂起状态 同时一直占用锁 这就产生了死锁