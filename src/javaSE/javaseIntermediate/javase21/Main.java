package javaSE.javaseIntermediate.javase21;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Set集合
 * 我们之前已经看过Set接口的定义了 我们发现接口中定义的方法都是Collection中直接继承的 因此 Set支持的功能其实也就和Collection中定义的差不多 只不过使用方法上稍有不同
 *
 * Set集合特点
 *      > 不允许出现重复元素
 *      > 不支持随机访问(不允许通过下标访问)
 *
 * 首先认识一下HashSet 它的底层就是采用哈希表实现的(我们在这里先不去探讨实现原理 因为底层实质上维护的是一个HashMap 我们学习了Map之后再来讨论)
 *                  HashSet<Integer> set = new HashSet<>();
 *                  set.add(120); // 支持插入元素 但是不支持指定位置插入
 *                  set.add(13);
 *                  set.add(11);
 *                  for (Integer integer : set) {
 *                      System.out.println(integer);
 *                  }
 *
 * 运行上面代码发现 最后Set集合中存在的元素顺序 并不是我们插入顺序 这是因为HashSet底层采用哈希表来实现的 实际的存放顺序是由Hash算法决定的
 *
 * 那么我们希望数据按照我们插入的顺序进行保存该怎么办呢? 我们可以使用LinkedHashSet:
 *                  LinkedHashSet<Integer> set = new LinkedHashSet<>(); // 会自动保存我们的插入顺序
 *                  set.add(120);
 *                  set.add(13);
 *                  set.add(11);
 *                  for (Integer integer : set) {
 *                      System.out.println(integer);
 *                  }
 *
 * LinkedHashSet底层维护的不再是一个HashMap 而是LinkedHashMap 它能够在插入数据时利用链表自动维护顺序 因此这样就能够保证我们插入顺序和最后的迭代顺序一致了
 *
 * 还有一种Set叫做TreeSet 它会在元素插入时进行排序:
 *                  TreeSet<Integer> set = new TreeSet<>();
 *                  set.add(1);
 *                  set.add(3);
 *                  set.add(2);
 *                  System.out.println(set);
 *
 * 可以看到最后得到的结果并不是我们插入顺序 而是按照数字的大小进行排列 当然 我们也可以自定义排序规则:
 *                  TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a); // 在创建对象指定规则即可
 *                  set.add(1);
 *                  set.add(3);
 *                  set.add(2);
 *                  System.out.println(set);
 *
 * 现在的结果就是我们自定义的排序规则了
 *
 * 虽然Set集合只是粗略的进行讲解 但是学习Map之后 我们还会回来看我们Set的底层实现 所以说最重要的还是Map 本节只需要记在Set的性质 使用即可
 */
public class Main {

    public static void main(String[] args) {

        /*HashSet<Integer> set = new HashSet<>();
        set.add(120);
        set.add(13);
        set.add(11);
        for (Integer integer : set) {
            System.out.println(integer);
        }*/

        /*LinkedHashSet<Integer> set = new LinkedHashSet<>(); //
        set.add(120);
        set.add(13);
        set.add(11);
        for (Integer integer : set) {
            System.out.println(integer);
        }*/

        // TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a);
        set.add(1);
        set.add(3);
        set.add(2);
        System.out.println(set);

    }

}
