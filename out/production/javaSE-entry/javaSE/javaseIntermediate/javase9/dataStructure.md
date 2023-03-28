数据结构基础

警告! 本部分内容难度很大 推荐计算机专业课程《数据结构与算法》作为前置学习课程 本部分介绍数据结构只是为了为后面的集合类型做准备

学习集合类之前 我们还有最关键的内容需要学习 同第一章一样 自底向上才是最佳的学习方向 比起直接带大家认识集合类 不如先了解一下数据结构
只有了解了数据结构基础 才能更好地学习集合类 同时 数据结构也是你以后深入学习JDK源码的必备条件(学习不要快餐式)
当然 我们主要是讲解java 数据结构作为铺垫作用 所以我们只会讲解关键的部分 其他部分可以下去自行了解

        在计算机科学中 数据结构是一种数据组织 管理和存储的格式 它可以帮助我们实现对数据高效的访问和修改
        更准确地说 数据结构是数据的集合 可以体现数据之间的关系 以及可以对数据进行应用的函数或操作

通俗地说 我们需要去学习在计算机中如何去更好地管理我们的数据 才能让我们对我们的数据控制更加灵活
        
        https://fast.itbaima.net/2022/07/10/9RwL7pxgyfoB3WT.png

比如现在我们需要保存100个学生的数据 那么你首先想到的肯定是使用数组吧! 没错 没有什么比数组更适合存放这100个学生的数据了 但是如果我们现在有了新的需求呢?
我们不仅仅是存放这些数据 我们还希望能够将这些数据按顺序存放 支持在某个位置插入一条数据 删除一条数据 修改一条数据等 这时候 数组就显得有些乏力了

数组无法做到这么高级的功能 那么我们就需要定义一种更加高级的数据结构来做到 我们可以使用线性表(Linear List)

        线性表是由同一类型的数据元素构成的有序序列的线性结构 线性表中元素的个数就是线性表的长度
        表的起始位置称为表头 表的结束位置称为表尾 当一个线性表中没有元素时 称为空表

线性表一般需要包含以下功能:

    > 获取指定位置上的元素: 直接获取线性表指定位置i上的元素
    > 插入元素: 在指定位置i上插入一个元素
    > 删除元素: 删除指定位置i上的一个元素
    > 获取长度: 返回线性表的长度

也就是说 现在我们需要设计的是一种功能完善的表结构 它不像是数组那么低级 而是真正意义上的表:

        https://fast.itbaima.net/2022/07/23/Ve6dlqROzhumD5o.png

简单来说它就是列表 比如我们的菜单 我们在点菜时就需要往菜单列表中添加菜品或是删除菜品 这时列表就很有用了
因为数组长度固定 操作简单 而我们添加菜品 删除菜品这些操作又要求长度动态变化 操作多样

那么 如此高级的数据结构 我们该如何去实现呢? 实现线性表的结构一般有两种 一种是顺序存储实现 还有一种是链式存储实现 我们先来看第一种 也是最简单的的一种

----

线性表: 顺序表

前面我们说到 既然数组无法实现这样的高级表结构 那么我就基于数组 对其进行强化 也就是说 我们存放数据还是使用数组
但是我们可以为其编写一些额外的操作来强化为线性表 像这样底层依然采用顺序存储实现的线性表 我们称为顺序表

        https://fast.itbaima.net/2022/07/24/elBvx4Zo1AJ2WqT.png

这里我们可以先定义一个新的类型:

                    public class ArrayList<E> { // 泛型E 因为表中要存的具体数据类型待定
                        int capacity = 10; // 当前顺序表的容量
                          int size = 0; // 当前已经存放的元素数量
                        private Object[] array = new Object[capacity]; // 底层存放数据的数组
                    }

        https://fast.itbaima.net/2022/09/27/24Glc7UQjLt5Wny.jpg

当插入元素时 需要将插入位置给腾出来 也就是将后面的所有元素向后移 同样的 如果要删除元素 那么也需要将所有的元素向前移动 顺序表是紧凑的 不能出现空位

所以说我们可以来尝试实现一下 首先是插入方法:

                    public void add(E element, int index){ // 插入方法需要支持在指定下标位置插入

                        for (int i = size; i > index; i--) // 从后往前 一个一个搬运元素
                            array[i] = array[i - 1];
                        array[index] = element; // 腾出位置之后 直接插入元素放到对应位置上
                        size++; // 插入完成之后 记得将size自增

                    }

只不过这样并不完美 因为我们的插入操作并不是在任何位置都支持插入的 我们允许插入的位置只能是 [0, size] 这个范围内

        https://fast.itbaima.net/2022/07/23/H67F1crBhqQiXxg.png

所以说我们需要在插入之前进行判断:

                    public void add(E element, int index){

                        if(index < 0 || index > size) // 插入之前先判断插入位置是否合法
                            throw new IndexOutOfBoundsException("插入位置非法 合法的插入位置为: 0 ~ " + size);
                        for (int i = size; i > index; i--)
                            array[i] = array[i - 1];
                        array[index] = element;
                        size++;

                    }

我们来测试一下吧:

                    public static void main(String[] args) {

                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(10, 1); // 一上来只能在第一个位置插入 第二个位置肯定是非法的

                    }

于是就成功得到异常:

        https://fast.itbaima.net/2022/09/27/rtkRMaWseE2Cm1z.png

只不过依然不够完美 万一我们的顺序表装满了咋办? 所以说 我们在插入元素之前 需要进行判断 如果已经装满了 那么我们需要先扩容之后才能继续插入新的元素:

                    public void add(E element, int index){

                        if(index < 0 || index > size)
                            throw new IndexOutOfBoundsException("插入位置非法 合法的插入位置为: 0 ~ " + size);
                        if(capacity == size) {
                            int newCapacity = capacity + (capacity >> 1); // 扩容规则就按照原本容量的1.5倍来吧
                            Object[] newArray = new Object[newCapacity]; // 创建一个新的数组来存放更多的元素
                            System.arraycopy(array, 0, newArray, 0, size); // 使用arraycopy快速拷贝原数组内容到新的数组
                            array = newArray; // 更换为新的数组
                            capacity = newCapacity; // 容量变成扩容之后的
                        }
                        for (int i = size; i > index; i--)
                            array[i] = array[i - 1];
                        array[index] = element;
                        size++;

                    }

我们来重写一下toString方法打印当前存放的元素:

                    public String toString() {

                        StringBuilder builder = new StringBuilder();
                        for (int i = 0; i < size; i++) builder.append(array[i]).append(" ");
                        return builder.toString();

                    }

可以看到 我们的底层数组会自动扩容 便于我们使用:

                    public static void main(String[] args) {

                        ArrayList<Integer> list = new ArrayList<>();
                        for (int i = 0; i < 20; i++)
                            list.add(i, i);
                        System.out.println(list);

                    }

        https://fast.itbaima.net/2022/09/27/6SMZxC5QI3cgXYk.png

我们接着来看删除操作 其实操作差不多 只需要将后面的覆盖到前面就可以了:

                    @SuppressWarnings("unchecked") // 屏蔽未经检查警告
                    public E remove(int index){ // 删除对应位置上的元素 注意需要返回被删除的元素

                        E e = (E) array[index]; // 因为存放的是Object类型 这里需要强制类型转换为E
                        for (int i = index; i < size; i++) // 从前往后 挨个往前搬一位
                        array[i] = array[i + 1];
                        size--; // 删完记得将size--
                        return e;

                    }

同样的 我们需要对删除的合法范围进行判断:

        https://fast.itbaima.net/2022/07/23/uHBjUfKpd9ygScW.png

所以说我们也来进行一下判断:

                    @SuppressWarnings("unchecked")
                    public E remove(int index){

                        if(index < 0 || index > size - 1)
                        throw new IndexOutOfBoundsException("删除位置非法 合法的插入位置为: 0 ~ " + (size - 1));
                        E e = (E) array[index];
                        for (int i = index; i < size; i++)
                        array[i] = array[i + 1];
                        size--;
                        return e;

                    }

因为删除不需要考虑容量的问题 所以说这里的删除操作就编写完成了

当然 我们还得支持获取指定下标位置上的元素 这个就简单了 直接从数组中那就行了:

                    @SuppressWarnings("unchecked")
                    public E get(int index){

                        if(index < 0 || index > size - 1) // 在插入之前同样要进行范围检查
                        throw new IndexOutOfBoundsException("非法的位置 合法的位置为: 0 ~ " + (size - 1));
                        return (E) array[index]; // 直接返回就完事
                        }
                        
                        public int size(){ // 获取当前存放的元素数量
                        return size;

                    }

是不是感觉顺便表其实还是挺简单的 也就是一个数组多了一些操作罢了