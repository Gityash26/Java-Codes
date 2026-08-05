/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------------------------- Methods of thread class -------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) start()	          ->   Start the thread and allocate the Thread object insdie the Thread pool
(2) run()	          ->   Used to perform an action for a thread.
(3) sleep()	          ->   Sleeps a thread for the specified amount of time.
(4) currentThread()	  ->   Returns a reference to the currently executing thread object.
(5) join()	          ->   Waits for a thread to die.
(6) getPriority()  	  ->   Returns the priority of the thread.
(7) setPriority()	  ->   Changes the priority of the thread.
(8) getName()	      ->   Returns the name of the thread.
(9) setName()      	  ->   Changes the name of the thread.
(10) getId()	      ->   Returns the ID of the thread.
(11) isAlive()	      ->   Tests if the thread is alive.
(12) yield()	      ->   Causes the currently executing thread object to pause and allows other threads to execute temporarily.
(13) suspend()	      ->   Suspends the thread.
(14) resume()	      ->   Resumes the suspended thread.
(15) stop()	          ->   Stops the thread.
(16) destroy()	      ->   Destroys the thread group and all of its subgroups.
(17) isDaemon()	      ->   Tests if the thread is a daemon thread.
(18) setDaemon()	  ->   Marks the thread as a daemon or user thread.
(19) interrupt()	  ->   Interrupts the thread.
(20) isInterrupted()  ->   Tests whether the thread has been interrupted.
(21) interrupted()	  ->   Tests whether the current thread has been interrupted.
(22) activeCount()	  ->   Returns the number of active threads in the current thread’s thread group.
(23) checkAccess()	  ->   Determines if the currently running thread has permission to modify the thread.
(24) holdLock()	      ->   Returns true if and only if the current thread holds the monitor lock on the specified object.
(25) dumpStack()	  ->   Prints a stack trace of the current thread to the standard error stream.
(26) getStackTrace()  ->   Returns an array of stack trace elements representing the stack dump of the thread.
(27) enumerate()	  ->   Copies every active thread’s thread group and its subgroup into the specified array.
(28) getState()	      ->   Returns the state of the thread.
(29) getThreadGroup() ->   Returns the thread group to which this thread belongs.
(30) toString()	      ->   Returns a string representation of this thread, including the thread’s name, priority, and thread group.
(31) notify()	      ->   Gives notification for only one thread waiting for a particular object.
(32) notifyAll()	  ->   Gives notification to all waiting threads of a particular object.

(33) setContextClassLoader()	            ->   Sets the context ClassLoader for the thread.

(34) getContextClassLoader()	            ->   Returns the context ClassLoader for the thread.

(35) getDefaultUncaughtExceptionHandler()	->   Returns the default handler invoked when a thread abruptly terminates due to
                                                  an uncaught exception.

(36) setDefaultUncaughtExceptionHandler()	->   Sets the default handler invoked when a thread abruptly terminates due to an 
                                                  uncaught exception.
*/


