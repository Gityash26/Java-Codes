/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Operation in Hashing =====================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


            Search ----------\
                             \
            Insert ----------|===========> O(1)
                            |
            Delete --------|

-> Hashing is very much useful that makes the operation to be performed in a constant time.
-> It helps to perform various operations most effeciently than other data structures.
-> Hashing is very much popular after Arrays due to its constant time complexity.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Not useful =====================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> There are some places where hasing was not useful like, 
   
    (1) Keeping data in a sorted manner
    (2) finding closet value



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Applications of Hashing ==================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) Dictionary
(2) Cryptography
(3) Caches in website
(4) Symbol table in compiler and Interpretors
(5) Routers


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Direct Table Access ======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Imagine a situation where you are having 1000 keys, (0 to 999) how would you implement O(1) Time complexity 
   to perform basic operations, such as
   
   -> Insert(), delete(), search(), update().

-> Yes, we all think about the previous "boolean array" approach where we consider our number as array index and put "True" 
    at the same index_value of the array, So that we can access our data in O(1) time complexity.

-> Using a boolean array from the Min to Max limit of the values and mark True and false accordingly is known as 
   Direct Access Table.
   
---------------------------------------------------------------------------------------------------------------
-> But, the problem with this approach is that it (can't handle large values) also using 1000 blocks of array is not so effecient, and 
if the limit of values are very large (phone no, float value, String) then it is not possible to use this approach. 

-> So, we came up with the concept of "Hashing" where instead of using Direct value as our index of array, we are using "key" -> "value"
approach where a unique "key" to generate the index of the array and put the value at that index.
---------------------------------------------------------------------------------------------------------------





*/

