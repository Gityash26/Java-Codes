/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                            LocalDate in Java
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

=> The LocalDate is a final class of the Date & Time API in java.

=> It is used to represent 'only the Date' (Year, Month, Day).

=> It does not store Time information.


~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Class Information
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Package   :   java.time
Class     :   LocalDate
Category  :   Final Class


~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Why do we use LocalDate?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Whenever an application requires only the Date information,

Examples
    ✔ Birth Date
    ✔ Joining Date
    ✔ Exam Date
    ✔ Invoice Date

LocalDate should be used.

Since no Time information is required, LocalDate provides a clean and simple representation.


~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                        Methods to create LocalDate instance
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Java provides three commonly used static methods.  

    • now()
    • of()
    • parse()


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. LocalDate.now()
------------------------------------------------
    -> Returns the current system date.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
2. LocalDate.of(int year, int month, int dayOfMonth)
------------------------------------------------------------
    -> Creates a LocalDate using specified year, month and day.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
3. LocalDate.parse(CharSequence text)
------------------------------------------------------------
    -> Creates a LocalDate from a String.
    -> The String must be in ISO format.

Example
    "2026-07-19"



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                        Instance Methods of LocalDate Class
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
1. int getYear()
--------------------------------------------------------
2. Month getMonth()
--------------------------------------------------------
3. int getDayOfMonth()
--------------------------------------------------------
4. LocalDate plusDays(long days)
--------------------------------------------------------
5. LocalDate minusDays(long days)
--------------------------------------------------------


===============================================================================
Program
===============================================================================
*/

import java.time.LocalDate;

public class p2_LocalDate
{
    public static void main(String[] args)
    {
        /*=====================================================================
                    Methods to create LocalDate instance 
        =======================================================================*/

        // now() method  --------> returns current local date
        LocalDate currentDate = LocalDate.now();
        System.out.println("\nCurrent Date : " + currentDate);

        // of() method  --------> returns specified local date
        LocalDate birthDate = LocalDate.of(2002, 10, 15);
        System.out.println("Birth Date   : " + birthDate);

        // parse() method  --------> returns local date using String ISO format
        LocalDate joiningDate = LocalDate.parse("2026-07-19");
        System.out.println("Joining Date : " + joiningDate);



        /*=====================================================================
                    Instance methods of LocalDate  
        =======================================================================*/

        // =================== Informational Methods =======================

        System.out.println("\nYear   (using getYear)       : " + joiningDate.getYear());
        System.out.println("Month  (using getMonth)      : " + joiningDate.getMonth());
        System.out.println("Day    (using getDayOfMonth) : " + joiningDate.getDayOfMonth());


        // =================== Data manipulation Methods =======================

        LocalDate nextWeek = joiningDate.plusDays(7);
        LocalDate previousWeek = joiningDate.minusDays(7);

        System.out.println("\nOriginal Date : " + joiningDate);
        System.out.println("Next Week     : " + nextWeek);
        System.out.println("Previous Week : " + previousWeek);
    }
}

