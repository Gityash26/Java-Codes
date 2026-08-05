/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----- Circular Linked List ---------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

          ______________        ______________        ______________         
    /--->|_Data_|_next_|-----> |_Data_|_next_|-----> |_Data_|_next_|-----\    
   |          head                                          tail          \
   |_______________________________________________________________________\


-> Circular linked list also similar to normal linkedlist but only difference is that last node 
   of a circular linkedlist points to the head node instead of null.

-> It provides a circular traversal 


                                Types of Circular Linkedlist
                    _________________________|_______________________________
                   |                                                        |
                Singly circular                                     Doubly circular
                linkedlist                                          linkedlist






~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----- (1) Circular Singly Linked List ----------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

              
             ______________      ______________      ______________      ______________
     /----->|_Data_|_next_|---> |_Data_|_next_|---> |_Data_|_next_|---> |_Data_|_next_|----\
    |             head                                                       tail           \
    \_______________________________________________________________________________________|




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----- (2) Circular Doubly Linked List ----------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

              
             ____________________        ____________________        ____________________        ____________________
     /=====>|_pre_|_Data_|_next_| <===> |_pre_|_Data_|_next_| <===> |_pre_|_Data_|_next_| <===> |_pre_|_Data_|_next_|<===\
    |             head                                                                                      tail          \
    \=====================================================================================================================|


    
\





*/

class Node {
    String data;
    Node next, previous;

    Node(String data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

class CircularDoubly {
    // Start and end pointers
    Node head = null, tail = null, newNode = null;

    void addFirst(String data) {
        newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            head.next = head.previous = head;
            System.out.println("\n-> No existing node (Adding element at first...)");
        } else {
            // making newNode as new head
            newNode.next = head;
            head.previous = newNode;
            head = newNode;

            // updating tail next to new head address
            head.previous = tail;
            tail.next = head;
            System.out.println("\n-> Adding element at first...");
        }
    }

    void addLast(String data) {
        newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            head.next = head.previous = head;
            System.out.println("\n-> No existing node (Adding element at last...)");
        } else {
            // making newNode as tail
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;

            // update tail next address
            tail.next = head;
            head.previous = tail;
            System.out.println("\n-> Adding element at last...");
        }
    }

    void removeFirst() {
        if (head == null) {
            System.out.println("\n-> Sorry!! Circular linked list is empty...");
        } else {
            if (head == tail) {
                System.out.printf("\n-> Single node available (Removing first node: %s)\n", head.data);
                head = tail = null;
            } else {
                Node temp = head;
                System.out.printf("\n-> Removing first node: %s\n", head.data);
                head = head.next;
                head.previous = tail;
                tail.next = head;

                // Clear pointers of the removed node
                temp.next = temp.previous = null;
            }
        }
    }

    void removeLast() {
        if (head == null) {
            System.out.println("\n-> Sorry!! Circular linked list is empty...");
        } else {
            if (head == tail) {
                System.out.printf("\n-> Single node available (Removing last node: %s)\n", tail.data);
                head = tail = null;
            } else {
                Node temp = tail;
                System.out.printf("\n-> Removing last node: %s\n", tail.data);
                tail = tail.previous;
                tail.next = head;
                head.previous = tail; 
                
                // Clear pointers of the removed node 
                temp.next = temp.previous = null;
            }
        }

    }

    void display() {
        if (head == null) {
            System.out.println("\n-> Circular linked list is empty...");
        } else {
            Node tem = head;
            System.out.print("\nCircular Linked List: ");
            do {
                System.out.print(tem.data + " ");
                tem = tem.next;
            } while (tem != head);
            System.out.println();
        }
    }
}

public class p3_CircularLinkedList {
    public static void main(String[] args) {
        CircularDoubly list = new CircularDoubly();

        // Adding elements
        list.addFirst("Apple");
        list.addLast("Banana");
        list.addLast("Orange");
        list.addFirst("Grapes");

        // Display the list
        list.display();

        // Remove elements
        list.removeFirst();
        list.removeLast();

        // Display the list again
        list.display();
    }
}
