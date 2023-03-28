线程表: 链表

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

public void add() {

    

}


