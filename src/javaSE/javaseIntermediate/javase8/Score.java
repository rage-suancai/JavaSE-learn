package javaSE.javaseIntermediate.javase8;

public class Score<T> implements ScoreInterface<T> {
    String name;
    String id;
    T score;

    @Override
    public T getScore() {
        return score;
    }

    @Override
    public void setScore(Object o) {
        this.score = score;
    }

}
