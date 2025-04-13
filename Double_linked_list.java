public class Double_linked_list {
private Dnode head;
private int size;

private class Dnode{
    private int value;
    private Dnode next;
    private Dnode prev;
   public Dnode(int value){
    this.value=value;
   }
}
public void display(){
    Dnode node=head;
    while(node!=null){
        System.out.print(node.value+"->");
        node=node.next;
    }
    System.out.print("null");
}
public void revdisplay(){
    Dnode node = head;
    Dnode last =null;
    while(node!=null){
        last=node;
        node=node.next;
    }
    while(last!=null){
        System.out.print(last.value+"->");
        last=last.prev;
    }
    System.out.print("null");
}
public void insertLast(int val){
    Dnode node = new Dnode(val);
    Dnode temp=head;
    if (head==null){
        head=node;
        return;
    }
    while(temp.next!=null){
        temp=temp.next;
    }
    temp.next=node;
    node.prev=temp;
    node.next=null;
    size++;
}
public void insert_0based(int val, int index){
    if(index==0){
        insertfirst(val);
        return;
    }
    if(index==size){
        insertLast(val);
        return;
    }
    Dnode temp=head;
    for(int i=1;i<index;i++){
        temp=temp.next;
    }
    Dnode node = new Dnode(val);
    temp.next.prev=node;
    node.next=temp.next;
    node.prev=temp;
    temp.next=node;
    size++;
}
public void insertafter(int find,int value){
    Dnode node = head;
    while(node!=null){
        if(node.value==find){
            break;
        }
        node=node.next;
    }
    if(node==null){
        System.out.println("\nValue not found");
        return;
    }
    Dnode n = new Dnode(value);
    node.next.prev=n;
    n.next= node.next;
    n.prev=node;
    node.next=n;
    size++;

}
public void insertfirst(int val){
    Dnode node = new Dnode(val);
    node.next=head;
if(head==null){
    head=node;
}
    node.prev=null;
    head.prev=node;
    head=node;
    size++;
}
}