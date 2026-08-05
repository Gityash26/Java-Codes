/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================------ Polymorphism in JAVA -------============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> The Polymorphism is comprises of two words Poly(many) + morph(forms) that simply means create
   an entity that having same name but different forms of functionality.

-> polymorphism in JAVA is used to treat object of multiple classes as an object of common superclass. 

-> It enable you to write a more flexible and reusable code that allows different class to use interchnagebly
   when they shares a common interface. 

   for example: 
   Polymorphism is just like a Universal remote that can be used to control multiple devices (such as TV, Speaker, DVD, AC etc)
   just with the help of a single remote control.

                                                     _______________
                                                    |   [o]   [O]  |
                                                    |  [1] [2] [3] |    
                                                    |  [4] [5] [6] |    
                                                    |  [7] [8] [9] |    
                                                    |     _____    |    
                                                    | [] |____| [] |    
                                                    |      []      |    
                                                    |______________|    
                                                    Universal Remote                                  
                                                           |
                                                           |
                     ______________________________________|_________________________________
                    |                                                                       |
             _______|______________                                                 ________|__________
            | ------------------- |                                                |+----------------+|
            ||                   ||                                                ||______DVD_______||
            ||   Television      ||                                                |+----------------+|
            ||-------------------||
            |_____________________|
                     /____\
                        
                                                                            

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================------ Types of Polymorphism -------===========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    
                         __________________|_______________________
                 _______|_______                            ______|_______
                | Compile Time |                           |  Run Time   |
                |_Polymorphism_|                           |_Poymorphism_|



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----- Compile Time Polymorphism ---------- (Early Binding)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=> Compile-time polymorphism in Java is achieved through method overloading. 

-> Operator Overloading: (NOT SUPPORTED) 
   It is used to overload an operator to perform different functionality other than its predefined meaning.
   It is also a compile time polymorphism but java does not support Operator Overloading
   due to multiple meaning of a same operator create confusion and inconvinient to maintain.

-> Method overloading: 
   It allows a class to have more than one method having the same name but different functionaliy. 



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------- Run Time Polymorphism ---------- (Late Binding)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=> Run-time polymorphism in Java is achieved through method overriding at Run time using inheritance. 

-> Method overriding: 
   It is used to determine which method is to be execute when same name method defined in the child as well as parent class.
   
*/