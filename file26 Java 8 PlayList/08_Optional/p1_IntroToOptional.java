/*
===============================================================================
                        Introduction To Optional
===============================================================================

Before Java 8, when a value was not found many methods just return 'null' that casue 
NullPointerException.


Example
    Employee emp = findEmployee(101);

If employee does not exist,
    ↓
emp = null

Now suppose we write

    emp.getName();
            ======> NullPointerException


To reduce such problems, Java 8 introduced Optional.


===============================================================================
What is Optional?
===============================================================================

=> Optional is a final class introduced in Java 8.

=> It acts as a wrapper (container) that "may" or "may-not" contain a value.

=> Instead of returning null, many Java 8 APIs return an (Optional_object) to safely represent 
   the presence or absence of a value.


===============================================================================
Why not simply return null?
===============================================================================

Suppose

    List<Integer> list = List.of();

Question

What is the first element?
There is no first element.
Returning null may cause
                |
                ============> NullPointerException



Instead, Java returns
            |
            ======> Optional.empty()


This forces the programmer to check whether a value exists before using it.


===============================================================================
Visual Representation
===============================================================================

Case 1 : Value Present

Optional<Integer>
        │
        ▼
┌────────────────────┐
│     Optional       │
│        10          │
└────────────────────┘


Case 2 : No Value Present

Optional<Integer>
        │
        ▼
┌────────────────────┐
│     Optional       │
│      Empty         │
└────────────────────┘


===============================================================================
Where have we already used Optional?
===============================================================================

Stream API
    findFirst()

Method Signature

Optional<T> findFirst()


Example

    Optional<Integer> first = numbers.stream()
                                     .findFirst();




===============================================================================
Advantages
===============================================================================

✔ Reduces NullPointerException.
✔ Clearly represents "value present" or "value absent".
✔ Encourages safer programming.
✔ Widely used in Java 8 APIs.

*/