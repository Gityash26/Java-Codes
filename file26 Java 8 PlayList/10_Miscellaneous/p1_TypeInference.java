/*
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
                            TypeInference
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Type Inference is a compiler feature that automatically determines the required data type from the context, reducing unnecessary code. It is commonly used with Lambda Expressions and Generics.

This reduces unnecessary code and improves readability.


=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Why do we need Type Inference?
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Before Java 8,
    Programmers had to explicitly mention the data types in many places.

Java 8 allows the compiler to identify those types automatically, making the code shorter 
and cleaner.


===============================================================================
Where is Type Inference used?
===============================================================================

Java 8 mainly uses Type Inference with

    ✔ Lambda Expressions
    ✔ Method References
    ✔ Generics (Diamond Operator <>)


===============================================================================
Example 1 : Lambda Expression
===============================================================================

Without Type Inference
    (int a, int b) -> a + b

With Type Inference
    (a, b) -> a + b


Reason
    The compiler already knows that both parameters are integers from the Functional Interface.
    Hence, writing int is unnecessary.


===============================================================================
Example 2 : Generics
===============================================================================

Before Java 7
    List<String> list = new ArrayList<String>();

Using Type Inference
    List<String> list = new ArrayList<>();

Reason
    The compiler already knows the Generic Type is String.

*/

