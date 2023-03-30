package javaSE.javaseIntermediate.javase22;

/**
 * @author YXS
 * @PackageName: javaSE.javaseIntermediate.javase22
 * @ClassName: Sutdent
 * @Desription:
 * @date 2023/3/30 19:26
 */
public class Student {

    private final String name;
    private final String type;
    private final int score;

    public Student(String name, String type, int score) {

        this.name = name;
        this.type = type;
        this.score = score;

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getScore() {
        return score;
    }

}
