/* 


                              Set interface
     _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|______________________________
    |                               |                         ____|_____
HashSet                          LinkedHashSet               |_TreeSet_|



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Prerequisit ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-----------------------------------------------------------
   What is BST (Binary Search Tree) 
===========================================================

-> A Binary Search Tree (BST) is a node-based binary tree data structure that follows a strict ordering rule to make searching for elements fast.
-> Every node can have a maximum of two children (hence "binary"), and it must satisfy the following properties:

 [Left node value] < [Parent Node] < [Right node value]

-> Both the left and right subtrees must also be binary search trees.


Problem with BST ---------------
--------------------------------
-> If you insert elements into a normal BST in sorted order (for example: 10, 20, 30, 40), the tree doesn't branch out. Instead, it grows completely 
   straight down to one side. 
-> This is called a skewed tree. When a tree becomes skewed, it completely loses its efficiency. Searching through it no longer takes O(log n) 
   it takes O(n) time, performing exactly like a slow LinkedList.


-----------------------------------------------------------
   What is Red Black Tree  
===========================================================
-> A Red-Black Tree is an evolution of the BST. It is a Self-Balancing Binary Search Tree where every node contains an extra storage bit representing a color: 
   either Red or Black.
-> These colors are used as flags to ensure the tree remains balanced during insertions and deletions, preventing the tree from ever becoming skewed.

-> To maintain its balance, a Red-Black Tree strictly enforces these 5 Balancing Rules:

(1) Node Color: Every node is explicitly colored either Red or Black.
(2) Root Rule: The root node of the tree is always Black.
(3) Null Leaf Rule: Every leaf node (the empty null endpoints at the bottom) is considered Black.
(4) Red Node Rule: If a node is Red, both of its children must be Black. (You cannot have two Red nodes adjacent to each other vertically).
(5) Black Height Rule: Every path from a given node to any of its descendant null leaves must contain the exact same number of black nodes.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Introduction to TreeSet ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> A TreeSet is the third major implemented class of the Set interface.
-> Unlike HashSet and LinkedHashSet, TreeSet does NOT use Hashing or a HashTable for storing elements.
-> It stores elements in a self-balancing binary search tree, specifically a "Red-Black Tree".
-> Like all Sets, it does not allow duplicate elements.
-> It is part of the java.util package.
-> It is not synchronized, meaning it is not thread-safe.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Key Points of TreeSet =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Underlying Data Structure => Red-Black Tree (Self-Balancing Binary Search Tree).

(2) Unique Elements => Ensures all elements are unique (no duplicates allowed).

(3) Sorted Collection => Elements are stored and retrieved in a completely sorted order

(4) Null Value => Does NOT allow null values. (throws-> "NullPointerException")

(5) Inheritance => TreeSet implements the NavigableSet interface, which extends SortedSet, which in turn extends the Set interface.

(6) Performance => Slower than HashSet and LinkedHashSet. Time complexity for core operations (add, remove, contains) is O(log n) due to tree balancing.

(7) Thread Safety => Not thread-safe. To use in multithreading environments, it must be synchronized externally.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Why TreeSet After LinkedHashSet? ==========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

--------------------------------
 LinkedHashSet Limitation:
--------------------------------
- Only maintains insertion order.
- Cannot automatically sort data or provide range-based search operations efficiently.

--------------------------------
 TreeSet:
--------------------------------
    - Solves sorting needs completely. 
    - Elements are dynamically sorted upon insertion.
    - Provides high-level navigation methods (finding values immediately higher/lower than a given target).


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== How TreeSet Works =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Internally, TreeSet uses a Red-Black Tree structure where every node represents an element.

-> When a new element is added, Java compares it with existing nodes starting from the root to find its correct placement.

-> Left child nodes contain values smaller than the parent node, while right child nodes contain values larger than the parent node.

-> The tree performs self-balancing rotations dynamically to ensure the depth remains optimal, keeping search speeds constant at O(log n).


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Storage Mechanism ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=> TreeSet maps elements using binary search sorting logic, looking roughly like this:

(1) Red-Black Tree Layout
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

               [Parent Node: 40]
                 /          \
                /            \
      [Left Child: 20]     [Right Child: 60]
           /                    \
          /                      \
  [Left Child: 10]        [Right Child: 80]




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Constructors of TreeSet ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) TreeSet():
    Creates an empty, default TreeSet that sorts elements according to their natural ascending order.

(2) TreeSet(Comparator comparator):
    Creates an empty TreeSet that sorts elements according to a custom specified comparator logic.

(3) TreeSet(Collection c):
    Creates a new TreeSet containing all elements from the specified collection, sorted by natural ordering.

(4) TreeSet(SortedSet s):
    Creates a new TreeSet containing all elements from the specified SortedSet, maintaining the exact same sorting rules.


*/



import java.util.TreeSet;
import java.util.List;
import java.util.Comparator;
import java.util.SortedSet;


public class p1_IntroToTreeSet
{
    public static void main(String[] args) 
    {
        // Default constructor -----------------------------------------------------
        TreeSet<Integer> setA = new TreeSet<>();
        setA.add(50);
        setA.add(10);
        setA.add(30);
        System.out.println("\n(1) Default Constructor (Natural Order): " + setA); 


        // Constructor with comparator ---------------------------------------------
        Comparator<Integer> descendingComp = new Comparator<Integer>() 
        {
            @Override
            public int compare(Integer a, Integer b) 
            {
                return b.compareTo(a); // Reverses natural order
            }
        };

        TreeSet<Integer> setB = new TreeSet<>(descendingComp);
        setB.add(50);
        setB.add(10);
        setB.add(30);
        System.out.println("\n(2) Comparator Constructor (Descending Order): " + setB); 
    


        // (3) Constructor with collection --------------------------------------------------- 
        TreeSet<Integer> SetC = new TreeSet<>(List.of(40, 20, 40, 10));
        System.out.println("\n(3) Collection Constructor : " + SetC); 
        
        

        // (4) Constructor with SortedSet ------------------------------------------
        SortedSet<Integer> oldSortedSet = new TreeSet<>(descendingComp);
        oldSortedSet.add(100);
        oldSortedSet.add(300);
        oldSortedSet.add(200);

        TreeSet<Integer> setD = new TreeSet<>(oldSortedSet);
        System.out.println("\n(4) SortedSet Constructor (Preserves Order): " + setD); 

    }
}