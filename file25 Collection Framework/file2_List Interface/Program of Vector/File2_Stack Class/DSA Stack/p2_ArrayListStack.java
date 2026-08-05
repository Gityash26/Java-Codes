/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============= Implementing Stack using ArrayList ===========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


                                    Heap memory
          --------------------------------------------------------------
          |                                                            |
          |         ___________________________________ _ _ _ _        |
          |        |_Data_|_Data_|_Data_|_Data_|_Data_| _ _ _ _        |
          |                                                            |
          |                                                            |
          --------------------------------------------------------------




*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.ListIterator;

class ArrayListStack 
{
    ArrayList<Integer> stack = new ArrayList<>();

    void push(int data)
    {
        stack.add(data);
        System.out.println("-> Push element : " + stack.getLast());
    }

    void pop()
    {
        if(stack.isEmpty())
            System.out.println("\n-> Stack is empty...");
        else 
            System.out.println("\n-> Pop element : " + stack.removeLast());
    }

    void peek()
    {
        if(stack.isEmpty())
            System.out.println("\n-> Satck is empty...");
        else 
            System.out.println("\n-> Peek Top Element : " + stack.getLast());
    }

    void display()
    {
        if(stack.isEmpty())
            System.out.println("\n-> Satck is empty...");
        else 
        {
            ListIterator<Integer> iterator = stack.listIterator(stack.size());
            System.out.println();
            while(iterator.hasPrevious())
            {
                System.out.println("|\t " + iterator.previous() + "\t   |");
                System.out.println("|__________________|");
            }
        }
    }
}

public class p2_ArrayListStack 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayListStack s = new ArrayListStack();
        int choice;

        while(true)
        {
            System.out.print("\nEnter your operation : \n(1) Push operation\n(2) Pop operation\n(3) Peek operation\n(4) Display operation\n(5) Quit\n---------> ");
            choice = sc.nextInt();
            
            switch(choice)
            {
                case 1:
                    System.out.print("\nEnter your data : ");
                    int data = sc.nextInt();
                    s.push(data);
                    break;
                    
                case 2:
                    s.pop();
                    break;
                    
                case 3:
                    s.peek();
                    break;

                case 4:
                    s.display();
                    break;

                case 5:
                    sc.close();
                    return;
                
                default:
                    System.out.println("Invalid input");
                    break;
                    
            }
        }
        
    }   
     
}
