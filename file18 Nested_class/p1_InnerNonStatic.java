/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============ Nested Class in Java ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> In java we can define a class within another class and make a Nested structure of classes.

for example:       class OuterClass
                    {
                        // code...     ------------
                                                  |
                        class InnerClass          |
                        {                         |
                            // code... <----------| (accessible here..)
                        }
                    }


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  ============== There are Two types of Nested CLass ========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  

(1) Non - static Nested class

(2) Static Nested class



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) Non-Static Nested Class ---------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> A non static class is nested inside another Outer class.
-> Inner class has the access to the methods of Outer class
-> Note that, we can only create the Instance of 'Inner' class using the Instance of the 'Outer' class.

-> Inner class can access the data memeber of Outer class using..

syntax:
    <OuterClassName>.<this>.<DataMember>    // this.dataMember

-> In this syntax we are using 'OuterCLassName' first then 'this.dataMember' because without class name it represnt member of Inner class





*/

class Computer
{
    String modelName;
    String type;          // desktop or laptop

    // assign the values using constructor
    public Computer(String modelName, String type)
    {
        this.modelName = modelName;
        this.type = type;
    } 

    private String getModelName()
    {
        return this.modelName;
    }

    // Inner Class
    class Memory
    {
        String memoryType;

        public void setMemory()
        {
            // Accessing the computer type 

            if(Computer.this.type == "desktop")
                this.memoryType = "DDR4 8GB Desktop RAM";

            else if(Computer.this.type == "laptop")
                this.memoryType = "DDR4 8GB Laptop RAM";

            else 
                this.memoryType = "4GB Normal RAM";
        }

        public String getDetails()
        {
            String str = "\nComputer : " + getModelName() + "\nMemory : " +  this.memoryType; 
            
            return str;
        }
    }
}


public class p1_InnerNonStatic
{
    public static void main(String[] args) 
    {

        // ---------------------------------------------------------------
        Computer c1 = new Computer("Linovo yoga", "laptop");
        Computer.Memory m = c1.new Memory();

        m.setMemory();
        System.out.println(m.getDetails());

        // ---------------------------------------------------------------

        Computer c2 = new Computer("Acer", "desktop");
        Computer.Memory m2 = c2.new Memory();

        m2.setMemory();
        System.out.println(m2.getDetails());


        
        // ---------------------------------------------------------------

        Computer c3 = new Computer("Samsung", "Smartphone");
        Computer.Memory m3 = c3.new Memory();

        m3.setMemory();
        System.out.println(m3.getDetails());

    }
}