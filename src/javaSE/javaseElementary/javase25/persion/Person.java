package javaSE.javaseElementary.javase25.persion;

public abstract class Person {

    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract void eat();

    public abstract void run();

    public abstract void study();

}
