package javaSE.Generics;

public class Score<T> {

    String name;

    String id;

    T value;

    public Score(String name, String id, T value) {
        this.name = name;
        this.id = id;
        this.value = value;
    }

}
