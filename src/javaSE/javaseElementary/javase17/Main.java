package javaSE.javaseElementary.javase17;

import javaSE.javaseElementary.javase17.student.SportsStudent;

public class Main {

    public static void main(String[] args) {

        /*Student student = new Student("叶玄朔", 19);
        System.out.println(student.getName());
        System.out.println(student.getAge());*/

        SportsStudent sportsStudent = new SportsStudent("yxs", 20);
        System.out.println(sportsStudent.hashCode());
        System.out.println(sportsStudent.equals(sportsStudent));
        System.out.println(sportsStudent.toString());

    }

}
