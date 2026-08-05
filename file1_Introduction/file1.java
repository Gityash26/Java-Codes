/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------------ Execution of JAVA ------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  
                       ___________                         ____________
 ________________     | ======== |      ___________       | %%%%%%%%% |
|__Programmer___|---> | ======== |---> | Compiler |-----> | ######### |___________ 
                      | ======== |     |__________|       | %%%%%%%%% |          |
                      |__________|                        |___________|          |
                      (source code)                        (Byte Code)           |
                        .java                                 .class             |
                                                                                 |
                                                                                 |
                                                            =============================================
                                                            |        JDK (Java Development Kit)         |
                                                            |===========================================|
                                                            |  ______________________________________   |
                                                            |  |                                     |  |
                                                            |  |       _________________________     |  |
                                                            |  |      |        JVM             |     |  |
                                                            |  |      | (JAVA virtual machine) |     |  |  
                                                            |  |      |________________________|     |  |
                                                            |  |                                     |  |
                                                            |  |    JRE (Java Runtime Environment)   |  |
                                                            |  |_____________________________________|  |
                                                            |___________________________________________|
                                                                     


                                                            
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------- JVM (Java Virtual Machine)---------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> JVM (Java Virtual Machine) is an abstract machine that enables you computer to run a java program.
-> When you run the java program, java compiler first compiles you java code to bytecode. 
-> Then JVM translate bytecode into native machine code (Computer understandable form)


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------- JRE, and JDK -----------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> JRE (Java Runtime Environment) is a software package that provides java class libraries, JAVA Virtual Machine (JVM), 
    and other components that are required to run a java applications.
    
-> JDK (Java Development Kit) is a software development kit required to develop application in java.
   In addition to JRE, JDK also contains a number of development tools (compiler, JavaDoc, JAva Debugger, etc)






j
-> First of all, A programmer writes a code of java (source code) then it compile to form a machine readable form(Byte code)
   Now that compiled Byte code can be ready to run into a JVM->(platform dependent).
                                                                     
-> A java program can have multiple files but JVM only execute prgram from main() So, It search for a sytax or signature that we need to specify in our program.

-> Signature : public static void main(string args[])



======================================================================
========= Explain the diference between JDK, JRE and JVM ==========
======================================================================

=> JVM (java virtual machine) was the core part that mainly used to interpret the (.class) java files into machine code and run on the machine.
   JVM is platform dependent 

=> JRE was the sewcond layer comes above the JVM which is (JAVA Runtime Environment) and it is basically contains java libraries (lang, util packages etc)
    It just give environment to run the java program on any system,
   
=> JDK (Java Development Kit) is basically contains of tools used to develop the java program or compile them.



🔹 JDK (Java Development Kit)

Used to develop Java applications

Contains: JRE + Compiler (javac) + Development tools

🔹 JRE (Java Runtime Environment)

Used to run Java programs

Contains: JVM + required libraries

🔹 JVM (Java Virtual Machine)

Executes bytecode

Converts bytecode → machine code

Platform dependent (each OS has its own JVM)

*/                                                                     


// -> Basic Hello world program

class file1  
{
    // main method
    public static void main(String args[])
    {
        // output: Hello world
        System.out.print("Hello world");
    }
}



