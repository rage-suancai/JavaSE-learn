package javaSE.javaseIntermediate.javase20;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * 迭代器
 * 集合的遍历
 * 所有的集合类 都支持foreach循环
 *                  LinkedList<Integer> list = new LinkedList<Integer>() { // java9才支持匿名内部类使用钻石运算符
 *                      {
 *                          this.add(10);
 *                          this.add(2);
 *                          this.add(5);
 *                          this.add(8);
 *                      }
 *                  };
 *                  for (Integer integer : list) {
 *                      System.out.println(integer);
 *                  }
 *
 * 当然 也可以使用JDK1.8新增的forEach方法 它接受一个Consumer接口实现:
 *                  list.forEach(i -> {
 *                      System.out.println(i);
 *                  });
 *
 * 从JDK1.8开始 lambda表达式开始逐渐成为主流 我们需要去适应函数式编程的这种语法 包括批量替换 也是用到了函数式接口来完成的
 *                  list.replaceAll((i) -> {
 *                      if(i == 2) return 3; // 将所有的2替换为3
 *                      else return i; // 不是2就不变
 *                  });
 *                  System.out.println(list);
 *
 * Iterable和Iterator接口
 * 我们之前学习数据结构时 已经得知 不同的线性表实现 在获取元素时的效率也不同 因此我们需要一种更好的方式来统一不同数据结构的遍历
 *
 * 由于ArrayList对于随机访问的深度更快 而LinkedList对于顺序访问的速度更快 因此在上述的传统for循环遍历操作中 ArrayList的效率更胜一筹 因此我们要使得LinkedList遍历效率提升 就需要采用顺序表访问的方式进行遍历
 * 如果没有迭代器帮助我们统一标准 那么我们在应对多种集合类型的时候 就需要对应编写不同的遍历算法 很显然这样会降低我们的开发效率 而迭代器的出现就帮助我们解决了这个问题
 *
 * 我们来看看迭代器里面的方法:
 *                  public interface Iterator<E> {
 *                      // ...
 *                  }
 *
 * 每个集合类都有自己的迭代器 通过iterator()方法来获取:
 *                  Iterator<Integer> iterator = list.iterator(); // 生成一个新的迭代器
 *                  while(iterator.hasNext()) { // 判断是否还有下一个元素
 *                      Integer i = iterator.next(); // 获取下一个元素(获取一个少一个)
 *                      System.out.println(i);
 *                  }
 *
 * 迭代器生成后 默认指向一个元素 每次调用next()方法 都会将指针后移 当指针移动到最后一个元素之后 调用hasNext()将会返回false 迭代器是一次性的 用完即止 如果需要再次使用 需要调用iterator()方法
 *                  ListIterator<Integer> iterator = list.listIterator(); // List还有一个更好地迭代器实现ListIterator
 *
 * ListIterator是List中独有的迭代器 在原有迭代器基础上新增了一些额外的操作
 */
public class Main {

    public static void main(String[] args) {

        /*LinkedList<Integer> list = new LinkedList<Integer>() {
            {
                this.add(10);
                this.add(2);
                this.add(5);
                this.add(8);
            }
        };
        for (Integer integer : list) {
            System.out.println(integer);
        }*/

        /*LinkedList<Integer> list = new LinkedList<Integer>() {
            {
                this.add(10);
                this.add(2);
                this.add(5);
                this.add(8);
            }
        };
        list.forEach(i -> {
            System.out.println(i);
        });*/

        /*LinkedList<Integer> list = new LinkedList<Integer>() {
            {
                this.add(10);
                this.add(2);
                this.add(5);
                this.add(8);
            }
        };
        list.replaceAll(new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 1;
            }
        });
        System.out.println(list);*/

        LinkedList<Integer> list = new LinkedList<Integer>() {
            {
                this.add(10);
                this.add(2);
                this.add(5);
                this.add(8);
            }
        };
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println(i);
        }

    }

}
