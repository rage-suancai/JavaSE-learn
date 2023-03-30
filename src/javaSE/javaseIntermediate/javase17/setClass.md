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