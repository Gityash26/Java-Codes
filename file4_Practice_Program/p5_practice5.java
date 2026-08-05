package file4_Practice_Program;

import java.util.Arrays;

public class p5_practice5
{
    public static void main(String[] args) 
    {
        int[] a = {1, 4, 6, 8, 2, 3, 7, 1, 3, 2, 1, 6 , 7, 4};

        System.out.println("Original Array : " + Arrays.toString(a));
        
        a = removeDuplicates((a));

        System.out.println("No Duplicates Array : " + Arrays.toString(a));

    }

    public static int[] removeDuplicates(int[] arr)
    {
        if(arr.length == 0 )
            return arr;
        
        Arrays.sort(arr);
        int[] tem = new int[arr.length];
        int j=0;

        for(int i=0 ; i<arr.length-1 ; i++)
        {
            if(arr[i] != arr[i+1])
                tem[j++] = arr[i];
        }
        tem[j++] = arr[arr.length -1];
        return Arrays.copyOf(tem, j);
    }
}