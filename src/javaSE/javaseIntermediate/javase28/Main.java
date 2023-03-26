package javaSE.javaseIntermediate.javase28;

import java.util.*;

/**
 * Arrays和Collections的使用
 * Arrays是一个用于操作数组的工具类 它给我们提供了大量的工具方法:
 *                  This class contains various methods for manipulating arrays (such as sorting and searching)
 *                  This class also contains a static factory that allows arrays to be viewed as lists. <- 注意: 这句话很关键
 *
 *                  @Author: Josh Bloch
 *                  @Author: Neal Gafter
 *                  @Author: John Rose
 *                  @since 1.2
 *
 *                  public class Arrays {
 *
 * 由于操作数组并不像集合那样方便 因此JDK提供了Arrays类来增强对数组操作 比如:
 *                  int[] array = {1, 5, 2, 4, 7, 3, 6};
 *                  Arrays.sort(array); // 直接进行排序(底层原理: 进行判断 元素少使用插入排序 大量元素使用双轴快速/归并排序)
 *                  System.out.println(array); // 由于int[]是一个对象类型 而数组默认是没有重写toString()方法 因此无法打印到想要的结果
 *                  System.out.println(Arrays.toString(array)); // 我们可以使用Arrays.toString()来像集合一样直接打印每一个元素出来
 *
 *                  int[] array = {1, 5, 2, 4, 7, 3, 6};
 *                  Arrays.sort(array);
 *                  System.out.println("排序后的结果: " + Arrays.toString(array));
 *                  System.out.println("目标元素3位置为: " + Arrays.binarySearch(array, 3)); // 二分搜索 必须是已经排序好的数组
 *
 *                  int[] array = {1, 5, 2, 4, 7, 3, 6};
 *                  Arrays
 *                          .stream(array) // 将数组转换为流进行操作
 *                          .sorted()
 *                          .forEach(System.out::println);
 *
 *                  int[] array = {1, 5, 2, 4, 7, 3, 6};
 *                  int[] array2 = Arrays.copyOf(array, array.length); // 复杂一个一模一样的数组
 *                  System.out.println(Arrays.toString(array2));
 *                  System.out.println(Arrays.equals(array, array2)); // 比较两个数组是否值相同
 *
 *                  Arrays.fill(array, 0); // 将数组的所有值全部填充为指定值
 *                  System.out.println(Arrays.toString(array));
 *
 *                  Arrays.setAll(array2, i -> array2[i] + 2); // 依次计算每一个元素(注意i是下标位置)
 *                  System.out.println(Arrays.toString(array2)); // 这里计算让每一个元素值+2
 *
 * 思考: 当二维数组使用Arrays.equals()进行比较以及Arrays.toString()进行打印时 还会得到我们想要的结果吗?
 *                  Integer[][] array = {{1, 5}, {2, 4}, {7, 3}, {6}};
 *                  Integer[][] array2 = {{1, 5}, {2, 4}, {7, 3}, {6}};
 *                  System.out.println(Arrays.toString(array)); // 这样还会得到我们想要的结果吗?
 *                  System.out.println(Arrays.equals(array2, array)); // 这样还会得到true吗?
 *
 *                  System.out.println(Arrays.deepToString(array)); // 使用deepToString就能得到打印多维数组
 *                  System.out.println(Arrays.deepEquals(array2, array)); // 使用deepEquals能够比较多维数组
 *
 * 那么 一开始提到的当做List进行操作呢? 我们可以使用Arrays.asList()来将数组转换为一个固定长度的List
 *                  Integer[] array = {1, 5, 2, 4, 7, 3, 6};
 *                  List<Integer> list = Arrays.asList(array); // 不支持基本类型数组 必须是对象类型数组
 *                  Arrays.asList("A", "B", "C"); // 也可以逐个添加 因为是可变参数
 *
 *                  list.add(1); // 此List实现是长度固定的 是Arrays内部单独实现的一个类型 因此不支持添加操作
 *                  list.remove(0); // 同理 也不支持移除
 *
 *                  list.set(0,8); // 直接设置指定下标的值就可以
 *                  list.sort(Comparator.reverseOrder()); // 也可以执行排序操作
 *                  System.out.println(list); // 也可以像List那样直接打印
 *
 * 文字游戏: allows arrays to be viewed as lists 实际上只是当做List使用 本质还是数组 因此数组的属性依然存在 因此如果要将数组快速转换为实际的List 可以像这样:
 *                  Integer[] array = {1, 5, 2, 4, 7, 3, 6};
 *                  List<Integer> list = new ArrayList<>(Arrays.asList(array));
 *
 * 通过自行创建一个真正的ArrayList并在构造时将Arrays的List值传递
 *
 * 既然数组操作都这么方便了 集合操作能不能也安排点高级的玩法呢? 那必须的 JDK为我们准备的Collocations类就是专用于集合的工具类:
 *                  List<Integer> list = new ArrayList<>();
 *                  Collections.max(list);
 *                  Collections.min(list);
 *
 * 当然 Collection提供的内容相比Arrays会更多 希望大家下去自行了解 这里就不多做介绍了
 */
public class Main {

    static void test1() {

        /*int[] array = {1, 5, 2, 4, 7, 3, 6};
        Arrays.sort(array);
        System.out.println(array);
        System.out.println(Arrays.toString(array));*/

        /*int[] array = {1, 5, 2, 4, 7, 3, 6};
        Arrays.sort(array);
        System.out.println("排序后的结果: " + Arrays.toString(array));
        System.out.println("目标元素3位置为: " + Arrays.binarySearch(array, 3));*/

        /*int[] array = {1, 5, 2, 4, 7, 3, 6};
        Arrays
                .stream(array)
                .sorted()
                .forEach(System.out::println);*/

        int[] array = {1, 5, 2, 4, 7, 3, 6};
        int[] array2 = Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.equals(array, array2));

        Arrays.fill(array, 0);
        System.out.println(Arrays.toString(array));

        Arrays.setAll(array2, i -> array2[i] + 2);
        System.out.println(Arrays.toString(array2));

    }

    static void test2() {

        Integer[][] array = {{1, 5}, {2, 4}, {7, 3}, {6}};
        Integer[][] array2 = {{1, 5}, {2, 4}, {7, 3}, {6}};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.equals(array2, array));

        System.out.println(Arrays.deepToString(array));
        System.out.println(Arrays.deepEquals(array2, array));

    }

    static void test3() {

        /*Integer[] array = {1, 5, 2, 4, 7, 3, 6};
        List<Integer> list = Arrays.asList(array);
        Arrays.asList("A", "B", "C");

        //list.add(1);
        //list.remove(0);

        list.set(0, 8);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);*/

        /*Integer[] array = {1, 5, 2, 4, 7, 3, 6};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(list);*/

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));

    }

    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

}
