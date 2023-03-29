package javaSE.javaseIntermediate.javase16;

/**
 * @author YXS
 * @PackageName: javaSE.javaseIntermediate.javase15
 * @ClassName: HashTable
 * @Desription:
 * @date 2023/3/29 19:39
 */
public class HashTable<E> {

    private final int TABLE_SIZE = 10;
    private final Object[] TABLE = new Object[TABLE_SIZE];

    public void insert(E element) {

        int index = hash(element);
        TABLE[index] = element;

    }

    public boolean contains(E element) {

        int index = hash(element);
        return TABLE[index] == element;

    }

    private int hash(Object object) {

        int hashCode = object.hashCode();
        return hashCode % TABLE_SIZE;

    }

}
