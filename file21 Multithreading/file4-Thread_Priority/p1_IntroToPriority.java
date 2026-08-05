/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-------------------------- Thread Priority ---------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> There can be multipe thread reside in the Thread pool. It is the reponsibility of the thread scheduler 
   to schedule those threads to to processor in such a way to maximize the CPU utilization and their should 
   be no clash occur between two treads.

-> The priority in which thread scheduler schedule the Threads for processing is called Thread Priority.

     ______________                __________________________              __________
    |__Thread_1____|              |     Thread Scheduler    |             |         |
    |__Thread 2____|   -------->  |  _____________________  | -------->   |  C P U  |
    |__Thread_3____|              | |_Scheduling Alorithm_| |             |_________|
    |__Thread 4____|              |_________________________|

    
Note: 
    -> Thread priority is an interger value from 1 to 10
    ->  The higher the number higher the priority to be scheduled first for execution.
    -> The default priority of a thread is 5.
    
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-------- Getter and Setter Method --------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Thread class provide Getter and  Setter to assign and get the priority explicitly of the thread.

(1) getPriority() : 
    It returns the thread priority

(2) setPriority(int priority):
    It is used to set priority of a thread.

    MIN_PRIORITY = 1    ----\
    NORM_PRIORITY = 5   ----|----- Three constants
    MAX_PRIORITY = 10   ---/

*/

class A extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++)
            System.out.println("Thread name -> " + this.getName());
    }
}

public class p1_IntroToPriority {
    public static void main(String[] args) {
        A th0 = new A();
        A th1 = new A();
        A th2 = new A();

        System.out.println("\nDefault Priority : ");
        System.out.println("Thread-0 priority : " + th0.getPriority());
        System.out.println("Thread-1 priority : " + th1.getPriority());
        System.out.println("Thread-2 priority : " + th2.getPriority());

        th0.setPriority(Thread.MIN_PRIORITY);
        th1.setPriority(Thread.MIN_PRIORITY);
        th2.setPriority(Thread.MAX_PRIORITY);
        
        System.out.println("\nExplicitly set Priority : ");
        System.out.println("Thread-0 priority : " + th0.getPriority());
        System.out.println("Thread-1 priority : " + th1.getPriority());
        System.out.println("Thread-2 priority : " + th2.getPriority());

        th0.start();
        th1.start();
        th2.start();
    }
}

