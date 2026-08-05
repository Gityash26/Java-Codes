/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                    INTRODUCTION TO METHOD REFERENCE
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Definition

A Method Reference is a shorter way of writing a Lambda Expression when the Lambda only calls an
already existing method.

Method Reference does NOT introduce new functionality.

It simply makes the code shorter and more readable.

In this file we will understand:

✔ Why Method Reference was introduced?
✔ When should we use it?
✔ How to convert a Lambda into a Method Reference?



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                        WHY METHOD REFERENCE ?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

We have already learned that Java 8 introduced Lambda Expressions to reduce Boilerplate Code.

Question Can every Lambda Expression be made even shorter?

Answer 
NO.
Only those Lambda Expressions which simply call an already existing method can be replaced with a
' Method Reference ' 






~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Example 1 : Comparator 
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Suppose we want Ascending Sorting.

Lambda

Comparator<Integer> ascending =
        (a,b) -> Integer.compare(a,b);



Question What logic are we writing?

Are we comparing numbers ourselves?
NO.

We are simply calling an already existing method => Integer.compare(a,b)
The Lambda itself contains NO business logic.
It only forwards the parameters to another method.

Visual Representation

(a,b)
  │
  │
  ▼
Integer.compare(a,b)

Since nothing new is happening, Java allows us to replace it with
Integer::compare





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
How does Java know what to do?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Comparator<Integer> ascending = Integer::compare;


Question
    Where did compare(a,b) disappear?

Remember, Comparator has only ONE abstract method. 

    int compare(Integer a,Integer b);

When Java sees

    Integer::compare

it automatically understands => Comparator.compare(a,b)
↓

call

Integer.compare(a,b)

Internally, Java behaves as if we had written

    (a,b) -> Integer.compare(a,b)

Nothing has changed. Only the syntax became shorter.







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Example 2 : Runnable
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Suppose we have

class Demo
{
    public static void printMessage()
    {
        System.out.println("Hello");
    }
}

Now create a Runnable.

Lambda

    Runnable r = () -> Demo.printMessage();



Question: What is the Lambda doing?

Nothing.
It simply calls Demo.printMessage();

Since no new logic exists, it can become

Runnable r = Demo::printMessage;

Again,

Runnable has only one abstract method => run()

So Java understands

run()
  ↓

Demo.printMessage()

Automatically.







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
When Method Reference CANNOT be used
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Example

Addition add = (a,b) -> a + b;

Question: Can this become a Method Reference?

NO.

Reason: 
    There is no existing method being called.

The Lambda itself contains the business logic.

Another Example

Square sq = (number) -> number * number;

Again,
No existing method is being called.

Therefore,
Method Reference cannot be used.







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Rule to Remember
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Ask yourself one question.

"Is my Lambda only calling another method?"
    YES
     ↓

Method Reference can be used.
    NO
     ↓

Continue using Lambda.







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Lambda vs Method Reference
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Lambda
        (a,b) -> Integer.compare(a,b)
                    ↓

            Method Reference
                    ↓
            (Integer::compare)

------------------------------------------------------------

Lambda
        () -> Demo.printMessage()
                    ↓

            Method Reference
                    ↓
            Demo::printMessage

------------------------------------------------------------

Lambda
        (a,b) -> a + b
                ↓

        Method Reference
        ❌ Not Possible

------------------------------------------------------------
  
*/