/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------------------------- Strings in JAVA ---------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> String is a class in JAVA but we can use it as a datatype to store strings (collection of characters).
-> Strings are immutable in JAVA.

syntax:
        String obj = new String("Value");      //Using String as class
                     or
        String <var_name> = "<string>";       // Simply using as a datatype
            
example: 
        String name = new String("Harry");
                    or
        String name = "Harry";


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------------------- Different ways to print in JAVA -------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) System.out.print()    -->  just print 
(2) System.out.println()  -->  print with newline at the end
(3) System.out.printf()   -->  print like c language (%d->int , %f->float , %c->char , %s->string)
(4) System.out.format()   -->  same as printf() 




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------------------------------- String Methods ----------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1)-> .length()       -> Return the length of the string
(2)-> .toUpperCase()  -> Returns the String in 'UPPERCASE' 
(3)-> .toLowerCase()  -> returns the string in 'lowercase'
(4)-> .trim()         -> Returns a string after removing leading and preceding whitespace.
(5)-> .subString(start_index , end index) -> Returns a substring from starting index to the end index (end index excludes)
(6)-> .replace(old,new)    -> Returns a string after replacing all the occurence with other value 
(7)->  .startswith("str")  -> Returns True if the string ends with given substring
(8)->  .endswith("str")    -> Returns True if the string starts with given substring
(9)->  .charAt(index)      -> Returns the character present at given index
(10)-> indexOf("str")      -> Returns the first index of given string (if available else -1) 
(11)-> .lastindexOf("str") -> Returns the last occurence of give str or chr
(12)-> .lastindexOf("str",index) -> Return the last occurence of give string before given index
(13)-> .equals("str")           -> Returns True if the string is equal to the given string (With case sensitivity)
(14)-> .equalsIgnoreCase("str") -> Returns True if the string is equal to the given string (without case sensitivity)
(15)-> .contains("str")  -> Check the availability of a given string
(16)-> .compareTo("another str")

*/

public class p1_Strings 
{

    // It shows different ways to print in JAVA
    public void Print_Types(String name) 
    {
        System.out.println("\n~~~~> Types of prints in JAVA <~~~~");

        System.out.print("\nYour string : " + name + "\n");
        System.out.println("Your string : " + name);
        System.out.printf("Your string : %s \n", name);
        System.out.format("Your string : %s \n", name);
    }

    // It shows string methods
    public void string_Methods() 
    {

        System.out.println("\n~~~~> Types of String methods in JAVA <~~~~\n");

        String s = "Hello world   ";
        System.out.println("String length: " + s.length()); // length of the string

        System.out.println("Uppercase string : " + s.toUpperCase()); // Uppercase

        System.out.println("Lowercase string : " + s.toLowerCase()); // lowercase

        System.out.println("Trim string : " + s.trim()); // trim spaces

        System.out.println("Sub string : " + s.substring(3, 7)); // get substring

        System.out.println("Replacing value : " + s.replace('l', 'p'));

        System.out.println("Check startswith : " + s.startsWith("Hel"));

        System.out.println("Check endswith : " + s.endsWith("ld"));

        System.out.println("Check character at index 8 : " + s.charAt(8));

        System.out.println("check index of String 'world' : " + s.indexOf("world"));

        System.out.println("Match equal string : " + s.equals("Hello world   "));  // case sensitive

        System.out.println("Match equal_Ignore string : " + s.equalsIgnoreCase("HELLO WORLD   "));  // without case sensitive

        System.out.println("Contains a value : " + s.contains("Hello"));
    }

    public static void main(String[] args) {

        p1_Strings obj = new p1_Strings();

        String name = "Yash"; // Declaring a string

        obj.Print_Types(name);
        obj.string_Methods();
    }
}
