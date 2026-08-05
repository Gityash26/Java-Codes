/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~
Problem : Push element at the bottom of the stack
~~~~~~~~~~~~~~~~~~~~~~~~~~~ 



Normal Appracoh:
============================================
    Step 1: Create a new Stack
    Step 2: Pop all the elements from the original stack and push them into the new stack
    Step 3: Push the new element into the original stack
    Step 4: Pop all the elements from the new stack and push them into the original stack
    

Recursion Approach:
============================================
    Step 1: Base Case: If the stack is empty, push the new element into the stack
    Step 2: Recursively pop all the elements from the stack and store them in the function call stack
    Step 3: Push the new element into the stack
    Step 4: Recursively push all the elements stored in the function call stack into the stack

*/



import java.util.Stack;


class StackClass
{
    Stack<String> stack = new Stack<>();

    void push(String data)
    {
        stack.push(data);
    }

    void pushBottom(String data)
    {
        // if stack is empty then push the data
        if(stack.isEmpty())
        {
            stack.push(data);
        }

        // else store all the elements in the function call stack
        String temp = stack.pop();
        pushBottom(data);
        push(temp);
    }

    void display()
    {
        System.out.println("Stack : " + stack);
    }
}

public class p3_RecusreStack 
{
    public static void main(String[] args) 
    {
        StackClass sc = new StackClass();
        sc.push("10");
        sc.push("30");
        sc.push("40");
        sc.display();
        
        sc.pushBottom("Yash");
        sc.display();
    }    
}
