package StackAndDeque;

class ANode {
    int data;
}

//top，bottom指向某个数组内的元素，本程序!=index
// 栈顶指向数组最后一名元素
// STACK[0]不存储元素
public class Arraystack {
    public final static int MAXSIZE = 100; // 顺序栈最大空间
    protected ANode[] STACK;
    protected ANode TOP;
    protected ANode BOTTOM;
    protected int LEN; // 栈内实际元素

    public Arraystack() {
        this.STACK = new ANode[MAXSIZE];
        this.TOP = this.BOTTOM = this.STACK[0];
        this.LEN = 0;
    }

    // 入栈
    public ANode Push(int value) {
        this.STACK[++this.LEN] = new ANode();
        this.STACK[LEN].data = value;
        this.TOP = this.STACK[LEN];

        return this.TOP;
    }

    // 出栈
    public ANode Pop() {
        ANode deleANode = this.TOP;
        this.TOP = this.STACK[--LEN];
        return deleANode;
    }

    // 获取栈有效长度
    public int GetSize() {
        return this.LEN;
    }

    // 获取栈顶元素
    public ANode GetTOP() {
        return this.TOP;
    }

    public Boolean isEmpty() {
        return  LEN == 0 ? true : false;
    }

    // 以清空顺序栈的方式遍历整个顺序栈
    public void Bianli() {
        int i = 1;
        while (!this.isEmpty()) {
            ANode current = this.Pop();
            System.out.println("第" + (i++) + "次出栈的元素为: " + current.data);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Arraystack as = new Arraystack();
        as.Push(1);
        as.Push(2);
        as.Push(3);
        System.out.println(as.GetSize());
        System.out.println(as.TOP.data);
        as.Push(4);
        as.Push(5);
        as.Bianli();
        System.out.println(as.isEmpty());
    }
}
