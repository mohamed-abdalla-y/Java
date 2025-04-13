public class linked_list implements Implementations {

    private Node head;
    private Node tail;
    public int size;
    public linked_list(){
        this.size=0;
    }
private class Node {
  private  int value;
  private Node next ;
  public Node(int value){
    this.value=value;
  } 
}
public void insertfirst(int val){
    Node node = new Node(val);
    node.next=head;
    head=node;
    if(tail == null){
        tail= head;
    }
    size++;
}
public void display(){
    Node node= head;
    System.out.print("[");
    if(node!=null){
    while(node.next!= null){
        if(node.next!=null){
        System.out.print(node.value+", ");}
        node=node.next;
    }
    System.out.print(node.value+"]");
    return;
}
System.out.print("]"); 
return;
}
public void insertLast(int val){
    Node node = head;
    if(head==null){
        insertfirst(val);
        return;
    }
    while(node.next!=null){
        node=node.next;
    }
    Node node2= new Node(val);
    node.next=node2;
    tail=node2;
    size++;
}

public void deleteFirst(){
    Node node = head;
    if(head==null){
        return;
    }
    head=head.next;
    node.next=null;
    if(head==null){
        tail=null;
    }
    size--;
}
public void Deletetail(){
    Node node= head;
    if(head==null){
        return;
    }

    while(node.next.next!=null){
        node=node.next;
    }
    node.next=null;
    tail=node;
    size --;
}
public Node find(int val){
    Node node = head;
    while(node!=null){
        if(node.value==val){
            return node;
        }
        node=node.next;
    }
    return null;
}
public void add(int value){
    insertLast(value);
    display();
}
public void insert(int val,int index){
    if(index==0){
        insertfirst(val);
        display();
        return;
    }
    if (index==size){
        insertLast(val);
        display();
        return;
    }
    if(index>size||index<0){
        System.out.println("Error");
        return;
    }
    Node temp= head;
    if(temp==null){
        System.out.println("Error");
        return;
    }
    Node node = new Node(val);
    for(int i=1;i<index;i++){
        temp=temp.next;
    }
    node.next=temp.next;
    temp.next=node;
    size++;
    display();
}
public void addToindex(int value,int index){
    // Node node = new Node(value);
    // Node temp=head;
    // if(head==null){
    //     System.out.println("Error");
    // }
    // for(int i=0;i<index-1;i++){
    //     temp=temp.next;
    // }
    // if(index==0){
    //     insertfirst(value);
    //     display();
    //     return;
    // }
    // node.next=temp.next;
    // temp.next=node;
    // size++;
   if(head!=null){
     insert(value, index);}
   else if(index==0&&head==null){
    insertfirst(value);
    display();
   }
   else if (head==null){
    System.out.println("Error");
                                }
}
public int get(int index){
    Node temp=head;
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

public void set(int value,int index){
    Node temp=head;
    if(temp==null||index>size-1||index<0){
        System.out.println("Error");
        return;
    }
    for(int i=0;i<index;i++){
        temp=temp.next;
    }
    temp.value=value;
    display();
}
public void clear(){
    if (head==null){
        System.out.println("[]");
        return;
    }
    head=null;
    System.out.println("[]");
}
public boolean isEmpty(){
    if(size==0){
        return true;
    }
    else return false;
}
public void remove(int index){
    Node temp= head;
    if(temp==null){
        System.out.println("Error");
        return;
    }
    if (index==0){
        deleteFirst();
        display();
        return;
    }
    if(index>size-1||index<0){
        System.out.println("Error");
        return;
    }
    for(int i=0;i<index-1;i++){
        temp=temp.next;
    }
    temp.next=temp.next.next;
    display();
}
public void sublist(int index_left,int index_rigth){
    Node temp= head;
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
public boolean contains(int value){
   Node node= find(value);
   if(node==null){
    return false;
   }
   else if(node.value==value){
    return true;
   }
   return false;
}
public int size() {
    return size;
}
}
 