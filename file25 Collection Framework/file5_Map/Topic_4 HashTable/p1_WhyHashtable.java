/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Why Hashtable ? ===========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

We have already studied

        HashMap
            │
            ▼
     Fast Retrieval (O(1))
     Uses Hashing Technique


HashMap is one of the most widely used implementations of the Map interface because of its fast insertion,
deletion and searching operations.

However, HashMap has one major limitation.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Problem with HashMap ============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> HashMap is NOT synchronized.

-> This means multiple threads can access and modify the same HashMap object simultaneously.

As a result,

-> Data may become inconsistent.
-> Multiple threads may overwrite each other's changes.
-> Unexpected results may occur.

Therefore, HashMap is not thread-safe.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Understanding the Problem ===================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose two threads are working on the same HashMap.

                    HashMap

Thread A -----------------------> put(101, "Rahul")

Thread B -----------------------> remove(101)


Both threads access the HashMap at the same time.

Since there is no synchronization, both operations may execute simultaneously,
which can lead to inconsistent data.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Solution ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

To solve this problem,

Java introduced

                Hashtable

Hashtable synchronizes its methods.

This means, only one thread can access the Hashtable at a particular time.

If one thread is performing an operation, other threads must wait until that operation completes.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Visual Representation =========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                    Hashtable


Thread A -----------------------> put(101, "Rahul")
                                  │
                                  │  (Lock Acquired)
                                  ▼

Thread B -----------------------> Waiting...

                                  ▼

                        Thread A finishes

                                  ▼

                        Thread B gets access



Result

✔ Safe Data Modification

✔ No simultaneous modification

✔ Thread Safe



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Advantages ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Thread-safe.

-> Prevents data inconsistency.

-> Suitable for multi-threaded applications.

-> Uses Hashing internally, just like HashMap.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Disadvantages ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Slightly slower than HashMap.

Reason:

Every method is synchronized.

Only one thread can access the Hashtable at a time.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Interview Questions ===========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Q1. Why was Hashtable introduced?

Ans. To provide thread-safe key-value storage.

------------------------------------------------------------

Q2. What problem does Hashtable solve?

Ans. It prevents simultaneous modification by multiple threads.

------------------------------------------------------------

Q3. Which is faster?

Ans. HashMap becausee of No synchronization.

Hashtable
        Every method is synchronized.

*/

