/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============== Names In String =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Ques: There is a String array contains the name of some students, You have to sort
      the array using string comparision
 
*/

import java.util.Arrays;

public class p6_NameStringSort 
{
    public static void main(String[] args) 
    {
        String[] names = {"Sanjay", "Kunal", "Sachin", "Shreya", "Nisha", "Deepak"};    

        for(int i=0 ; i<names.length ; i++)
        {
            for(int j=0 ; j<names.length ; j++)
            {
                int res = names[j].compareToIgnoreCase(names[i]);

                if(res > 0)
                {
                    String tem = names[i];
                    names[i] = names[j];
                    names[j] = tem;
                }   
            }

        }
        System.out.println(Arrays.toString(names));
    }
    
}
