package javaSE.javaseIntermediate.javase13;

/**
 * @author YXS
 * @PackageName: javaSE.javaseIntermediate.javase13
 * @ClassName: TreeNode
 * @Desription:
 * @date 2023/3/29 14:24
 */
public class TreeNode<E> {

    public E element;
    public TreeNode<E> left, right;

    public TreeNode(E element) {
        this.element = element;
    }

}
