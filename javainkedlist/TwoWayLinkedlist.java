package javainkedlist;

class TNode{
    int data;   //数据域
    TNode next; //指向后一个结点指针
    TNode pre;  //指向前一个结点指针
    public TNode(int value){
        this.data=value;
        this.next=null;
        this.pre=null;
    }
}
public class TwoWayLinkedlist {
    //没有设定尾节点
    TNode HEAD;
    //int LEN;
    /**
     *--- 头插
     * @param value  插入结点的值,类型int
     * @return
     */
    public int insert_head(int value){
        if(this.HEAD==null){
            this.HEAD=new TNode(value);
            this.HEAD.next=null;
            this.HEAD.pre=null;
            return value;
        }
        TNode current=new TNode(value);
        current.next=this.HEAD; //指向原头节点
        current.pre=null;
        this.HEAD.pre=current;
        this.HEAD=current;
        return value;
    }
    /**
     * ----尾插
     * @param value
     * @return
     */
    public int Insert_tail(int value){
        if(this.HEAD==null){
            this.HEAD=new TNode(value);
            this.HEAD.next=null;
            this.HEAD.pre=null;
            return value;
        }
        TNode temp=this.HEAD;
        while(temp.next!=null){
            temp=temp.next;
        }
        TNode current=new TNode(value);
        temp.next=current;
        current.pre=temp;
        current.next=null;
        return value;
    }
    public int Insert_i(int i,int value){
        if(i<=0)
            return 0;
        else if(this.HEAD==null){ //如果双向链表为空，则直接新建头节点
            this.HEAD=new TNode(value);
            this.HEAD.next=null;
            this.HEAD.pre=null;
            return value;
        }else if(i==1){//需要移动头节点
            TNode current=new TNode(value);
            current.next=this.HEAD; //指向原头节点
            current.pre=null;
            this.HEAD.pre=current;
            this.HEAD=current;
            return value;
        }else{
            TNode temp=this.HEAD;
            for(int k=1;k<i-1;k++)//找到i前一个结点
                temp=temp.next;
            TNode temp2=temp.next; //结点i
            TNode current=new TNode(value);
            temp.next=current;
            current.pre=temp;
            current.next=temp2;
            temp2.pre=current;
            return value;    
        }
    }
    public int Delete_i(int i){
        if(this.HEAD==null){
            System.out.println("Error!TowWayLinkedlist is empty !");
            return 0;
        }else if(i==1){//删除头节点，需要移动
            int value=this.HEAD.data;
            TNode current=this.HEAD.next;
            current.pre=null;
            this.HEAD=current;
            return value;
        }else{
            TNode temp=this.HEAD;
            for(int k=1;k<i-1;k++)
                temp=temp.next;
            TNode current=temp.next;
            int value=current.data;
            TNode temp2=current.next;
            temp2.pre=temp;
            temp.next=current.next;
            return value;
        }
    }
        public int GetValue(int i){
            if(i<=0){
                System.out.println("Error");
                return 0;
            }else if(this.HEAD==null){
                System.out.println("Linkedlist is Empty !");
                return 0;
            }else{
                TNode temp=this.HEAD;
                for(int k=1;k<i;k++)
                    temp=temp.next;
                return temp.data;
            }
        }
        public void Bianli() {
            if (this.HEAD == null) {
                return ;
            }
            //ArrayList<Integer> A = new ArrayList<>();
            TNode temp = this.HEAD;
            System.out.print(temp.data + " ");
            while (temp.next != null) {
                temp = temp.next;
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }
    
        public static void main(String[] args) {
            TwoWayLinkedlist list=new TwoWayLinkedlist();
            list.insert_head(1);
            list.insert_head(2);
            list.insert_head(3);            
            list.insert_head(4);
            list.insert_head(5);
            list.insert_head(6);
            list.Bianli();
            list.Insert_tail(7);
            list.Bianli();
            list.Insert_i(2, 100);
            list.Bianli();
            list.Insert_i(1, 200);
            list.Bianli();
            list.Delete_i(1);
            list.Bianli();
            list.Delete_i(2);
            list.Bianli();
        }
}

