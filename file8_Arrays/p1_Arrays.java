/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------------- Arrays in java ------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> An array is a homogenous and non-primitive data type and it can store primitive types of 
   values(such as integer, float) as well as non-primitive type of values(such as object).
-> It is data structure that allows you to store multiple values of the same type in a single variable.
-> It stores the element of same type in a contiguous memory allocation.
-> Each element in the array is accessed by its index, which starts from 0.
-> Arrays in Java have a fixed length, which means once an array is created, its length cannot be changed.

                                Types of Arrays
             _________________________|________________________________
            |                        |                                |
    Single-dimensional        Multi-dimensional               Jagged arrays.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) Single Dimensional Array:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> A single dimensional array consisting of a Single row having fixed numbers of columns.
-> Each column consist of a value of same type.

~~~~~~~~~~~~~~~~~~~~~~~~
=== syntax:-============
~~~~~~~~~~~~~~~~~~~~~~~~
datatype [] var_name = new datatype[size];

-> example: 
        int[] marks = new int[5];   // Reserve memory for 5 int values

                or 

        int[] var = {v1,v2,v3};   // assign value at delaration time

-> Representation:                               
                                      _____            ______________________________
                            marks[5] |____|      =>   |_____|_____|_____|_____|_____|           
                                                        [0]   [1]   [2]   [3]   [4]  


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------- arr.length ----------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> It is used to get the length of the array.
*/

public class p1_Arrays 
{
    // first method
    public void display_Array(int[] arr) 
    {
        System.out.println("\nDisplaying Array Values (for loop): ");
        for (int i = 0; i < arr.length; i++) 
        {
            System.out.printf("\nValue of arr[%d] : %d", i, arr[i]);
        }
    }

    // second method
    public void display_foreach(int[] arr) 
    {
        System.out.println("\n\nDisplaying Array Values (foreach loop)");
        for (int value : arr) 
        {
            System.out.printf("\nValue : %d", value);
        }
    }

    public static void main(String[] args) 
    {
        p1_Arrays obj = new p1_Arrays();

        // int[] arr = new int[10];
        // arr = new int[] { 2, 4, 6, 8, 10, 12, 14 };
        int arr[] = { 2, 4, 5, 7, 8, 9 };

        obj.display_Array(arr); // Display method calling (for loop)
        obj.display_foreach(arr); // Display method calling (for each loop)

    }
}
