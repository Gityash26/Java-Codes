/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~--------------- static Method -----------------~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> If we create a method static it means we don,t require any object to call that method.
   In Simple word we can say that it act as an normal function Instead of a method of a class.
*/




public class staticMethod {

    // Static method to calculate the square of a number
    public static int square(int num) {
        return num * num;
    }
    
    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    // Main method
    public static void main(String[] args) {
        int num = 5;

        System.out.println("Square of " + num + " is: " + square(num));
        System.out.println("Factorial of " + num + " is: " + factorial(num));
    }
}
