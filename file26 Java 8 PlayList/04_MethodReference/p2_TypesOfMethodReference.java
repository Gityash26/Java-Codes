/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                    TYPES OF METHOD REFERENCE
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

In the previous file we learned Method Reference can be used only when a Lambda
simply calls an already existing method.


Question
        How many ways can we reference a method?

Java provides FOUR types of Method References.

1. Reference to a Static Method
2. Reference to an Instance Method of a Particular Object
3. Reference to an Instance Method of an Arbitrary Object
4. Constructor Reference

Let's understand each one.







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Type 1 : Reference to a Static Method   => (ClassName::staticMethod)
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Suppose we already have

    Integer.compare(a,b)

Now write a Lambda

Comparator<Integer> ascending = (a,b) -> Integer.compare(a,b);


Question What is the Lambda doing?
    It simply calls the static method => Integer.compare()

Therefore, it can become

    Comparator<Integer> ascending = Integer::compare;





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Type 2 : Reference to an Instance Method of a Particular Object
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

@FunctionalInterface
interface Greeting
{
    void greet();
}

class Demo
{
    public void show()
    {
        System.out.println("Hello");
    }
}


Demo d = new Demo();

// Lambda
Greeting g = () -> d.show();

Note: In the above line we are juts calling a single method class

// Method Reference
Greeting g = d::show;




~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Type 3 : Reference to an Instance Method of an Arbitrary Object
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Suppose we have

Comparator<String> compare = (a,b) -> a.compareTo(b);



Notice carefully, compareTo() is NOT static.

It belongs to every String object.

Java understands

(a,b)
  ↓

a.compareTo(b)

can become
    String::compareTo

Syntax
        ClassName::instanceMethod

Examples

    String::compareTo

    String::equals

    String::toUpperCase

Remember

    No object is written here.
    Java will automatically use the first parameter as the object.

Example

(a,b)
  ↓

a.compareTo(b)







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Type 4 : Constructor Reference
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Suppose we have a class

class Student
{
    Student()
    {
        System.out.println("Object Created");
    }
}

Normally, object creation is

    Student s = new Student();

---------------------------------------------------
Now suppose we have a Functional Interface
---------------------------------------------------

@FunctionalInterface
interface StudentFactory
{
    Student create();
}

Question: Can we implement create() using Lambda?

Of course.

    StudentFactory sf = () -> new Student();

Now ask yourself:
    What is this lambda doing?

create()
    ↓
new Student()

That's all => No logic => No calculations => Just object creation.

=====================
Java says
=====================

"Since your lambda is only creating an object..."

you can replace

    StudentFactory sf = () -> new Student();

with

    StudentFactory sf = Student::new;

That's called a Constructor Reference.






~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Remember
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

ClassName::staticMethod
        ↓

Static Method Reference

------------------------------------------------------------

objectReference::instanceMethod
        ↓

Instance Method Reference
(of a Particular Object)

------------------------------------------------------------

ClassName::instanceMethod
        ↓

Instance Method Reference
(of an Arbitrary Object)

------------------------------------------------------------

ClassName::new
        ↓

Constructor Reference

================================================================================
*/


import java.util.Comparator;

@FunctionalInterface
interface Greeting
{
    void greet();
}

//------------------------------------------------------------

@FunctionalInterface
interface StudentFactory
{
    Student create();
}

//------------------------------------------------------------

class Demo
{
    // Instance Method
    public void show()
    {
        System.out.println("Hello from Demo.show()");
    }

    // Static Method
    public static void display()
    {
        System.out.println("Hello from Demo.display()");
    }
}

//------------------------------------------------------------

class Student
{
    Student()
    {
        System.out.println("Student Object Created");
    }
}

//------------------------------------------------------------

public class p2_TypesOfMethodReference
{
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {

        /*
        ============================================================
        Type 1 : Reference to a Static Method
        ============================================================

        Lambda:
            (a,b) -> Integer.compare(a,b)

        Method Reference:
            Integer::compare
        */

        Comparator<Integer> ascending = Integer::compare;

        System.out.println("10 vs 20 = " + ascending.compare(10,20));



        /*
        ============================================================
        Type 2 : Reference to an Instance Method of a Particular Object
        ============================================================

        Lambda:
            () -> d.show()

        Method Reference:
            d::show
        */

        Demo d = new Demo();

        Greeting g1 = d::show;   // it says that Greeting interface method greet() internally calling Class method show show()
        g1.greet();



        /*
        ============================================================
        Type 3 : Reference to an Instance Method of an Arbitrary Object
        ============================================================

        Lambda:
            (a,b) -> a.compareTo(b)

        Method Reference:
            String::compareTo
        */

        Comparator<String> cmp = String::compareTo;         // it define in Lambda expression that compare internall call compareTo()
        System.out.println(cmp.compare("Apple","Banana"));



        /*
        ============================================================
        Type 4 : Constructor Reference
        ============================================================

        Lambda:
            () -> new Student()

        Method Reference:
            Student::new
        */

        StudentFactory sf = Student::new;
        Student s = sf.create();

    }
}