threadLocal的使用

既然每个线程都有一个自己的工作内存 那么能否只在自己的工作内存中创建变量仅供线程自己使用呢?

我们可以使用ThreadLocal类 来创建工作内存中的变量 它将我们的变量值存储在内部(只能存储一个变量) 不同的线程访问到ThreadLocal对象时 都只能获取到当前线程所属的变量:

                    public static void main(String[] args) throws InterruptedException {

                        ThreadLocal<String> local = new ThreadLocal<>(); // 注意这是一个泛型类 存储类型为我们要存放的变量类型

                        Thread t1 = new Thread(() -> {
                            local.set("lbwnb"); // 将变量的值给予ThreadLocal
                            System.out.println("变量值已设定！");
                            System.out.println(local.get()); // 尝试获取ThreadLocal中存放的变量
                        });

                        Thread t2 = new Thread(() -> {
                            System.out.println(local.get()); // 尝试获取ThreadLocal中存放的变量
                        });

                        t1.start();
                        Thread.sleep(3000); // 间隔三秒
                        t2.start();

                    }

上面的例子中 我们开启两个线程分别去访问ThreadLocal对象 我们发现 第一个线程存放的内容 第一个线程可以获取
但是第二个线程无法获取 我们再来看看第一个线程存入后 第二个线程也存放 是否会覆盖第一个线程存放的内容:

                    public static void main(String[] args) throws InterruptedException {

                        ThreadLocal<String> local = new ThreadLocal<>(); // 注意这是一个泛型类 存储类型为我们要存放的变量类型

                        Thread t1 = new Thread(() -> {
                            local.set("lbwnb"); // 将变量的值给予ThreadLocal
                            System.out.println("线程1变量值已设定");
                            try {
                                Thread.sleep(2000); // 间隔2秒
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("线程1读取变量值: ");
                            System.out.println(local.get()); // 尝试获取ThreadLocal中存放的变量
                        });

                        Thread t2 = new Thread(() -> {
                            local.set("yyds"); // 将变量的值给予ThreadLocal
                            System.out.println("线程2变量值已设定");
                        });

                        t1.start();
                        Thread.sleep(1000); // 间隔1秒
                        t2.start();

                    }

我们发现 即使线程2重新设定了值 也没有影响到线程1存放的值 所以说 不同线程向ThreadLocal存放数据
只会存放在线程自己的工作空间中 而不会直接存放到主内存中 因此各个线程直接存放的内容互不干扰

我们发现在线程中创建的子线程 无法获得父线程工作内存中的变量:

                    public static void main(String[] args) {

                        ThreadLocal<String> local = new ThreadLocal<>();

                        Thread t = new Thread(() -> {
                           local.set("lbwnb");
                           new Thread(() -> {
                               System.out.println(local.get());
                           }).start();
                        });
                        t.start();

                    }

我们可以使用InheritableThreadLocal来解决:

                    public static void main(String[] args) {

                        ThreadLocal<String> local = new InheritableThreadLocal<>();
                        
                        Thread t = new Thread(() -> {
                           local.set("lbwnb");
                            new Thread(() -> {
                                System.out.println(local.get());
                            }).start();
                        });
                        t.start();

                    }

在InheritableThreadLocal存放的内容 会自动向子线程传递