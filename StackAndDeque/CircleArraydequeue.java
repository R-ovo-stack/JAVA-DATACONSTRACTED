package StackAndDeque;

/**
 * class ANode2 {
    int data;
    public ANode2(int value) {
        this.data = value;
    }
 */

/**
 * 循环队列:队头和队尾使用取模运算获得新的数组下标,以使[由于顺序队列中队头出队，队尾入队]产生的多余的空间得以利用
 * .本程序判断队空条件:front==rear; .本程序判断队满条件:放弃一个空间不使用 (rear+1)%maxsize==front
 */

public class CircleArraydequeue {
    public final static int MAXSIZE = 5; // 顺序栈最大空间
    ANode2[] ADeque = new ANode2[MAXSIZE];
    int front; // 指向队头
    int rear; // 指向队尾
    // protected int LEN; // 队列实际元素数量

    public CircleArraydequeue() {
        ADeque = new ANode2[MAXSIZE]; // 初始化
        this.front = 0;
        this.rear = 0;
        // this.LEN = 0;
    }

    public ANode2 Enqueue(int value) {
        // 从队尾入队
        if (this.isFull()) {
            System.out.println("队列已满");
            return null;
        }
        ANode2 current = new ANode2(value);
        this.ADeque[rear] = current;
        this.rear = (this.rear + 1) % MAXSIZE;
        return current;
    }

    /**
     * 由于每次每次出队，队头指针上移，遗漏的空间在顺序队列中无法利用到(入队只能从队尾进入)
     * 所以当rear=MAXSIZE会出现假溢出(出队空出的数组空间没有使用到) 可以让队列改为循环队列消除这种浪费空间的假溢出现象(队头和队尾相连)
     * 
     * @return 返回出队元素
     */
    public ANode2 Dequeue() {
        if (this.isEmpty()) {
            System.out.println("队列已空");
            return null;
        }
        ANode2 current = this.ADeque[this.front];
        this.front = (this.front + 1) % MAXSIZE;
        return current;
    }

    public int GetLength() {
        return (this.rear - this.front + MAXSIZE) % MAXSIZE;
    }

    public ANode2 GetFront() {
        return this.ADeque[this.front];
    }

    public Boolean isFull() {
        return this.front == (this.rear + 1) % MAXSIZE ? true : false;
    }

    public Boolean isEmpty() {
        return this.front == this.rear ? true : false;
    }

    // 以出队方式遍历，遍历完成，队列已空
    public void Bianli() {
        int i = 0;
        while (!this.isEmpty()) {
            System.out.println("第" + (++i) + "次出队元素为: " + this.Dequeue().data);
        }
    }

    // 通过temp遍历，不进行出队遍历
    public void Bianli2() {
        // 从头到尾遍历
        int flag=1;
        int i = this.front;
        while (i != this.rear) {
            System.out.println("队列第"+(flag++)+"个元素为: "+this.ADeque[i].data);
            i = (i + 1) % MAXSIZE;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircleArraydequeue CA = new CircleArraydequeue();
        CA.Enqueue(1);
        CA.Enqueue(2);
        CA.Enqueue(3);
        CA.Enqueue(4);
        // 队列已满
        CA.Enqueue(5);
        CA.Enqueue(6); // 队列已满
        CA.Bianli();
        CA.Bianli(); // 队列已空
        CA.Enqueue(1);
        CA.Enqueue(2);
        CA.Enqueue(3);
        CA.Enqueue(4); // 队列已满
        CA.Dequeue();
        CA.Dequeue(); // 数组前2位此时空闲
        CA.Enqueue(5);
        CA.Enqueue(6); // 补足空闲空间
        System.out.println(CA.isFull());
        System.out.println(CA.GetLength());
        CA.Bianli2();
        CA.Bianli();
        System.out.println(CA.isEmpty());

    }
}
