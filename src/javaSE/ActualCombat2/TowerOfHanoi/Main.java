package javaSE.ActualCombat2.TowerOfHanoi;

public class Main {

    public static void main(String[] args) {

        tower('a', 'b', 'c', 3);

    }

    private static void tower(char a, char b, char c, int n) {

        if (n == 1) System.out.println(a + " --> " + c);
        else {
            tower(a, c, b, n-1);
            System.out.println(a + " --> " + c);
            tower(b, a, c, n-1);
        }

    }

}
