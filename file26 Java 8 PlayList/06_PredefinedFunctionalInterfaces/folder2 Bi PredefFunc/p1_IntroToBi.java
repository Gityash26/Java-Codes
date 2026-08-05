/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                INTRODUCTION TO BI PREDEFINED FUNCTIONAL INTERFACES
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Till now, we have studied the following Predefined
Functional Interfaces.

Consumer<T>

    Input  : One
    Return : Nothing
------------------------------------------------------------

Supplier<T>

    Input  : None
    Return : One Value
------------------------------------------------------------

Predicate<T>

    Input  : One
    Return : boolean
------------------------------------------------------------

Function<T,R>

    Input  : One
    Return : One Value
------------------------------------------------------------



Question: What if our task requires TWO input values?

Examples

Student Name + Marks

Rahul      95
------------------------------------------------------------

Length + Width

10      20
------------------------------------------------------------

Product + Price

Laptop      65000
------------------------------------------------------------

Employee Name + Salary

Amit      50000

Using Consumer, Predicate or Function is not enough because they accept only ONE input.
Java 8 solves this problem by providing

        ''' Bi Predefined Functional Interfaces ''''





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
What does "Bi" mean?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Bi  =>  Two

A Bi Functional Interface accepts TWO input values.

Only the number of input parameters changes.

Everything else remains the same.





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Relationship
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Consumer<T>
        │
        ▼

BiConsumer<T,U>

------------------------------------------------------------

Predicate<T>
        │
        ▼

BiPredicate<T,U>

------------------------------------------------------------

Function<T,R>
        │
        ▼

BiFunction<T,U,R>





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Why is there no BiSupplier?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Supplier never accepts any input.
It only returns a value.

Method

        get()

Since Supplier has ZERO input, there is no meaning of "Two Inputs"

Therefore, Java does NOT provide BiSupplier.

*/