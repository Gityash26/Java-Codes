/*
===============================================================================
                        Period Duration And Formatter
===============================================================================

Definition

Java provides some special classes to calculate the difference between 'Date' and 'Times'.

It also provides a formatter class to display Date and Time in the required format.

These classes are

• Period
• Duration
• DateTimeFormatter


===============================================================================
Class Information
===============================================================================
____________________________________________________________________________________________
│ Package        │=>     java.time       │=>     java.time.format                          │
│________________│_______________________│_________________________________________________│
│                │                       │                       │                         │
│ Classes        │=>     Period          │=>     Duration        │=> DateTimeFormatter     │
│________________│_______________________│_______________________│_________________________│



-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
When should we use them?
-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=


=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
1. Period
===================================
        The period class is used to calculate the difference between two Dates.
        Example,
Joining Date → Current Date



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
2. Duration
===================================

        The duration class is used to calculate the difference between two Times.
        Example
Login Time → Logout Time



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
3. DateTimeFormatter
===================================
        The DateTimeFormatter is Used to format Date & Time into a user-friendly format.
        Example

20-07-2026
instead of  ===> 2026-07-20


===============================================================================
Program
===============================================================================
*/

import java.time.*;
import java.time.format.DateTimeFormatter;

public class p5_PeriodDurationAndFormatter
{
    public static void periodExample()
    {
        System.out.println("\n========== Period class (Date difference)==========\n");

        LocalDate DOB = LocalDate.of(2002,10,13);   // yyyy/MM/DD   -- Date of birth
        LocalDate today = LocalDate.now();          // current date

        Period period = Period.between(DOB, today);

        System.out.println("Years  : " + period.getYears());
        System.out.println("Months : " + period.getMonths());
        System.out.println("Days   : " + period.getDays());

    }


    //============================================================

    public static void durationExample()
    {
        System.out.println("\n========== Duration Class (Time difference) ==========\n");

        LocalTime login = LocalTime.of(9,30);
        LocalTime logout = LocalTime.of(18,15);

        Duration duration = Duration.between(login, logout);

        System.out.println("Hours   : " + duration.toHours());
        System.out.println("Minutes : " + duration.toMinutes());

    }


    //============================================================

    public static void formatterExample()
    {
        System.out.println("\n========== Formatter Class ==========\n");

        // current loacal date object 
        LocalDate today = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formattedDate = today.format(formatter);

        System.out.println("Formatted Date : " + formattedDate);
    }

     public static void main(String[] args)
     {
        periodExample();
        durationExample();
        formatterExample();
     }
}

