package javaSE.javaseIntermediate.javase18;

import javaSE.javase12.ArrayQueue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 集合类的使用
 * List列表
 * 首先介绍ArrayList 它的底层是用数组实现的 内部维护的是一个可改变大小的数组 也就是我们之前所说的线性表 跟我们之前自己写的ArrayList相比 它更加规范 同时继承自List接口
 *
 * 先看看ArrayList的源码
 *
 * 基本操作
 *                  List<String> list = new ArrayList<>(); // 默认的长度的列表
 *                  List<String> listInit = new ArrayList<>(); // 初始长度为100的列表
 *
 * 向列表中添加元素:
 *                  List<String> list = new ArrayList<>();
 *                  list.add("yxsnb");
 *                  list.add("yyds");
 *                  list.contains("yyds"); // 是否包含某个元素
 *                  System.out.println(list);
 *
 * 移除元素:
 *                  List<String> list = new ArrayList<>();
 *                  list.add("yxsnb");
 *                  list.add("yyds");
 *                  list.remove(0); // 按下标移除元素
 *                  list.remove("yyds); // 移除指定元素
 *                  System.out.println(list);
 *
 * 也支持批量操作:
 *                  ArrayList<String> list = new ArrayList<>();
 *                  list.addAll(new ArrayList<>()); // 在尾部批量添加元素
 *                  list.removeAll(new ArrayList<>()); // 批量移除元素(只有给指定集合中存放的元素才会被移除)
 *                  list.retainAll(new ArrayList<>()); //
 *                  System.out.println(list);
 */
public class Main {

    public static void main(String[] args) {

        /*List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        System.out.println(list);*/

        /*List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.contains("B");
        System.out.println(list);*/

       /*List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.remove(0);
        list.remove("B");
        System.out.println(list);*/

    }

}
