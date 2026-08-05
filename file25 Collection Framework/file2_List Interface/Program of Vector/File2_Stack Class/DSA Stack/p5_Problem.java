/* 
========================================
Question: Insertion / Deletion from any index in a stack
========================================
*/


import java.util.Scanner;
import java.util.Stack;


enum Operation 
{
    Push(1), Pop(2), PushAt(3), PopAt(4), Display(5), Quit(6);

    private int index;

    private Operation(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return this.index;
    }

}

class StackOperation
{
    Stack<Integer> stack = new Stack<>();

    void push(int data)
    {
        stack.push(data);
        System.out.println("-> Push data : " + data);
    }


    void pop()
    {
        if(stack.isEmpty())
            System.out.println("\n-> Satck is empty...");
        else 
            System.out.println("-> Pop element : " + stack.pop());
    }

    void pushAt(int index, int data) 
    {
        Stack<Integer> tempStack = new Stack<>();
        int currentIndex = stack.size();

        // Move elements to tempStack until the desired index
        while (currentIndex >= index) 
        {
            tempStack.push(stack.pop());
            currentIndex--;
        }

        // Push the new data at the desired index
        push(data);

        // Restore the elements back to the main stack
        while (!tempStack.isEmpty()) 
        {
            stack.push(tempStack.pop());
        }
    }

    void popAt(int index) 
    {
        Stack<Integer> tempStack = new Stack<>();
        int currentIndex = stack.size();
    
        // Pop elements until the desired index is reached
        while (currentIndex > index) 
        {
            tempStack.push(stack.pop());
            currentIndex--;
        }
    
        // Remove the element at the desired index
        if (!stack.isEmpty()) 
        {
            System.out.println("-> Pop element at index " + index + " : " + stack.pop());
        } 
        else 
        {
            System.out.println("-> Stack is empty at the specified index.");
        }
    
        // Restore the elements back to the main stack
        while (!tempStack.isEmpty()) 
        {
            stack.push(tempStack.pop());
        }
    }
    
    void display()
    {
        if(stack.isEmpty())
        {
            System.out.println("|_______________|");
            return;
        }

        int tem = stack.pop();
        System.out.println("|\t" + tem + "\t|------> index (" + (1 + stack.size()) + ")");
        display();
        stack.push(tem);
    }

    int getIndex(int choice)
    {
        int index;
        int indexLimit = (choice == 1)? stack.size()+1 : stack.size();
        
        if(choice==1 && indexLimit==1 || choice==2 && indexLimit==0)
        return indexLimit;

        // creating scanner object for input 
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
            
        while(true)
        {
            try 
            {
                System.out.print("\nAvailable index are from 1 to " + indexLimit + " : ");
                index = sc.nextInt();
                
                if(index>=1 && index<=indexLimit)
                {
                    return index;
                }
                else 
                {
                    System.out.println("-> Please enter index within range...");
                }
            }
            catch(Exception e)
            {
                sc.nextLine();
                System.out.println("\n-> Invalid input...");
            }
        }
    }
    
    
}


public class p5_Problem 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int choice, data, index;

        StackOperation stackObj = new StackOperation();

        while(true)
        {
            System.out.println("\n");
            for(Operation opt : Operation.values())
            {
                System.out.println("Press " + opt.getIndex() + " ----> " + opt + " Operation");
            }

            System.out.print("\nEnter your operation : ");
            choice = sc.nextInt();

            switch(choice)
            {

                // push operation 
                case 1:
                {
                    System.out.print("\n-> Enter a data to push : ");
                    data = sc.nextInt();
                    stackObj.push(data);                   
                    break;
                }

                // pop operation 
                case 2:
                {
                    stackObj.pop();
                    break;
                }

                // pushAt operation 
                case 3:
                {
                    System.out.print("\n-> Enter a data to pushAt : ");
                    data = sc.nextInt();
                    index = stackObj.getIndex(1);
                    stackObj.pushAt(index, data);
                    break;
                }
                
                // pophAt operation 
                case 4:
                {
                    index = stackObj.getIndex(2);
                    if(index == 0)
                        System.out.println("\n-> Satck is empty...");
                    else 
                        stackObj.popAt(index);
                    break;
                }
                
                // display operation 
                case 5:
                {
                    System.out.println("\nSatck Elements are.....\n");
                    stackObj.display();
                    break;
                }

                case 6:
                    System.out.println("\n-> Cosing stack operations....");
                    sc.close();
                    return;
                
                default:
                    System.out.println("\n-> Please enter a correct choice...");
                    break;

            }
        }

    }
}