/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Doubly Linked List ========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> As per the name suggest 'doubly linked list' it provides a two way connection 
   between nodes.

-> Doubly linked list node contains of three sections [previous], [Data], [next] in which 
   a previous section stores the reference to the previous node and next section stores the reference 
   to the next node, and the data part stores the data.

    _________________________           _________________________           _________________________
   |_previous_|_Data_|_next_| <------> |_previous_|_Data_|_next_| <------> |_previous_|_Data_|_next_|
           head                                                                 tail

           


------ key points ------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=> Each node have reference to the both previous and next node in the list.
=> Support iteration in both the forward and backward direction. 

*/

import java.util.Scanner;

class MyNode
{
    String data; 
    MyNode previous;
    MyNode next;
    static int count = -1;

    MyNode(String data)
    {
        this.data = data;
        previous = next = null;
        count ++;
    }
}


class DoublyLinkedList
{
    private MyNode head = null;
    private MyNode tail = null;

    // -------------------------------------- Adding at starting  ---------------------
    void addFirst(String data)
    {
        MyNode newNode = new MyNode(data);
        System.out.println("-> Inserting " + data + " at starting...");
        
        if(head == null)
        {
            head = tail = newNode;
        }
        else 
        {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        displayIteration(1);
    }
    
    // -------------------------------------- Adding at last  ---------------------
    void addLast(String data)
    {
        MyNode newNode = new MyNode(data);
        System.out.println("-> Inserting " + data + " at ending...");

        if(tail == null)
        {
            head = tail = newNode;
        }
        else 
        {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        displayIteration(1);
    }

    // -------------------------------------- Adding at specific index  ---------------------
    void addAt(String data)
    {
        if(head == null) //  True --> empty list
        {
            System.out.println("-> No existing node available...");
            addFirst(data);
        }

        else if(head == tail)  // True --> single node 
        {
            System.out.println("-> Only single node available...");
            addLast(data);
        }

        else
        {
            // creating scanmner class object 
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);

            System.out.printf("\n-> Available nodes indexes are from [0] to [%d]", MyNode.count);
            System.out.print("\n-> Enter a index to insert after : ");
            int index = sc.nextInt();

            if(index>=0 && index<=MyNode.count)
            {
                if(index == MyNode.count) // True-> [index-0]--> [index-1]--> null
                {
                    addLast(data);
                }
                else 
                {
                    MyNode newNode = new MyNode(data);
                    MyNode tem = head;
                    
                    for(int i=0 ; i<index ; i++)
                    {
                        tem = tem.next;
                    }
                    newNode.previous = tem;     // [tem] <---[newNode]
                    newNode.next = tem.next;   // [newNode]--> [MyNode]
                    tem.next = tem.next.previous = newNode; // [tem_Next]---> [neNode] <---[Node_previouis]
                    
                    System.out.printf("-> Inserting %s after index [%d]...\n", data, index);
                    displayIteration(1);
                }
            }
            else 
            {
                System.out.println("-> Invalid index entered!");
                addAt(data);
            }
        }
    }

    // -------------------------------------- Remove from first  ---------------------
    void removeFist()
    {
        if(head == null)
        {
            System.out.println("\n-> LinkedList have no elements to remove...");
            return;
        }
        System.out.println("\n-> Removing first node : " + head.data);

        if(head == tail)
        {
            head = tail = null;
        }
        else 
        {
            head = head.next;
            head.previous = null;
        }
        MyNode.count--;
        displayIteration(1);
    }


    // -------------------------------------- Remove from last  ---------------------
    void removeLast()
    {
        if(tail == null)
        {
            System.out.println("\n-> LinkedList have no elements to remove...");
            return;
        }
        System.out.println("\n-> Removing last node : " + tail.data);

        if(head == tail)
        {
            head = tail = null;
        }
        else 
        {
            tail = tail.previous;
            tail.next = null;
        }
        MyNode.count--;
        displayIteration(1);
    }

    // -------------------------------------- Remove from middle  ---------------------
    void removeAt()
    {
        // empty linked list check 
        if(head == null)
        {
            System.out.println("\n-> LinkedList have no elements to remove...");
            return;
        }
        
        // single node checking 
        else if(head == tail)
        {
            System.out.println("\n-> Only single node is available...");
            removeFist();
        }
        
        else
        {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
        
            System.out.print("\n-> Available node indexes to remove from 0 to " + MyNode.count + " : ");
            int index = sc.nextInt();

            if(index>=0 && index<=MyNode.count)
            {
                if(index == MyNode.count)
                    removeLast();
                else 
                {
                    MyNode tem;
                    // Near to head node
                    if(index <= MyNode.count/2)
                    {
                        tem = head;
                        for(int i=0 ; i<index ; i++)
                            tem = tem.next;
                    }
                    // near to tail node 
                    else 
                    {
                        tem = tail;
                        for(int i=MyNode.count ; i>index ; i--)
                            tem = tem.previous;
                    }

                    // Now tem present at index node 
                    System.out.printf("-> Removing MyNode %s at index [%d]...\n", tem.data, index);

                    tem.previous.next = tem.next;
                    tem.next.previous = tem.previous;
                    tem = null;
                    MyNode.count--;
                    displayIteration(1);
                }
            }
            else 
            {
                System.out.println("-> Invalid index entered!");
                removeAt();
            }
        }

    }



    // -------------------------------------- Iteration  ---------------------
    void displayIteration(int choice)
    {
        if(head == null)
        {
            System.out.println("\nLinkedList contain no elements...");
            return;
        }

        if(choice == 1)
        {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("---------- forward iteration -----------");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            MyNode tem = head;
            while(tem != null)
            {
                System.out.print(tem.data + "--> ");
                tem = tem.next;
            }
            System.out.print("TailNode(null)\n");
        }
        else
        {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("---------- backward iteration -----------");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            MyNode tem = tail;
            while(tem != null)
            {
                System.out.print(tem.data + "--> ");
                tem = tem.previous;
            }
            System.out.print("HeadNode(null)\n");
        }
    }


    void startDoublyLikedList()
    {
        int choice;
        String data;
        Scanner sc = new Scanner(System.in);

        try 
        {
            while(true)
            {
                System.out.println("\nEnter operation to perform : ");
                System.out.println("\tPress(1) : Insertion at front");
                System.out.println("\tPress(2) : Insertion at end");
                System.out.println("\tPress(3) : Insertion at middle");
                System.out.println("\tPress(4) : Remove from front");
                System.out.println("\tPress(5) : Remove from end");
                System.out.println("\tPress(6) : Remove from middle");
                System.out.println("\tPress(7) : Iterate in forward direction");
                System.out.println("\tPress(8) : Iterate in reverse direction");
                System.out.println("\tPress(9) : Closing... ");
                System.out.print("\n\tEnter your operation-----> ");
                
                choice = sc.nextInt();

                switch(choice)
                {
                    case 1:
                    case 2:
                    case 3:
                        System.out.print("\nEnter a string data to insert: ");
                        sc.nextLine();
                        data = sc.nextLine();

                        if(choice == 1)
                            addFirst(data);

                        else if (choice == 2) 
                            addLast(data);

                        else 
                            addAt(data);

                        break;

                    case 4:
                        removeFist();
                        break;
                
                    case 5: 
                        removeLast();
                        break;

                    case 6: 
                        removeAt();
                        break;

                    case 7: 
                        displayIteration(1);
                        break;
                        
                    case 8: 
                        displayIteration(2);
                        break;

                    case 9: 
                        System.out.println("\nClosing Doubly LinkedList...");
                        sc.close();
                        return;

                    default:
                        System.out.println("\nInvalid choice! Please try again.");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("\n!! Invalid Input Entered !!\n");
            startDoublyLikedList();
        }
    }        
}



public class p2_DoublyLinked 
{
    public static void main(String[] args) 
    {
        DoublyLinkedList list = new DoublyLinkedList();
        list.startDoublyLikedList();
    }    
}
