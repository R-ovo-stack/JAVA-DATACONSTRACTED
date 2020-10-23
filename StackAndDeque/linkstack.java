package StackAndDeque;

class Node{
    int data;
    Node next;
    public Node(){}
    public Node(int value){
        this.data=value;
    }
}
public class linkstack{
    protected Node TOP; //栈顶 -->元素此进此出
    protected Node BOTTOM; //栈底
    protected int LEN=0;  //记录栈的深度

    public linkstack(){
        this.BOTTOM=this.TOP=null;
    }
    /**
     * 
     * @param value  压入数字链栈的数值
     * @return
     */
    public Node Push(int value){
        if(this.TOP==null){
            Node current=new Node(value);
            this.BOTTOM=this.TOP=current;
            current.next=null;
            return current;
            /**
             * 发现一个事情，如果这个时候我没有建立current,
             * 而只是使用了this.BOTTOM=this.TOP=new Node(value);
             * 在遍历的时候，会遍历两次栈底BOTTOM
             */
        }
        Node current=new Node(value);
        current.next=this.TOP;
        this.TOP=current;        
        return this.TOP;
    }
    public Node Pop(){
        if(this.TOP==null)
            return null;
        Node current=this.TOP;
        this.TOP=current.next;
        return current;
    }
    //遍历链栈
    public void Bianli(){
        if(this.TOP==null)
            return;
        Node temp=this.TOP;
        System.out.print(temp.data+"  ");
        while(temp!=this.BOTTOM){
            temp=temp.next;
            System.out.print(temp.data+"  "); 
        }
        System.out.println();
    }
    /**
     * 通过出栈顺序遍历.
     * 
     */
    public void PopBianli(){
        int i=0;
        if(this.TOP==null)
            return;
        while(this.TOP!=null){
            System.out.println("第"+(++i)+"次出栈的值为: "+this.Pop().data);
        }
        
        /*
        while(this.TOP!=this.BOTTOM){
            System.out.println("第"+(++i)+"次出栈的值为: "+this.Pop().data);
        }
        System.out.println("第"+(++i)+"次出栈的值为: "+this.Pop().data);
        */
    }
    public static void main(String[] args) {
        linkstack stack=new linkstack();
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        stack.Push(4);
        stack.Push(5);
        stack.Push(6);
        stack.Push(7);
        stack.Bianli();
        stack.Pop();
        stack.Pop();
        stack.Bianli();
        stack.Push(100);
        stack.Bianli();
        stack.PopBianli();
    }
}