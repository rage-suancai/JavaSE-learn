线性表: 链表

前面我们介绍了如何使用数组实现线性表 我们接着来看第二种方式 我们可以使用链表来实现 那么什么是链表呢?

        https://fast.itbaima.net/2022/07/23/ruemiRQplVy7q9s.png

链表不同顺序表 顺序表底层采用数组作为存储容器 需要分配一块连续且完整的内存空间进行使用 而链表则不需要 它通过一个指针来连接各个分散的结点
形成了一个链状的结构 每个结点存放一个元素 以及一个指向下一个结点的指针 通过这样一个一个相连 最后形成了链表 它不需要申请连续的空间
只需要按照顺序连接即可 虽然物理是可能不相邻 但是在逻辑上依然是每个元素相邻存放的 这样的结构叫做链表(单链表)

链表分为带头结点的链表和不带头结点的链表 带头结点的链表就是会有一个头结点指向后续的整个链表 但是头结点不存放数据:

        https://fast.itbaima.net/2022/07/23/gRUEfOqbtrGN2JZ.png

而不带头结点的链表就像上面那样 第一个结点就是存放数据的结点 一般设计链表都会采用带头结点的结构 因为操作更加方便

我们来尝试定义一下:

                    public class LinkedList<E> {

                        // 链表的头结点 用于连接之后的所有结点
                        private final Node<E> head = new Node<>(null);
                        private int size = 0; // 当前的元素数量还是要存一下 方便后面操作
                        
                        private static class Node<E> { // 结点类 仅供内部使用

                            E element; // 每个结点都存放元素
                            Node<E> next; // 以及指向下一个结点的引用
                          
                            public Node(E element) {
                                this.element = element;
                            }

                        }

                    }

接着我们来设计一下链表的插入和删除 我们前面实现类顺序表的插入 那么链表的插入该怎么做呢?

        https://fast.itbaima.net/2022/07/23/71dgFSWDfoELiXB.png

我们可以先修改新插入的结点的后继结点(也就是下一个结点)指向 指向原本在这个位置的结点:

        https://fast.itbaima.net/2022/07/23/8MNURYiacWZqwu6.png

接着我们可以将前驱结点(也就是上一个结点)的后续结点指向修改为我们新插入的结点:

        https://fast.itbaima.net/2022/07/23/ysETUJb6cgBz2Qx.png

这样 我们就成功插了一个新的结点 现在新插入的结点到达了原本的第二个位置上:

        https://fast.itbaima.net/2022/07/23/Kb7jCiWa3o4AN8D.png

按照这个思路 我们来实现一下 首先设计一下方法:

                    public void add(E element, int index) {
                    
                        Node<E> prev = head; // 先找到对应位置的前驱结点
                        for (int i = 0; i < index; i++)
                            prev = prev.next;
                        Node<E> node = new Node<>(element); // 创建新的结点
                        node.next = prev.next; // 先让新的结点指向原本在这个位置上的结点
                        prev.next = node; // 然后让前驱结点指向当前结点
                        size++; // 完事之后一样的 更新size
                    
                    }

我们来重写一下toString方法看看能否正常插入:

                    @Override
                    public String toString() {

                        StringBuilder builder = new StringBuilder();
                        Node<E> node = head.next; // 从第一个结点开始 一个一个遍历 遍历一个就拼接到字符串上去
                        while (node != null) {
                            builder.append(node.element).append(" ");
                            node = node.next;
                        }
                        return builder.toString();

                    }

可以看到我们的插入操作是可以正常工作的:

                    public static void main(String[] args) {

                        LinkedList<Integer> list = new LinkedList<>();
                        list.add(10, 0);
                        list.add(30, 0);
                        list.add(20, 1);
                        System.out.println(list);

                    }

        https://fast.itbaima.net/2022/09/27/Mpj9azwWciemAZY.png

只不过还不够完美 跟之前一样 我们还得考虑插入位置是否合法:

                    public void add(E element, int index){

                        if(index < 0 || index > size)
                            throw new IndexOutOfBoundsException("插入位置非法 合法的插入位置为: 0 ~ " + size);
                        Node<E> prev = head;
                        for (int i = 0; i < index; i++)
                            prev = prev.next;
                        Node<E> node = new Node<>(element);
                        node.next = prev.next;
                        prev.next = node;
                        size++;

                    }

插入操作完成之后 我们接着来看删除操作 那么我们如何实现删除操作呢?
实际上也会更简单一些 我们可以直接将待删除结点的前驱结点指向修改为删除结点的下一个:

        https://fast.itbaima.net/2022/07/23/N5sZx9T2a8lOzoC.png

        https://fast.itbaima.net/2022/07/23/tNYnBJe9pczUq1Z.png

这样 在逻辑上来说 待删除结点其实已经不在链表中了 所以我们只需要释放掉待删除结点占用的内存空间就行了:

        https://fast.itbaima.net/2022/07/23/MFE2gZuS5eOysDW.png

那么我们就按照这个思路来编写一下程序:

                    public E remove(int index){

                        if(index < 0 || index > size - 1) // 同样的 先判断位置是否合法
                            throw new IndexOutOfBoundsException("删除位置非法 合法的删除位置为: 0 ~ " + (size - 1));
                        Node<E> prev = head;
                        for (int i = 0; i < index; i++) // 同样需要先找到前驱结点
                            prev = prev.next;
                        E e = prev.next.element; // 先把待删除结点存放的元素取出来
                        prev.next = prev.next.next; // 可以删了
                        size--; // 记得size--
                        return e;

                    }

是不是感觉还是挺简单的? 这样 我们就成功完成了链表的删除操作

我们接着来实现一下获取对应位置上的元素:

                    public E get(int index){
                        if(index < 0 || index > size - 1)
                            throw new IndexOutOfBoundsException("非法的位置 合法的位置为: 0 ~ " + (size - 1));
                        Node<E> node = head;
                        while (index-- >= 0) // 这里直接让index减到-1为止
                            node = node.next;
                        return node.element;
                    }
                    
                    public int size(){
                        return size;
                    }

这样 我们的链表就编写完成了 实际上只要理解了那种结构 其实还是挺简单的

问题: 什么情况下使用顺序表 什么情况下使用链表呢?

    > 通过分析顺序表和链表的特征我们不难发现 链表在随机访问元素时 需要通过遍历来完成 而顺序表则利用数组的特性直接访问得到
      所以 当我们读取数据多于插入或是删除数据的情况下时 使用顺序表会更好

    > 而顺序表在插入元素时就显得有些鸡肋了 因为需要移动后续元素 整个移动会浪费时间 而链表则不需要
      只需要修改结点 指向即可完成插入 所以在频繁出现插入或删除的情况下 使用链表会更好

虽然单链表使用起来比较方便 不过有一个问题就是 如果我们想要操作某一个结点 比如删除或是插入 那么由于单链表的性质 我们只能先去找到它的前前驱结点
才能进行 为了解决这种查找前驱结点非常麻烦的问题 我们可以让结点不仅保存指向后续结点的指针 同时也保存指向前驱结点的指针:

        https://fast.itbaima.net/2022/07/24/oeXm6nyW7I9lPMf.png

这样我们无论在哪个结点 都能够快速找到对应的前驱结点 就很方便了 这样的链表我们称为双向链表(双链表)