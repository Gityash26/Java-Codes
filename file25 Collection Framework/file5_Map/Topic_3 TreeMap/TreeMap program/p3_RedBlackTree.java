/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Red-Black Tree ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

In the previous file, we learned that reeMap internally uses

        ''' Red-Black Tree  '''

instead of a normal Binary Search Tree (BST).


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== What is Red-Black Tree ? ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

A Red-Black Tree is a Self Balancing Binary Search Tree (BST).

It automatically balances itself after every 'Insertion' and 'Deletion' operation.

Therefore, its height always remains approximately balanced.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Why do we need it ? ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we use a normal BST.

Insert (10, 20, 30, 40, 50, 60, 70)

Result


10
 \
 20
   \
    30
      \
      40
        \
        50
          \
          60
            \
            70


This is called

        Skew Tree or Unbalanced Tree.


--> Searching, Insert, Delete all become O(n) which is very slow.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Balanced Tree ================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

A Red-Black Tree automatically balances itself.

Example


                 40
               /    \
             20      60
            / \     / \
          10  30   50 70


Height becomes much smaller.

Searching, Insert, Delete, remain O(log n)


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
==================== Why Smaller Height is Better ? ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we search (50)

Balanced Tree


                 40
               /    \
             20      60
                    /
                  50


Comparisons

40

↓

60

↓

50


Only

3 comparisons



---------------------------------------------------


Unbalanced Tree


10

 \

 20

   \

   30

     \

      40

        \

        50


Comparisons

10 -> 20 -> 30 -> 40 -> 50   =====> 5 comparisons

Smaller Height => Less Comparisons => Faster Searching



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Why is it called ==============================================
======================== "Red-Black" Tree ? ============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Each node stores one extra piece of information.

                ''' Color ''''

Every node is either (RED or BLACK)

Example


                 40(B)
               /       \
           20(R)      60(R)
          /    \      /   \
      10(B) 30(B) 50(B) 70(B)



The colors are NOT used for searching. They are only used to maintain balance.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Red-Black Rules =============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

A Red-Black Tree follows some rules.

----------------------------------------------------
Rule 1: Every node is either RED or BLACK.
----------------------------------------------------
Rule 2: The Root Node must always be BLACK.
----------------------------------------------------
Rule 3: Every NULL leaf is considered BLACK.
----------------------------------------------------
Rule 4: A RED node cannot have RED child.
----------------------------------------------------


Correct


        BLACK
        /
      RED
      /
   BLACK


Wrong


      RED
      /
    RED



----------------------------------------------------
Rule 5: 

Every path from Root to NULL leaf must contain same number of BLACK nodes.
These rules ensure that the tree never becomes highly unbalanced.
----------------------------------------------------



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= What happens after Insertion ? =================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose, a newly inserted node breaks one of the rules.

Java automatically performs

        ''' Recoloring '''

or

        ''' Rotation '''

to restore balance.


Example

Before Balancing

10

  \
   20

      \
      30



After Balancing


      20
     /  \
   10    30



The programmer never needs to perform these operations manually.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Rotation (Concept Only) =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Two basic balancing operations are used.


        Left Rotation

            A
             \
              B
               \
                C


becomes


             B
            / \
           A   C



--------------------------------------------



        Right Rotation


              C
             /
            B
           /
          A


becomes


             B
            / \
           A   C



TreeMap performs these rotations

internally whenever required.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Time Complexity =============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Search

        O(log n)


Insertion

        O(log n)


Deletion

        O(log n)



Reason

The height of the tree

always remains balanced.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Summary ================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

✓ Red-Black Tree

        Self Balancing BST


✓ Stores

        Color Information


✓ Maintains Balance


✓ Uses

        Rotation and Recoloring


✓ Guarantees

        O(log n)


Hence,

TreeMap internally stores all entries inside a Red-Black Tree.

*/

public class p3_RedBlackTree {

    public static void main(String[] args) {

        System.out.println("Red-Black Tree");
        System.out.println("-----------------------");
        System.out.println("Self Balancing Binary Search Tree");
        System.out.println("Used internally by TreeMap");
        System.out.println("Search    : O(log n)");
        System.out.println("Insertion : O(log n)");
        System.out.println("Deletion  : O(log n)");

    }
}