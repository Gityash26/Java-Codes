/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------ what is Abstract -----------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> The word 'Abstract' simply means existance in thoughts and idea without any physical 
   existance.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 Abstract method
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> A method that is declared without any implementation is known as Abstract method.
  
syntax:
        abstract void Display(int a, int b);
       

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 Abstract class
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> If a class contains abstract method then the entire class will be declared as abstract class.

syntax:
        abstract class Car
        { 
            abstract void Display(int a, int b);
            
            //more code or more methods
        }

        


~~~~~~~~~~~~~~~~~~~~~
 ::: for exmple :::
~~~~~~~~~~~~~~~~~~~~~

class Car 
{
    public void Drive()
    {
        // I dont't know how to define a Drive method 
    }

    public void playMusic()
    {
        System.out.println("Playing music...");
    }
}  

-> In the above example we created a class 'Car' having two methods (Drive) and (Playmusic) but define only one method.
-> Therefore in java Abstract keyword facilitate to just declare the method without defining it and the subclass having 
   the responsibility to define those abstract method in its own class.

Note:
-> A class having abstract method called as a Abstract class.
-> We cannot create object of abstract class.
-> subclass extends an abstract class must define the abstract methods.
-> It is not necessary for an abstrat class to have abstract methods only
   Abstract class can have -> All the non abstract methods
                           -> All the abstact methods.
                           -> Abstract and non-Abstract methods both 
*/

// Abstract class______________________________
abstract class Car 
{
    // declaration of abstract method
    abstract void Drive();

    // definition of method payMusic 
    public void playMusic()
    {
        System.out.println("Playing music...");
    }
} 

// Concrete class_____________________________
class WagnoR extends Car
{
    // Car class don't have Drive method definition but child class should have its 
    // definition to being a proper car entity
    public void Drive()
    {
        System.out.println("Driving WagnoR...");
    }
}

public class p1_Intro {
    public static void main(String[] args) {
        WagnoR car1 = new WagnoR();
        car1.Drive();
        car1.playMusic();
    }    
}

