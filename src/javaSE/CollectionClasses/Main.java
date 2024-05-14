package javaSE.CollectionClasses;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        //listTest();

        //iteratorTest();

        //queueTest();

        //setTest();

        //mapTest();

        //streamTest();

        collectionsTest();

    }

    private static void listTest() {

        /*List<String> list = new ArrayList<>();
        list.add("科技与狠活"); list.add("上头啊");
        System.out.println(list);*/

        /*List<String> list = new ArrayList<>();
        String str = "哟唉嘛干你";
        list.add(str); list.add(str);
        System.out.println(list);*/

        /*List<List<String>> list = new LinkedList<>();
        list.add(new LinkedList<>());
        System.out.println(list.get(0).isEmpty());*/

        List<String> list = Arrays.asList("A", "B", "C");
        System.out.println(list);

    }

    private static void iteratorTest() {

        /*List<String> list = Arrays.asList("A", "B", "C");
        for (String s : list) System.out.print(s);*/

        /*List<String> list = Arrays.asList("A", "B", "C");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next());*/

        /*List<String> list = Arrays.asList("A", "B", "C");
        list.forEach(System.out::print);*/

        /*IterableTest test = new IterableTest();
        for (String s : test) System.out.println(s);*/

        List<String> list = Arrays.asList("A", "B", "C");
        ListIterator<String> iterator = list.listIterator();
        iterator.next(); iterator.set("X");
        System.out.println(list);

    }

    private static void queueTest() {

        /*Queue<String> queue = new LinkedList<>();
        queue.offer("AAA"); queue.offer("BBB");
        System.out.println(queue.poll());
        System.out.println(queue.poll());*/

        /*Deque<String> deque = new LinkedList<>();
        deque.push("AAA"); deque.push("BBB");
        System.out.println(deque.pop());
        System.out.println(deque.pop());*/

        /*Deque<String> deque = new LinkedList<>();
        deque.push("AAA"); deque.push("BBB");
        Iterator<String> descendingIterator = deque.descendingIterator();
        System.out.println(descendingIterator.next());
        Iterator<String> iterator = deque.iterator();
        System.out.println(iterator.next());*/

        //Queue<Integer> queue = new PriorityQueue<>();
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.offer(10); queue.offer(4); queue.offer(5);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }

    private static void setTest() {

        /*Set<String> set = new HashSet<>();
        System.out.println(set.add("AAA"));
        System.out.println(set.add("AAA"));
        System.out.println(set);*/

        /*Set<String> set = new HashSet<>();
        System.out.println(set.add("AAA"));
        System.out.println(set.remove("AAA"));
        System.out.println(set);*/

        /*Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList("A", "0", "-", "+"));
        System.out.println(set);*/

        /*Set<String> set = new LinkedHashSet<>();
        set.addAll(Arrays.asList("A", "0", "-", "+"));
        System.out.println(set);*/

        Set<Object> set = new TreeSet<>();
        set.add(1); set.add(3); set.add(8);
        System.out.println(set);

    }

    private static void mapTest() {

        /*Map<Integer, String> map = new HashMap<>();
        map.put(1, "小明"); map.put(2, "小红");
        System.out.println(map.get(2));*/

        /*Map<Integer, String> map = new HashMap<>();
        map.put(1, "小明");
        System.out.println(map.getOrDefault(3, "备胎"));*/

        /*Map<Integer, String> map = new HashMap<>();
        map.put(1, "小明");*/

        /*Map<String, String> map = new HashMap<>();
        map.put("0", "十七张"); map.put("+", "牌"); map.put("p", "你能秒我");
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());*/

        /*Map<Integer, String> map = new TreeMap<>((a, b) -> b - a);
        map.put(0, "单走"); map.put(1, "一个六"); map.put(3, "**");
        System.out.println(map);*/

        /*Map<Integer, String> map = new HashMap<>();
        map.put(1, "A"); map.put(2, "B");
        map.compute(1, (k, v) -> {
            return v + "M";
        });
        map.computeIfPresent(1, (k, v) -> {
            return v + "M";
        });
        System.out.println(map);*/

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A"); map.put(2, "B");
        map.computeIfAbsent(0, (k) -> {
            return "M";
        });
        System.out.println(map);

    }

    private static void streamTest() {

        /*List<String> list = new ArrayList<>();
        list.add("A"); list.add("B"); list.add("C");
        list = list.stream().filter(e -> !e.equals("B")).collect(Collectors.toList());
        System.out.println(list);*/

        /*List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(3);
        list = list.stream().distinct().sorted((a,b) -> b-a).map(e -> e+1).limit(2).collect(Collectors.toList());
        System.out.println(list);*/

        /*List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(3);
        list = list.stream()
                .distinct()
                .sorted((a,b) -> b-a)
                .map(e -> {
                    System.out.println(">>>" + e);
                    return e+1;
                })
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(list);*/

        /*Random random = new Random();
        random.ints(-100, 100).limit(10).filter(i -> i<0).sorted().forEach(System.out::println);*/

        /*Random random = new Random();
        IntSummaryStatistics statistics = random.ints(0, 100).limit(100).summaryStatistics();
        System.out.println(statistics.getMax());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getAverage());*/

        List<String> list = new ArrayList<>();
        list.add("A,B"); list.add("C,D"); list.add("E,F");
        list = list.stream().flatMap(e -> Arrays.stream(e.split(","))).collect(Collectors.toList());
        System.out.println(list);

    }

    private static void collectionsTest() {

        /*List<Integer> list = Arrays.asList(2,3,8,9,10,13);
        System.out.println(Collections.binarySearch(list,8));*/

        /*List<Object> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Collections.fill(list,6); System.out.println(list);*/

        /*List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> newList = Collections.unmodifiableList(list);
        newList.add(10);*/

        /*List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(Collections.indexOfSubList(list, Arrays.asList(4, 5)));*/

        List list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list.add("aaa"); System.out.println(list);

    }

    private static class IterableTest implements Iterable<String> {

        @Override
        public Iterator<String> iterator() {
            return new Iterator<String>() {
                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public String next() {
                    return "测试";
                }
            };
        }

    }

}
