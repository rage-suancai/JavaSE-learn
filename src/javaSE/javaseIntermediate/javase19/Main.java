package javaSE.javaseIntermediate.javase19;

import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList
 * 我们再来看LinkedList 其实本质就是一个链表 我们来看看源码
 *
 * 其实与我们之前编写的LinkedList不同之处在于 它内部使用的是一个双向链表:
 *                  private static class Node<E> {
 *                      E item;
 *                      Node<E> next;
 *                      Node<E> prev;
 *
 *                      Node(Node<E> prev, E element, Node<E> next) {
 *                          this.item = element;
 *                          this.next = next;
 *                          this.prev = prev;
 *                      }
 *                  }
 *
 * 当然 我们发现它还实现了Queue接口 所以LinkedList也能被当做一个队列或是栈来使用:
 *                  LinkedList<String> list = new LinkedList<>();
 *                  list.offer("A"); // 入队
 *                  System.out.println(list.poll()); // 出队
 *                  list.push("A");
 *                  list.push("B"); // 进栈
 *                  list.push("C");
 *                  System.out.println(list.poll());
 *                  System.out.println(list.poll()); // 出栈
 *                  System.out.println(list.poll());
 *
 * 利用代码块来快速添加内容
 * 前面我们学习了匿名内部类 我们就可以利用代码块 来快速生成一个自带元素的List
 *                  List<String> list = new LinkedList<String>(){{ // 初始化时添加
 *                      this.add("A");
 *                      this.add("B");
 *                  }};
 *
 * 如果是需要快速生成一个只读的List 后面我们会讲解Arrays工具类
 *
 * 集合的排序
 *                  LinkedList<Integer> list = new LinkedList<Integer>(){ // java9才支持匿名内部类使用钻石运算符
 *                      {
 *                          this.add(10);
 *                          this.add(2);
 *                          this.add(5);
 *                          this.add(8);
 *                      }
 *                  };
 *                  list.sort((a, b) -> { // 排序已经由JDK实现 现在只要填入自定义规则 完成Comparator接口实现
 *                      return  a - b; // 返回值小于0 表示a应该在b前面 返回值大于0 表示a应该在b后面 等于0则不进行交换
 *                  });
 *                  System.out.println(list);
 */
public class Main {

    public static void main(String[] args) {

        /*LinkedList<String> list = new LinkedList<>();
        list.offer("A");
        System.out.println(list.poll());
        list.push("A");
        list.push("B");
        list.push("C");
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.poll());*/

        /*List<String> list = new LinkedList<String>(){{
            this.add("A");
            this.add("B");
        }};
        System.out.println(list);*/

        LinkedList<Integer> list = new LinkedList<Integer>(){
            {
                this.add(10);
                this.add(2);
                this.add(5);
                this.add(8);
            }
        };
        list.sort((a, b) -> {
            return  a - b;
        });
        System.out.println(list);

    }

}
