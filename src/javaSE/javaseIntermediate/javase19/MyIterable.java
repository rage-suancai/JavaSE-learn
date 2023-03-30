package javaSE.javaseIntermediate.javase19;

import java.util.Iterator;

/**
 * @author YXS
 * @PackageName: javaSE.javaseIntermediate.javase19
 * @ClassName: MyIterable
 * @Desription:
 * @date 2023/3/30 15:23
 */
public class MyIterable implements Iterable<String> {

    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public String next() {
                return "测试";
            }

        };

    }

}
