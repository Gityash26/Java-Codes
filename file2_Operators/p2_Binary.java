/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------- Binary Operator -------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Binary Operators are operates on a Two variable.

ex: 
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    -> Arithmetic Operators (+ , - , * , / , %)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    -> Assignment Operators (= , += , -= , *= , /= , %=)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    -> Relational Operators (< , <= , > , >= , == , !=)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    -> Logical Operators (&& , || , !)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    -> Bitwise Operators (& , | , ^ , ~)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    -> shift Operators (<< , >> , >>>)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         
*/

class Bin_Operator 
{
    public void Arithmetic(int a, int b) 
    {
        System.out.println("\n\nImplementation of Arithmetic Opertors : (+ , - , * , / , %)");

        System.out.println("\n => Addition operator : " + (a + b));
        System.out.println("\n => Subtraction operator : " + (a - b));
        System.out.println("\n => Multiplication operator : " + (a * b));
        System.out.println("\n => Division operator : " + (a / b));
        System.out.println("\n => Modulus operator : " + (a % b));
    }

    public void Assignment() 
    {
        System.out.println("\n\nImplementation of Assignment Opertors : (= , += , -= , *= , /= , %=)");

        int a = 22;
        System.out.println("\n=> Assignment operator (=) : " + a);

        a += 3;
        System.out.println("\n=>  Assignment operator (+=) : " + a);

        a -= 4;
        System.out.println("\n=> Assignment operator (-=) : " + a);

        a *= 5;
        System.out.println("\n=> Assignment operator (*=) : " + a);

        a /= 4;
        System.out.println("\n=> Assignment operator (/=) : " + a);

        a %= 4;
        System.out.println("\n=> Assignment operator (%=) : " + a);
    }

    void Relational(int a, int b) 
    {
        System.out.println("\n\nImplementation of Relational Opertors : (< , <= , > , >= , == , !=)");

        boolean c = a < b;
        System.out.println("\n=> Less than operator (<) : " + c);

        c = a <= b;
        System.out.println("\n=> Less than or equal to operator (<=) : " + c);

        c = a > b;
        System.out.println("\n=> Greater than operator (>) : " + c);

        c = a >= b;
        System.out.println("\n=> Greater than or equal to operator (>=) : " + c);

        c = a == b;
        System.out.println("\n=> Equal to operator (==) : " + c);

        c = a != b;
        System.out.println("\n=> Not equal to operator (!=) : " + c);
    }

    void Logical(int a, int b) 
    {
        System.out.println("\n\nImplementation of Logical Opertors : (&& , || , !)");

        System.out.println("\n=> Logical AND operator (&&) : " + (a < b && a == 9)); // False
        System.out.println("\n=> Logical OR operator (||) : " + (a < b || a == 9)); // True
        System.out.println("\n=> Logical NOT operator (!) : " + !false); // True
    }

    void Bitwise(int a, int b) 
    {
        System.out.println("\n\nImplementation of Bitwise Opertors : (& , | , ^ , ~)");

        int result = a & b;
        System.out.println("\n=> Bitwise AND operator (&) : ");
        System.out.printf("(%d) & (%d) = %d \n", a, b, result);
        System.out.printf("(%s) & (%s) = %s \n", Integer.toBinaryString(a), Integer.toBinaryString(b), Integer.toBinaryString(result));
        
        int result2 = a | b;
        System.out.println("\n=> Bitwise OR operator (|) : ");
        System.out.printf("(%d) | (%d) = %d \n", a, b, result2);
        System.out.printf("(%s) | (%s) = %s \n", Integer.toBinaryString(a), Integer.toBinaryString(b), Integer.toBinaryString(result2));
        
        int result3 = a ^ b;
        System.out.println("\n=> Bitwise XOR operator (^) : ");
        System.out.printf("(%d) ^ (%d) = %d \n", a, b, result3);
        System.out.printf("(%s) ^ (%s) = %s \n", Integer.toBinaryString(a), Integer.toBinaryString(b), Integer.toBinaryString(result3));

        int result4 = ~a;
        System.out.println("\n=> Bitwise NOT operator (!) : ");
        System.out.printf("~(%d) = %d \n", a, result4);
        System.out.printf("~(%s) = %s \n", Integer.toBinaryString(a), Integer.toBinaryString(result4));
    }

    void Shift(int a, int b) 
    {
        System.out.println("\n\nImplementation of Shift Operators : (<< , >> , >>>)");

        int c = a << b;
        System.out.println("\n=> Left shift operator (<<) : " + c);

        int d = a >> b;
        System.out.println("\n=> Right shift operator (>>) : " + d);

        int e = a >>> b;
        System.out.println("\n=> Unsigned right shift operator (>>>) : " + e);
    }
}

public class p2_Binary 
{
   public static void main(String[] args) 
   {
        // ----------------------------------------------- creating object 
        Bin_Operator obj = new Bin_Operator();
        
        // ----------------------------------------------- creating variable 
        int x = 10, y = 24;
        
        // ----------------------------------------------- calling methods 
        obj.Arithmetic(x, y);
        obj.Assignment();
        obj.Relational(x, y);
        obj.Logical(x, y);
        obj.Bitwise(x, y);
        obj.Shift(x, y);
    }
}
