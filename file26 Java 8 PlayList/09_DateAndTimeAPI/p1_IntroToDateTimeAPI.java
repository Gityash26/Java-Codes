/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                Introduction To DateTime API
===============================================================================

Definition

Date & Time API is a modern API introduced in Java 8 for handling date and time.

It replaces the older Date and Calendar classes and provides a simpler, immutable 
and thread-safe approach for working with dates and time.


~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Why was Date & Time API introduced?
===============================================================================

Before Java 8,

Java provided
    • Date
    • Calendar

These classes had several problems.

    ✘ Difficult to use.
    ✘ Mutable (values can be modified).
    ✘ Not Thread Safe.
    ✘ Many confusing methods.

To overcome these limitations, Java 8 introduced the Date & Time API.


===============================================================================
Main Classes
===============================================================================



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
LocalDate 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=> Represents only the Date.

Example
    2026-07-19



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
LocalTime
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=> Represents only the Time.

Example
    10:30:45



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
LocalDateTime
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=> Represents both Date and Time.

Example
    2026-07-19T10:30:45




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Period
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=> Represents the difference between two Dates.

Example
    5 Years
    2 Months
    10 Days




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Duration
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=> Represents the difference between two Times.

Example
    3 Hours
    25 Minutes



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DateTimeFormatter
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Used to format and parse Date & Time.




~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Hierarchy
===============================================================================

Date & Time API
        │
        ├── LocalDate          (provides only date)
        │
        ├── LocalTime          (provides only time)
        │
        ├── LocalDateTime      (provides date and time)
        │
        ├── Period             (provides differrence b/w two dates)
        │
        ├── Duration           (provides differrence b/w two time)
        │
        └── DateTimeFormatter  (modify date and time parse)



        
===============================================================================
Remember
===============================================================================

✔ Introduced in Java 8.
✔ Replaces Date and Calendar.
✔ Immutable.
✔ Thread Safe.
✔ Easy to use.

===============================================================================
*/