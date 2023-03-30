List列表

List是集合类型的一个分支 它的主要特性有:

    > 是一个有序的集合 插入元素默认是插入到尾部 按顺序从前往后存放 每个元素都有一个自己的下标位置
    > 列表中允许存在重复元素

在List接口中 定义了列表类型需要支持的全部操作 List直接继承自前面介绍的Collection接口
其中很多地方重新定义了一次Collection接口中定义的方法 这样做是为了更加明确方法的具体功能 当然 为了直观 我们这里就省略掉:

                    // List是一个有序的集合类 每个元素都有一个自己的下标位置
                    // List中可插入重复元素
                    // 针对于这些特性 扩展了Collection接口中一些额外的操作
                    public interface List<E> extends Collection<E> {
                        ...
                    
                        // 将给定集合中所有元素插入到当前结合的给定位置上(后面的元素就被挤到后面去了 跟我们之前顺序表的插入是一样的)
                        boolean addAll(int index, Collection<? extends E> c);
                    
                        ...
                    
                        // Java8新增方法 可以对列表中每个元素都进行处理 并将元素替换为处理之后的结果
                        default void replaceAll(UnaryOperator<E> operator) {
                            Objects.requireNonNull(operator);
                            final ListIterator<E> li = this.listIterator(); // 这里同样用到了迭代器
                            while (li.hasNext()) {
                                li.set(operator.apply(li.next()));
                            }
                        }
                    
                        // 对当前集合按照给定的规则进行排序操作 这里同样只需要一个Comparator就行了
                        @SuppressWarnings({"unchecked", "rawtypes"})
                        default void sort(Comparator<? super E> c) {
                            Object[] a = this.toArray();
                            Arrays.sort(a, (Comparator) c);
                            ListIterator<E> i = this.listIterator();
                            for (Object e : a) {
                                i.next();
                                i.set((E) e);
                            }
                        }
                    
                        ...
                    
                        // -------- 这些是List中独特的位置直接访问操作 --------
                    
                         // 获取对应下标位置上的元素
                        E get(int index);
                    
                        // 直接将对应位置上的元素替换为给定元素
                        E set(int index, E element);
                    
                        // 在指定位置上插入元素 就跟我们之前的顺序表插入是一样的
                        void add(int index, E element);
                    
                        // 移除指定位置上的元素
                        E remove(int index);
                    
                    
                        // ------- 这些是List中独特的搜索操作 -------
                    
                        // 查询某个元素在当前列表中的第一次出现的下标位置
                        int indexOf(Object o);
                    
                        // 查询某个元素在当前列表中的最后一次出现的下标位置
                        int lastIndexOf(Object o);
                    
                    
                        // ------- 这些是List的专用迭代器 -------
                    
                        // 迭代器我们会在下一个部分讲解
                        ListIterator<E> listIterator();
                    
                        // 迭代器我们会在下一个部分讲解
                        ListIterator<E> listIterator(int index);
                    
                        // ------- 这些是List的特殊转换 -------
                    
                        // 返回当前集合在指定范围内的子集
                        List<E> subList(int fromIndex, int toIndex);
                    
                        ...
                    }

可以看到 在List接口中 扩展了大量列表支持的操作 其中最突出的就是直接根据下标位置进行的增删改查操作 而在ArrayList中 底层就是采用数组实现的 跟我们之前的顺序表思路差不多:

                    public class ArrayList<E> extends AbstractList<E>
                            implements List<E>, RandomAccess, Cloneable, java.io.Serializable
                    {
                    
                        // 默认的数组容量
                        private static final int DEFAULT_CAPACITY = 10;
                    
                        ...
                    
                        // 存放数据的底层数组 这里的transient关键字我们会在后面I/O中介绍用途
                        transient Object[] elementData;
                    
                        // 记录当前数组元素数的
                        private int size;
                    
                        // 这是ArrayList的其中一个构造方法
                        public ArrayList(int initialCapacity) {
                            if (initialCapacity > 0) {
                                this.elementData = new Object[initialCapacity]; // 根据初始化大小 创建当前列表
                            } else if (initialCapacity == 0) {
                                this.elementData = EMPTY_ELEMENTDATA;
                            } else {
                                throw new IllegalArgumentException("Illegal Capacity: "+
                                                                   initialCapacity);
                            }
                        }
                      
                          ...
                          
                           public boolean add(E e) {
                           ensureCapacityInternal(size + 1); // 这里会判断容量是否充足 不充足需要扩容
                           elementData[size++] = e;
                           return true;
                        }
                          
                          ...
                        
                            // 默认的列表最大长度为Integer.MAX_VALUE - 8
                            // JVM都C++实现中 在数组的对象头中有一个_length字段 用于记录数组的长
                            // 度 所以这个8就是存了数组_length字段(这个只做了解就行)
                            private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
                          
                          private void grow(int minCapacity) {
                            int oldCapacity = elementData.length;
                            int newCapacity = oldCapacity + (oldCapacity >> 1); // 扩容规则跟我们之前的是一样的 也是1.5倍
                            if (newCapacity - minCapacity < 0) // 要是扩容之后的大小还没最小的大小大 那么直接扩容到最小的大小
                                newCapacity = minCapacity;
                            if (newCapacity - MAX_ARRAY_SIZE > 0) // 要是扩容之后比最大的大小还大 需要进行大小限制
                                newCapacity = hugeCapacity(minCapacity); // 调整为限制的大小
                            elementData = Arrays.copyOf(elementData, newCapacity); // 使用copyOf快速将内容拷贝到扩容后的新数组中并设定为新的elementData底层数组
                        }
                    }

一般的 如果我们要使用一个集合类 我们会使用接口的引用:

                    public static void main(String[] args) {

                        List<String> list = new ArrayList<>(); // 使用接口的引用来操作具体的集合类实现 是为了方便日后如果我们想要更换不同的集合类实现 而且接口中本身就已经定义了主要的方法 所以说没必要直接用实现类
                        list.add("科技与狠活"); // 使用add添加元素
                        list.add("上头啊");
                        System.out.println(list); // 打印集合类 可以得到一个非常规范的结果

                    }

可以看到 打印集合类的效果 跟我们使用Arrays工具类是一样的:

        https://fast.itbaima.net/2022/10/01/v3uzfnhamXV5St8.png

集合的各种功能我们都可以来测试一下 特别注意一下 我们在使用Integer时 要注意传参问题:

                    public static void main(String[] args) {

                        List<Integer> list = new ArrayList<>();
                        list.add(10); // 添加Integer的值10
                        list.remove((Integer) 10); // 注意 不能直接用10 默认情况下会认为传入的是int类型值 删除的是下标为10的元素 我们这里要删除的是刚刚传入的值为10的Integer对象
                        System.out.println(list); // 可以看到 此时元素成功被移除

                    }

那要是这样写呢?

                    public static void main(String[] args) {

                        List<Integer> list = new ArrayList<>();
                        list.add(new Integer(10)); // 添加的是一个对象
                        list.remove(new Integer(10)); // 删除的是另一个对象
                        System.out.println(list);

                    }

可以看到 结果依然是删除成功 这是因为集合类在删除元素时 只会调用equals方法进行判断是否为指定元素
而不是进行等号判断 所以说一定要注意 如果两个对象使用equals方法相等 那么集合中就是相同的两个对象:

                    // ArrayList源码部分
                    public boolean remove(Object o) {
                        if (o == null) {
                            ...
                        } else {
                            for (int index = 0; index < size; index++)
                            if (o.equals(elementData[index])) { // 这里只是对两个对象进行equals判断
                                fastRemove(index);
                                return true; // 只要判断成功 直接认为就是要删除的对象 删除就完事
                            }
                        }
                        return false;
                    }

列表中允许存在相同元素 所以说我们可以添加两个一模一样的:

                    public static void main(String[] args) {

                        List<String> list = new ArrayList<>();
                        String str = "哟唉嘛干你";
                        list.add(str);
                        list.add(str);
                        System.out.println(list);

                    }

        https://fast.itbaima.net/2022/10/01/paeKLsGntNVfHPT.png

那要是此时我们删除对象呢 是一起删除还是只删除一个呢?

                    public static void main(String[] args) {

                        List<String> list = new ArrayList<>();
                        String str = "哟唉嘛干你";
                        list.add(str);
                        list.add(str);
                        list.remove(str);
                        System.out.println(list);

                    }

        https://fast.itbaima.net/2022/10/01/5HdFh74wlqbMoj6.png

可以看到 这种情况下 只会删除排在前面的第一个元素

集合类是支持嵌套使用的 一个集合中可以存放多个集合 套娃嘛 谁不会:

                    public static void main(String[] args) {

                        List<List<String>> list = new LinkedList<>();
                        list.add(new LinkedList<>()); // 集合中的每一个元素就是一个集合 这个套娃是可以一直套下去的
                        System.out.println(list.get(0).isEmpty());

                    }

在Arrays工具类中 我们可以快速生成一个只读的List:

                    public static void main(String[] args) {

                        List<String> list = Arrays.asList("A", "B", "C"); // 非常方便
                        System.out.println(list);

                    }

注意 这个生成的List是只读的 不能进行修改操作 只能使用获取内容相关的方法
否则抛出 UnsupportedOperationException异常 要生成正常使用的 我们可以将这个只读的列表作为参数传入:

                    public static void main(String[] args) {

                        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
                        System.out.println(list);

                    }

当然 也可以利用静态代码块:

                    public static void main(String[] args) {

                        List<String> list = new ArrayList<String>() {{ // 使用匿名内部类(匿名内部类在Java8无法使用钻石运算符 但是之后的版本可以)
                                add("A");
                                add("B");
                                add("C");
                        }};
                        System.out.println(list);

                    }

这里我们接着介绍另一个列表实现类 LinkedList同样是List的实现类 只不过它是采用的链式实现 也就是我们之前讲解的链表 只不过它是一个双向链表 也就是同时保存两个方向:

                    public class LinkedList<E>
                        extends AbstractSequentialList<E>
                        implements List<E>, Deque<E>, Cloneable, java.io.Serializable
                    {
                    transient int size = 0;
                    
                        // 引用首结点
                        transient Node<E> first;
                    
                        // 引用尾结点
                        transient Node<E> last;
                    
                        // 构造方法 很简单 直接创建就行了
                        public LinkedList() {
                        }
                      
                          ...
                          
                        private static class Node<E> { // 内部使用的结点类
                            E item;
                            Node<E> next; // 不仅保存指向下一个结点的引用 还保存指向上一个结点的引用
                            Node<E> prev;
                    
                            Node(Node<E> prev, E element, Node<E> next) {
                                this.item = element;
                                this.next = next;
                                this.prev = prev;
                            }
                        }
                      
                        ...
                    }

inkedList的使用和ArrayList的使用几乎相同 各项操作的结果也是一样的 在什么使用使用ArrayList和LinkedList 我们需要结合具体的场景来决定 尽可能的扬长避短

只不过LinkedList不仅可以当做List来使用 也可以当做双端队列使用 我们会在后面进行详细介绍