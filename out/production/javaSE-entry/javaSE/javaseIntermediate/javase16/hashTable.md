哈希表

在之前 我们已经学习了多种查找数据的方式 比如最简单的 如果数据量不大的情况下 我们可以直接通过顺序查找的方式在集合中搜索我们想要的元素
当数据量较大时 我们可以使用二分搜索来快速找到我们想要的数据 不过需要要求数据按照顺序排列 并且不允许中途对集合进行修改

在学习完树形结构篇之后 我们可以利用二叉查找树来建立一个便于我们查找的树形结构 甚至可以将其优化为平衡二叉树或是红黑树来进一步提升稳定性

这些都能够极大地帮助我们查找数据 而散列表 则是我们数据结构系列内容的最后一块重要知识

散列(Hashing) 通过散列函数(哈希函数)将要参与检索的数据与散列值(哈希值)关联起来 生成一种便于搜索的数据结构 我们称其为散列表(哈希表)
也就是说 现在我们需要将一堆数据保存起来 这些数据会通过哈希函数进行计算 得到与其对应的哈希值 当我们下次需要查找这些数据时 只需要再次计算哈希值就能快速找到对应的元素了:

        https://fast.itbaima.net/2022/08/18/Tcj6Spy2Pt5ZIuW.png

散列函数也叫哈希函数 哈希函数可以对一个目标计算出其对应的哈希值 并且 只要是同一个目标 无论计算多少次 得到的哈希值都是一样的结果
不同的目标计算出的结果介乎都不同 哈希函数在现实生活中应用十分广泛 比如很多下载网站都提供下载文件的MD5码校验 可以用来判别文件是否完整
哈希函数多种多样 目前应用最为广泛的是SHA-1和MD5 比如我们在下载IDEA之后 会看到有一个验证文件SHA-256校验和的选项 我们可以点进去看看:

        https://fast.itbaima.net/2022/08/18/tD8AjiGwvJkdahE.png

点进去之后 得到:

                    e54a026da11d05d9bb0172f4ef936ba2366f985b5424e7eecf9e9341804d65bf *ideaIU-2022.2.1.dmg

这一串由数字和小写字母随意组合的一个字符串 就是安装包文件通过哈希算法计算得到的结果，那么这个东西有什么用呢?
我们的网络可能有时候会出现卡顿的情况 导致我们下载的文件可能会出现不完整的情况 因为哈希函数对同一个文件计算得到的结果是一样的
我们可以在本地使用同样的哈希函数去计算下载文件的哈希值 如果与官方一致 那么就说明是同一个文件 如果不一致 那么说明文件在传输过程中出现了损坏

可见 哈希函数在这些地方就显得非常实用 在我们的生活中起了很大的作用 它也可以用于布隆过滤器和负载均衡等场景 这里不多做介绍了

前面我们介绍了散列函数 我们知道可以通过散列函数计算一个目标的哈希值 那么这个哈希值计算出来有什么用呢 对我们的程序设计有什么意义呢? 
我们可以利用哈希值的特性 设计一张全新的表结构 这种表结构是专为哈希设立的 我们称其为哈希表(散列表)

        https://fast.itbaima.net/2022/08/18/M2o1vE7hHasN8DP.png

我们可以将这些元素保存到哈希表中 而保存的位置则与其对应的哈希值有关 哈希值是通过哈希函数计算得到的
我们只需要将对应元素的关键字(一般是整数)提供给哈希函数就可以进行计算了 一般比较简单的哈希函数就是取模操作 哈希表长度是多少(长度最好是一个素数) 模就是多少

        https://fast.itbaima.net/2022/08/19/CAPhlJnQeLjMHfd.png

比如现在我们需要插入一个新的元素(关键字为17)到哈希表中:

        https://fast.itbaima.net/2022/08/19/ovieRjrzlXhKMC2.png

插入的位置为计算出来的哈希值 比如上面是8 那么就在下标位置8插入元素 同样的 我们继续插入27:

        https://fast.itbaima.net/2022/08/19/pisuSAIZyf5JE7B.png

这样 我们就可以将多种多样的数据保存到哈希表中了 注意保存的数据是无序的 因为我们也不清楚计算完哈希值最后会放到哪个位置
那么如果现在我们想要从哈希表中查找数据呢? 比如我们现在需要查找哈希表中是否有14这个元素

        https://fast.itbaima.net/2022/08/19/H1hAvQPjNui2RYt.png

同样的 直接去看哈希值对应位置上看看有没有这个元素 如果没有 那么就说明哈希表中没有这个元素
可以看到 哈希表在查找时只需要进行一次哈希函数计算就能直接找到对应元素的存储位置 效率极高

我们来尝试编写一下:

                    public class HashTable<E> {

                        private final int TABLE_SIZE = 10;
                        private final Object[] TABLE = new Object[TABLE_SIZE];
                        
                        public void insert(E element){

                            int index = hash(element);
                            TABLE[index] = element;

                        }
                        
                        public boolean contains(E element){

                            int index = hash(element);
                            return TABLE[index] == element;

                        }
                        
                        private int hash(Object object){ // 哈希函数 计算出存放的位置

                            int hashCode = object.hashCode();  
                            // 每一个对象都有一个独一无二的哈希值 可以通过hashCode方法得到(只有极小的概率会出现相同的情况)
                            return hashCode % TABLE_SIZE;

                        }

                    }

这样 我们就实现了一个简单的哈希表和哈希函数 通过哈希表 我们可以将数据的查找时间复杂度提升到常数阶

前面我介绍了哈希函数 通过哈希函数计算得到一个目标的哈希值 但是在某些情况下 哈希值可能会出现相同的情况:

        https://fast.itbaima.net/2022/08/19/XqpZd1YP5ulEJRy.png

比如现在同时插入14和23这两个元素 他们两个计算出来的哈希值是一样的 都需要在5号下标位置插入
这时就出现了打架的情况 那么到底是把哪一个放进去呢? 这种情况 我们称为哈希碰撞(哈希冲突)

这种问题是很严重的 因为哈希函数的设计不同 难免会出现这种情况 这种情况是不可避免的 我们只能通过使用更加高级的哈希函数来尽可能避免这种情况
但是无法完全避免 当然 如果要完全解决这种问题 我们还需要去寻找更好的方法 这里我们只介绍一种比较重要的 会在后面集合类中用到的方案

实际上常见的哈希冲突解决方案是链地址法 当出现哈希冲突时 我们依然将其保存在对应的位置上 我们可以将其连接为一个链表的形式:

        https://fast.itbaima.net/2022/09/30/Hd1LDvkY6ScVTN2.png

当表中元素变多时 差不多就变成了这样 我们一般将其横过来看:

        https://fast.itbaima.net/2022/09/30/kr4CcVEwI72AiDU.png

通过结合链表的形式 哈希冲突问题就可以得到解决了 但是同时也会出现一定的查找开销 因为现在有了链表 我们得挨个往后看才能找到 当链表变得很长时
查找效率也会变低 此时我们可以考虑结合其他的数据结构来提升效率 比如当链表长度达到8时 自动转换为一棵平衡二叉树或是红黑树 这样就可以在一定程度上缓解查找的压力了:

                    public class HashTable<E> {

                        private final int TABLE_SIZE = 10;
                        private final Node<E>[] TABLE = new Node[TABLE_SIZE];
                    
                        public HashTable(){

                            for (int i = 0; i < TABLE_SIZE; i++)
                                TABLE[i] = new Node<>(null);

                        }
                    
                        public void insert(E element){

                            int index = hash(element);
                            Node<E> prev = TABLE[index];
                            while (prev.next != null)
                                prev = prev.next;
                            prev.next = new Node<>(element);

                        }
                    
                        public boolean contains(E element){

                            int index = hash(element);
                            Node<E> node = TABLE[index].next;
                            while (node != null) {
                                if(node.element == element)
                                    return true;
                                node = node.next;
                            }
                            return false;

                        }
                    
                        private int hash(Object object){

                            int hashCode = object.hashCode();
                            return hashCode % TABLE_SIZE;

                        }
                    
                        private static class Node<E> {

                            private final E element;
                            private Node<E> next;
                    
                            private Node(E element){
                                this.element = element;
                            }

                        }

                    }

实际上这种方案代码写起来也会更简单 使用也更方便一些

至此 数据结构相关内容 我们就讲解到这里 学习这些数据结构 实际上也是为了方便各位小伙伴对于后续结合类的学习 因为集合类的底层实现就是这些数据结构