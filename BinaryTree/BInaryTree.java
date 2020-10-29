package BinaryTree;

import java.util.Scanner;

/**
 * 
 * 为什么创建了二叉树后根节点的左右孩子始终为Null?/???????
 */
class BTnode {
    // 创建二叉树结点，存储数据类型为一个整型数据
    BTnode left;
    BTnode right;
    int data;
    String s;

    public BTnode(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
        this.s = "";
    }

    public BTnode() {
    }

    public BTnode(String m) {
        this.s = m;
        this.data = 0;
        this.left = null;
        this.right = null;
    }
    //
}

public class BInaryTree {
    public static Scanner queScanner = new Scanner(System.in);

    // 询问法创建二叉树 || 递归 || 前序遍历方式创建
    // 输入1表示需要同意，0表示不打算
    public static void CreateBT(BTnode root) {
        if (root == null) {
            System.out.println("请输入节点数据: ");
            int m = queScanner.nextInt();
            root = new BTnode(m);
        }
        System.out.print("数据域为" + root.data + "是否创建左子树? ");
        int m = queScanner.nextInt();
        if (m == 0) {
            root.left = null;
        } else if (m == 1) {
            CreateBT(root.left);
        }
        System.out.print("数据域为" + root.data + "的结点是否创建右子树? ");
        int n = queScanner.nextInt();
        if (n == 0) {
            root.right = null;
        } else if (n == 1) {
            CreateBT(root.right);
        }
        //return root;
    }

    // 插空法创建二叉树 || 前序遍历
    public static void CreateTree(BTnode root) {
        // 输入一个字符，作为数据或者null结点信号
        System.out.println("请输入一个字符，如果输入的是#,则创建空节点，否则创建一个新的结点");
        
        
        String ch = queScanner.next();
        if (ch == "#") {
            root = null;
            return ;
        } else {
            root = new BTnode(ch);
            CreateTree(root.left);
            CreateTree(root.right);
            //return root;
        }

    }

    // 前序遍历二叉树
    public static void preorder(BTnode root) {
        // System.out.println("开始前序遍历:");
        if (root != null) {
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }
    //中序遍历
    public static void zhongorderr(BTnode root){
        if (root != null) {
            preorder(root.left);
            System.out.println(root.data);
            preorder(root.right);
        }
    }
    //后序遍历
    public static void houorder(BTnode root){
        if (root != null) {
            preorder(root.left);
            preorder(root.right);
            System.out.println(root.data);
        }
    }

    public static void main(String[] args) {
        BTnode tree = new BTnode(1); // 初始化根节点为1
        // BTnode temp = tree;
        /*
        CreateBT(tree);
        System.out.println(tree.left);
        System.out.println(tree.right);
        preorder(tree);
        */
        // BTnode tree2=null;
        CreateTree(tree);
        preorder(tree);
    }
}
