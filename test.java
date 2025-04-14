import java.util.Scanner;

interface Implementations {
    public void add(int value);
    public void addToindex(int value,int index);
    public int get(int index);
    public void set(int value,int index);
    public void clear();
    public boolean isEmpty();
    public void remove(int index);
    public void sublist(int index_left,int index_rigth);
    public boolean contains(int value);
    public int size();
    
}
class DLL implements Implementations {
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
    Dnode node= head;
    System.out.print("[");
    while(node != null){
        System.out.print(node.value);
        if(node.next != null){
            System.out.print(", ");
        }
        node = node.next;
    }
    System.out.println("]");
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
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (head == null) {
        if (index == 0) {
            insertfirst(value);
        } else {
     throw new IndexOutOfBoundsException();
        }
        return;
    }
    insert(value, index);
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
public void set(int value, int index) {
    Dnode temp=head;
    // System.out.println(size);
    if(temp==null||index >= size||index<0){
 throw new IndexOutOfBoundsException();
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
        throw new IndexOutOfBoundsException();
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
public void sublist(int index_left, int index_right) {
    if (index_left > index_right || index_left < 0 || index_right >= size) {
        System.out.println("Error");
        return;
    }

    if (head == null || size == 0) {
        System.out.println("[]");
        return;
    }

    Dnode temp = head;
    for (int i = 0; i < index_left; i++) {
        temp = temp.next;
    }

    System.out.print("[");
    for (int i = index_left; i <= index_right; i++) {
        System.out.print(temp.value);
        if (i != index_right) {
            System.out.print(", ");
        }
        temp = temp.next;
    }
    System.out.println("]");
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

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input= scanner.nextLine().trim().replaceAll("\\[|\\]", "");
        boolean isEmpty=false;
        if(input.equals("")){
            isEmpty=true;
        }
        try{
        String[] howmany=input.split(", ");
        DLL D1 = new DLL();
        if(isEmpty==false){
        for(String i : howmany){
          D1.insertLast(Integer.parseInt(i));
        }
        }
        String command=scanner.nextLine().trim();
        if(command.equals("addToIndex")){
            int index = scanner.nextInt();
            int value=scanner.nextInt();
            D1.addToindex(value, index);
            D1.display();
        }
        else  if (command.equals("add")) {
            int value=scanner.nextInt();
            D1.add(value);
            D1.display();
        }
        else  if (command.equals("isEmpty")) {
            if(D1.isEmpty()==true){
                System.out.println("True");
            }
            else System.out.println("False");
        }
        else  if (command.equals("set")) {
            int index=scanner.nextInt();
            int value=scanner.nextInt();
            D1.set(value,index);
            D1.display();
        }
        else  if (command.equals("get")) {
            int index=scanner.nextInt();
            System.out.println(D1.get(index));
        }
        else  if (command.equals("size")) {
            System.out.println(D1.size());
        }
        else  if (command.equals("contains")) {
            int value=scanner.nextInt();
            if(D1.contains(value)==true){
            System.out.println("True");
        }
        else System.out.println("False");
        }
        else  if (command.equals("sublist")) {
            int index_left=scanner.nextInt();
            int index_rigth=scanner.nextInt();
            D1.sublist(index_left, index_rigth);
        }
        else if (command.equals("clear")) {
            D1.clear();
        }
        else   if (command.equals("remove")) {
            int index=scanner.nextInt();
            D1.remove(index);
            D1.display();
        }
        else{
        System.out.println("Error");
        } 
        scanner.close(); 
    } catch(IndexOutOfBoundsException | NullPointerException e ){
        System.out.println("Error");
    } 

    }
}
