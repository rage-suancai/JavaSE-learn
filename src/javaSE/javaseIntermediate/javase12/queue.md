线程表: 队列

前面我们学习了栈 栈中元素只能栈顶出入 它是一种特殊的线性表 同样的 队列(Queue)也是一种特殊的线性表

就像我们在超市 食堂需要排队一样 我们总是排成一列 先到的人就排在前面 后来的人就排在后面 越前面的人越先完成任务 这就是队列 队列有队头和队尾:

        https://fast.itbaima.net/2022/07/25/xBuZckTNtR54AEq.png

秉承先来后到的原则队列中的元素只能从队伍尾进入 只能从队首出去 也就是说 入队顺序为1, 2, 3, 4
那么出队顺序也一定是1, 2, 3, 4 所以队列是一种先进先出(FIFO, First In, First Out)的数据结构

队列也可以使用链表和顺序表来实现 只不过使用链表的话就不需要关心容量之类的问题了 会更加灵活一些:

        https://fast.itbaima.net/2022/07/25/lwGgHXqAV5z2KNk.png

注意: 我们需要同时保存队首和队尾两个指针 因此是单链表 所以队首需要存放指向头结点的指针
因为需要的是前驱结点 而队尾则直接是指向尾结点的指针即可 后面只需要直接在后面拼接就行

当有新的元素入队时 只需要拼在队尾就行了 同时队尾指针也要后移一位:

        https://fast.itbaima.net/2022/07/25/ufmFEwrS9xVKoIZ.png

出队时 只需要移除队首指向的下一个元素即可:

        https://fast.itbaima.net/2022/07/25/geJRFwHKhGT69XD.png

那么我们就按照这个思路 来编写一下代码吧:

                    public class LinkedQueue<E> {

                        private final Node<E> head = new Node<>(null);
                    
                        public void offer(E element){ // 入队操作

                            Node<E> last = head;
                            while (last.next != null) // 入队直接丢到最后一个结点的屁股后面就行了
                                last = last.next;
                            last.next = new Node<>(element);

                        }
                    
                        public E poll(){ // 出队操作

                            if(head.next == null) // 如果队列已经没有元素了 那么肯定是没办法取的
                                throw new NoSuchElementException("队列为空");
                            E e = head.next.element;
                            head.next = head.next.next; // 直接从队首取出
                            return e;

                        }
                    
                        private static class Node<E> {

                            E element;
                            Node<E> next;
                    
                            public Node(E element) {
                                this.element = element;
                            }

                        }

                    }

其实使用起来还是挺简单的 我们来测试一下吧:

                    public static void main(String[] args) {

                        LinkedQueue<String> stack = new LinkedQueue<>();
                        stack.offer("AAA");
                        stack.offer("BBB");
                        stack.offer("CCC");
                        System.out.println(stack.poll());
                        System.out.println(stack.poll());
                        System.out.println(stack.poll());

                    }

        https://fast.itbaima.net/2022/09/28/FUS1Rc8JuEMT6bq.png

可以看到 队列遵从先进先出 入队顺序和出队顺序是一样的