package javaSE.javaseIntermediate.javase13;

/**
 * 本版块主要学习的是二叉树 树也是一种数据结构 但是它使用起来更加的复杂
 *
 * 树
 * 我们前面已经学习过链表了 我们知道链表是单个结构之间相连 也就是一种一对一的关系 而树则是一个节点连接多个节点 也就是一对多的关系
 *
 * 一个节点可以有N个子节点 看起来就像是一颗树 而位于最顶端的节点(没有父节点) 我们称为根节点 而节点拥有的子节点数量称为度 每向下一级称为一个层次 树中出现的最大层次称为树的深度(高度)
 *
 * 二叉树
 * 二叉树是一种特殊的树 每个节点最多有两颗子树 所以二叉树中不存在度大于2的节点 位于两边的子节点称为左右子树(注意: 左右子树是明确区分的 是左就是左 是右就是右)
 *
 * 数学性质:
 *      > 在二叉树的第i层上最多有2^(i-1)个节点
 *      > 二叉树中如果深度为k 那么最多有2^k-1个节点
 *
 * 设计一个二叉树节点类:
 *                  public class TreeNode<E> {
 *                      public E e; // 当前节点数据
 *                      public TreeNode<E> left; // 左子树
 *                      public TreeNode<E> right; // 右子树
 *                  }
 *
 * 二叉树的遍历
 * 顺序表的遍历其实就是依次有序去访问表中每一个元素 而像二叉树这样的复杂结构 我们有四种遍历方式 它们是: 前序遍历 中序遍历 后序遍历以及层序遍历 本版块我们主要讨论前三种遍历方式:
 *      > 前序遍历: 从二叉树的根节点出发 到达节点就直接输出节点数据 按照先向左在向右的方向访问 ABCDEF
 *      > 中序遍历: 从二叉树的根节点出发 优先输出左子树的节点的数据 在输出当前节点本身 最后才是右子树 CBDAEF
 *      > 后序遍历: 从二叉树的根节点出发 优先遍历其左子树 在遍历右子树 最后在输出当前节点本身 CDBFEA
 *
 * 满二叉树和完全二叉树
 * 二叉树和完全二叉树其实就是特殊情况下的二叉树 满二叉树左右是所有叶子节点都在同一层 也就是说 完全把每一层都给满了节点
 * 完全二叉树满二叉树不同的地方在与 它的最下层叶子节点可以不满 但是最后下层的叶子节点必须靠左排布
 *
 * 其实满二叉树和完全二叉树就是有一定规律的二叉树 很容易理解
 *
 * 快速查找
 * 我们之前提到的这些数据结构 很好地帮我们管理了数据 但是 如果需要查找某一个元素是否存在于数据结构中 如何才能更加高效的去完成呢?
 */
public class Main {

    static void test1(TreeNode<String> root) {

        if (root == null) return;
        System.out.print(root.e);
        test1(root.left);
        test1(root.right);

    }

    static void test2(TreeNode<String> root) {

        if (root == null) return;
        test2(root.left);
        System.out.print(root.e);
        test2(root.right);

    }

    static void test3(TreeNode<String> root) {

        if (root == null) return;
        test3(root.left);
        test3(root.right);
        System.out.print(root.e);

    }

    public static void main(String[] args) {

        TreeNode<String> root = new TreeNode<>("A");
        root.left = new TreeNode<>("B");
        root.right = new TreeNode<>("E");
        root.left.left = new TreeNode<>("C");
        root.left.right = new TreeNode<>("D");
        root.right.right = new TreeNode<>("F");
        System.out.println("debug");
        //test1(root);
        //test2(root);
        test3(root);

    }

}
