/* 

-------------------------------------------
========== Students Example ===============
-------------------------------------------

-> Lets take an example of Students data in a school or University, 
   So, each and every student of a class having a unique roll no. that helps to identify the student record effeciently.



                               /-> Student name
                              |->  Student age
   Roll no. ------------------\->  Student address
                               \->  Student marks
                                \-> Student phone no. etc....


-------------------------------------------
========== Library Example ===============
-------------------------------------------
-> In a library we have a large no. of books of different subjects, categories and authors.
-> In order to manage, issue and keeping records of the books, we can use the 'Hashing' technique.
-> In hashing each book assigned with a unique 'Key_Id' or 'Book_Id' that hepls to identify the book Issue record, 
    position in the self, and other details.



                               /-> Data Structure and Algorithm Book 
                              |->  Author name: Prakash Kumar
    DsaBookA23 ---------------\->  Self No. 23
                               \-> Price: 500
                                \-> Publisher: XYZ
                                 \-> Pages: 500 etc.... 





~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Hashing Introduction ==========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Hashing is a technique in which we can store and retrieve the data in an efficient way that provides constant time 
   access O(1) time complexity.

-> Hashing is required because "Keys" that are used for uniquely identify the 'data values', are not always a single integers value 
   that we can use as an index in an array.

-> Keys can be like this : 
   Book Id--------> DsaBookA23, javaBookB45, pythonBookC67
   Student Roll No. ----> AB101, CollegeCode102, HBlock103

-> Thats, why in hashing {Complex keys} are converted into a simple {Index_key} that provides a unique index to store and 
   retrieve the data in an efficient way like arrays.

                         ____________________             ___________________________
                        |  int Hash (Key)   |            |__Index___|____Key________|
                        |   {               |            |_____2____|__DsaBookA23___|
  UniqueKey-----------> |     some logic;   | ---------> |_____5____|__javaBookB45__|
                        |     retrun index; |            |_____7____|__pythonBookC67_|
                        |   }               |            |_____9____|__javaBookB45__|
                        |___________________|                   Hash Table
                            hasfunction

Notes: Basically the logic is to convert a "complexKey" into a simple "IndexKey" that can be used as an index in an array.
       So, that we can store and retrieve the data in an efficient way.
       And mapping of the complex key to the index key is stored inside the "Hash Table".



=============================
(1) Hashing : 
=============================
-> Technique of converting a complex key into a simple index key that can be used as an index in an array.

=============================
(2) Hash Function : 
=============================
-> A function with some mathematical logic that converts a complex key into a simple index key.

=============================
(3) Hash Table :
=============================
-> A data structure that stores the mapping of complex key to the index key.



*/


 
// Question: An array is given with some elements range from,  -MIN_Num
//           our task is to search for a element in the array in O(1) time complexity.



class Hashing 
{
    final int max = 1000;
    boolean[][] hashArray = new boolean[max+1][2];

    public void insert(int[] array)
    {
        for(int i=0 ; i < array.length ; i++)
        {
            if(array[i] >= 0)
            {
                hashArray[array[i]][0] = true;
            }
            else
            {
                hashArray[Math.abs(array[i])][1] = true;
            }
        }
    }

    public boolean search(int num)
    {
        if(num >= 0)
            return hashArray[num][0];
        else
            return hashArray[Math.abs(num)][1];
    }
}



public class p1_IntroToHash 
{
    
    public static void main(String[] args) 
    {
        Hashing obj = new Hashing();
        int[] array = {-1, 9, 2, -5, 7, 5};
        
        obj.insert(array);

        System.out.println("Search for -5 : " + obj.search(-5));
        System.out.println("Search for 7 : " + obj.search(7));
        System.out.println("Search for 10 : " + obj.search(10));
        System.out.println("Search for -5 : " + obj.search(-5));
        System.out.println("Search for -3 : " + obj.search(5));

    }
}
