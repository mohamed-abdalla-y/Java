public class circular_linked_list {
    private Cnode head;
    private Cnode tail;
    public circular_linked_list(){
        this.head=null;
        this.tail=null;
    }
private class Cnode{
    private int value;
    private Cnode next;
    
    public Cnode(int value){
        this.value=value;
    }
}
public void insertlast(int val){
    Cnode node = new Cnode(val);
    if(head==null){
        head=node;
        tail=node;
        return;
    }
    tail.next=node;
    node.next=head;
    tail=node;

}
public void display(){
    Cnode node = head;
   if(head!=null){
    do{
        System.out.print(node.value+"->");
        node=node.next;
        
    }while(node!=head);
   }
   System.out.print("null");
}
public void delete(int val){
Cnode node= head;
if(node==null){
    return;
}
if(node.value==val){
    head=head.next;
    tail.next=head;
    return;
}
do{
    if(node.next.value==val){
        node.next=node.next.next;
        break;
    }
    node=node.next;
}while(node!=head);
}
}
