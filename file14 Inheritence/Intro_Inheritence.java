/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Inheritence In JAVA =============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Inheritence is one of the core concept of Object Oriented programming.
-> It allows user to create a new class by inheriting the 'properties' and 'Behaviours' of an existing class.
-> It is a powerful tool of OOps in which we don't require to write thousands of line of code again for writing a
   program for an entity that having similar functionality just like existing class but with some additional functionality.
-> Inheritence promotes code reusability and creating a hierarchy  of classes.

-> Class inheriting its properties called Base class (parent class)
-> class inherit properties of an existing class called as a Derived class (child class)

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~ syntax:~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 class BaseClass
 {
    Properties;
    Bahaviours;
 }
                                             ____________________________________________________________ 
                   _________________________ \'extends' keyword is used for inheriting Base to Derived) /
                  |                           \________________________________________________________/
 class Derived extends BaseClass
 {
    Aditional Properties;
    Additional Behaviours;
 } 


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Types of Inheritence =============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) Single level Inheritence:
    In this type of Inheritence their is only a single parent class and a derived class.  
    And parent class inherit its Properties & Behaviours to derived class.

      ________________
     |____Employee___| 
            |                        <-------- single-level Inheritence
       _____|__________         
      |___Programmer__|   


     
(2) Multi-level Inheritence :
    In this type of inheritence a parent class inherit into derived class and this derive class further derived into next class.
    it is like a straight chain like structure.  []-->[]-->[]-->[]-->[]-->[]
      _______________
     |__GrandFather__|
     _______|_________
    |____Father______|
     _______|_________
    |____Child_______|
   

(3) Hierarchical Inheritence:
    In this inheritence a single class inherits its properties into multiple classes just like a 
    company organizational structure. (superior-> subordinates)
                         _______________
                        |_____person___|
            ___________________|____________________ 
   ________|____________                   ________|_____________
  |_FullTime_Employee__|                  |_partTime_Employee___|
     
    
(4) Multiple Inheritence:
    In this inheritence multiple parent classes inherit into a single deive class.
    This multiple inheritence is not supported in JAVA as it create a confusion and complex to maintain But, 
    can be impleent using concept of interfaces (Going to learn further).
  
       ______________                 ________________  
      |____person___|                |___Employee____|  
                |____________________________|
                        _____|_______
                       |___Teacher__|

(5) Hybrid :
    When we implement more than one type of inheritence then it is called as hybrid inheritence.
                            _______________
                           |_Grand Father_|
                             _____|_______              <--------- single-level Inheritence
                            |___Father___|
                    ______________|________________
               ____|________                 _____|_____   <--------- Multilevel Inheritence           
              |__Daughter__|                |___Son____|           





*/
