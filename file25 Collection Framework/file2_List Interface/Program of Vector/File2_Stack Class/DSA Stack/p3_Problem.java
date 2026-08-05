/* 
========================================
    Question: Reverse a Stack in java
========================================

*/


// =================== Using recursion ===================

// import java.util.Stack;
// import java.util.List;

// public class p3_Problem 
// {

//     static void pushAtBottom(Stack<Integer> stack, int data)
//     {
//         if(stack.isEmpty())
//             stack.push(data);
//         else 
//         {
//             int tem = stack.pop();
//             pushAtBottom(stack, data);
//             stack.push(tem);
//         }
//     }

//     static void reverseStack(Stack<Integer> stack)
//     {
//         if(stack.isEmpty())
//             return;

//         int data = stack.pop();
//         reverseStack(stack);
//         pushAtBottom(stack, data);
//     }


//     public static void main(String[] args) 
//     {
//         Stack<Integer> stack = new Stack<>();
//         stack.addAll(List.of(22, 33, 44, 55, 66, 77, 88, 99));        

//         System.out.println("\nBefore Reversing the stack : " + stack);

//         reverseStack(stack);

//         System.out.println("\nAfter Reversing the stack : " + stack);
//     }
// }


// ====================== using simple Loop ================= 

import java.util.Stack;
import java.util.List;

public class p3_Problem 
{
    static Stack<Integer> reverseStack(Stack<Integer> stack)
    {
        Stack<Integer> temStack = new Stack<>();
        while (!stack.isEmpty()) 
        {
            temStack.push(stack.pop());
        }

        return temStack;
    }

    public static void main(String[] args) 
    {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(List.of(22, 33, 44, 55, 66, 77, 88, 99));        

        System.out.println("\nBefore Reversing the stack : " + stack);

        stack = reverseStack(stack);

        System.out.println("\nAfter Reversing the stack : " + stack);
    }
}