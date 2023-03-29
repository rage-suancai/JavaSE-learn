线性表: 栈

栈(也叫堆栈 Stack) 是一种特殊的线性表 它只能在表尾进行插入和删除操作 就像下面这样:

        https://fast.itbaima.net/2022/07/24/D3heysaM9EpAgS4.png

也就是说 我们只能在一端进行插入和删除 当我们依次插入1, 2, 3, 4这四个元素后
连续进行四个次删除操作 删除的顺序刚好相反: 4, 3, 2, 1 我们一般将其竖起着看:

        https://fast.itbaima.net/2022/07/24/2NxUpCIRLoZt9Ky.png

底部称为栈底 顶部称为栈顶 所有的操作只能在栈顶进行 也就是说 被压在下方的元素 只能等待其上方的元素出栈之后才能取出
就像我们往箱子里面放的书一样 因为只有一个口取出里面的物品 所以被压在下面的书只能等上面的书本被拿出来之后才能取出
这就是栈的思想 它是一种先进后出的数据结构(FILO First In, Last Out)

实现栈也是非常简单的 可以基于我们前面的顺序表或是链表 这里我们需要实现两个新的操作:

    > pop: 出栈操作 从栈顶取出一个元素
    > push: 入栈操作 向栈中压入一个新的元素

栈可以使用顺序表实现 也可以使用链表实现 这里我们就使用链表 实际上使用链表会更加的方便
我们可以直接将头结点指向顶结点 而栈顶结点连接后续的栈内结点:

        https://fast.itbaima.net/2022/07/24/outf2S7D3WzQK8c.png

当有新的元素入栈 只需要在链表头部插入新的结点即可 我们来尝试编写一下:

                    public class LinkedStack<E> {

                        private final Node<E> head = new Node<>(null); // 大体内容跟链表类似
                    
                        private static class Node<E> {
                            E element;
                            Node<E> next;
                    
                            public Node(E element) {
                                this.element = element;
                            }
                        }

                    }

接着我们来编写一下入栈操作:

        https://fast.itbaima.net/2022/07/24/GdBj3g5YRFzSsVw.png

代码如下:

                    public void push(E element){

                        Node<E> node = new Node<>(element); // 直接创建新结点
                        node.next = head.next; // 新结点的下一个变成原本的栈顶结点
                        head.next = node; // 头结点的下一个改成新的结点

                    }

这样 我们就可以轻松实现入栈操作了 其实出栈也是同理 所以我们需要将第一个元素移除即可:

                    public E pop(){

                        if(head.next == null) // 如果栈已经没有元素了 那么肯定是没办法取的
                            throw new NoSuchElementException("栈为空");
                        E e = head.next.element; // 先把待出栈元素取出来
                        head.next = head.next.next; // 直接让头结点的下一个指向下一个的下一个
                        return e;

                    }

我们来测试一下吧:

                    public static void main(String[] args) {

                        LinkedStack<String> stack = new LinkedStack<>();
                        stack.push("AAA");
                        stack.push("BBB");
                        stack.push("CCC");
                        System.out.println(stack.pop());
                        System.out.println(stack.pop());
                        System.out.println(stack.pop());

                    }

可以看到 入栈顺序和出栈顺序是完全相反的:

        https://fast.itbaima.net/2022/09/28/yaWmfPDU63X8BQn.png

其实还是挺简单的