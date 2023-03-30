package javaSE.javaseIntermediate.javase22;

import java.util.*;

/**
 * @author YXS
 * @PackageName: javaSE.javaseIntermediate.javase22
 * @ClassName: Main
 * @Desription:
 * @date 2023/3/30 16:57
 */
public class Main {

    static void test1() {

        /*Map<Integer, String> map = new HashMap<>();
        map.put(1, "小明");
        map.put(2, "小红");
        System.out.println(map.get(2));*/

        /*Map<Integer, String> map = new HashMap<>();
        map.put(1, "小明");
        map.put(1, "小红");
        System.out.println(map.get(1));*/

        /*Map<Integer, String> map = new HashMap<>();
        map.put(1, "小明");
        map.putIfAbsent(1, "小红");
        System.out.println(map.get(1));*/

        /*Map<Integer, String> map = new HashMap<>();
        map.put(1, "小明");
        System.out.println(map.get(3));*/

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "小明");
        System.out.println(map.getOrDefault(3, "备胎"));

    }

    static void test2() {

       /*Map<String, String> map = new HashMap<>();
       map.put("0 ", " 十七张");
       map.put("+ ", " 牌");
       map.put("P ", " 你能秒我");
       System.out.println(map);
       System.out.println(map.keySet());
       System.out.println(map.values());*/

       /*Map<String, String> map = new LinkedHashMap<>();
       map.put("0 ", " 十七张");
       map.put("+ ", " 牌");
       map.put("P ", " 你能秒我");
       System.out.println(map);
       System.out.println(map.keySet());
       System.out.println(map.values());*/

        /*HashMap<String , String> map = new HashMap<>();
        System.out.println(map.put("0", "十七张"));
        System.out.println(map.put("0", "慈善家"));*/

        TreeMap<Integer, String> map = new TreeMap<>((a, b) -> b - a);
        map.put(0, "单走");
        map.put(1, "一个六");
        map.put(3, "**");
        System.out.println(map);

    }

    static void test3() {

        /*Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.compute(1, (k, v) -> {
            return v + "M";
        });
        map.computeIfPresent(1, (k, v) -> {
            return v + "M";
        });
        System.out.println(map);*/

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.computeIfAbsent(0, (k) -> {
            return "M";
        });
        System.out.println(map);

    }

    static void test4() {

        List<Student> students = Arrays.asList(
                new Student("yoni", "English", 80),
                new Student("yoni", "Chiness", 98),
                new Student("yoni", "Math", 95),
                new Student("taohai.wang", "English", 50),
                new Student("taohai.wang", "Chiness", 72),
                new Student("taohai.wang", "Math", 41),
                new Student("Seely", "English", 88),
                new Student("Seely", "Chiness", 89),
                new Student("Seely", "Math", 92)
        );
        Map<String, Integer> scoreMap = new HashMap<>();

        students.forEach(student -> scoreMap.merge(student.getName(), student.getScore(), Integer::sum));
        scoreMap.forEach((k, v) -> System.out.println("姓名key: " + k + " 总分" + "value: " + v));

    }

    static void test5() {

        /*HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "单走");
        map.replace(0, ">>>");
        System.out.println(map);*/

        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "单走");
        map.remove(0, "单走");
        System.out.println(map);

    }

    public static void main(String[] args) {

        //test1();
        //test2();
        //test3();
        //test4();
        test5();

    }

}
