package javaSE.javaseElementary.javase18;

import javaSE.javaseElementary.javase18.student.ArtStudent;
import javaSE.javaseElementary.javase18.student.SportsStudent;
import javaSE.javaseElementary.javase18.student.Student;

public class Main {

    public static void main(String[] args) {

        /*SportsStudent sportsStudent = new SportsStudent("yxs", 19);
        sportsStudent.study();*/

        /*Student student = new SportsStudent("yxs", 19);
        student.study();*/

        /*Student student = new SportsStudent("yxs", 19);
        SportsStudent sportsStudent = (SportsStudent) student;
        sportsStudent.exercise();*/

        Student student = new ArtStudent("yxs", 19);;
        test(student);

    }

    public static void test(Student student) {

        if (student instanceof SportsStudent) {
            SportsStudent sportsStudent = (SportsStudent) student;
            sportsStudent.exercise();
        }else if(student instanceof ArtStudent) {
            ArtStudent artStudent = (ArtStudent) student;
            artStudent.art();
        }

    }

}
