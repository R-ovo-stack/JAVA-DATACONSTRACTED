package BinaryTree;

/**
 * 写了一段垃圾代码.....
 * 待修改，明天整几个接口改改
 */
public class T_Stack {

    class Node<T>{
        T data;   //
        Node<T> next;
        public Node(){}
        public Node(T value){
            this.data=value;
        }
    }
    
    protected Node<BNode> TOP; //栈顶 -->元素此进此出
    protected Node<BNode> BOTTOM; //栈底
    protected int LEN=0;  //记录栈的深度
    public T_Stack(){
        this.BOTTOM=this.TOP=null;
    }

    /**
     * 
     * @param value  压入数字链栈的数值
     * @return
     */

    public Node<BNode> Push(Node value){
        if(this.TOP==null){
            Node<BNode> current=new Node(value);
            this.BOTTOM=this.TOP=current;
            current.next=null;
            return current;
            /**
             * 发现一个事情，如果这个时候我没有建立current,
             * 而只是使用了this.BOTTOM=this.TOP=new Node(value);
             * 在遍历的时候，会遍历两次栈底BOTTOM
             */
        }
        Node<BNode> current=new Node(value);
        current.next=this.TOP;
        this.TOP=current;        
        return this.TOP;
    }

    public Node<BNode> Pop(){
        if(this.TOP==null)
            return null;
        Node<BNode> current=this.TOP;
        this.TOP=current.next;
        return current;
    }
/*
    //遍历链栈
    public void Bianli(){
        if(this.TOP==null)
            return;
        Node<BNode> temp=this.TOP;
        System.out.print(temp.data+"  ");
        while(temp!=this.BOTTOM){
            temp=temp.next;
            System.out.print(temp.data+"  "); 
        }
        System.out.println();
    }
*/
    /**
     * 通过出栈顺序遍历.
     * 
     */
    /*
    public void PopBianli(){
        int i=0;
        if(this.TOP==null)
            return;
        while(this.TOP!=null){
            System.out.println("第"+(++i)+"次出栈的值为: "+this.Pop().data);
        }
    }
*/
/*
    public static void main(String[] args) {
        T_Stack stack=new T_Stack();
        BNode k=new BNode(1);
        stack.Push(k);
        stack.Pop();
        stack.Pop();
        stack.Push(100);
    }
    */
}
