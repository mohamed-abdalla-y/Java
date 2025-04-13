import java.util.Scanner;

public class App  {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        String input= scanner.nextLine().trim().replaceAll("\\[|\\]", "");
        boolean isEmpty=false;
        if(input.equals("")){
            isEmpty=true;
        }

        String[] howmany=input.split(", ");
       linked_list Sl = new linked_list();
        if(isEmpty==false){
        for(String i : howmany){
          Sl.insertLast(Integer.parseInt(i));
        }
    }
        String command=scanner.nextLine().trim();
        if(command.equals("addToIndex")){
            int index = scanner.nextInt();
            int value=scanner.nextInt();
            Sl.addToindex(value, index);
        }
      else  if (command.equals("add")) {
            int value=scanner.nextInt();
            Sl.add(value);
        }
      else  if (command.equals("isEmpty")) {
            if(Sl.isEmpty()==true){
                System.out.println("True");
            }
            else System.out.println("False");
        }
      else  if (command.equals("set")) {
            int index=scanner.nextInt();
            int value=scanner.nextInt();
            Sl.set(value,index);
        }
      else  if (command.equals("get")) {
            int index=scanner.nextInt();
            System.out.println(Sl.get(index));
        }
      else  if (command.equals("size")) {
            System.out.println(Sl.size);
        }
      else  if (command.equals("contains")) {
            int value=scanner.nextInt();
            if(Sl.contains(value)==true){
            System.out.println("True");
        }
        else System.out.println("False");
        }
      else  if (command.equals("sublist")) {
            int index_left=scanner.nextInt();
            int index_rigth=scanner.nextInt();
            Sl.sublist(index_left, index_rigth);
        }
       else if (command.equals("clear")) {
            Sl.clear();
        }
     else   if (command.equals("remove")) {
            int index=scanner.nextInt();
            Sl.remove(index);
        }
       else{
        System.out.println("Error");
       } 
       scanner.close(); 
    }
}
