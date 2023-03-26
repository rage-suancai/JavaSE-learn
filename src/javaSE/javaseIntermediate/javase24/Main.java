package javaSE.javaseIntermediate.javase24;

import java.util.HashMap;
import java.util.Map;

/**
 * TreeMap
 * TreeMap其实就是自动维护顺序的一种Map 就和我们前面提到的TreeSet一样:
 *                  private final Comparator<? super K> comparator;
 *                  private transient Entry<K,V> root;
 *
 *                  static final class Entry<K,V> implements Map.Entry<K,V> {
 *
 * 我们发现它的内部直接维护了一个红黑树 就像它的名字一样 就是一个Tree 因为它默认就是有序的 所以说直接采用红黑树会更好 我们在创建时 直接给予一个比较规则即可
 *
 * Map的使用
 * 我们首先来看看Map的一些基本操作:
 *                  HashMap<Integer, String> map = new HashMap<>();
 *                  map.put(1, "A");
 *                  map.put(2, "B");
 *                  map.put(3, "C");
 *                  System.out.println(map.get(1)); // 获取Key为1的值
 *                  System.out.println(map.getOrDefault(0, "K")); // 不存在就返回K
 *                  map.remove(3); // 移除这个Key的键值对
 *
 * 由于Map并未实现迭代器接口 因此不支持forEach 但是JDK1.8为我们提供了forEach方法使用:
 *                  public static void main(String[] args) {
 *
 *                      Map<Integer, String> map = new HashMap<>();
 *                      map.put(1, "A");
 *                      map.put(2, "B");
 *                      map.put(3, "C");
 *                      map.forEach((k, v) -> System.out.println(k + " -> " + v));
 *
 *                      for(Map.Entry<Integer, String> entry : map.entrySet()) { // 也可以获取所有的Entry来forEach
 *                          int key = entry.getKey();
 *                          String value = entry.getValue();
 *                          System.out.println(key + " -> " + value);
 *                      }
 *
 *                  }
 *
 * 我们也可以单独获取所有的值或者是键:
 *                  public static void main(String[] args) {
 *                      map.put(1, "A");
 *                      map.put(2, "B");
 *                      map.put(3, "C");
 *                      System.out.println(map.keySet()); // 直接获取所有的Key
 *                      System.out.println(map.values()); // 直接获取所有的值
 *                  }
 */
public class Main {

    public static void main(String[] args) {

        /*HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        System.out.println(map.get(1));
        System.out.println(map.getOrDefault(0, "k"));
        map.remove(3);
        System.out.println(map);*/

        /*Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.forEach((k, v) -> System.out.println(k + " -> " + v));

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " -> " + value);
        }*/

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        System.out.println(map.keySet());
        System.out.println(map.values());

    }

}
