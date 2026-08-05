/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== WeakHashMap Working Programs ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

The purpose of this file is NOT to learn methods.

The purpose is to understand HOW WeakHashMap behaves when the Garbage Collector removes objects.

Remember, 

WeakHashMap stores KEYS using Weak References.

If no Strong Reference to a key exists,
        ↓

The key becomes eligible for Garbage Collection.
        ↓

Once GC removes the key,

WeakHashMap automatically removes the entire entry.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Program 1 ===================================================
====================== Strong Reference Still Exists =======================================

If at least ONE Strong Reference exists, Garbage Collector CANNOT remove the object.

Therefore, WeakHashMap entry remains.


class Student
{
    int roll;

    Student(int roll)
    {
        this.roll = roll;
    }

    @Override
    public String toString()
    {
        return "Student : " + roll;
    }
}

public class Program1
{
    public static void main(String[] args)
    {

        Student s = new Student(101);

        Student s2 = s;

        WeakHashMap<Student,String> map = new WeakHashMap<>();

        map.put(s,"Java");

        s = null;

        System.gc();

        System.out.println(map);

    }
}


Output (Most likely)

{Student:101=Java}


Explanation

Student Object

Strong Reference -> s2

Weak Reference   -> WeakHashMap

Since a Strong Reference still exists, GC cannot remove the object.

Therefore, Entry remains.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Program 2 ===================================================
======================== No Strong Reference Exists ========================================

Now both Strong References are removed.

Student s = new Student(101);

Student s2 = s;

WeakHashMap<Student,String> map = new WeakHashMap<>();

map.put(s,"Java");

s = null;

s2 = null;

System.gc();

Thread.sleep(100);

System.out.println(map);


Possible Output {}


Explanation

Student Object

Strong References ×

Weak Reference ✓

No Strong Reference exists.

Therefore, Object becomes eligible for GC.

GC removes the object.

WeakHashMap removes the complete entry.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Program 3 ===================================================
===================== Key Retrieved Again ==================================================

Student s = new Student(101);

WeakHashMap<Student,String> map = new WeakHashMap<>();

map.put(s,"Java");

Student x = map.keySet().iterator().next();

s = null;

System.gc();

System.out.println(map);


Possible Output

{Student-101=Java}


Explanation

Strong Reference x
        ↓

Student Object
    Since x still references the key,

GC cannot remove it.

Therefore, WeakHashMap entry remains.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Program 4 ===================================================
========================== HashMap vs WeakHashMap ==========================================

HashMap

Student s = new Student(101);

HashMap<Student,String> map = new HashMap<>();

map.put(s,"Java");

s = null;

System.gc();

System.out.println(map);


Output

{Student-101=Java}


Reason...

HashMap itself stores the key using a Strong Reference.

Therefore, GC cannot remove it.






~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Important Notes =============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) WeakHashMap stores Weak References only for KEYS.
------------------------------------------------------------
(2) Values are stored normally.
------------------------------------------------------------
(3) The entry disappears only after Garbage Collector actually removes the key.
------------------------------------------------------------
(4) Calling System.gc() does NOT guarantee immediate removal.
    It only requests the JVM to run GC.
------------------------------------------------------------
(5) Never write logic that depends on "After System.gc(), my entry MUST disappear."
    The JVM decides when Garbage Collection occurs.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/