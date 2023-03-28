package javaSE.javaseIntermediate.javase2;

import javax.lang.model.element.VariableElement;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        /*int[] arr = new int[5];
        try {
            arr[5] = 1;
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("线程运行出现异常");
        }
        System.out.println("yxsnb");*/

        /*File file = new File("my.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            int[] arr = new int[Integer.MAX_VALUE];
        } catch (Throwable e) {
            System.out.println("捕获到错误");
        }
        System.out.println("yxsnb");

    }

}
