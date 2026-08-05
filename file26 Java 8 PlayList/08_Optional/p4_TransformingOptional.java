/*

===============================================================================
                         map() Method
===============================================================================


------------------------------------------------------------------------------------------------
Note: Previously we are familiar with the map() method form the stream of java8, But in this 
Optional class, the map method is use to perform a functional operation on a value and 
return another Optional. 
------------------------------------------------------------------------------------------------

=> The map() is an instance method of the Optional class.

=> It is used to transform (modify) the value stored inside an Optional object.

=> If the Optional contains a value, the specified Function is applied and a new Optional containing 
   the transformed value is returned.

=> If the Optional is empty, no transformation is performed and Optional.empty() is returned.


===============================================================================
Why do we need map()?
===============================================================================

Suppose an Optional contains a value.

        Optional["rahul"]

Now we want
        ↓
Optional["RAHUL"]    <----- into UpperCase

Without map(),

        • Extract the value.
        • Modify it.
        • Again create an Optional.

With map(),
        The transformation is performed directly on the Optional object.


===============================================================================
Method Information
===============================================================================

Class
        Optional

Method
        map()

Category
        Instance Method

Parameter
        Function<T,R>

Return Type
        Optional<U>


===============================================================================
Method Signature
===============================================================================

        <U> Optional<U> map(Function<? super T, ? extends U> mapper)


===============================================================================
Working
===============================================================================

Optional["rahul"]
        │
        ▼ 
map(String::toUpperCase)
        │
        ▼ 
Optional["RAHUL"]


Notice

The value changes.

The container (Optional) remains the same.

Hence,
        map() returns another Optional.



============================================================================
Program
===============================================================================
*/

import java.util.Optional;

public class p4_TransformingOptional
{
    public static void main(String[] args)
    {
        Optional<String> name = Optional.of("rahul");


        // ~~~~~~~~~~~~~ Transform Value ~~~~~~~~~~~~~~~~~~~~

        Optional<String> upperName = name.map(String::toUpperCase);
        System.out.println("\nTransform into UpperCase : " + upperName);



        // ~~~~~~~~~~~~~ Empty Optional ~~~~~~~~~~~~~~~~~~~~

        Optional<String> city = Optional.empty();
        Optional<String> result = city.map(String::toUpperCase);
        System.out.println("\nTransform empty optional : " + result);
    }
}