<img src="https://image.itbaima.cn/markdown/2022/10/04/aRsN9WoS7BcC3uY.png"/>

## 多线程与反射
前面我们已经讲解了JavaSE的大部分核心内容 最后一章 我们还将继续学习JavaSE中提供的各种高级特性 这些高级特性对于我们之后的学习 会有着举足轻重的作用

### 多线程
注意: 本章节会涉及到**操作系统**相关知识

在了解多线程之前 让我们回顾一下`操作系统`中提到的进程概念:

<img src="https://image.itbaima.cn/markdown/2022/10/04/GhrSTfNRsc2jFZM.jpg"/>

进程是程序执行的实体 每一个进程都是一个应用程序(比如我们运行QQ, 浏览器, LOL, 网易云音乐等软件) 都有自己的内存空间
CPU一个核心同时只能处理一件事情 当出现多个进程需要同时运行时 CPU一般通过`时间片轮转调度`算法 来实现多个进程的同时运行

<img src="https://image.itbaima.cn/markdown/2022/10/04/hUkGafu7vztB4qR.png"/>

在早期的计算机中 进程是拥有资源和独立运行的最小单位 也是程序执行的最小单位 但是 如果我希望两个任务同时进行 就必须运行两个进程 由于每个进程都有一个自己的内存空间
进程之间的通信就变得非常麻烦(比如要共享某些数据) 而且执行不同进程会产生上下文切换 非常耗时 那么能否实现在一个进程中就能够执行多个任务呢?

<img src="https://image.itbaima.cn/markdown/2022/10/04/okgq3HEKGn6jBVw.png"/>

后来 线程横空出世 一个进程可以有多个线程 线程是程序执行中一个单一的顺序控制流程 现在线程才是程序执行流的最小单元 各个线程之间共享程序的内存空间(也就是所在进程的内存空间) 上下文切换速度也高于进程

在Java中 我们从开始 一直以来编写的都是单线程应用程序(运行main()方法的内容) 也就是说只能同时执行一个任务(无论你是调用方法, 还是进行计算 始终都是依次进行的 也就是同步的) 
而如果我们希望同时执行多个任务(两个方法同时在运行或者是两个计算同时在进行 也就是异步的) 就需要用到Java多线程框架 实际上一个Java程序启动后 会创建很多线程 不仅仅只运行一个主线程:

```java
                        public static void main(String[] args) {
        
                            ThreadMXBean bean = ManagementFactory.getThreadMXBean();
                            long[] ids = bean.getAllThreadIds();
                            ThreadInfo[] infos = bean.getThreadInfo(ids);
                            for (ThreadInfo info : infos) {
                                System.out.println(info.getThreadName());
                            }
                            
                        }
```

关于除了main线程默认以外的线程 涉及到JVM相关底层原理 在这里不做讲解 了解就行

#### 线程的创建和启动
通过创建Thread对象来创建一个新的线程 Thread构造方法中需要传入一个Runnable接口的实现(其实就是编写要在另一个线程执行的内容逻辑) 同时Runnable只有一个未实现方法 因此可以直接使用lambda表达式:

```java
                        @FunctionalInterface
                        public interface Runnable {
                            /**
                             * When an object implementing interface <code>Runnable</code> is used
                             * to create a thread, starting the thread causes the object's
                             * <code>run</code> method to be called in that separately executing
                             * thread.
                             * <p>
                             * The general contract of the method <code>run</code> is that it may
                             * take any action whatsoever.
                             *
                             * @see     java.lang.Thread#run()
                             */
                            public abstract void run();
                        }
```

创建好后 通过调用`start()`方法来运行此线程:

```java
                        public static void main(String[] args) {
    
                            Thread t = new Thread(() -> { // 直接编写逻辑
                                System.out.println("我是另一个线程!");
                            });
                            t.start(); // 调用此方法来开始执行此线程
    
                        }
```

可能上面的例子看起来和普通的单线程没两样 那我们先来看看下面这段代码的运行结果:

```java
                        public static void main(String[] args) {
    
                            Thread t = new Thread(() -> {
                                System.out.println("我是线程: " + Thread.currentThread().getName());
                                System.out.println("我正在计算 0-10000 之间所有数的和...");
                                int sum = 0;
                                for (int i = 0; i <= 10000; i++) {
                                    sum += i;
                                }
                                System.out.println("结果: " + sum);
                            });
                            t.start();
                            System.out.println("我是主线程");
                            
                        }
```

我们发现 这段代码执行输出结果并不是按照从上往下的顺序了 因为它们分别位于两个线程 它们是同时进行的 如果你还是觉得很疑惑 我们接着来看下面的代码运行结果:

注意: 我们发现还有一个run方法 也能执行线程里面定义的内容 但是run是直接在当前线程执行 并不是创建一个线程执行!







































