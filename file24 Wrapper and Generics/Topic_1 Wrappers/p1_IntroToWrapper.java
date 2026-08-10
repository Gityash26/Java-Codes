/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Wrapper Class ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Wrapper Classes are predefined classes in Java that wrap primitive data types
   into objects.

-> In other words, Wrapper Classes allow primitive values to be treated as
   objects whenever required.

-> Every primitive data type has a corresponding Wrapper Class.

Example:

        Primitive Type        Wrapper Class
        -----------------------------------
             int       ----->    Integer
             char      ----->    Character
             double    ----->    Double

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Why Wrapper Class? ==================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Java is primarily an Object-Oriented Programming language.

-> However, Java provides primitive data types (int, char, float, etc.)
   for better performance.

-> Primitive data types are NOT objects.

-> Many Java APIs (such as Collection Framework and Generics) work only with
   objects.

-> Therefore, Java provides Wrapper Classes to convert primitive values into
   objects whenever needed.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Primitive vs Wrapper ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Primitive Data Types
--------------------
-> Store actual values.
-> Faster.
-> Less memory.
-> Cannot call methods.
-> Cannot be stored directly in Collections.

Wrapper Classes
---------------
-> Store primitive values as objects.
-> Slower than primitives.
-> Consume more memory.
-> Provide many useful built-in methods.
-> Can be stored inside Collections.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Eight Wrapper Classes ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    ===========================================================
       Primitive Type              Wrapper Class
    ===========================================================
          byte                ->       Byte
          short               ->       Short
          int                 ->       Integer
          long                ->       Long
          float               ->       Float
          double              ->       Double
          char                ->       Character
          boolean             ->       Boolean
    ===========================================================

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Importance of Wrapper Classes ==========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

----------------------------------------
1. Collection Framework
----------------------------------------

-> Java Collections (ArrayList, HashMap, HashSet, etc.) store only objects.

Example:

    ArrayList<Integer> list = new ArrayList<>();

Not Allowed:

    ArrayList<int> list;

----------------------------------------
2. Generics
----------------------------------------

-> Generics work only with reference types (objects).

Example:

    List<Integer>

Not

    List<int>

----------------------------------------
3. Utility Methods
----------------------------------------

-> Wrapper Classes provide useful methods.

Examples:

Integer.parseInt()

Integer.valueOf()

Integer.max()

Character.isDigit()

Boolean.parseBoolean()

----------------------------------------
4. Type Conversion
----------------------------------------

-> Convert primitive to String.

-> Convert String to primitive.

-> Convert primitive to Wrapper Object.

-> Convert Wrapper Object to primitive.

----------------------------------------
5. Null Values
----------------------------------------

-> Primitive variables cannot store null.

Example:

    int num = null;      // Not Allowed

-> Wrapper objects can store null.

Example:

    Integer num = null;  // Allowed

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Characteristics ========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Wrapper Classes are immutable.

2. They belong to java.lang package.

3. Every primitive type has one Wrapper Class.

4. Wrapper Classes support Autoboxing and Unboxing.

5. They provide many static utility methods.

6. They can participate in Generics and Collections.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Autoboxing & Unboxing ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

----------------------------------------
Autoboxing
----------------------------------------

-> Automatic conversion of primitive data type into Wrapper Object.

Example:

    int number = 10;

    Integer obj = number;

----------------------------------------
Unboxing
----------------------------------------

-> Automatic conversion of Wrapper Object into primitive data type.

Example:

    Integer obj = 50;

    int number = obj;

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Advantages ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Can be stored inside Collections.

2. Support Generics.

3. Provide useful utility methods.

4. Allow null values.

5. Easy type conversion.

6. Immutable and thread-safe.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Disadvantages =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Consume more memory than primitive types.

2. Slightly slower because objects are created.

3. Boxing and Unboxing introduce small performance overhead.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=================== Frequently Asked Interview Questions ======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. What is a Wrapper Class?

2. Why are Wrapper Classes required?

3. Difference between int and Integer?

4. What is Autoboxing?

5. What is Unboxing?

6. Why do Collections use Wrapper Classes?

7. Can Wrapper Objects store null?

8. Are Wrapper Classes immutable?   

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

public class p1_IntroToWrapper
{

    public static void main(String[] args) 
    {

        // ================= Integer Wrapper =================

        Byte byteObj = 10;
        Short shortObj = 100;
        Integer intObj = 1000;
        Long longObj = 100000L;

        // ================= Floating Wrapper =================

        Float floatObj = 25.75f;
        Double doubleObj = 99.999;

        // ================= Character Wrapper =================

        Character charObj = 'A';

        // ================= Boolean Wrapper =================

        Boolean boolObj = true;

        System.out.println("============== Integer Wrapper Classes ==============");

        System.out.println("Byte      : " + byteObj);
        System.out.println("Short     : " + shortObj);
        System.out.println("Integer   : " + intObj);
        System.out.println("Long      : " + longObj);

        System.out.println("\n============== Floating Wrapper Classes ==============");

        System.out.println("Float     : " + floatObj);
        System.out.println("Double    : " + doubleObj);

        System.out.println("\n============== Character Wrapper Class ==============");

        System.out.println("Character : " + charObj);

        System.out.println("\n============== Boolean Wrapper Class ==============");

        System.out.println("Boolean   : " + boolObj);

        System.out.println("\n============== Null Value Support ==============");

        Integer marks = null;

        System.out.println("Integer Object = " + marks);

        System.out.println("\nWrapper Classes successfully store primitive values as objects.");
    }
}