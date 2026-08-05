/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------------- Bitwise Operator -----------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) &  - Bitwise AND
(2) |  - Bitwise OR 
(3) ^  - Bitwise XOR
(4) ~  - Bitwise Not
(5) << - Left shift
(6) >> - Right shift
(7) >>> - Unsigned right shift



   __________________________________________________________________
  |     x     |     y     ||    x & y    |    x | y    |    x ^ y    |
  |===========|===========||=============|=============|=============|
  |     0     |     0     ||     0       |      0      |      0      |
  |-----------|-----------||-------------|-------------|-------------|
  |     0     |     1     ||     0       |      1      |      1      | 
  |-----------|-----------||-------------|-------------|-------------|
  |     1     |     0     ||     0       |      0      |      1      |
  |-----------|-----------||-------------|-------------|-------------|
  |     1     |     1     ||     1       |      1      |      0      |
  |___________|___________||_____________|_____________|_____________|


*/
 
import java.util.Scanner;

class BitwiseOperations 
{
    int a, b;
    Scanner sc = new Scanner(System.in);

    public BitwiseOperations()
    {
        System.out.print("\nEnter first number :  ");
        this.a = sc.nextInt();

        System.out.print("Enter second number :  ");
        this.b = sc.nextInt();
    }

    public void display() 
    {
        
        // Bitwise AND (&)
        System.out.println("\n~~~~~~~~~ Bitwise AND(&) Operation ~~~~~~~~~\n");
        int Result = a & b; // 0101 & 0011 = 0001
        RepresentBinary(a, b, Result);
        
        
        // Bitwise OR (|)
        System.out.println("\n~~~~~~~~~ Bitwise OR(|) Operation ~~~~~~~~~\n");
        int orResult = a | b; // 0101 | 0011 = 0111
        RepresentBinary(a, b, orResult);
        
        // Bitwise XOR (^)
        System.out.println("\n~~~~~~~~~ Bitwise XOR(^) Operation ~~~~~~~~~\n");
        int xorResult = a ^ b; // 0101 ^ 0011 = 0110
        RepresentBinary(a, b, xorResult);
        
        // Bitwise NOT (~)
        System.out.println("\n~~~~~~~~~ Bitwise NOT(~) Operation ~~~~~~~~~\n");
        int notResult = ~a; // ~0101 = 1010 (in 32-bit representation, it's all bits inverted)
        RepresentBinary(a, notResult);
        
        // Left Shift (<<)
        System.out.println("\n~~~~~~~~~ Bitwise Left Shift(<<) Operation ~~~~~~~~~\n");
        int leftShiftResult = a << 1; // 0101 << 1 = 1010 (equivalent to multiplying by 2)
        RepresentBinary(a, b, leftShiftResult);
        
        // Right Shift (>>)
        System.out.println("\n~~~~~~~~~ Bitwise Right Shift(<<) Operation ~~~~~~~~~\n");
        int rightShiftResult = a >> 1; // 0101 >> 1 = 0010 (equivalent to dividing by 2)
        RepresentBinary(a, b, rightShiftResult);
        
        // Unsigned Right Shift (>>>)
        System.out.println("\n~~~~~~~~~ Bitwise Unsigned Right Shift(<<) Operation ~~~~~~~~~\n");
        int unsignedRightShiftResult = -a >>> 1; // Shifts right with zero fill
        RepresentBinary(a, b, unsignedRightShiftResult);

    }

    private static void RepresentBinary(int ...arr)
    {
        int count = 0;
        int maxlength = 0;

        for(int num : arr)
        {
            int length = Integer.toBinaryString(num).length();

            if(length >= maxlength)
                maxlength = length; 
            System.out.println("Maxlength : " + maxlength);
        }

        for(int num : arr)           // 5  7
        {
            count++;
            String s = Integer.toBinaryString(num);

            if(count == arr.length)
            {
                for(int i=1 ; i<= maxlength ; i++)
                    System.out.print("====");
                    System.out.println();
            }

            
            for(int i = 1 ; i <= maxlength-s.length() ; i++)
                System.out.print("0  ");
            
            for(char c : s.toCharArray())
                System.out.print(c + "  ");
            
            System.out.print("  -------------> " + num + "\n");
        }
    }
}



public class p3_Bitwise
{
    public static void main(String[] args) 
    {
        BitwiseOperations obj = new BitwiseOperations();
        obj.display();
    }
}