/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(2) Multidimensional Array 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> It is said to be as an Array of Array as it contains more than 1 dimensions.
-> In Simple words a multidimensional array consist of more than one 1-Dimensional array.

syntax:
         int[][] arr = new int[row][column];

ex:   
         int[][] a = new int[3][3];
    
Representation:
                     _____________________
                0   |__v1__|__v2__|__v3__|
                1   |__v4__|__v5__|__v6__|
                2   |__v7__|__v8__|__v9__|
                       0      1       2
 

*/

class p2_Multi_Dimensional 
{
    public static void main(String[] args) 
    {
        // 2D Array
        int[][] a = new int[3][3];

        a[0][0] = 10;
        a[0][1] = 20;
        a[0][2] = 30;
        a[1][0] = 11;
        a[1][1] = 22;
        a[1][2] = 33;
        a[2][0] = 12;
        a[2][1] = 13;
        a[2][2] = 14;

        // Display using for loop
        System.out.println("\nDisplay array values (for loop)");
        for (int i = 0; i < a.length; i++) 
        {
            for (int j = 0; j < a[0].length; j++) 
            {
                System.out.printf("\na[%d][%d] : %d", i, j, a[i][j]);
            }
        }

        

        // Display using for each loop
        System.out.println("\n\nDisplay array values (for each loop)");

        for (int[] row : a) 
        {
            for (int value : row) 
            {
                System.out.println(value);
            }
        }
    }
}