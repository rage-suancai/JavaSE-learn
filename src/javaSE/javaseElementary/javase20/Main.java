package javaSE.javaseElementary.javase20;

import javaSE.javaseElementary.javase20.service.Eat;
import javaSE.javaseElementary.javase20.student.SportsStudent;

public class Main {

    public static void main(String[] args) {

        /*Eat eat = new SportsStudent("yxs", 19);

        SportsStudent sportsStudent = (SportsStudent) eat;
        sportsStudent.exercise();*/

        SportsStudent student = new SportsStudent("yxs", 19);
        System.out.println(student instanceof Eat);

    }

}
