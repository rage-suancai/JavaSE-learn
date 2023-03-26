package javaSE.javaseIntermediate.javase7;

import org.w3c.dom.NameList;

public class Score<T extends Number> {
    private final String name;
    private final String id;
    private T score;

    public Score(String name, String id, T score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public T getScore() {
        return score;
    }

}
