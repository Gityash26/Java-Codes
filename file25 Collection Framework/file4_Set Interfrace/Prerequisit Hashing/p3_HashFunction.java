/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============== How a Hash Function works? =======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Should always map a (large_Key) into (small_Key)'.

-> Sould generate value from 0 to m-1.

-> Should be fast, O(1) for integers, O(str_length) for a String str. 

-> Should uniformally distributed large key into Hash Table slots.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============== Generally used Hash Function =======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Division method
=================================
-> hash(58) = 58 % M 


(2) Mid square method
=================================
-> squaring of the key and take out its middle value
hash(16)  =>  16^2  =>  256 ('2' and '6' removed)
hash(5)  =>  5^2  =>  25 ('2'removed)



(3) Digit folding method
=================================
-> Divide the key into smaller segments of equal size (k -> k1, k2, k3, k4, ----- , kn)
-> Take the sum of all the segments (S = k1 + k2 + k3 ---- + kn)
-> S % M

example:      key = 12345 and the table range form (0 - 99)
              
step1: Divide the key into equal segments
        12345 = (k1 = 12)  ,  (k2 = 34)  ,   (k3 = 5)

step2: Take the sum
        S = k1 + k2 + k3
        S = 12 + 34 + 5
        S = 51

step3: Take the modulo %
        S % M
        51 % 10 = [1]

Therefore,  Hash(12345) = 1



(4) Multiplication method
=================================

hash(K) ==> floor(M (KA mod 1))

Step1: Choose a constant value 'A'
       where o < A < 1

Step2: key * A

Step3: Extract fractional part of (key * A)

Step4: Multiple previous step result by M.

Step5: Take out the floor value of the result


example: Hash(12345)
         M (table size) = 12
         A = 0.234 




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
== Hash function example
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


============================================= 
(1) Hash function example (for Numbers)
============================================= 
-> retrun the modulous of the number with a prime number.

    Hash (large_key)
    {
        retrun large_key % m;
        }
        

        
============================================= 
(2) Hash function example (for Strings)
============================================= 
-> Multiplying ASCII value of each character of string with the power of a number.

    Hash (str)
    {
        int index = (str[0] * x^0) + (str[1] * x^1) + (str[2] * x^2);
        return index;
    }



Note: We can build a perfect Hashing function if we know about the keys in advance.
      Suppose you have a hash table of size 10
      You have to insert 10 phone numbers in the hash table
      So, we can create a function like, use last digit of the phone number as the index
      It make the chances of collision higher.



      
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============== Collision Handling Methods =======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> When multiple keys compute to formed a same HashKey from the Hash function, It makes to occur collision 
   of multiple entries on the same Bucket slot.


HashMap logic: (key % M)
------------------------------------
k1 = 20 % 9  => 2  --\ 
k1 = 29 % 9  => 2  ---|---> same slot index
k1 = 38 % 9  => 2  --/
------------------------------------



-> If we know about keys in advance then we can create a perfect hash function.
-> But in real world keys are not mentioned before so we have to handle collision using 
   following methods.

   

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============== Collision Resolution Techniques ==================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        ________________________|____________________________________
        |                                                           |
   Chaining                                                    Open Addressing
 (open hashing)                                                (closed hashing)
                                                                     |
                                        _____________________________|____________________________
                                        |                           |                            |
                                   Linear probing             Quadratic probing         Double Hashing
                                   (H(R)+i) % M                (H(R)+i^2) % M            H(k,i) = (h1CK) + i*H2(K)%M
   
   








*/


