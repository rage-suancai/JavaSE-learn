package javaSE.javaseIntermediate.javase5;

public class Score2<T> {
    String name;
    String id;
    T score;

    public Score2(String name, String id, T score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

}
