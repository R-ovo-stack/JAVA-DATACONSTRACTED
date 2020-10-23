package StackAndDeque;

/**
 * class ANode{ int data; }
 */
class ANode2 {
    int data;
    public ANode2(int value) {
        this.data = value;
    }
}

/**
 * LEN=rear-front || rear永远指向空元素 由于要通过队头队尾，为了方便研究队长，故此处使用frong和rear模拟充当队列数组的索引
 * .在链队中，rear指针指向队列最后一个元素，但是在顺序队列中，rear指向最后一个元素的下一个元素null
 */
// 顺序队列 || 数组实现
public class ArrayDeque {
    public final static int MAXSIZE = 100; // 顺序栈最大空间
    ANode2[] ADeque = new ANode2[MAXSIZE];
    int front; // 指向队头
    int rear; // 指向队尾
    //protected int LEN; // 队列实际元素数量

    public ArrayDeque() {
        ADeque = new ANode2[MAXSIZE]; // 初始化
        this.front = 0;
        this.rear = 0;
        //this.LEN = 0;
    }

    public ANode2 Enqueue(int value) {
        // 从队尾入队
        ANode2 current = new ANode2(value);
        this.ADeque[rear++] = current;
        return current;
    }

    /**
     * 由于每次每次出队，队头指针上移，遗漏的空间在顺序队列中无法利用到(入队只能从队尾进入)
     * 所以当rear=MAXSIZE会出现假溢出(出队空出的数组空间没有使用到)
     * 可以让队列改为循环队列消除这种浪费空间的假溢出现象(队头和队尾相连)
     * @return 返回出队元素
     */
    public ANode2 Dequeue() {
        if (this.isEmpty()){
            System.out.println("队列已空");
            return null;
        }
        ANode2 current = this.ADeque[this.front++];
        return current;
    }

    public Boolean isEmpty() {
        return this.front == this.rear ? true : false;
    }

    //以出队方式遍历，遍历完成，队列已空
    public void Bianli(){
        int i=0;
        while(!this.isEmpty()){
            System.out.println("第"+(++i)+"次出队元素为: "+this.Dequeue().data);
        }
    }

    public static void main(String[] args) {
        ArrayDeque ad =new ArrayDeque();
        ad.Enqueue(1);
        ad.Enqueue(2);
        ad.Enqueue(3);
        ad.Enqueue(4);
        ad.Enqueue(5);
        ad.Bianli();
        System.out.println(ad.rear-ad.front);
        ad.Enqueue(6);
        ad.Enqueue(7);
        ad.Dequeue();
        ad.Bianli();
    }
}
