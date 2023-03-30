Queue和Deque

通过前面的学习 我们已经了解了List的使用 其中LinkedList除了可以直接当做列表使用之外 还可以当做其他的数据结构使用 可以看到它不仅仅实现了List接口:

                    public class LinkedList<E>
                        extends AbstractSequentialList<E>
                        implements List<E>, Deque<E>, Cloneable, java.io.Serializable
                    {

这个Deque接口是干嘛的呢? 我们先来看看它的继承结构:

        https://fast.itbaima.net/2022/10/02/sCMgv9rl5b743BE.png

我们先来看看队列接口 它扩展了大量队列相关操作:

                    public interface Queue<E> extends Collection<E> {
                        // 队列的添加操作 是在队尾进行插入(只不过List也是一样的 默认都是尾插)
                        // 如果插入失败 会直接抛出异常
                        boolean add(E e);
                    
                        // 同样是添加操作 但是插入失败不会抛出异常
                        boolean offer(E e);
                    
                        // 移除队首元素 但是如果队列已经为空 那么会抛出异常
                        E remove();
                    
                        // 同样是移除队首元素 但是如果队列为空 会返回null
                        E poll();
                    
                        // 仅获取队首元素 不进行出队操作 但是如果队列已经为空 那么会抛出异常
                        E element();
                    
                        // 同样是仅获取队首元素 但是如果队列为空 会返回null
                        E peek();
                    }

我们可以直接将一个LinkedList当做一个队列来使用:

                    public static void main(String[] args) {

                        Queue<String> queue = new LinkedList<>(); // 当做队列使用 还是很方便的
                        queue.offer("AAA");
                        queue.offer("BBB");
                        System.out.println(queue.poll());
                        System.out.println(queue.poll());

                    }

        https://fast.itbaima.net/2022/10/02/veHxlUkKyVYErgm.png

我们接着来看双端队列 实际上双端队列就是队列的升级版 我们一个普通的队列就是:

        https://fast.itbaima.net/2022/07/25/xBuZckTNtR54AEq.png

普通队列中从队尾入队 队首出队 而双端队列允许在队列的两端进行入队和出队操作:

        https://fast.itbaima.net/2022/10/02/gn8i3teclAKbhQS.png

        https://fast.itbaima.net/2022/10/02/in8IX3QkwtsLgWN.png

利用这种特性 双端队列既可以当做普通队列使用 也可以当做栈来使用 我们来看看Java中是如何定义的Deque双端队列接口的:

                    // 在双端队列中 所有的操作都有分别对应队首和队尾的
                    public interface Deque<E> extends Queue<E> {
                    // 在队首进行插入操作
                    void addFirst(E e);
                    
                        // 在队尾进行插入操作
                        void addLast(E e);
                            
                        // 不用多说了吧?
                        boolean offerFirst(E e);
                        boolean offerLast(E e);
                    
                        // 在队首进行移除操作
                        E removeFirst();
                    
                        // 在队尾进行移除操作
                        E removeLast();
                    
                        // 不用多说了吧?
                        E pollFirst();
                        E pollLast();
                    
                        // 获取队首元素
                        E getFirst();
                    
                        // 获取队尾元素
                        E getLast();
                    
                        // 不用多说了吧?
                        E peekFirst();
                        E peekLast();
                    
                        // 从队列中删除第一个出现的指定元素
                        boolean removeFirstOccurrence(Object o);
                    
                        // 从队列中删除最后一个出现的指定元素
                        boolean removeLastOccurrence(Object o);
                    
                        // *** 队列中继承下来的方法操作是一样的 这里就不列出了 ***
                    
                        ...
                    
                        // *** 栈相关操作已经帮助我们定义好了 ***
                    
                        // 将元素推向栈顶
                        void push(E e);
                    
                        // 将元素从栈顶出栈
                        E pop();
                    
                    
                        // *** 集合类中继承的方法这里也不多种介绍了 ***
                    
                        ...
                    
                        // 生成反向迭代器 这个迭代器也是单向的 但是是next方法是从后往前进行遍历的
                        Iterator<E> descendingIterator();
                    
                    }

我们可以来测试一下 比如我们可以直接当做栈来进行使用:

                    public static void main(String[] args) {

                        Deque<String> deque = new LinkedList<>();
                        deque.push("AAA");
                        deque.push("BBB");
                        System.out.println(deque.pop());
                        System.out.println(deque.pop());

                    }

        https://fast.itbaima.net/2022/10/02/92woGL5MiBsTcKe.png

可以看到 得到的顺序和插入顺序是完全相反的 其实只要各位理解了前面讲解的数据结构 就很简单了 我们来测试一下反向迭代器和正向迭代器:

                    public static void main(String[] args) {

                        Deque<String> deque = new LinkedList<>();
                        deque.addLast("AAA");
                        deque.addLast("BBB");
                        
                        Iterator<String> descendingIterator = deque.descendingIterator();
                        System.out.println(descendingIterator.next());
                    
                        Iterator<String> iterator = deque.iterator();
                        System.out.println(iterator.next());

                    }

可以看到 正向迭代器和反向迭代器的方向是完全相反的

当然 除了LinkedList实现了队列接口之外 还有其他的实现类 但是并不是很常用 这里做了解就行了:

                    public static void main(String[] args) {

                        Deque<String> deque = new ArrayDeque<>(); // 数组实现的栈和队列
                        Queue<String> queue = new PriorityQueue<>(); // 优先级队列

                    }

这里需要介绍一下优先级队列 优先级队列可以根据每一个元素的优先级 对出队顺序进行调整 默认情况按照自然顺序:

                    public static void main(String[] args) {

                        Queue<Integer> queue = new PriorityQueue<>();
                        queue.offer(10);
                        queue.offer(4);
                        queue.offer(5);
                        System.out.println(queue.poll());
                        System.out.println(queue.poll());
                        System.out.println(queue.poll());

                    }

        https://fast.itbaima.net/2022/10/03/bmEP9fgCS1Ksaqw.png

可以看到 我们的插入顺序虽然是10/4/5 但是出队顺序是按照优先级来的 类似于VIP用户可以优先结束排队 我们也可以自定义比较规则 同样需要给一个Comparator的实现:

                    public static void main(String[] args) {

                        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a); // 按照从大到小顺序出队
                        queue.offer(10);
                        queue.offer(4);
                        queue.offer(5);
                        System.out.println(queue.poll());
                        System.out.println(queue.poll());
                        System.out.println(queue.poll());

                    }

        https://fast.itbaima.net/2022/10/03/G5SZgKxvUJyPABD.png

只不过需要注意的是 优先级队列并不是队列中所有的元素都是按照优先级排放的 优先级队列只能保证出队顺序是按照优先级进行的 我们可以打印一下:

        https://fast.itbaima.net/2022/10/03/9dSheG4xqFoXB5i.png

想要了解优先级队列的具体是原理 可以在《数据结构与算法》篇章节中学习大顶堆和小顶堆