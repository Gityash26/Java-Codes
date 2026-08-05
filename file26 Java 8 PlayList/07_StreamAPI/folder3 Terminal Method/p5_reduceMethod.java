

/*
===============================================================================
                            reduce() method 
===============================================================================

The reduce method of the java streams helps to combine all the elements of the streams into a single result 
after performing any binary operatoion. 

This works like perform operation on first two elements and hold the result to perform same operation with
the next element. 


Examples

Find the Sum
    10 + 20 + 30 + 40 = 100

Find the Product
    2 × 3 × 4 = 24

Find the Maximum
    10, 40, 25, 80 → 80

For such operations, Stream API provides the reduce() method.


===============================================================================
Category
===============================================================================

Stream
    │
    │
    └── Terminal Operations
            ├── forEach()
            ├── collect()
            ├── count()
            ├── findFirst()
            ├── anyMatch()
            ├── allMatch()
            ├── noneMatch()
            └── reduce()        ← You are here

reduce() is a Terminal Operation because it consumes the Stream and returns a SINGLE result.


===============================================================================
Method Signatures
===============================================================================

                                There are Two forms of reduce()
                    __________________________|________________________________
                    |                                                         |
      Optional reduce(accumulator)                            T reduce(identity, accumulator)
     
            [2, 4, 6, 8, 10]                                          [1]       [2, 4, 6, 8, 10]
                  list                                            identity              List

step1: 2 x 4 = 8                                                       step1: 1 x 2 = 2
step2: 8 x 6 = 48                                                      step2: 2 x 4 = 8
step2: 48 x 10 = 480                                                   step3: 8 x 6 = 48
                                                                       step4: 48 x 8 = 384
                                                                       step5: 384 x 10 = 3840


=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Difference
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Without Identity
    • Java starts with the first two Stream elements.
    • Since the Stream may be empty, the return type is Optional<T>.


With Identity

    • Java starts with the identity value and the first Stream element.
    • Since an initial value is already available, the return type is T.


    

    

===============================================================================
Program
===============================================================================
*/

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class p5_reduceMethod 
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10,20,30,40);

        /* ===============================================================
        Sum using reduce()
        =============================================================== */

        Optional<Integer> sum = numbers.stream()
                                       .reduce((a,b) -> a + b);

        System.out.println(sum);
        System.out.println();


        /*
        ===============================================================
        Sum using Identity Value
        ===============================================================
        */

        int total = numbers.stream()
                           .reduce(0, (a,b) -> a + b);

        System.out.println(total);
    }
}


/*

===============================================================================
How reduce() Works
===============================================================================

Collection [10, 20, 30, 40]
        │
        ▼
    stream()
        │
        ▼
reduce((a,b) -> a+b)
        │
        ▼

Step 1: 10 + 20 = 30
Step 2: 30 + 30 = 60
Step 3: 60 + 40 = 100
        │
        ▼
  Optional[100]




===============================================================================
Identity Version
===============================================================================

reduce(0, (a,b) -> a+b)

Identity = 0

Start: 0 + 10 = 10
       10 + 20 = 30
       30 + 30 = 60
       60 + 40 = 100

Output: 100



===============================================================================
Real World Examples
===============================================================================

Sum

numbers.stream()
       .reduce(Integer::sum);

---------------------------------------------

Maximum

numbers.stream()
       .reduce(Integer::max);

---------------------------------------------

Minimum

numbers.stream()
       .reduce(Integer::min);


===============================================================================
Remember
===============================================================================

✔ reduce() is a Terminal Operation.

✔ It combines all Stream elements into one value.

✔ Without identity, it returns Optional<T>.

✔ With identity, it returns T.

✔ Commonly used for Sum, Product, Maximum and Minimum.

===============================================================================
*/