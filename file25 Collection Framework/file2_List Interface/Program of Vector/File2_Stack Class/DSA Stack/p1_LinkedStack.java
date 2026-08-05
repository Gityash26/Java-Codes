/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========== Satck Implementation using Linked List ===============
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                    head--\
                     ______\__________
                    |__Data__|__next_|
                                  \
                             ______\__________
                            |__Data__|__next_|
                                          \
                                     ______\__________
                                    |__Data__|__next_|
                                                  \
                                             ______\__________
                                            |__Data__|__next_|




*/

import java.util.Scanner;


// ---------------------- Creating a Node
class MyStackNode 
{
    int data;
    MyStackNode next;

    MyStackNode(int data) 
    {
        this.data = data;
        this.next = null;
    }
}

// ------------------------------- Stack class with push, pop, peek operations 
class StackClass 
{
    MyStackNode head = null;

    // function for push operation 
    void pushElement(int data) 
    {
        MyStackNode newNode = new MyStackNode(data);
        
        if(head == null)
        {
            head = newNode;
        }
        else 
        {
            newNode.next = head; 
            head = newNode;
        }

        System.out.println("\n-> push element : " + head.data);

    }

    // function for pop operation 
    void popElement() 
    {
        if(head == null)
            System.out.println("\n-> Stack is empty...");
        else 
        {
            System.out.println("\n-> pop element : " + head.data);
            head = head.next;
        }
    }

    // function for peek operation 
    void peekElement() 
    {
        if(head == null)
            System.out.println("\n-> Stack is empty...");
        else 
            System.out.println("\n-> Peek element : " + head.data);
    }

    // function for display operation 
    void display()
    {
        if(head == null)
            System.out.println("\nStack is empty...");
        else 
        {
            MyStackNode tem = head;
            System.out.println();
            while(tem != null)
            {
                System.out.println("|\t" + tem.data + "\t|");
                System.out.println("==================");
                tem = tem.next;
            }
        }
    }

}

public class p1_LinkedStack 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StackClass stack = new StackClass();
        int choice, data;

        try 
        {
            while (true) 
            {

                System.out.print("\n(1) Push \n(2) Pop \n(3) Peek \n(4) Display Stack \n(5) Quit \n\n====> Enter your operation : ");
                choice = sc.nextInt();

                switch (choice) 
                {
                    case 1:
                        System.out.print("Enter your data : ");
                        data = sc.nextInt();
                        stack.pushElement(data);
                        break;

                    case 2:
                        stack.popElement();
                        break;

                    case 3:
                        stack.peekElement();
                        break;

                    case 4:
                        stack.display();
                        break;

                    case 5:
                    System.out.println("\n-> Closing stack....");
                    return;
                    
                    default:
                        System.out.println("\n!! Invalid choice !!");
                        break;

                }
            }
        } 
        catch (Exception e) 
        {
            System.out.println("\n!! Invalid input, please enter a valid number !!");
        } 
        finally 
        {
            sc.close();
        }

    }
}
