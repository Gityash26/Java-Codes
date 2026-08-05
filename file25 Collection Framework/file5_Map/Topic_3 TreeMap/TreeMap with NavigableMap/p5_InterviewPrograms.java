/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
==================== NavigableMap Practice Programs =====================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

This file contains practical programs based on the NavigableMap methods learned previously.

Methods Covered

-> firstKey()                     ------------------ \
-> lastKey()                      -------------------/------------------> Boundaries elements access... 

-> higherKey()                    -------------------\
-> lowerKey()                     -------------------/------------------> Just less or greater than specified key 

-> ceilingKey()                   
-> floorKey()                     

-> pollFirstEntry()
-> pollLastEntry()

-> descendingMap()
-> descendingKeySet()
-> navigableKeySet()

*/

import java.util.NavigableMap;
import java.util.TreeMap;

public class p5_NavigableMapPrograms
{
    public static void main(String[] args)
    {

        NavigableMap<Integer, String> students = new TreeMap<>();

        students.put(101, "Rahul");
        students.put(105, "Amit");
        students.put(110, "Neha");
        students.put(115, "Rohan");
        students.put(120, "Vikas");


        // ==========================================================
        // Program 1 : Find First & Last Student
        // ==========================================================

        System.out.println("\n----------- Program 1 -----------");

        System.out.println("First Roll Number : " + students.firstKey());

        System.out.println("Last Roll Number : " + students.lastKey());



        // ==========================================================
        // Program 2 : Find Next Student
        // ==========================================================

        System.out.println("\n----------- Program 2 -----------");

        int currentRoll = 110;

        System.out.println("Current Roll : " + currentRoll);

        System.out.println("Next Roll : " + students.higherKey(currentRoll));



        // ==========================================================
        // Program 3 : Find Previous Student
        // ==========================================================

        System.out.println("\n----------- Program 3 -----------");

        System.out.println("Previous Roll : " + students.lowerKey(currentRoll));



        // ==========================================================
        // Program 4 : Find Closest Roll Number
        // ==========================================================

        System.out.println("\n----------- Program 4 -----------");

        int searchRoll = 113;

        System.out.println("Search Roll : " + searchRoll);

        System.out.println("Ceiling Roll : " + students.ceilingKey(searchRoll));

        System.out.println("Floor Roll : " + students.floorKey(searchRoll));



        // ==========================================================
        // Program 5 : Remove Boundary Students
        // ==========================================================

        System.out.println("\n----------- Program 5 -----------");

        System.out.println("Removed First : " + students.pollFirstEntry());
        System.out.println("Removed Last : " + students.pollLastEntry());
        System.out.println(students);



        // Reinsert removed entries

        students.put(101, "Rahul");
        students.put(120, "Vikas");



        // ==========================================================
        // Program 6 : Reverse Order Traversal
        // ==========================================================

        System.out.println("\n----------- Program 6 -----------");
        System.out.println(students.descendingMap());



        // ==========================================================
        // Program 7 : Descending Keys
        // ==========================================================

        System.out.println("\n----------- Program 7 -----------");
        System.out.println(students.descendingKeySet());



        // ==========================================================
        // Program 8 : Ascending Keys
        // ==========================================================

        System.out.println("\n----------- Program 8 -----------");
        System.out.println(students.navigableKeySet());

    }

}



/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Interview Questions ==========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Q1. Which interface provides

higherKey()
lowerKey()
floorKey()
ceilingKey()

Ans.
        NavigableMap


------------------------------------------------------------


Q2. Which class implements NavigableMap?

Ans.
        TreeMap


------------------------------------------------------------

Q3. Difference between
    higherKey() and ceilingKey()


higherKey(): Strictly Greater (>)

ceilingKey(): Greater than OR Equal (>=)


------------------------------------------------------------

Q4. Difference between lowerKey() and floorKey()

lowerKey(): 
        Strictly Smaller (<)

floorKey()
        Smaller than OR Equal (<=)

------------------------------------------------------------

Q5. Difference between firstEntry() and pollFirstEntry()

firstEntry(): Returns the entry only.

pollFirstEntry(): Returns + Removes the entry.



------------------------------------------------------------

Q6. Does descendingMap() create another TreeMap?

Ans.

No.
It returns a reverse-order view of the same TreeMap.

*/