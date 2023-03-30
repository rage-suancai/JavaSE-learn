package javaSE.javaseIntermediate.javase23;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author YXS
 * @PackageName: javaSE.javaseIntermediate.javase23
 * @ClassName: Main
 * @Desription:
 * @date 2023/3/30 19:47
 */
public class Main {

    static void test1() {

        /*List<String> list = new ArrayList<>();
        list.add("A"); list.add("B"); list.add("C");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals("B")) iterator.remove();
        }
        list = list.stream()
                        .filter(e -> !e.equals("B"))
                        .collect(Collectors.toList());
        System.out.println(list);*/

        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(3);

        list = list.stream()
                .distinct()
                .sorted((a, b) -> b - a)
                .map(e -> e + 1)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(list);

    }

    static void test2() {

        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(3);

        list = list.stream()
                .distinct()
                .sorted((a, b) -> b - a)
                .map(e -> {
                    System.out.println(">>> " + e); return e + 1;
                })
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(list);

    }

    static void test3() {

        /*Random random = new Random();
        random
                .ints(-100, 100)
                .limit(10)
                .filter(i -> i < 0)
                .sorted()
                .forEach(System.out::println);*/

        /*Random random = new Random();
        IntSummaryStatistics statistics = random
                .ints(0, 100)
                .limit(100)
                .summaryStatistics();
        System.out.println(statistics.getMax());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getAverage());

        /*List<String> list = new ArrayList<>();
        list.add("A,B"); list.add("A,B"); list.add("A,B");

        list = list.stream()
                .flatMap(e -> Arrays.stream(e.split(",")))
                .collect(Collectors.toList());
        System.out.println(list);*/

        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3);

        int sum = list.stream()
                .reduce((a, b) -> a + b)
                .get();
        System.out.println(sum);

    }

    public static void main(String[] args) {

        //test1();
        //test2();
        test3();

    }

}
