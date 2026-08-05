/* 
============================================================
-------- Basic mathematical Set Operations -----------------
============================================================

------------------------------
(1) Union (A U B)
------------------------------
=> Set of all the distinct elements of A and B
=> use method to perform intersection operation is --> A.addAll(B)


------------------------------
(2) Intersection (A ∩ B)
------------------------------
=> Set of all the common elements in A and B
=> use method to perform intersection operation is --> A.retainAll(B) 


------------------------------
(3) Difference (A - B)
------------------------------
=> Set of all the elements that are present in A but not in B
=> use method to perform intersection operation is --> A.removeAll(B)


------------------------------
(4) Subset (A ⊆ B)
------------------------------
=> A is subset of B if all the elements of A are present in B
=> use method to perform intersection operation is --> B.containsAll(A)


------------------------------
(5) Superset (A ⊇ B)
------------------------------
=> A is superset of B if all the elements of B are present in A
=> use method to perform intersection operation is --> A.containsAll(B)

*/

import java.util.HashSet;
import java.util.List;

public class p2_Set_MathOpt 
{
     static void basicMathSetOperation(HashSet<Integer> A, HashSet<Integer> B)
    {
        // Union of two sets
        System.out.println("\nSet A : " + A + "\nSet B : " + B);
        A.addAll(B);
        System.out.println("Union of A and B: " + A);
        
        // Intersection of two sets
        System.out.println("\nSet A : " + A + "\nSet B : " + B);
        A.retainAll(B);
        System.out.println("Intersection of A and B: " + A);
        
        // Difference of two sets
        System.out.println("\nSet A : " + A + "\nSet B : " + B);
        A.removeAll(B);
        System.out.println("Difference of A and B: " + A);
        
        // Subset of two sets
        System.out.println("\nSet A : " + A + "\nSet B : " + B);
        System.out.println("Is A subset of B: " + B.containsAll(A));
        
        // Superset of two sets
        System.out.println("\nSet A : " + A + "\nSet B : " + B);
        System.out.println("Is A superset of B: " + A.containsAll(B));

    }


    public static void main(String[] args) 
    {
        // creating Set A 
        HashSet<Integer> A = new HashSet<>(List.of(1, 3, 5, 7, 9, 2, 5, 6, 8));        
        // creating Set B 
        HashSet<Integer> B = new HashSet<>(List.of(3, 4, 5, 6, 7, 8, 9, 10));        

        basicMathSetOperation(A, B);

    }
}
 