/*
===============================================================================
                        P1_IntroductionToStreamAPI
===============================================================================

Before Java 8, whenever we wanted to process data stored inside a Collection,
we usually used loops.

Suppose we have a List of numbers.

        [10, 15, 20, 25, 30, 35, 40]

Requirement

    • Print only even numbers.
    • Convert them into their squares.
    • Sort the result.
    

=> Using traditional Java, we need loops, conditions and sometimes temporary collections, 
   making the code lengthy.

=> Java 8 introduced Stream API to perform these operations in a cleaner and more readable way.


===============================================================================
What is a Stream?
===============================================================================

A Stream is an object that processes the data of a Collection.

It does not store data.
It simply reads the elements from the Collection and performs the required operations on them.

Relationship

Collection
    │
    └── stream()
            │
            ▼
      Stream Object


===============================================================================
Memory Representation
===============================================================================

Before stream()

        numbers
           │
           ▼

    +---------------------------+
    |10|15|20|25|30|35|40|
    +---------------------------+
          List Object


After stream()

        numbers                         stream
           │                               │
           ▼                               ▼

    +---------------------------+    +---------------+
    |10|15|20|25|30|35|40|      |    | Stream Object |
    +---------------------------+    +---------------+
                                              │
                                              ▼
                                Processes Collection Data


Notice

✔ Collection remains unchanged.
✔ No new Collection is created.
✔ No data is copied.
✔ Only a Stream object is created.


===============================================================================
How Stream Processes Data
===============================================================================

Every Stream works like a processing pipeline.

Collection
    │
    └── stream()
            │
            ├── Intermediate Operations
            │       ├── filter()
            │       ├── map()
            │       ├── sorted()
            │       ├── distinct()
            │       ├── limit()
            │       └── skip()
            │
            └── Terminal Operations
                    ├── forEach()
                    ├── collect()
                    ├── count()
                    ├── reduce()
                    └── findFirst()


===============================================================================
Intermediate vs Terminal Operations
===============================================================================


=-=-=-=-=-=-=-=-=-=-=-=-
Intermediate Operations
=-=-=-=-=-=-=-=-=-=-=-=-


These operations process the data and return another Stream.

Example

    Collection
        │
        ▼
[10, 15, 20, 25, 30]
        │
        ▼

filter(number -> number % 2 == 0)
        │
        ▼

    [10, 20, 30]      <---- new stream



Notice that nothing is printed yet.

Intermediate operations are called Lazy Operations because they only prepare the processing steps. 
They do not execute immediately.




=-=-=-=-=-=-=-=-=-=-=-=-
Terminal Operations
=-=-=-=-=-=-=-=-=-=-=-=-

A Terminal Operation starts the execution of the complete Stream pipeline and produces the final result.

Example


Collection
    │
    └──> stream()
            │
            └──> filter()
                    │
                    └──> map()
                          │
                          └──> sorted()
                                │
                                └──> forEach()
                                        │
                                        └──>  'OUTPUT'


===============================================================================
Remember
===============================================================================

✔ Stream does not store data; it processes Collection data.
✔ stream() creates a Stream object from a Collection.
✔ Intermediate Operations process the data and return another Stream.
✔ Terminal Operations execute the Stream pipeline and produce the final result.
✔ A Stream can be traversed only once.

===============================================================================
*/