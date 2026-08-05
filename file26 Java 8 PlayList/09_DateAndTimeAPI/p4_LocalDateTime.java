/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                    LocalDateTime class in java 
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~


This is also a final class of the java8 Date & Time API.
It is used to represent both - "Date and Time" together.

It stores

    ✔ Year ✔ Month ✔ Day         <--- Date information
    ✔ Hour ✔ Minute ✔ Second     <--- Time information



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Why do we use LocalDateTime?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Whenever an application requires both Date and Time,

Examples
    ✔ Order Date & Time
    ✔ Account Login Date & Time
    ✔ Attendance Record
    ✔ Transaction Date & Time



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Methods to create LocalDateTime instance
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Java provides three commonly used static methods.
    • now()
    • of()
    • parse()


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. LocalDateTime.now()
~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
    -> simple returns current date and time details

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
2. LocalDateTime.of(year, month, dayOfMonth, hour, minute)
~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
    -> Simply returns specified date and time details 


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
3. LocalDateTime parse(CharSequence text)
~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
    -> Creates a LocalDateTime from a String.

Example
    "2026-07-20T10:30:45"



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Common Instance Methods
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

int getYear()                           <------ return year
------------------------------------------------------
Month getMonth()                        <------ return month
------------------------------------------------------
int getDayOfMonth()                     <------ return day
------------------------------------------------------
int getHour()                           <------ return hour details
------------------------------------------------------
int getMinute()                         <------ return minute details
------------------------------------------------------
int getSecond()                         <------ return minute details
------------------------------------------------------
LocalDateTime plusDays(long days)      
------------------------------------------------------
LocalDateTime minusDays(long days)     
------------------------------------------------------
LocalDateTime plusHours(long hours)    
------------------------------------------------------
LocalDateTime minusHours(long hours)   
------------------------------------------------------


===============================================================================
Program
===============================================================================
*/

import java.time.LocalDateTime;

public class p4_LocalDateTime
{

    public static void createLocalDateTime()
    {
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime meeting = LocalDateTime.of(2026, 7, 20, 10, 30, 45);
        LocalDateTime joining = LocalDateTime.parse("2026-07-20T09:15:30");

        System.out.println("Current : " + current);
        System.out.println("Meeting : " + meeting);
        System.out.println("Joining : " + joining);
    }

    //========================================================

    public static void informationMethods()
    {
        LocalDateTime meeting = LocalDateTime.of(2026, 7, 20, 10, 30, 45);

        System.out.println("\nInformation Methods");

        System.out.println("Year   : " + meeting.getYear());
        System.out.println("Month  : " + meeting.getMonth());
        System.out.println("Day    : " + meeting.getDayOfMonth());

        System.out.println("Hour   : " + meeting.getHour());
        System.out.println("Minute : " + meeting.getMinute());
        System.out.println("Second : " + meeting.getSecond());
    }

    //========================================================

    public static void manipulationMethods()
    {
        LocalDateTime meeting = LocalDateTime.of(2026, 7, 20, 10, 30, 45);

        System.out.println("\nManipulation Methods");

        System.out.println("Original  : " + meeting);
        System.out.println("Next Day  : " + meeting.plusDays(1));
        System.out.println("Next Hour : " + meeting.plusHours(2));
    }

    public static void main(String[] args)
    {
        createLocalDateTime();
        informationMethods();
        manipulationMethods();
    }

}

