/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------------------- Stack Methods -----------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
1. push(Object o): It is used to insert an element onto the top of the stack.

2. pop(): Remove and retrun the top element of the stack. 
          It throws EmptyStackException if the stack is empty.
    
3. peek(): Returns the Top element of the stack without removing it. 
           It throws EmptyStackException if the stack is empty.
    
4. search(Object o): Search and return index of specific element in the stack.
                     Retruns the 1-based position of the element from the top of the stack.
                     Retruns -1 if the element is not found in the stack.
    
5. isEmpty(): Returns true if the stack is empty, otherwise false.
    
6. size(): It is used to return the number of elements in the stack.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Advantages of Stack Class:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Simple and intuitive interface for LIFO operations.
-> Built-in thread-safety due to inheritance from Vector.
-> Easy to use with generic support.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Disadvantages of stack class:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=> Performance: 
   Due to synchronization, it may be slower in single-threaded environments.

=> Outdated Design: 
   Modern alternatives like Deque and ArrayDeque are preferred for better performance and flexibility.

   
*/

import java.util.Stack;

public class p2_StackMethods 
{
    public static void main(String[] args) 
    {
        // Creating an empty Stack
        Stack<Integer> stack = new Stack<>();
        
        // Pushing elements into the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        // Displaying the stack
        System.out.println("Stack : " + stack);
        
        // Removing the top element
        stack.pop();
        
        // Displaying the stack after pop operation
        System.out.println("Stack after pop operation : " + stack);
        
        // Displaying the top element of the stack
        System.out.println("Top element of the stack : " + stack.peek());
        
        // Searching an element in the stack
        int position = stack.search(10);
        if(position != -1)
            System.out.println("Element found at position : " + position);
        else
            System.out.println("Element not found in the stack");
        
        // Checking whether the stack is empty or not
        if(stack.empty())
            System.out.println("Stack is empty");
        else
            System.out.println("Stack is not empty");
        
        // Displaying the number of elements in the stack
        System.out.println("Number of elements in the stack : " + stack.size());
    }    
}
