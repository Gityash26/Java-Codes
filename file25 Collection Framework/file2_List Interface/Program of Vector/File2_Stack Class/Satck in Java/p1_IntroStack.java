/*
=======================================================================================================================
| Feature                   | Array                  | ArrayList                        | LinkedList                  |
|---------------------------|------------------------|----------------------------------|-----------------------------|
| Size                      | Fixed                  | Dynamic                          | Dynamic                     |
| Access Time               | O(1)                   | O(1)                             | O(n)                        |
| Insertion/Removal Time    | O(n) (manual resize)   | O(1) (end)/O(n) (middle, resize) | O(1) (given reference)      |
| Memory Usage              | Low (contiguous)       | Medium                           | High (extra pointers)       |
| Cache Performance         | High                   | Medium                           | Low                         |
| Implementation Overhead   | Low                    | Medium                           | High                        |
=======================================================================================================================

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================ Satck in java collection framework =======
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> So, we already aware about what is a 'Stack' data structure and how to implement it using "ArrayList" & "Linkedlist"

-> Basically Stack is a 'linear data structure' that store the data elements one above the other and allows Push(Insertion)
   and Pop(Deletion) operation in LIFO manner.
   
-> Stack can be implemented using Arrays, ArrayList, & LinkedList but 'Java Collection framework' provide a dedicated Stack class
   (subclass of Vector) to provide functionality of Stack data Structure..



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========== Key Points of Stack class in Java =============
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. LIFO Principle : Elements are added or removed from the top of the stack.
2. Inheritance: Stack class extends the Vector class and its methods.
3. Thread-safe: Stack class is synchronized and thread-safe.
4. Dynamic resizing: Stack dynamically resize itself when the stack is full.
5. Null elements: Stack allows null elements.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------------------- Constructors -----------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Stack(): Creates an empty stack with default initial capacity of 10.

*/

// Implementation of Stack class constructors 


import java.util.Stack;

public class p1_IntroStack 
{
    public static void main(String[] args) 
    {
        // Creating an empty Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Displaying the stack
        System.out.println("Stack : " + stack);
    }
}
