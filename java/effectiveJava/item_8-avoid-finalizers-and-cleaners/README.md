* Finalizers are unpredictable, often dangerous and generally unnecessary.
* in Java 9 finalizers are replaced by cleaners. Cleaners are less dangerous, but still unpredictable, slow,
and generally unnecessary.
* never do anything time-critical in a finalizer or cleaner (because it can take arbitrarily long between the time
that an object becomes unreachable and the time its finalizer or cleaner runs)
* never depend on finalizer and cleaner to update persistent state
* methods System.gc and System.runFinalization guarantee nothing
* there is a severe performance problem in using finalizers and cleaners
* Finalizers have a serious security problem: they open your class to finalizer attacks.
* Throwing an exception from a constructor should be sufficient to prevent an object from coming into existence; 
in the presence of finalizers, it is not.
    * to prevent nonfinal class from finalizer attacks, write a final finalize() method that does nothing
* exception of usage is a safety net (auto closing) or to terminate noncritical native resources.