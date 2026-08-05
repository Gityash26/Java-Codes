/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Why TreeMap ? ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

So far, we have studied two implementations of the Map Interface.

        Map Interface
              |
      ---------------------
      |                   |
   HashMap          LinkedHashMap


Both are excellent for storing data in the form of Key-Value pairs.

But they have one major limitation...

They CANNOT store data in Sorted Order.  (phle m, phle m....)


Example:

Insert the following keys

        50
        10
        80
        20
        40



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== HashMap ===============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap uses 'Hash Table' to store the entries.

                    put(50)
                        │
                    Hash Function
                        │
                        ▼
                 Bucket Position

Since Hashing depends upon the hashCode(), the elements are NOT stored according to their values.

Possible Output

        20 -> 50 -> 80 -> 10 -> 40

There is NO guarantee of ordering.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== LinkedHashMap ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

LinkedHashMap also uses 'Hash Table' but additionally maintains "Doubly Linked List"
which preserves -> Insertion Order.

Example

Insertion Order

50-> 10-> 80-> 20-> 40


Output
50, 10, 80, 20, 40


Notice carefully...

The order is preserved, but it is STILL NOT 'SORTED'.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Problem ===============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we are developing

=> Student Ranking System

Roll No: 101, 105, 102, 103, 104

Required Output

101-> 102-> 103-> 104-> 105

Or


Bank Account Numbers

1008
1002
1005
1001

Required Output

1001-> 1002-> 1005-> 1008

Or


Dictionary
(Apple, Ball, Cat, Dog, Elephant)


We always need

        Sorted Data

Neither HashMap nor LinkedHashMap can guarantee this.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Solution =============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Java introduced

                '''  TreeMap   '''

TreeMap automatically stores the keys in Sorted Order.

Example

Insert

50
10
80
20
40


TreeMap Output

10
20
40
50
80


The programmer DOES NOT need to sort the data manually.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== How is TreeMap Different ? =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap

Uses

        Hash Table

        hashCode()

        equals()

Average Time

        O(1)

--------------------------------------------

TreeMap

Uses

        Red-Black Tree

        compareTo()

        Comparator

Average Time

        O(log n)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Why Not Hashing ? ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Question: Why doesn't TreeMap use Hashing?
Answer

Hashing distributes data among buckets to achieve very fast searching.

Example

Keys

50
10
80
20
40

may be stored as

Bucket 0 ---> 80
Bucket 1 ---> 20
Bucket 2 ---> 50
Bucket 3 ---> 10
Bucket 4 ---> 40


Since elements are scattered among different buckets, sorting becomes impossible.

Therefore, TreeMap DOES NOT use Hashing.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== TreeMap uses Tree ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Instead of Hash Table, TreeMap uses

        ''' Red-Black Tree '''

which is a Self Balancing Binary Search Tree (BST).


Example

Insert (50)

            50



Insert (30)

              50
             /
           30



Insert (70)

              50
             /  \
           30    70



Insert (20)

                50
               /  \
             30    70
            /
          20


Insert (40)

                50
               /  \
             30    70
            / \
          20  40



Notice

Every new node is placed at its correct position.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
==================== Why Sorted Output ? ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Binary Search Tree follows

        Left  <  Root  <  Right


Example

                50
               /  \
             30    70
            / \
          20  40


If we traverse

Left -> Root -> Right


Output becomes

20, 30, 40, 50, 70


This traversal is called

        '''  Inorder Traversal   '''

and it always produces Sorted Order.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Real World Applications ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=> Dictionary

=> Phone Directory

=> Student Ranking

=> Leaderboard

=> Employee Records

=> Banking Systems

=> Online Shopping (Sorting Products)

=> Scheduling Systems

=> Navigation Systems



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Prerequisites ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Before learning TreeMap, we should understand the following concepts.

✓ Binary Tree
✓ Binary Search Tree (BST)
✓ Self Balancing Tree
✓ Red-Black Tree
✓ Comparable Interface
✓ Comparator Interface

These concepts will help us understand:

=> How TreeMap stores data
=> How searching works
=> How sorting is maintained
=> How custom sorting is implemented

*/
