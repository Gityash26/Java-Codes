/*
============================================================================
                PREDEFINED FUNCTIONAL INTERFACES
============================================================================

Till now, whenever we wanted to use a Lambda Expression, we created our own
Functional Interface.

Example

@FunctionalInterface
interface Greeting
{
    void greet();
}

Greeting g = () -> System.out.println("Hello");   ====> This works perfectly.



Question: Do we need to create our own Functional Interface every time?
Answer: NO.

    => Java 8 already provides many commonly used Functional Interfaces in java.util.function package.

    => These are called Predefined Functional Interfaces.

    => They save us from creating interfaces for common operations.


============================================================================
Why were they introduced?
============================================================================

Suppose we only want to

• Print something
• Check a condition
• Return a value
• Transform one object into another

Creating a new Functional Interface every time becomes unnecessary.
Instead, Java already provides ready-made interfaces.


Example

Consumer
    Accepts data and performs some operation.

Supplier
    Supplies the data.

Predicate
    Checks a condition and returns true/false.

Function
    Takes one input and returns another value.



============================================================================
Most Frequently Used Interfaces
============================================================================

Consumer<T>

Input   : One
Return  : Nothing (void)

------------------------------------------------------------

Supplier<T>

Input   : None
Return  : One value

------------------------------------------------------------

Predicate<T>

Input   : One
Return  : boolean

------------------------------------------------------------

Function<T,R>

Input   : One
Return  : One value (possibly different type)


*/