守护线程

不要把操作系统重的守护进程和守护线程相提并论

守护进程在后台运行 不需要和用户交互 本质和普通进程类似 而守护线程就不一样了 当其他所有的非守护线程结束之后
守护线程自动结束 也就是说 Java中所有的线程都执行完毕后 守护线程自动结束 因此守护线程不适合进行IO操作 只适合打打杂

                    public static void main(String[] args) throws InterruptedException{

                        Thread t = new Thread(() -> {
                            while (true){
                                try {
                                    System.out.println("程序正常运行中...");
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                        t.setDaemon(true); // 设置为守护线程(必须在开始之前 中途是不允许转换的)
                        t.start();
                        for (int i = 0; i < 5; i++) {
                            Thread.sleep(1000);
                        }

                    }

在守护线程中产生的新线程也是守护的:

                    public static void main(String[] args) throws InterruptedException{

                        Thread t = new Thread(() -> {
                            Thread it = new Thread(() -> {
                                while (true){
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

                        t.setDaemon(true); // 设置为守护线程(必须在开始之前 中途是不允许转换的)
                        t.start();
                        for (int i = 0; i < 5; i++) {
                            Thread.sleep(1000);
                        }

                    }

----

再谈集合类

集合类中有一个东西是Java8新增的Spliterator接口 翻译过来就是: 可拆分迭代器(Splitable Iterator)和Iterator一样 Spliterator也用于遍历数据源中的元素
但它是为了并行执行而设计的 Java8已经为集合框架中包含的所有数据结构提供了一个默认的Spliterator实现 在集合根接口Collection中提供了一个spliterator()方法用于获取可拆分迭代器

其实我们之前在讲解集合类的根接口时 就发现有这样一个方法:

                    default Stream<E> parallelStream() {
                        return StreamSupport.stream(spliterator(), true); // parallelStream就是利用了可拆分迭代器进行多线程操作
                    }

并行流 其实就是一个多线程执行的流 它通过默认的ForkJoinPool实现(这里不讲解原理) 它可以提高你的多线程任务的速度

                    public static void main(String[] args) {

                        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 5, 2, 9, 3, 6, 0));
                        list
                                .parallelStream() // 获得并行流
                                .forEach(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));

                    }

我们发现 forEach操作的顺序 并不是我们实际List中的顺序 同时每次打印也是不同的线程在执行 我们可以通过调用forEachOrdered()方法来使用单线程维持原本的顺序:

                    public static void main(String[] args) {

                        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 5, 2, 9, 3, 6, 0));
                        list
                                .parallelStream() // 获得并行流
                                .forEachOrdered(System.out::println);

                    }

我们之前还发现 在Arrays数组工具类中 也包含大量的并行方法:

                    public static void main(String[] args) {

                        int[] arr = new int[]{1, 4, 5, 2, 9, 3, 6, 0};
                        Arrays.parallelSort(arr); // 使用多线程进行并行排序 效率更高
                        System.out.println(Arrays.toString(arr));

                    }

更多地使用并行方法 可以更加充分地发挥现代计算机多核心的优势 但是同时需要注意多线程产生的异步问题:

                    public static void main(String[] args) {

                        int[] arr = new int[]{1, 4, 5, 2, 9, 3, 6, 0};
                        Arrays.parallelSetAll(arr, i -> {
                            System.out.println(Thread.currentThread().getName());
                            return arr[i];
                        });
                        System.out.println(Arrays.toString(arr));

                    }

因为多线程的加入 我们之前认识的集合类都废掉了:

                    public static void main(String[] args) throws InterruptedException {

                        List<Integer> list = new ArrayList<>();

                        new Thread(() -> {
                            for (int i = 0; i < 1000; i++) {
                                list.add(i); // 两个线程同时操作集合类进行插入操作
                            }
                        }).start();

                        new Thread(() -> {
                            for (int i = 1000; i < 2000; i++) {
                                list.add(i);
                            }
                        }).start();

                        Thread.sleep(2000);
                        System.out.println(list.size());

                    }

我们发现 有些时候运气不好 得到的结果并不是2000个元素 而是:

        https://fast.itbaima.net/2022/10/04/m1nZfG4wPCOQx8V.png

因为之前的集合类 并没有考虑到多线程运行的情况 如果两个线程同时执行 那么有可能两个线程同一时间都执行同一个方法 这种情况下就很容易出问题:

                    public boolean add(E e) {
                        ensureCapacityInternal(size + 1); // 当数组容量更好还差一个满的时候 这个时候两个线程同时走到了这里 因为都判断为没满 所以说没有进行扩容 但是实际上两个线程都要插入一个元素进来
                        elementData[size++] = e; // 当两个线程同时在这里插入元素 直接导致越界访问
                        return true;
                    }

当然 在Java早期的时候 还有一些老的集合类 这些集合类都是线程安全的:

                    public static void main(String[] args) throws InterruptedException {

                        Vector<Integer> list = new Vector<>(); // 我们可以使用Vector代替List使用

                        // Hashtable<Integer, String> 也可以使用Hashtable来代替Map
                        new Thread(() -> {
                            for (int i = 0; i < 1000; i++) {
                                list.add(i);
                            }
                        }).start();

                        new Thread(() -> {
                            for (int i = 1000; i < 2000; i++) {
                                list.add(i);
                            }
                        }).start();
                    
                        Thread.sleep(1000);
                        System.out.println(list.size());

                    }

因为这些集合类中的每一个方法都加了锁 所以说不会出现多线程问题 但是这些老的集合类现在已经不再使用了 我们会在JUC篇视频教程中介绍专用于并发编程的集合类

通过对Java多线程的了解 我们就具备了利用多线程解决问题的思维