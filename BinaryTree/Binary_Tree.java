package BinaryTree;

/**
 * 又是一串辣鸡>.....
 * 没学通...
 */
import java.util.Scanner;

//二叉链表结点
class BNode {
    String data;
    BNode left;
    BNode right;

    public BNode(String value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }



}

// 二叉链表实现
public class Binary_Tree {

    
    public static int i = 0;
    public static Scanner cin = new Scanner(System.in);

    // 使用#号截停方式创建二叉树[前序遍历]
    public static void CreateBinaryTree(BNode root) {
        String current = cin.nextLine();
        if (current == "#")
            root = null;
        // System.out.print("请输入第" + (++i) + "个结点值:");
        root=new BNode(current);
        CreateBinaryTree(root.left);
        CreateBinaryTree(root.right);
    }

    public static void OFF() {
        i = 0;
    }

    public static void PreOrder(BNode root) {
        if (root == null)
            return;
        System.out.println("第" + (++i) + "个结点值:" + root.data);
        PreOrder(root.left);
        PreOrder(root.right);
    }
    public static void main(String[] args) {
        BNode HEAD = new BNode("5");
        CreateBinaryTree(HEAD);
        PreOrder(HEAD);
    }
}
