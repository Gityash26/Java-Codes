/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Ques: Given an array, find the most frequent element in it. If there are multiple elements that appear a miximum
      number of times, print any one of them.


Input:
------------------
n = 6
arr[] = {1, 3, 2, 1, 4, 1}

Output:
------------------
1


Solution Algo:

step1: traverse the array
step2: Insert array value as 'key' and the occurence as value
step3: during insertion check if the key already exist
       if yes, 
                Increase value + 1
        else 
                insert the key - value

step: return the maximum value

*/

import java.util.HashMap;

public class p3_Question 
{
    public static void main(String[] args) 
    {
        int arr[] = {1, 3, 7, 2, 4, 1, 5, 6, 4, 6, 8};
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFrequentNum = -1, frequency = 0;

        for(int key : arr)
        {
            if(!map.containsKey(key)) 
            {
                map.put(key, 1);
            } 
            else 
            {
                int newValue = map.get(key) + 1;
                map.put(key, newValue);

                if(frequency < newValue)
                {
                    frequency = newValue;
                    maxFrequentNum = key;
                }
            }
        }

        if(maxFrequentNum != -1)
            System.out.println("\nNumber " + maxFrequentNum + " repeating maximum " + frequency + " times...");
        else 
            System.out.println("\nNo repeating elements...");
    }    
}
 