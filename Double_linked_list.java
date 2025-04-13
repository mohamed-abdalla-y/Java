public class Double_linked_list implements Implementations {
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
    System.out.println("null");
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
    System.out.print("null\n");
}
public void insertLast(int val){
    Dnode node = new Dnode(val);
    Dnode temp=head;
    if (head==null){
        head=node;
        size++;
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
 //!-----------------------------------
public void insert(int val,int index){
    if(index==0){
        insertfirst(val);
        // display();
        return;
    }
    if (index==size){
        insertLast(val);
        // display();
        return;
    }
    if(index>size||index<0){
        System.out.println("Error");
        return;
    }
    Dnode temp= head;
    if(temp==null){
        System.out.println("Error");
        return;
    }
    Dnode node = new Dnode(val);
    for(int i=1;i<index;i++){
        temp=temp.next;
    }
    node.next=temp.next;
    node.prev=temp;
    temp.next.prev = node;
    temp.next=node;
    size++;
    // display();
}

public Dnode find(int val){
    Dnode node = head;
    while(node!=null){
        if(node.value==val){
            return node;
        }
        node=node.next;
    }
    return null;
}


@Override
public void add(int value) {
    insertLast(value);
}
@Override
public void addToindex(int value, int index) {
    if(head!=null){
        insert(value, index);}
    else if(index==0&&head==null){
        insertfirst(value);
        // display();
    }
    else if (head==null)
        System.out.println("Error");
}
@Override
public int get(int index) {
    Dnode temp=head;
    if(temp==null||index<0){
        System.out.println("Error");
        System.exit(0);
    }
    int value=temp.value;
    for(int i=0;i<index;i++){
        if(temp.next==null){
            System.out.println("Error");
            System.exit(0);
        }
        temp=temp.next;
        value=temp.value;
    }
    return value;
}
@Override
public void set(int index, int value) {
    Dnode temp=head;
    // System.out.println(size);
    if(temp==null||index >= size||index<0){
        System.out.println("Error");
        return;
    }
    for(int i=0;i<index;i++){
        temp=temp.next;
    }
    temp.value=value;
}
@Override
public void clear() {
    if (head==null){
        System.out.println("[]");
        return;
    }
    head=null;
    size = 0;
    System.out.println("[]");
}
@Override
public boolean isEmpty() {
    if(size==0){
        return true;
    }
    else return false;
}
@Override
public void remove(int index) {
    if (index < 0 || index >= size || head == null) {
        System.out.println("Error");
        return;
    }

    if (index == 0) {
        if (head.next != null) {
            head = head.next;
            head.prev = null;
        } else {
            // only one element
            head = null;
        }
        size--;
        return;
    }

    Dnode temp = head;
    for (int i = 0; i < index; i++) 
        temp = temp.next;
    if (temp.prev != null) 
        temp.prev.next = temp.next;
    if (temp.next != null) 
        temp.next.prev = temp.prev;
    size--;
}
@Override
public void sublist(int index_left, int index_rigth) {
    Dnode temp= head;
    if(index_left>index_rigth){
        System.out.println("Error");
        return;
    }
    if(temp==null && size==0 &&index_left==0 && index_rigth==0){
        System.out.println("[]");
        return;
    }
    if(temp==null||index_rigth>size-1||index_left<0){
        System.out.println("Error");
        return;
    }
    for(int i=0;i<index_left;i++){
        temp=temp.next;
    }
    System.out.print("[");
    int elements= index_rigth-index_left;
    for(int j=0;j<elements;j++){
        System.out.print(temp.value+", ");
        temp=temp.next;
    }
    System.out.println(temp.value+"]");
}
@Override
public boolean contains(int value) {
    Dnode node= find(value);
    if(node==null){
    return false;
    }
    else if(node.value==value){
    return true;
    }
    return false;
}
@Override
public int size() {
    return size;
}
}

