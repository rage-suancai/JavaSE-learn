package javaSE.ObjectOriented;

public class Person {

    private final String name;

    private final int age;

    private final String sex;

    public void hello() {

        System.out.println("我叫:" + name + " 今年:" + age + "岁了" + " 性别是:" + sex);

    }

    public Person(String name, int age, String sex) {
        this.name = name; this.age = age; this.sex = sex;
    }

}
