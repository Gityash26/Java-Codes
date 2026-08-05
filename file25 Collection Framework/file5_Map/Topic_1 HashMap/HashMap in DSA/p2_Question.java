/* 
Ques: Create a HashMap using java HashMap class to store the following pairs (Person, Age) and display them.

Input:
        Akash    21
        Yash     16
        Lavish   24
        Rashika  34
        Harry    18


Output:
        Age of Akash is 21
        Age of Yash is 16
        Age of Lavish is 24
        Age of Rashika is 34
        Age of Harry is 18

        


*/

import java.util.HashMap;
import java.util.Map;

public class p2_Question 
{
    public static void main(String[] args) 
    {
        HashMap<String, Integer> map = new HashMap<>();

        // adding entries
        map.put("Akash", 21);  
        map.put("Yash", 16);  
        map.put("Lavish", 24);  
        map.put("Rashika", 34);  
        map.put("Harry", 18);  
        
        // displaying entries 
        for(Map.Entry<String, Integer> e : map.entrySet())
        {
            System.out.println("Age of " + e.getKey() + " is " + e.getValue());
        }



    }    
}
