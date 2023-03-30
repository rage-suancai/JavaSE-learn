集合类

前面我们已经把基础介绍完了 从这章节开始 我们就正式进入到集合类的讲解中

集合类是Java中非常重要的存在 使用频率极高 集合其实与我们数学中的集合是差不多的概念 集合表示一组对象 每一个对象我们都可以称其为元素
不同的集合有着不同的性质 比如一些集合允许重复的元素 而另一些则不允许 一些集合是有序的 而其他则是无序的

        https://fast.itbaima.net/2022/09/30/ZWxPduaYGgRzmNO.png

集合类其实就是为了更好地组织 管理和操作我们的数据而存在的 包括列表、集合、队列、映射等数据结构 从这一块开始 我们会从源码角度给大家讲解
(先从接口定义对于集合需要实现哪些功能开始说起 包括这些集合类的底层机制是如何运作的) 不仅仅是教会大家如何去使用

集合跟数组一样 可以表示同样的一组元素 但是他们的相同和不同之处在于

    1. 它们都是容器 都能够容纳一组元素

不同之处:

    1. 数组的大小是固定的 集合的大小是可变的
    2. 数组可以存放基本数据类型 但集合只能存放对象
    3. 数组存放的类型只能是一种 但集合可以有不同种类的元素

集合根接口

Java中已经帮我们将常用的集合类型都实现好了 我们只需要直接拿来用就行了 比如我们之前学习的顺序表:

                    import java.util.ArrayList; // 集合类基本都是在java.util包下定义的

                    public class Main {

                        public static void main(String[] args) {

                            ArrayList<String> list = new ArrayList<>();
                            list.add("树脂666");

                        }

                    }

当然 我们会在这一部分中认识大部分Java为我们提供的集合类 所有的集合类最终都是实现自集合根接口的 比如我们下面就会讲到的ArrayList类 它的祖先就是Collection接口:

        https://fast.itbaima.net/2022/09/30/U9DdJinhCp6BITe.png

这个接口定义了集合类的一些基本操作 我们来看看有哪些方法:

                    public interface Collection<E> extends Iterable<E> {
                        // -------这些是查询相关的操作----------
                    
                        // 获取当前集合中的元素数量
                        int size();
                    
                        // 查看当前集合是否为空
                        boolean isEmpty();
                    
                        // 查询当前集合中是否包含某个元素
                        boolean contains(Object o);
                    
                        // 返回当前集合的迭代器 我们会在后面介绍
                        Iterator<E> iterator();
                    
                        // 将集合转换为数组的形式
                        Object[] toArray();
                    
                        // 支持泛型的数组转换 同上
                        <T> T[] toArray(T[] a);
                    
                        // -------这些是修改相关的操作----------
                    
                        // 向集合中添加元素 不同的集合类具体实现可能会对插入的元素有要求，
                        // 这个操作并不是一定会添加成功 所以添加成功返回true 否则返回false
                        boolean add(E e);
                    
                        // 从集合中移除某个元素 同样的 移除成功返回true 否则false
                        boolean remove(Object o);
                    
                    
                        // -------这些是批量执行的操作----------
                    
                        // 查询当前集合是否包含给定集合中所有的元素
                        // 从数学角度来说 就是看给定集合是不是当前集合的子集
                        boolean containsAll(Collection<?> c);
                    
                        // 添加给定集合中所有的元素
                        // 从数学角度来说 就是将当前集合变成当前集合与给定集合的并集
                        // 添加成功返回true 否则返回false
                        boolean addAll(Collection<? extends E> c);
                    
                        // 移除给定集合中出现的所有元素 如果某个元素在当前集合中不存在 那么忽略这个元素
                        // 从数学角度来说 就是求当前集合与给定集合的差集
                        // 移除成功返回true 否则false
                        boolean removeAll(Collection<?> c);
                    
                        // Java8新增方法 根据给定的Predicate条件进行元素移除操作
                        default boolean removeIf(Predicate<? super E> filter) {
                            Objects.requireNonNull(filter);
                            boolean removed = false;
                            final Iterator<E> each = iterator(); // 这里用到了迭代器 我们会在后面进行介绍
                            while (each.hasNext()) {
                                if (filter.test(each.next())) {
                                    each.remove();
                                    removed = true;
                                }
                            }
                            return removed;
                        }
                    
                        // 只保留当前集合中在给定集合中出现的元素 其他元素一律移除
                        // 从数学角度来说 就是求当前集合与给定集合的交集
                        // 移除成功返回true 否则false
                        boolean retainAll(Collection<?> c);
                    
                        // 清空整个集合 删除所有元素
                        void clear();
                    
                    
                        // -------这些是比较以及哈希计算相关的操作----------
                    
                        // 判断两个集合是否相等
                        boolean equals(Object o);
                    
                        // 计算当前整个集合对象的哈希值
                        int hashCode();
                    
                        // 与迭代器作用相同 但是是并行执行的 我们会在下一章多线程部分中进行介绍
                        @Override
                        default Spliterator<E> spliterator() {
                            return Spliterators.spliterator(this, 0);
                        }
                    
                        // 生成当前集合的流 我们会在后面进行讲解
                        default Stream<E> stream() {
                            return StreamSupport.stream(spliterator(), false);
                        }
                    
                        // 生成当前集合的并行流 我们会在下一章多线程部分中进行介绍
                        default Stream<E> parallelStream() {
                            return StreamSupport.stream(spliterator(), true);
                        }
                    }

可以看到 在这个接口中对于集合相关的操作 还是比较齐全的 那么我们接着就来看看它的实现类

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




