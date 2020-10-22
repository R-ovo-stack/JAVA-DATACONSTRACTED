package javainkedlist;

//import java.util.ArrayList;


/**
 * 单链表节点
 */

class Node{
    int data;  //type类型data
    Node next;  //指向下一结点的指针 || 在java中使用引用类型来表示
    /**
     * 
     * @param data 带参构造器
     */
    public Node(int data){
        this.data=data;
        this.next=null;  //初始化为Null
    }
}

/**
 * 单链表类
 * 提供头节点 | 链表长度 | 尾节点
 * 以下所有链表的索引值都从1开始
 */
public class linkedlist {

    protected Node HEAD=null;  //头指针
//    protected Node TAIL=null;  //尾指针
    protected int LEN=0;  //链表长度

    /**insert1插入函数
     * 尾插 | 链表自带有尾指针的情况
     * @param list  待插入的链表
     * @param value  插入节点的值
     * @return
     */
    /*
    public static linkedlist Insert_Wei1(linkedlist list,int value){
        //如果链表为空
        if(list.HEAD==null){
            list.HEAD=new Node(value);
            list.TAIL=list.HEAD; //此时只有一个元素
            list.TAIL.next=null;
            return list;
        }
        Node temp=list.TAIL;  //获取链表尾节点并使用移动指针temp
        temp.next=new Node(value);
        list.TAIL=temp.next;
        list.TAIL.next=null;
        return list;
    }
    */

    /**
     * 尾插
     * @param list
     * @param value
     * @return
     */
    public static linkedlist Insert_Wei2(linkedlist list,int value){
        //没有尾指针
        if(list.HEAD==null){
            list.HEAD=new Node(value);
            list.HEAD.next=null;
            return list;
        }
        Node temp=list.HEAD;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node(value);
        temp.next.next=null;
        return list;
    }
    /**
     * 在第i个节点前插入新的节点
     * @param list
     * @param value
     * @return
     */
    public static linkedlist Insert_I(linkedlist list,int value,int i){
        //此处不考虑尾节点TAIL
        if(list.HEAD==null || i<=0)
            return null;
        else if(i==1){//头节点前移
            //Node temp=list.HEAD;
            Node NewNode=new Node(value);
            NewNode.next=list.HEAD;
            list.HEAD=NewNode;
            return list;
        }
        else{
            Node temp=list.HEAD;
            for(int k=1;k<i-1;k++){
                //找到第i个元素之前的元素
                temp=temp.next;
            }
            Node temp2=temp.next;
            temp.next=new Node(value);
            temp.next.next=temp2;
            return list;
        }
    }
    /**
     * 头插
     * @param list
     * @param value
     * @return
     */
    public static linkedlist Insert_Head(linkedlist list,int value){
        //不考虑尾指针
        if(list.HEAD==null){
            list.HEAD=new Node(value);
            list.HEAD.next=null;
            return list;
        }
        Node current=new Node(value);
        current.next=list.HEAD;
        list.HEAD=current;
        return list;
    }
    /**
     * 删除第i个结点，按索引删除
     * @param list
     * @param value
     * @return
     */
    public static linkedlist Delete_I(linkedlist list,int i){
        if(list.HEAD==null || i<=0)
            return null;
        else if(i==1){//删除头节点 || 第一个结点就是头节点
            list.HEAD=list.HEAD.next;
            return list;
        }
        else{
            Node temp=list.HEAD;
            for(int k=1;k<i-1;k++){ //找到i结点前一个结点
                temp=temp.next;
            }
            Node temp2=temp.next; //temp2指向第i个结点
            temp.next=temp2.next;
            return list;
        }
    }
    /*
    public static ArrayList Bianli(linkedlist list) {
        if (list.HEAD == null) {
            return null;
        }
        ArrayList<Integer> A = new ArrayList<>();
        Node temp = list.HEAD;
        while (temp.next != null) {
            A.add(temp.data);
            temp = temp.next;
        }
        return A;
    }
    */

    public static void Bianli(linkedlist list) {
        if (list.HEAD == null) {
            return ;
        }
        //ArrayList<Integer> A = new ArrayList<>();
        Node temp = list.HEAD;
        System.out.print(temp.data + " ");
        while (temp.next != null) {
            temp = temp.next;
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        linkedlist m=new linkedlist();
        Insert_Head(m,1);
        Insert_Head(m,2);
        Insert_Head(m,3);
        Insert_Head(m,4);
        Insert_Head(m,5);
        Insert_Head(m,6);
        Insert_Head(m,7);
        Bianli(m);
        Delete_I(m, 3); //删除函数测试
        Bianli(m);
        Delete_I(m, 1);  //删除函数头节点测试
        Bianli(m); 
        Insert_I(m, 100, 1); //插入函数头节点前测试
        Bianli(m);
        Insert_I(m, 200, 2);    //插入函数测试
        Bianli(m);
        Insert_Wei2(m, 1000);  //尾插函数测试
        Bianli(m);
        Insert_Head(m,19);  //头插函数测试
        Bianli(m);
    }
}
