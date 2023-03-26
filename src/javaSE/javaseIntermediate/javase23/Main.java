package javaSE.javaseIntermediate.javase23;

import java.util.LinkedHashMap;

/**
 * HashMap和LinkedHashMap
 * HashMap的实现过程 相比List 就非常地复杂了 它并不是简简单单的表结构 而是利用哈希表存放映射关系 我们来看看HashMap是如何实现的 首先回顾我们之前学习的哈希表
 *
 * 哈希表的本质其实就是一个用于存放后续节点的头节点的数组 数组里面的每一个元素都是一个头节点(也可以说就是一个链表)
 * 当要新插入一个数据时 会先计算该数据的哈希值 找到数组下标 然后创建一个新的节点 添加到对应的链表后面
 *
 * 而HashMap就是采用这种方式 我们可以看到源码中同样定义了这样的一个结构:
 *                  transient Node<K,V>[] table;
 *
 * 这个表会在第一次使用时初始化 同时在必要时进行扩容 并且它的大小永远是2的倍数
 *                  static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
 *
 * 我们可以看到默认的大小为2的4次方 每次都需要是2的倍数 也就是说 下一次增长之后 大小会变成2的5次方
 *
 * 我们现在需要思考一个问题 当我们表中的数据不断增加之后 链表会变得越来越长 这样会严重导致查询速度变慢
 * 首先想到办法就是 我们可以对数组的长度进行扩容 来存放更多的链表 那么什么情况下会进行扩容呢?
 *                  final float loadFactor;
 *
 * 我们还发现HashMap源码中有这样一个变量 也就是负载因子 那么它是干嘛的呢
 *
 * 负载因子其实就是用来衡量当前情况是否需要进行扩容的标准 我们可以看到默认的负载因子是0.75
 *                  static final float DEFAULT_LOAD_FACTOR = 0.75f;
 *
 * 那么负载因子是怎么控制扩容的呢 0.75的意思是 在插入新的节点后 如果当前数组的占用率达到75%则进行扩容
 * 在扩容时 会将所有的数据重新计算哈希值 得到一个新的下标 组成新的哈希表
 *
 * 但是这样依然有一个问题 链表过长的情况还是有可能发生 所以 为了从根源上解决这个问题 在JDK1.8时 引入了红黑树这个数据结构
 *
 * 当链表的长度达到8时 会自动将链表转换为红黑树 这样能使得原有的查询效率大幅度降低 当使用红黑树之后
 * 我们就可以利用二分搜索的思想 快速地去寻找我们想要的结果 而不是像链表一样挨个去看
 *                  static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
 *
 * 除了Node以外 HashMap还有TreeNode 很明显这就是为了实现红黑树而设计的内部类 不过我们发现 TreeNode并不是直接继承Node
 * 而是使用了LinkedHashMap中的Entry实现 它保存了前后节点的顺序(也就是我们的插入顺序)
 *                  static class Entry<K,V> extends HashMap.Node<K,V> {
 *                      Entry<K,V> before, after;
 *                      Entry(int hash, K key, V value, Node<K,V> next) {
 *                          super(hash, key, value, next);
 *                      }
 *                  }
 *
 * LinkedHashMap是直接继承自HashMap 具有HashMap的全部性质 同时得益于每一个节点都是一个双向链表 保持了插入顺序
 * 这样我们在遍历LinkedHashMap时 顺序就同我们插入顺序一致 当然 也可以使用访问顺序 也就是说对于刚访问过的元素 会被排到最后一位
 *                  LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true); //以访问顺序
 *                  map.put(1, "A");
 *                  map.put(2, "B");
 *                  map.put(3, "C");
 *                  System.out.println(map.get(2));
 *                  System.out.println(map);
 *
 * 观察结果 我们发现 刚访问的结果被排到了最后一位
 */
public class Main {

    public static void main(String[] args) {

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true); //以访问顺序
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        System.out.println(map.get(2));
        System.out.println(map);

    }

}
