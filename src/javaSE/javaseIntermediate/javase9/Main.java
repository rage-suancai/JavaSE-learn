package javaSE.javaseIntermediate.javase9;

/**
 * 数据结构基础
 * 警告! 本章最难的部分
 *
 * 学习集合类之前 我们还有最关键的内容需要学习 同第一章一样 自底向上才是最佳的学习方向 比起直接带大家认识集合类 不如先了解一下数据结构 只有了解了数据结构基础 才能更好地学习集合类
 * 同时 数据结构也是你以后深入学习JDK源码的必备条件(学习不要快餐式) 当然 我们主要是讲解java 数据结构作为铺垫作用 所以我们只会讲解关键的部分 其他部分可以下去自行了解
 *
 * 在计算机科学中 数据结构是一种数据组织 管理和存储的格式 它可以帮助我们实现对数据高效的访问和修改 更准确地说 数据结构是数据的集合 可以体现数据之间的关系 以及可以对数据进行应用的函数或操作
 *
 * 通俗地上 我们需要去学习在计算机中如何去更好地管理我们的数据 才能让我们对我们的数据控制更加灵活
 *
 * 线性表
 * 线性表是最基本的一种数据结构 它是表示一组相同类型数据的有限序列 你可以把它与数组进行参考但是它并不是数组 线性表是一种表结构
 * 它能够支持数据单位插入 删除 更新 查询等 同时数组可以随意存放在数组中任意位置 而线性表只能依次有序排列 不能出现空隙 因此 我们需要进一步的设计
 *
 * 顺序表
 * 将数据依次存储在连续的整块物理空间中 这种存储结构称为顺序存储结构 而以这种方式实现的线性表 我们称为顺序表
 *
 * 同样的 表中的每一个个体都被称为元素 元素左边的元素(上一个元素)称为前驱 同理 右边的元素(后一个元素)称为后驱
 *
 * 我们设计线性表的目标就是为了去更好地管理我们的数据 也就是说 我们可以基于数组 来进行封装 实现增删改查 既然要存储一组数据 那么很容易联想到我们之前学过的数组 数组就能容纳一组同类型的数据
 *
 * 目标: 以数组为底层 编写以下抽象类的具体实现
 *                  public abstract class AbstractList<E> {
 *
 *                      public abstract int size();
 *
 *                      public abstract void add(E e, int index);
 *
 *                      public abstract E remove(int index);
 *
 *                      public abstract E get(int index);
 *
 *                  }
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("A", 0);
        list.add("B", 0);

        list.remove(0);

        System.out.println(list.get(0));

        System.out.println(list.size());

        System.out.println("debug");

    }

}
