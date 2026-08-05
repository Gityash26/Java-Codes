/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== LinkedList Data Structure ==================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      
           __________________        __________________        __________________
   head-> |__Data__|__next__|-----> |__Data__|__next__|-----> |__Data__|__next__| <-tail

        
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
****** Why LinkedList *************
=====================================================

-> After learning about Arrays and ArrayList data structure we all now aware about how they 
   store the data in the memory.

-> LinkedList data structure resolve the limitations of the Arrays and ArrayList 
   in which 'Insertion' & 'Deletion' opertions are costly and shifting of elements required.

-> Also resolve the need of contiguous memory and dynamically resizing problem of ArrayList.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
****** What is LinkedList *************
=====================================================
-> Linked List data structure is a dynamic data structure where data stored in non-contiguous memeory 
   location.

-> It uses a "node structure" that contains two section, (1) Data (2) Address
   * Data section stores the data part 
   * Addrerss part stores the reference of the next node.

-> All the nodes are connected sequentially and a head pointer points a very first node.

-> Linked list support efficient insertion and deletion in the middle but not support Positional access.

-> Elements can be only accessed sequentially from starting or ending.


               __________________     __________________     __________________       
      head->  |__Data__|__Next__|--->|__Data__|__Next__|--->|__Data__|__Next__|---> null



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
****** LinkedList Operations *************
=====================================================
-> Add element at first
-> Add element at last
-> Add element atr specific index

-> Remove element from first
-> Remove element from last
-> Remove element from specific index

-> Iterate Elements
-> Search for an element








************************** Documentation **********************

|=========================|
| NewNode creating class  |   ------------> Creates multiple nodes(object) ----> [data, next]  [data, next]  [data, next]  
|=========================|


|=========================|
|   Linked List Class     |
|-------------------------|
|  static count           |
|  Node head              |
|  Node next              |  -------------->  perform opertion (Add data, Connect nodes, display)
|-------------------------|
|   addfirst()            |
|                         |
|   addlast()             |
|                         |
|   addAt()               |
|-------------------------|
|   removefirst()         |
|                         |
|   removelast()          |
|                         |
|   removeAt()            |
|-------------------------|
|   displayElement()      |
|                         |
|=========================|



|=========================|
|       Main Class        |
|-------------------------|   -----------------> Call LinkedList class
|   psvm(String args[])   |
|=========================|



*/
import java.util.Scanner;

// Node structure
class Node 
{
    static int count = -1;
    String data;
    Node next;

    Node(String data) 
    {
        this.data = data;
        this.next = null;
        count++;
    }
}

// Linked list class
class MyLinkedList {
    private Node head = null;
    private Node tail = null;

    // Adding at the first position
    void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        System.out.printf("-> Inserting %s at starting...", data);
        displayLinkedList();
    }

    // Adding at the last position
    void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        System.out.printf("-> Inserting %s at ending...", data);
        displayLinkedList();
    }

    // Adding at a specific index
    void addAt(String data) {
        if (head == null) {
            System.out.println("\n-> No existing node available...");
            addFirst(data);
        } 
        else 
        {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);

            System.out.printf("\n-> Available indexes are from [0] to [%d]\n", Node.count);
            System.out.print("\nEnter an index to insert data: ");
            int index = sc.nextInt();

            if (index >= 0 && index <= Node.count) {
                if (index == Node.count) {
                    addLast(data);
                } else {
                    Node newNode = new Node(data);
                    Node temp = head;
                    for (int i = 0; i < index; i++) {
                        temp = temp.next;
                    }
                    newNode.next = temp.next;
                    temp.next = newNode;
                    System.out.printf("Inserting %s after index [%d]...", data, index);
                }
                displayLinkedList();
            } else {
                System.out.println("-> Invalid index entered!");
                addAt(data);
            }
        }
    }

    // Remove the first node
    void removeFirst() {
        if (head != null) {
            System.out.println("\n-> Deleting first node " + head.data);
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
            Node.count--;
            displayLinkedList();
        } else {
            System.out.println("\n-> Linked List has no elements...");
        }
    }

    // Remove the last node
    void removeLast() {
        if (tail != null) {
            System.out.println("\n-> Deleting last node " + tail.data);
            if (head == tail) {
                head = tail = null;
            } else {
                Node temp = head;
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
            Node.count--;
            displayLinkedList();
        } else {
            System.out.println("\n-> Linked List has no elements...");
        }
    }

    // Remove a node at a specific index
    void removeAt() {
        if (head == null) {
            System.out.println("\n-> Linked List has no elements...");
            return;
        }

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("\nSelect a node index to remove (0 to " + Node.count + "): ");
        int index = sc.nextInt();

        if (index < 0 || index > Node.count) {
            System.out.println("\n-> Invalid index! Please select within range...");
            return;
        }

        if (index == 0) {
            removeFirst();
        } else if (index == Node.count) {
            removeLast();
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node toDelete = temp.next;
            temp.next = toDelete.next;
            System.out.println("\n-> Deleting node at index " + index + ": " + toDelete.data);
            Node.count--;
            displayLinkedList();
        }
    }

    // Display the linked list
    void displayLinkedList() 
    {
        if (head == null) 
        {
            System.out.println("\n-> LinkedList contains no elements...");
        } 
        else 
        {
            Node temp = head;
            System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("========== Elements of Linked List ===========");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            while (temp != null) {
                System.out.print("|" + temp.data + "|---> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
}

public class p1_SinglyLinkedList 
{
    public static void main(String[] args) 
    {
        int choice;
        String data;
        Scanner sc = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();

        while (true) 
        {
            System.out.print("\n\nChoose an operation: \n(1) Insert at first \n(2) Insert at end \n(3) Insert in middle \n(4) Remove from front \n(5) Remove from end \n(6) Remove from middle \n(7) Display \n(8) Exit \n-> ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {

                case 1:
                case 2:
                case 3:
                    System.out.print("\nEnter a string to insert: ");
                    data = sc.nextLine();

                    if(choice == 1)
                        list.addFirst(data);

                    else if (choice == 2) 
                        list.addLast(data);

                    else 
                        list.addAt(data);

                    break;

                case 4:
                    list.removeFirst();
                    break;
                
                case 5: 
                    list.removeLast();
                    break;

                case 6: 
                    list.removeAt();
                    break;

                case 7: 
                    list.displayLinkedList();
                    break;

                case 8: 
                    System.out.println("\nExiting program...");
                    sc.close();
                    break;

                default:
                    System.out.println("\nInvalid choice! Please try again.");
                    break;
            }
        }
    }
}
