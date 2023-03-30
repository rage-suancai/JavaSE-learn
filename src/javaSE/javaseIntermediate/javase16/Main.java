package javaSE.javaseIntermediate.javase16;

public class Main {

    static HashTable<String> Stable = new HashTable<>();
    static HashTable<Integer> Itable = new HashTable<>();

    static void test1() {

        String str = "AAA";
        System.out.println(Stable.contains(str));
        Stable.insert(str);
        System.out.println(Stable.contains(str));

    }

    static void test2() {

        for (int i = 0; i < 70; i++) Itable.insert(i);
        System.out.println(Itable);

    }

    public static void main(String[] args) {

        // test1();
        test2();

    }

}
