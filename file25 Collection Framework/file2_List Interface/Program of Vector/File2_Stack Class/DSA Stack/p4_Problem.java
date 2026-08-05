/* 
====================================================
 Question: Create a copy of a Stack in java
====================================================

*/

import java.util.Stack;

public class p4_Problem 
{

    static Stack<Integer> cloneStack(Stack<Integer> stack)
    {
        Stack<Integer> copyStack = new Stack<>();

        for(int val : stack)
        {
            copyStack.push(val);
        }

        return copyStack;
    }
    public static void main(String[] args) 
    {
        Stack<Integer> stack = new Stack<>();    
        
        // push elements in the satck 
        stack.push(10);
        stack.push(30);
        stack.push(50);
        stack.push(70);
        stack.push(90);

        Stack<Integer> copyStack = cloneStack(stack);

        System.out.println("Original Stack : " + stack);
        System.out.println("Copy Stack : " + copyStack);

    }    
}
