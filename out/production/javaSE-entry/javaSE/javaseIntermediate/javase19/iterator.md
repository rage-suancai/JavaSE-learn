迭代器

我们接着来介绍迭代器 实际上我们的集合类都是支持使用foreach语法的:

                    public static void main(String[] args) {

                        List<String> list = Arrays.asList("A", "B", "C");
                        for (String s : list) { // 集合类同样支持这种语法
                            System.out.println(s);
                        }

                    }

但是由于仅仅是语法糖 实际上编译之后:

                    public static void main(String[] args) {

                        List<String> list = Arrays.asList("A", "B", "C");
                        Iterator var2 = list.iterator(); // 这里使用的是List的迭代器在进行遍历操作
                    
                        while(var2.hasNext()) {
                            String s = (String)var2.next();
                            System.out.println(s);
                        }
                    
                    }

那么这个迭代器是一个什么东西呢? 我们来研究一下:

                    public static void main(String[] args) {

                        List<String> list = Arrays.asList("A", "B", "C");
                        // 通过调用iterator方法快速获取当前集合的迭代器
                        // Iterator迭代器本身也是一个接口 由具体的集合实现类来根据情况实现
                        Iterator<String> iterator = list.iterator();

                    }

通过使用迭代器 我们就可以实现对集合中的元素的进行遍历 就像我们遍历数组那样 它的运作机制大概是:

        https://fast.itbaima.net/2022/10/02/8KS5jbTv7LoAVOs.png

一个新的迭代器就像上面这样 默认有一个指向集合中第一个元素的指针:

        https://fast.itbaima.net/2022/10/02/HxjfipVB9TlEbz5.png

每一次next操作 都会将指针后移一位 直到完成每一个元素的遍历 此时再调用next将不能再得到下一个元素 至于为什么要这样设计 是因为集合类的实现方案有很多
可能是链式存储 也有可能是数组存储 不同的实现有着不同的遍历方式 而迭代器则可以将多种多样不同的集合类遍历方式进行统一 只需要各个集合类根据自己的情况进行对应实现就行了

我们来看看这个接口的源码定义了哪些操作:

                    public interface Iterator<E> {

                        // 看看是否还有下一个元素
                        boolean hasNext();
                    
                        // 遍历当前元素 并将下一个元素作为待遍历元素
                        E next();
                    
                        // 移除上一个被遍历的元素(某些集合不支持这种操作)
                        default void remove() {
                            throw new UnsupportedOperationException("remove");
                        }
                    
                        // 对剩下的元素进行自定义遍历操作
                        default void forEachRemaining(Consumer<? super E> action) {
                            Objects.requireNonNull(action);
                            while (hasNext())
                                action.accept(next());
                        }

                    }

在ArrayList和LinkedList中 迭代器的实现也不同 比如ArrayList就是直接按下标访问:

                    public E next() {

                        ...
                        cursor = i + 1; // 移动指针
                        return (E) elementData[lastRet = i]; // 直接返回指针所指元素

                    }

LinkedList就是不断向后寻找结点:

                    public E next() {

                        ...
                        next = next.next; // 向后继续寻找结点
                        nextIndex++;
                        return lastReturned.item; // 返回结点内部存放的元素

                    }

虽然这两种列表的实现不同 遍历方式也不同 但是都是按照迭代器的标准进行了实现 所以说 我们想要遍历一个集合中所有的元素
那么就可以直接使用迭代器来完成 而不需要关心集合类是如何实现 我们该怎么去遍历:

                    public static void main(String[] args) {

                        List<String> list = Arrays.asList("A", "B", "C");
                        Iterator<String> iterator = list.iterator();
                        while (iterator.hasNext()) { // 每次循环一定要判断是否还有元素剩余
                            System.out.println(iterator.next()); // 如果有就可以继续获取到下一个元素
                        }

                    }

注意 迭代器的使用是一次性的 用了之后就不能用了 如果需要再次进行遍历操作 那么需要重新生成一个迭代器对象
为了简便 我们可以直接使用foreach语法来快速遍历集合类 效果是完全一样的:

                    public static void main(String[] args) {

                        List<String> list = Arrays.asList("A", "B", "C");
                        for (String s : list) {
                            System.out.println(s);
                        }

                    }

在Java8提供了一个支持Lambda表达式的forEach方法 这个方法接受一个Consumer 也就是对遍历的每一个元素进行的操作:

                    public static void main(String[] args) {

                        List<String> list = Arrays.asList("A", "B", "C");
                        list.forEach(System.out::println);

                    }

这个效果跟上面的写法是完全一样的 因为forEach方法内部本质上也是迭代器在处理 这个方法是在Iterable接口中定义的:

                    default void forEach(Consumer<? super T> action) {

                        Objects.requireNonNull(action);
                        for (T t : this) { // foreach语法遍历每一个元素
                            action.accept(t); // 调用Consumer的accept来对每一个元素进行消费
                        }

                    }

那么我们来看一下 Iterable这个接口又是是什么东西?

        https://fast.itbaima.net/2022/10/02/4ShtiO6kdIcwZ85.png

我们来看看定义了哪些内容:

                    // 注意这个接口是集合接口的父接口 不要跟之前的迭代器接口搞混了
                    public interface Iterable<T> {
                    // 生成当前集合的迭代器 在Collection接口中重复定义了一次
                    Iterator<T> iterator();
                    
                        // Java8新增方法 因为是在顶层接口中定义的 因此所有的集合类都有这个方法
                        default void forEach(Consumer<? super T> action) {
                            Objects.requireNonNull(action);
                            for (T t : this) {
                                action.accept(t);
                            }
                        }
                    
                        // 这个方法会在多线程部分中进行介绍 暂时不做讲解
                        default Spliterator<T> spliterator() {
                            return Spliterators.spliteratorUnknownSize(iterator(), 0);
                        }
                    }

得益于Iterable提供的迭代器生成方法 实际上只要是实现了迭代器接口的类(我们自己写的都行) 都可以使用foreach语法:

                    public class Test implements Iterable<String>{   // 这里我们随便写一个类 让其实现Iterable接口

                        @Override
                        public Iterator<String> iterator() {

                            return new Iterator<String>() {   // 生成一个匿名的Iterator对象

                                @Override
                                public boolean hasNext() { // 这里随便写的 直接返回true 这将会导致无限循环
                                    return true;
                                }
                    
                                @Override
                                public String next() { // 每次就直接返回一个字符串吧
                                    return "测试";
                                }

                            };

                        }

                    }

        https://fast.itbaima.net/2022/10/02/KejcFB8TChE5z4o.png

是不是感觉集合类的设计非常巧妙? 

我们这里再来介绍一下ListIterator 这个迭代器是针对于List的强化版本 增加了更多方便的操作 因为List是有序集合 所以它支持两种方向的遍历操作 不仅能从前向后 也可以从后向前:

                    public interface ListIterator<E> extends Iterator<E> {

                        // 原本就有的
                        boolean hasNext();
                    
                        // 原本就有的
                        E next();
                    
                        // 查看前面是否有已经遍历的元素
                        boolean hasPrevious();
                    
                        // 跟next相反 这里是倒着往回遍历
                        E previous();
                    
                        // 返回下一个待遍历元素的下标
                        int nextIndex();
                    
                        // 返回上一个已遍历元素的下标
                        int previousIndex();
                    
                        // 原本就有的
                        void remove();
                    
                        // 将上一个已遍历元素修改为新的元素
                        void set(E e);
                    
                        // 在遍历过程中 插入新的元素到当前待遍历元素之前
                        void add(E e);

                    }

我们来测试一下吧:

                    public static void main(String[] args) {

                        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
                        ListIterator<String> iterator = list.listIterator();
                        iterator.next(); // 此时得到A
                        iterator.set("X"); // 将A原本位置的上的元素设定为成新的
                        System.out.println(list);

                    }

        https://fast.itbaima.net/2022/10/02/C3xNDTEWGaPLfO6.png

这种迭代器因为能够双向遍历 所以说可以反复使用