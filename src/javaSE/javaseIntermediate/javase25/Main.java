package javaSE.javaseIntermediate.javase25;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 在谈Set原理
 * 通过观察HashSet的源码发现 HashSet几乎都在操作内部维护的一个HashMap 也就是说 HashSet只是一个表壳 而内部维护的HashMap才是灵魂
 *                  private static final Object PRESENT = new Object();
 *
 * 我们发现 在添加元素时 其实添加的是一个键为我们插入的元素 而值就是PRESENT常量:
 *                  public boolean add(E e) {
 *                      return map.put(e, PRESENT)==null;
 *                  }
 *
 * 观察其他的方法 也几乎都是在用HashMap做事 所以说 HashSet利用了HashMap内部的数据结构 轻松地就实现了Set定义的全部功能
 *
 * 在来看TreeSet 实际上用的就是我们的TreeMap:
 *                  private transient NavigableMap<E,Object> m;
 *
 * 同理 这里就不多做阐述了
 *
 * JDK1.8新增方法使用
 * 最后 我们再来看看JDK1.8中集合类新增的一些操作(之前没有提及的) 首先来看看compute方法:
 *                  HashMap<Integer, String> map = new HashMap<>();
 *                  map.put(1, "A");
 *                  map.put(2, "B");
 *                  map.put(3, "C");
 *                  map.compute(1, (k, v) -> { // compute会将指定Key的值进行重新计算 若Key不存在 v会返回null
 *                      return v + "M"; // 这里返回原来的value + M
 *                  });
 *                  map.computeIfPresent(1, (k, v) -> { // 当Key存在时存在则计算并赋予新的值
 *                      return v + "M"; // 这里返回原来的value + M
 *                  });
 *                  System.out.println(map);
 *
 * 也可以使用computeIfAbsent 当不存在Key时 计算并将键值对放入Map:
 *                  Map<Integer, String> map = new HashMap<>();
 *                  map.put(1, "A");
 *                  map.put(2, "B");
 *                  map.put(3, "C");
 *                  map.computeIfAbsent(0, (k) -> { // 若不存在则计算并插入新的值
 *                     return "M"; // 这里返回M
 *                  });
 *
 * merge方法用于处理数据:
 *                  List<Student> students = Arrays.asList(
 *                          new Student("yoni", "English", 80),
 *                          new Student("yoni", "Chinese", 98),
 *                          new Student("yoni", "Math", 95),
 *                          new Student("taohai wang", "English", 50),
 *                          new Student("taohai wang", "Chinese", 72),
 *                          new Student("taohai wang", "Math", 41),
 *                          new Student("Seely", "English", 88),
 *                          new Student("Seely", "Chinese", 89),
 *                          new Student("Seely", "Math", 92)
 *                  );
 *                  HashMap<String, Integer> map = new HashMap<>();
 *                  students.forEach(student -> map.merge(student.getName(), student.getScore(), Integer::sum));
 *                  map.forEach((k, v) -> System.out.println("Key:" + k + " 总分" + "value:" + v));
 *
 *                  static class Student {
 *                      private final String name;
 *                      private final String type;
 *                      private final int score;
 *
 *                      public Student(String name, String type, int score) {
 *                          this.name = name;
 *                          this.type = type;
 *                          this.score = score;
 *                      }
 *
 *                      public String getName() {
 *                          return name;
 *                      }
 *
 *                      public String getType() {
 *                          return type;
 *                      }
 *
 *                      public int getScore() {
 *                          return score;
 *                      }
 *                  }
 */
public class Main {

    public static void main(String[] args) {

        /*HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.compute(1, (k, v) -> {
            return v + "M";
        });
        map.computeIfPresent(2, (k, v) -> {
            return v + "M";
        });
        System.out.println(map);*/

        /*HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.computeIfAbsent(4, (k) -> {
            return "D";
        });
        System.out.println(map);*/

        List<Student> students = Arrays.asList(
                new Student("yoni", "English", 80),
                new Student("yoni", "Chinese", 98),
                new Student("yoni", "Math", 95),
                new Student("taohai wang", "English", 50),
                new Student("taohai wang", "Chinese", 72),
                new Student("taohai wang", "Math", 41),
                new Student("Seely", "English", 88),
                new Student("Seely", "Chinese", 89),
                new Student("Seely", "Math", 92)
        );
        HashMap<String, Integer> map = new HashMap<>();
        students.forEach(student -> map.merge(student.getName(), student.getScore(), (a, b) -> a+b));
        map.forEach((k, v) -> System.out.println("Key:" + k + " 总分" + "value:" + v));

    }

    static class Student {
        private final String name;
        private final String type;
        private final Integer score;

        public Student(String name, String type, Integer score) {
            this.name = name;
            this.type = type;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public int getScore() {
            return score;
        }
    }

}
