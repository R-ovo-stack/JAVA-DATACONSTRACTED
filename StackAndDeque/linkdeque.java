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
        this.FRONT=null;
        this.REAR=null;
    }
    public Node Enqueue(int value){
        if(this.FRONT==this.REAR){
            Node current=new Node(value);
            this.FRONT=current;
           // this.FRONT.next=null;
            this.REAR=current.next;
            this.LEN++;
            System.out.println("队长为: "+this.LEN);
            return this.FRONT;
        }else{
            Node current=new Node(value);
            this.REAR=current;
            this.REAR=current.next;
            this.LEN++;
            System.out.println("队长为: "+this.LEN);
            return current;
        }
    }
    public Node dequeue(){
        if(this.FRONT==this.REAR)
            return null;
        Node temp=this.FRONT;
        Node current=temp;
        temp=temp.next;
        this.FRONT=temp;
        this.LEN--;
        return current;
    }
    public void Bianli(){
        if(this.FRONT==this.REAR)
            return ;
        Node temp=this.FRONT;
        System.out.println(temp.data);
       // while(temp.next!=this.REAR)
        for(int i=1;i<=5;i++){
            temp=temp.next;
            System.out.println(temp.data);
        }   
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

