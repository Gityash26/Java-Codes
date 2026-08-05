/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Binary Search Tree (BST) ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Before understanding TreeMap, we must first understand

      ''''  Binary Search Tree (BST)  ''''

Because TreeMap stores its entries using a 'Red-Black Tree' and a Red-Black Tree is an improved 
version of a Binary Search Tree.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= What is a Tree ? =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

A Tree is a hierarchical data structure. Unlike Arrays or Linked Lists, a Tree stores data in 
Parent-Child relationship.

Example

                    A
                  /   \
                 B     C
               /  \     \
              D    E     F


Terminology

A   -> Root Node
B,C -> Children of A
D,E -> Children of B
F   -> Child of C



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Binary Tree ==============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

A Binary Tree is a Tree in which each node can have Maximum Two Children called (Left child)
and (Right Child)

Example

                    50
                  /    \
                30      70
               /  \       \
             20   40       90


Notice, Every node has 0, 1 or 2 children atmost.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Binary Search Tree ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

A Binary Search Tree (BST) is a special type of Binary Tree.

It follows one important rule.

                Left < Root < Right


That means, Every node in the Left Subtree must be SMALLER than the Root.

Every node in the Right Subtree must be GREATER than the Root.


Example


                    50
                  /    \
                30      70
               /  \    /  \
             20   40 60   80



Observe, 
20 < 30 < 40 < 50 < 60 < 70 < 80

Hence, this is a valid BST.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Insertion ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we insert (50, 30, 70, 20, 40, 60, 80)

Insertion Process

-----------------------------------------------------
Insert 50

                50


----------------------------------------------------
Insert 30

                50
               /
             30
----------------------------------------------------
Insert 70

                50
               /  \
             30    70
----------------------------------------------------
Insert 20

                  50
                 /  \
               30    70
              /
            20
----------------------------------------------------
Insert 40

                  50
                 /  \
               30    70
              / \
            20  40
----------------------------------------------------
Insert 60

                    50
                  /    \
                30      70
               / \     /
             20  40   60
----------------------------------------------------
Insert 80

                    50
                  /    \
                30      70
               / \     / \
             20  40   60 80


Notice Every insertion automatically goes to its proper location.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Searching ===============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we search

60


Start (root)

                50


------------------------
60 > 50           | Go Right (-->)
------------------------

                70


------------------------
60 < 70           | Go left (<--)
------------------------


                60 Found.


Only few comparisons were required.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Tree Traversal ==============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

There are mainly three traversals.

----------------------------------------------------
(1) Preorder

Root
↓
Left
↓
Right
----------------------------------------------------


----------------------------------------------------
(2) Inorder

Left
↓
Root
↓
Right

====> Produces Sorted Output
----------------------------------------------------




----------------------------------------------------
(3) Postorder

Left
↓
Right
↓
Root
----------------------------------------------------



Example


                    50
                  /    \
                30      70
               / \     / \
             20  40   60 80



Preorder

50 30 20 40 70 60 80


Inorder

20 30 40 50 60 70 80


Postorder

20 40 30 60 80 70 50



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Why BST is Fast ? ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Searching in an Array


10 20 30 40 50 60 70

Need to check one by one.


Searching in BST


                50
              /    \
            30      70
           / \     / \
         20 40   60 80


Each comparison eliminates half of the remaining tree.

Therefore, Searching is much faster.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ Problem with BST ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we insert (10 20 30 40 50 60 70)

The Tree becomes


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


This is called Unbalanced BST. Searching becomes O(n) which is as slow as a Linked List.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Solution ============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Java does NOT use a simple BST.

Instead,

TreeMap uses

        Red-Black Tree

which is

Self Balancing.


Balanced Tree


                40
              /    \
            20      60
           / \     / \
         10 30   50 70


Height remains small adnd Searching remains O(log n).



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Summary ========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

✓ Binary Tree

        Maximum two children.


✓ Binary Search Tree

        Left < Root < Right


✓ Inorder Traversal

        Produces Sorted Order.


✓ Simple BST

        Can become Unbalanced.


✓ Red-Black Tree

        Self Balancing BST.


TreeMap internally uses

        Red-Black Tree

instead of a normal BST.

*/

public class p2_BinarySearchTree {

    public static void main(String[] args) {

        System.out.println("Binary Search Tree (BST)");
        System.out.println("-------------------------");
        System.out.println("Rule : Left < Root < Right");
        System.out.println("Inorder Traversal produces Sorted Order.");
        System.out.println("TreeMap uses a Self Balancing Red-Black Tree.");

    }
}