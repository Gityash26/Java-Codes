/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Generic Class ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> A Generic Class is a class that can work with different data types.

-> Instead of defining a fixed data type, a Generic Class uses a
   Type Parameter.

-> The actual data type is specified while creating the object.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Why Generic Class? ===============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we create a class that stores an Integer value.

        class Box
        {
            Integer value;
        }

It can store only Integer values.
If we want to store a String,
we need another class.

Again,

if we want to store Double,
we need another class.
This leads to code duplication.

Generics solve this problem by allowing one class to work with
multiple data types.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Generic Class Syntax ===============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

class ClassName<T>
{

}

Example

class Box<T>
{
    T value;
}

Here,

T represents the data type.

While creating an object,

T is replaced by the actual type.

Example

Box<Integer>

Box<String>

Box<Double>

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Type Parameter =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> T is called the Type Parameter.

It can represent any reference type.

Common Naming Convention

------------------------------------------------------
T   -> Type

E   -> Element

K   -> Key

V   -> Value

N   -> Number

R   -> Return Type
------------------------------------------------------

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Advantages ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Type Safety

2. Code Reusability

3. Eliminates Type Casting

4. Compile-Time Error Checking

5. Easy Maintenance

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Important Notes =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

✔ Generic Classes work only with Objects.

Correct

        Box<Integer>

Incorrect

        Box<int>

Reason

int is primitive.

Integer is a Wrapper Class.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Frequently Asked Interview Questions =====================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. What is a Generic Class?

2. Why is Generic Class required?

3. What is Type Parameter?

4. Why can't Generics use primitive data types?

5. Difference between Generic Class and Normal Class?

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

class Box<T>
{
    private T value;

    // Constructor
    public Box(T value)
    {
        this.value = value;
    }

    // Setter Method
    public void setValue(T value)
    {
        this.value = value;
    }

    // Getter Method
    public T getValue()
    {
        return value;
    }

    // Display Method
    public void display()
    {
        System.out.println("Stored Value : " + value);
    }
}

public class p2_GenericClass
{
    public static void main(String[] args)
    {
        // =====================================================
        // Integer Object
        // =====================================================

        Box<Integer> integerBox = new Box<>(100);

        integerBox.display();

        System.out.println("Value : " + integerBox.getValue());

        // =====================================================
        // String Object
        // =====================================================

        Box<String> stringBox = new Box<>("Yash");

        stringBox.display();

        System.out.println("Value : " + stringBox.getValue());

        // =====================================================
        // Double Object
        // =====================================================

        Box<Double> doubleBox = new Box<>(99.95);

        doubleBox.display();

        System.out.println("Value : " + doubleBox.getValue());

        // =====================================================
        // Character Object
        // =====================================================

        Box<Character> characterBox = new Box<>('A');

        characterBox.display();

        System.out.println("Value : " + characterBox.getValue());

        // =====================================================
        // Boolean Object
        // =====================================================

        Box<Boolean> booleanBox = new Box<>(true);

        booleanBox.display();

        System.out.println("Value : " + booleanBox.getValue());

        // =====================================================
        // Updating Value
        // =====================================================

        integerBox.setValue(500);

        System.out.println("\nAfter Updating Integer Value");

        integerBox.display();
    }
}