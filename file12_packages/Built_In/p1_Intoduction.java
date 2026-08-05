package file12_packages.Built_In;

/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
==============================--- Packages in JAVA ----============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> The concept of Packages in JAVA is used for a well structure arrangement of similar kind of 
   files, classes, or Interfaces.

-> Just like a person create folder or sub folders to store and arrange their files such as, 
   videos, movies, musics, pictures etc.

-> Similarly packages in java are used to label and store files that having classes and methods having similar purpose,
   Into a single package(folder).

-> It promotes modularity so that we can easily import those classes or packages at the application or program that having 
   final implementation of presenting data.


   
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
==================== Advantages of Packages ========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   -> Organization of Code :
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   Packages allows you to logically group related classes and interfaces together.
   This Organization help for easy navigation as well as understanding the codebase.


   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   -> Avoiding Naming Conflicts:
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   Packages provide namespaces, allowing classes with the same name to exist in different packages without conflicts. This is similar to having different folders where files with the same name can exist.

   
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   -> Access Control:
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   Packages allows to implement access control by defining various Visibility levels (public, Private, Protected) for classes and methods.
   They are used to define the accessibility level or access field of those classes and methods in our project.
   
   
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   -> Reusability and Modularity: 
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   The classes define inside a package can be reused in other projects also or even within the same project without any conflict.

   Packages encourage modular design by allowing creating seprate packages for every different functionalities, This modularity enhance code maintainability and scalability.    
   
   
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   -> Encapsulation and Information Hiding:
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   Packages support encapsulation by allowing you to hide details of classess. Classes can be marked as 'private' that can only be accessed within the class, ensuring a level of encapsulation.


   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   -> Simplified Imports:
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   We can simply import the package that we require and then we dont't require to type complete path each time to use any class or method present inside the package.That makes it simple to just import and ready to use.


   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   -> Third-party and APIs:
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   Libraries and APIs often using packages to organize their functionalities. Importing such third part code become more manageable when organized into packages.

   
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   -> Team Collaboration: 
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   Packages are also helps in team based development. As tasks can be divide among various developers without any code change or conflict.



                                 =======================================
                                 ~~~~~~~ Types of Packages in JAVA ~~~~~
                                 =======================================
                         __________________________|___________________________
                        |                                                     |
                 Built-In Packages                                   User Defined Packages


                 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=======================---- Built In Packages ----===========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Built-In packages in java comes with the Java Development Kit => (JDK).

-> They are the part of Java API (Application programming Interface) that provide essential functionalities.

-> These Built-In packages contains a vast collection of classes and interface that enables a developer to just 
   import and use them without implementing from scratch.
   
   
   
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
-> Some Example of Built-Int Packages:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
(1) java.lang
(2) java.util
(3) java.io
(4) java.net



~~~~~Representation~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                          _____
                         |     \_____                
                         |           |  
                         |___________|
                          java folder
      __________________________|_________________________________________
     |                          |                     |                  | 
    _____                     _____                 _____               _____
   |     \_____              |     \_____          |     \_____        |     \_____
   |          |              |          |          |          |        |          |
   |__________|              |__________|          |__________|        |__________|
    'lang' foder               'util' folder          'io' folder        'net' folder 



-> Therefore, their is a 'java folder' contains subfolders 'lang','util','io','net'. 
-> Those subclasses further contains implementation of diffrent classes.
-> If we require to import those classes then we can simply import them like,


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> syntax to Import  '.' operator is used that represent '\' backslash in a path)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
       import java.lang.<specific_className>;
  
                 OR
  
       import java.lang.*;

  -> * star represent to import all the available classes.


*/


import java.lang.Math;

class p1_Inroduction {
   public static void main(String[] args) {

      int a = 25;
      System.out.println("Square Root of " + a + " is : " + Math.sqrt(a));
   }
}



