package StackAndDeque;
import StackAndDeque.Node;

/**
 * 顺序队列中，队头指向队列第一个元素
 *.队尾指针指向待插入元素的位置
 * 
 */
public class linkdeque{
    Node FRONT;  //队头
    Node REAR;  //队尾
    int LEN=0; //记录队长
    public linkdeque(){
        //初始化一个头节点--头节点不存储元素
        //队头指针永远指向该空的头节点
        //队尾指针永远指向队列最后一个结点
        this.FRONT=this.REAR=new Node();
    }
    public Node Enqueue(int value){
        Node current=new Node(value);
        this.REAR.next=current;
        this.REAR=current;

        this.LEN++;
        System.out.println("队长为: "+this.LEN);

        return this.REAR;
    }
    public Node dequeue(){
        if(this.FRONT==this.REAR)
            System.out.println("队列已空!");
        Node current=this.FRONT.next;
        this.FRONT.next=current.next;
        this.FRONT=current;
        return current;
    }

    //以普通方式遍历链队
    public void Bianli(){
        if(this.FRONT==this.REAR)
            return ;
        int i=0;
        Node current=this.FRONT;
        while(current!=this.REAR){
            current=current.next;
            System.out.print("第"+(++i)+"次出列的元素为: "+current.data);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //linkstack m=new linkstack();
        linkdeque m=new linkdeque();
        m.Enqueue(1);
        m.Enqueue(2);
        m.Enqueue(3);
        m.Enqueue(4);
        m.Enqueue(5);
        m.Bianli();
        m.dequeue();
        m.dequeue();
        m.Bianli();

    }
}

