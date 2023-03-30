Set集合

前面我们已经介绍了列表 我们接着来看Set集合 这种集合类型比较特殊 我们先来看看Set的定义:

                    public interface Set<E> extends Collection<E> {
                        // Set集合中基本都是从Collection直接继承过来的方法 只不过对这些方法有更加特殊的定义
                        int size();
                        boolean isEmpty();
                        boolean contains(Object o);
                        Iterator<E> iterator();
                        Object[] toArray();
                        <T> T[] toArray(T[] a);
                    
                        // 添加元素只有在当前Set集合中不存在此元素时才会成功 如果插入重复元素 那么会失败
                        boolean add(E e);
                    
                        // 这个同样是删除指定元素
                        boolean remove(Object o);
                    
                        boolean containsAll(Collection<?> c);
                    
                        // 同样是只能插入那些不重复的元素
                        boolean addAll(Collection<? extends E> c);
                      
                        boolean retainAll(Collection<?> c);
                        boolean removeAll(Collection<?> c);
                        void clear();
                        boolean equals(Object o);
                        int hashCode();
                    
                        // 这个方法我们同样会放到多线程中进行介绍
                        @Override
                        default Spliterator<E> spliterator() {
                            return Spliterators.spliterator(this, Spliterator.DISTINCT);
                        }
                    }

我们发现接口中定义的方法都是Collection中直接继承的 因此 Set支持的功能其实也就和Collection中定义的差不多 只不过:

    > 不允许出现重复元素
    > 不支持随机访问(不允许通过下标访问)

首先认识一下HashSet 它的底层就是采用哈希表实现的(我们在这里先不去探讨实现原理 因为底层实质上是借用的一个HashMap在实现
这个需要我们学习了Map之后再来讨论) 我们可以非常高效的从HashSet中存取元素 我们先来测试一下它的特性:

                    public static void main(String[] args) {

                        Set<String> set = new HashSet<>();
                        System.out.println(set.add("AAA")); // 这里我们连续插入两个同样的字符串
                        System.out.println(set.add("AAA"));
                        System.out.println(set); // 可以看到 最后实际上只有一个成功插入了

                    }

        https://fast.itbaima.net/2022/10/03/y5AoUG1iuWzhOSj.png

在Set接口中并没有定义支持指定下标位置访问的添加和删除操作 我们只能简单的删除Set中的某个对象:

                    public static void main(String[] args) {

                        Set<String> set = new HashSet<>();
                        System.out.println(set.add("AAA"));
                        System.out.println(set.remove("AAA"));
                        System.out.println(set);

                    }

由于底层采用哈希表实现 所以说无法维持插入元素的顺序:

                    public static void main(String[] args) {

                        Set<String> set = new HashSet<>();
                        set.addAll(Arrays.asList("A", "0", "-", "+"));
                        System.out.println(set);

                    }

        https://fast.itbaima.net/2022/10/03/OekDqMlpVbxImsK.png

那要是我们就是想要使用维持顺序的Set集合呢? 我们可以使用LinkedHashSet LinkedHashSet底层维护的不再是一个HashMap
而是LinkedHashMap 它能够在插入数据时利用链表自动维护顺序 因此这样就能够保证我们插入顺序和最后的迭代顺序一致了:

                    public static void main(String[] args) {

                        Set<String> set = new LinkedHashSet<>();
                        set.addAll(Arrays.asList("A", "0", "-", "+"));
                        System.out.println(set);

                    }

        https://fast.itbaima.net/2022/10/03/TpczL2Zi1OkaHWI.png

还有一种Set叫做TreeSet 它会在元素插入时进行排序:

                    public static void main(String[] args) {

                        TreeSet<Integer> set = new TreeSet<>();
                        set.add(1);
                        set.add(3);
                        set.add(2);
                        System.out.println(set);

                    }

        https://fast.itbaima.net/2022/10/03/3VwDQzRxUTGrOZb.png

可以看到最后得到的结果并不是我们插入顺序 而是按照数字的大小进行排列 当然 我们也可以自定义排序规则:

                    public static void main(String[] args) {

                        TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a); // 同样是一个Comparator
                        set.add(1);
                        set.add(3);
                        set.add(2);
                        System.out.println(set);

                    }

目前 Set集合只是粗略的进行了讲解 但是学习Map之后 我们还会回来看我们Set的底层实现 所以说最重要的还是Map 本节只需要记住Set的性质 使用即可