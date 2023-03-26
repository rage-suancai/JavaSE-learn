package javaSE.javaseElementary.javase23;

import javaSE.javaseElementary.javase23.entity.Status;
import javaSE.javaseElementary.javase23.entity.Student;

public class Main {

    public static void main(String[] args) {

        Student student = new Student("yxs", 19);

        student.setStatus(Status.SLEEP);
        System.out.println(student.getStatus().getName());

        /*for (Status value : Status.values()) {
            System.out.println(value);
        }*/

    }

}
