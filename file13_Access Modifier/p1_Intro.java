 /* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------------------------- Access Modifier --------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> In java we can apply access modifier within a class or within a packages in which we
   try to import class and their method from one java file to another "class".
-> We can change the access field by applying various Access Modifiers.
-> Access Specifiers help to implement data hiding or data security.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------------------------- Types of Access Modifiers -----------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) Default - No Keyword Required
(2) Private
(3) Protected
(4) Public


(1) Default Access Modifier
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> When we do not specified any Access modifier for a class, method or data member 
   then the java automatically set it to "default access modifier".

   -> It is also known as package-private modifier because classes can only accessed 
   within the same package not from any other package. 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~




(2) Private Access Modifier :
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> It is used to specified using keyword "private".
-> Variable or methods declare as "private" can only be accessed within the same class only.
-> Any class of the same package will not be access to the private variable or method.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



(3) Protected Access Modifier :
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> It is specified by uisng the keyword "protected".

-> 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~




(4) Public Access Modifier :
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> The public declaration of class method or data variables can be access from everywhere.
-> Their is no restriction on the public scope of data members. 
-> These can be accessed from any package.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


 
==================================================================
|  Modifier  |    Class   |    Package  |   Subclass  |  World   |
|================================================================|
| Public     |     ✅    |     ✅      |     ✅     |     ✅   |
=================================================================|
| Protected  |     ✅    |     ✅      |     ✅     |     ❌   |
=================================================================|
| Default    |     ✅    |     ✅      |     ❌     |     ❌   |
=================================================================|
| Private    |     ✅    |     ❌      |     ❌     |     ❌   |  
=================================================================|


