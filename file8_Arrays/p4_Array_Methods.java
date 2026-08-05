
/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-------------------------------- Array class Methods -------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) .length  -> Return the length of the array 
(2) .clone   -> Return a copy of the array
(3) .toString -> Return a string representation of the array
(4) .equals -> Check if two arrays are equal
(5) .sort -> Sort the elements of the array
(6) .binarySearch -> Search for an element in the array
(7) .fill -> Assign a specified value to each element of the array
(8) .copyOf -> Create a new array with a specified length and copy elements from the original array
(9) .copyOfRange -> Create a new array with a specified range of elements from the original array
*/
import java.util.Arrays;

class p4_Array_Methods 
{
    public void methods(int a[]) 
    {
        // .length method
        System.out.println("Length of the array: " + a.length);

        // .clone
        int clone[] = a.clone();
        System.out.println("Cloned array: " + Arrays.toString(clone));

        // .toString
        System.out.println("String representation : " + Arrays.toString(clone));

        // .equals
        System.out.println("Are the arrays equal? " + Arrays.equals(a, clone));

        // .sort
        Arrays.sort(a);
        System.out.println("Sorted array: " + Arrays.toString(a));

        // .binarySearch
        System.out.println("Index of the value (33) is : " + Arrays.binarySearch(a, 33));

        // .fill
        int fillValue = 3;
        Arrays.fill(a, fillValue);
        System.out.println("Array after filling with " + fillValue + ": " + Arrays.toString(a));

        // Example of .copyOf
        int[] copiedArray = Arrays.copyOf(a, a.length);
        System.out.println("Copied array: " + Arrays.toString(copiedArray));

        // Example of .copyOfRange
        int[] copiedRangeArray = Arrays.copyOfRange(a, 1, 3);
        System.out.println("Copied range array: " + Arrays.toString(copiedRangeArray));
    }

    public static void main(String[] args) 
    {
        p4_Array_Methods obj = new p4_Array_Methods();
        int[] arr = { 16, 23, 33, 81, 52};
        obj.methods(arr);
    }
}
