/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(3) Jagged Array -------------------------------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Jagged array is a type of array where each row can have different numbers of columns.
-> It means that when we create a multi-dimensional array suppose of size 3 x 3, then it create 
   an array having 3 Rows and each Row having 3 Columns.
-> But in jagged array each row can have different numbers of columns.


~~~~~~~~~~~~~~~~~~~
~~~~ syntax ~~~~~~~
~~~~~~~~~~~~~~~~~~~

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Method-1 : Statically assign Both size and values:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   int[][] a = {{10,20,30},{44,55},{6,7,8,9}};

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Method-2 : Empty Jagged Array (Row size required)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   int[][] a = new int[3][];  // fixed row size
  
   a[0] = new int[column];    ___
   a[1] = new int[column];      |---- Seperately fixing column of each row
   a[2] = new int[column];    __|

   
*/




import java.util.Scanner;

class Jagged 
{
   private int[][] a;

   // Scanner Object
   Scanner sc = new Scanner(System.in);

   // Constructor
   public Jagged() 
   {
      System.out.print("\nRow Size you Want : ");
      int row = sc.nextInt();
      a = new int[row][];
      System.out.printf("=> %d Rows fixed Successfully\n", row);
   }

   // Dynamically set column and values
   public void setColumn() 
   {
      for (int i = 0; i < a.length; i++) 
      {
         System.out.printf("\nColumns Size Required for Row %d : ", i + 1);
         int column_Size = sc.nextInt();

         a[i] = new int[column_Size];
         System.out.println("Columns sucessfuly fixed");
         SetValues(i);
      }
   }

   // Set values
   public void SetValues(int row) {
      System.out.println("\nEnter your array values : \n");
      for (int i = 0; i < a[row].length; i++) {
         System.out.printf("-> Value %d : ", i + 1);
         int value = sc.nextInt();
         a[row][i] = value;
      }
   }

   // Display jagged array in a table-like format
   public void displayArray() {
      System.out.println("\nYour Jagged Array : \n");
      int count=0;
      for (int[] row : a) {
         System.out.printf("Row %d -> ",++count);
         for (int col : row) {
            System.out.print("[" + col + "]  ");
         }
         System.out.println("\n");
      }
   }
}

public class p3_JaggedArray 
{
   public static void main(String[] args)  
   {
      Jagged ob = new Jagged();
      ob.setColumn();
      ob.displayArray();
   }
}