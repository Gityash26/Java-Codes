/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                            LocalTime in java
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

=> The LocalTime is a final class of the Date & Time API in java.

=> It is used to represent 'only the Time'.

=> It does not store Date information.



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Class Information
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Package   :   java.time
Class     :   LocalTime
Category  :   Final Class


~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Why do we use LocalTime?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Whenever an application requires only the Time information,

Examples
    ✔ Office Login Time
    ✔ Meeting Time
    ✔ Train Departure Time
    ✔ Alarm Time

LocalTime should be used.

Since no Date information is required, LocalTime provides a clean and simple representation.





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                        Methods to create LocalTime instance
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Java provides three commonly used static methods.  (same as local date)

    • now()
    • of()
    • parse()


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. LocalTime.now()
------------------------------------------------
    -> Returns the current system time.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
2. LocalTime of(int hour, int minute)
------------------------------------------------
    -> Creates a LocalTime using specified hour and minute.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
3. LocalTime of(int hour, int minute, int second)
------------------------------------------------------------
    -> Creates a LocalTime using hour, minute and second.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
static LocalTime parse(CharSequence text)
------------------------------------------------------------
    -> Creates a LocalTime from a String.
    -> The String must be in ISO format.

Example
    "10:30:45"





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                        Instance Methods of LocalTime Class
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
1. int getHour()
--------------------------------------------------------
2. int getMinute()
--------------------------------------------------------
3. int getSecond()
--------------------------------------------------------
4. LocalTime plusHours(long hours)
--------------------------------------------------------
5. LocalTime minusHours(long hours)
--------------------------------------------------------


===============================================================================
Program
===============================================================================
*/

import java.time.LocalTime;

public class p3_LocalTime
{
    public static void main(String[] args)
    {
        /*=====================================================================
                    Methods to create localTime instance 
        =======================================================================*/


        // now() method  --------> returns current local time
        LocalTime currentTime = LocalTime.now();
        System.out.println("\nCurrent Time : " + currentTime);


        // of() method  --------> returns specified local time
        LocalTime meetingTime = LocalTime.of(10, 30, 45);
        System.out.println("Meeting Time : " + meetingTime);


        // parse() method  --------> returns local time using String ISO format
        LocalTime loginTime = LocalTime.parse("09:15:30");
        System.out.println("Login Time : " + loginTime);



        
        /*=====================================================================
                    Instance methods of LocalTime  
        =======================================================================*/


        // =================== Informational Methods =======================

        System.out.println("\nHour    (using GetHour)    : " + meetingTime.getHour());
        System.out.println("Minute  (using GetMinute)  : " + meetingTime.getMinute());
        System.out.println("Second  (using GetSecond)  : " + meetingTime.getSecond());


        // =================== Data manipulation Methods =======================
        LocalTime nextHour = meetingTime.plusHours(1);
        LocalTime previousHour = meetingTime.minusHours(1);

        System.out.println("\nOriginal Time : " + meetingTime);

        System.out.println("Next Hour     : " + nextHour);
        System.out.println("Previous Hour : " + previousHour);
    }
}


/*
===============================================================================
Working
===============================================================================

LocalTime

    10:30:45
        │
        ├────────────► getHour()
        │                 │
        │                 ▼
        │                10
        │
        ├────────────► getMinute()
        │                 │
        │                 ▼
        │                30
        │
        ├────────────► getSecond()
        │                 │
        │                 ▼
        │                45
        │
        ├────────────► plusHours(1)
        │                 │
        │                 ▼
        │             11:30:45
        │
        └────────────► minusHours(1)
                          │
                          ▼
                      09:30:45


===============================================================================
Important Points
===============================================================================

✔ LocalTime stores only Time.
✔ It does not contain Date information.
✔ LocalTime is immutable.
✔ plusHours() and minusHours() return new LocalTime objects.

===============================================================================
*/