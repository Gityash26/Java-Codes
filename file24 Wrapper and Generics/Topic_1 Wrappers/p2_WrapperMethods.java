/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Wrapper Class Methods ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Wrapper Classes provide many predefined methods to perform various
   operations on primitive values.

-> These methods are useful for:

   1. Type Conversion
   2. Parsing
   3. Comparison
   4. Mathematical Operations
   5. Character Checking

-> Most Wrapper Class methods are static methods.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Integer Class Methods ==============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

------------------------------------------------------------------------------
1. parseInt(String str)
------------------------------------------------------------------------------

-> Converts a String into primitive int.

Example:

    String str = "100";

    int num = Integer.parseInt(str);

------------------------------------------------------------------------------
2. valueOf(String str)
------------------------------------------------------------------------------

-> Converts a String into an Integer object.

Example:

    Integer obj = Integer.valueOf("250");

------------------------------------------------------------------------------
3. toString(int value)
------------------------------------------------------------------------------

-> Converts primitive int into String.

Example:

    String str = Integer.toString(500);

------------------------------------------------------------------------------
4. max(int a, int b)
------------------------------------------------------------------------------

-> Returns the larger of two numbers.

------------------------------------------------------------------------------
5. min(int a, int b)
------------------------------------------------------------------------------

-> Returns the smaller of two numbers.

------------------------------------------------------------------------------
6. sum(int a, int b)
------------------------------------------------------------------------------

-> Returns the sum of two integers.

------------------------------------------------------------------------------
7. compare(int a, int b)
------------------------------------------------------------------------------

-> Compares two integer values.

Returns:

    0   -> if both are equal

    >0  -> if first number is greater

    <0  -> if first number is smaller

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Double Class Methods ===============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

------------------------------------------------------------------------------
1. parseDouble(String str)
------------------------------------------------------------------------------

-> Converts String into primitive double.

------------------------------------------------------------------------------
2. valueOf(String str)
------------------------------------------------------------------------------

-> Converts String into Double object.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Boolean Class Methods ===============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

------------------------------------------------------------------------------
1. parseBoolean(String str)
------------------------------------------------------------------------------

-> Converts String into primitive boolean.

Example:

    Boolean.parseBoolean("true");

    Boolean.parseBoolean("false");

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Character Class Methods ==============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

------------------------------------------------------------------------------
1. isDigit(char ch)
------------------------------------------------------------------------------

-> Returns true if character is a digit.

------------------------------------------------------------------------------
2. isLetter(char ch)
------------------------------------------------------------------------------

-> Returns true if character is an alphabet.

------------------------------------------------------------------------------
3. isUpperCase(char ch)
------------------------------------------------------------------------------

-> Returns true if character is uppercase.

------------------------------------------------------------------------------
4. isLowerCase(char ch)
------------------------------------------------------------------------------

-> Returns true if character is lowercase.

------------------------------------------------------------------------------
5. toUpperCase(char ch)
------------------------------------------------------------------------------

-> Converts character into uppercase.

------------------------------------------------------------------------------
6. toLowerCase(char ch)
------------------------------------------------------------------------------

-> Converts character into lowercase.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Important Notes =================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

✔ parseXXX() methods return primitive values.

✔ valueOf() methods return Wrapper Objects.

✔ Character class provides many utility methods for character validation.

✔ Most Wrapper methods are static, therefore they can be called using the
  class name.

Example:

    Integer.parseInt("100");

instead of

    obj.parseInt("100");

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

public class p2_WrapperMethods {

    public static void main(String[] args) {

        // ==========================================================
        // Integer Methods
        // ==========================================================

        System.out.println("============== Integer Methods ==============");

        int number = Integer.parseInt("100");
        System.out.println("parseInt() : " + number);

        Integer integerObject = Integer.valueOf("250");
        System.out.println("valueOf() : " + integerObject);

        String str = Integer.toString(500);
        System.out.println("toString() : " + str);

        System.out.println("max() : " + Integer.max(40, 90));

        System.out.println("min() : " + Integer.min(40, 90));

        System.out.println("sum() : " + Integer.sum(40, 90));

        System.out.println("compare(20,10) : " + Integer.compare(20, 10));

        // ==========================================================
        // Double Methods
        // ==========================================================

        System.out.println("\n============== Double Methods ==============");

        double decimal = Double.parseDouble("56.75");
        System.out.println("parseDouble() : " + decimal);

        Double doubleObject = Double.valueOf("99.99");
        System.out.println("valueOf() : " + doubleObject);

        // ==========================================================
        // Boolean Methods
        // ==========================================================

        System.out.println("\n============== Boolean Methods ==============");

        boolean flag = Boolean.parseBoolean("true");

        System.out.println("parseBoolean() : " + flag);

        // ==========================================================
        // Character Methods
        // ==========================================================

        System.out.println("\n============== Character Methods ==============");

        char ch = 'A';

        System.out.println("isDigit('A') : " + Character.isDigit(ch));

        System.out.println("isLetter('A') : " + Character.isLetter(ch));

        System.out.println("isUpperCase('A') : " + Character.isUpperCase(ch));

        System.out.println("isLowerCase('A') : " + Character.isLowerCase(ch));

        System.out.println("toLowerCase('A') : " + Character.toLowerCase(ch));

        System.out.println("toUpperCase('a') : " + Character.toUpperCase('a'));
    }
}