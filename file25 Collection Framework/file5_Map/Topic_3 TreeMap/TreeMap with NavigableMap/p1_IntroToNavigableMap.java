/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== NavigableMap Interface =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                               Map
                                │
                                ▼
                           SortedMap
                                │
                                ▼
                          NavigableMap     <-------- learning 
                                │
                                ▼
                             TreeMap       (already completed and implemnets all the Navigable methods)


-> NavigableMap is a child interface of the SortedMap interface.

-> It extends the functionality of SortedMap by providing methods to navigate through the sorted key-value pairs.

-> TreeMap is the standard implementation class of the NavigableMap interface.

-> It is present in the java.util package.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Why NavigableMap ? =================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

We have already studied that

        HashMap
            │
            ▼
      Fast Retrieval
      Average O(1)

Problem:
-> Does not maintain sorted order.
-> Cannot determine the next or previous key. (Basically navigation features.....)

Therefore, Java introduced

        TreeMap
            │
            ▼
      Sorted Key-Value Pairs


Now another question arises...

If the keys are already stored in sorted order,

Can we directly find

    • Next Greater Key ?
    • Previous Smaller Key ?
    • Closest Greater Key ?
    • Closest Smaller Key ?

YES.

To support these navigation operations efficiently, Java introduced the ''' NavigableMap ''' interface.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= What does "Navigate" mean ? =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Navigation means moving through the sorted data.

Instead of manually traversing the TreeMap,

we can directly ask questions like

        "What is the next key?"

        "What is the previous key?"

        "Which key is just greater than this?"

        "Which key is just smaller than this?"



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ Visual Representation ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Sorted Keys
10 -------- 20 -------- 30 -------- 40 -------- 50 -------- 60



==============================================
Suppose Current Key = 30
==============================================

Next Greater Key
30 -----------------------> 40

Previous Smaller Key
30 <----------------------- 20

Equal or Next Greater
30 -----------------------> 30

Equal or Previous Smaller
30 <----------------------- 30



==============================================
Suppose Current Key = 35
==============================================

Next Greater Key
35 -----------------------> 40

Previous Smaller Key
35 <----------------------- 30

Equal or Next Greater
35 -----------------------> 40

Equal or Previous Smaller
35 <----------------------- 30



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Why Not HashMap ? ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap stores entries using Hashing.

Object
   │
   ▼
Hash Function
   │
   ▼
Bucket Index
   │
   ▼
Store Entry


Since HashMap does not maintain sorted order,

it cannot efficiently determine

    -> Higher Key
    -> Lower Key
    -> Ceiling Key
    -> Floor Key

Such operations would require scanning all entries, resulting in O(n) time complexity.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Why TreeMap Supports It ? ==============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

TreeMap stores keys in sorted order using a Red-Black Tree.

                50
               /  \
             30    70
            / \    / \
          20 40   60 80

Because the keys are always sorted,

finding

    -> Next Key
    -> Previous Key
    -> Closest Greater Key
    -> Closest Smaller Key

becomes efficient.

Average Time Complexity : O(log n)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Methods We Are Going To Learn ============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Boundary Methods

    -> firstKey()
    -> lastKey()
    -> firstEntry()
    -> lastEntry()


(2) Navigation Methods

    -> higherKey()
    -> lowerKey()
    -> ceilingKey()
    -> floorKey()

    -> higherEntry()
    -> lowerEntry()
    -> ceilingEntry()
    -> floorEntry()


(3) Polling Methods

    -> pollFirstEntry()
    -> pollLastEntry()


(4) Reverse View Methods

    -> descendingMap()
    -> descendingKeySet()
    -> navigableKeySet()



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Interview Points ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Q1. Why was NavigableMap introduced?
Ans: 
    To efficiently perform navigation operations on sorted key-value pairs.


Q2. Which class implements NavigableMap?
Ans:
    TreeMap.


Q3. Can HashMap support navigation methods efficiently?
Ans:
    No, Because HashMap does not maintain sorted order.


Q4. Which data structure makes these operations efficient?
Ans:
    Red-Black Tree.


*/

