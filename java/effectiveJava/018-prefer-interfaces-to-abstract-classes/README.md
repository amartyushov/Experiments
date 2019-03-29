- Major issue is ability to extend only one subclass vs ability to implement 
many interfaces  
- Interfaces are ideal for defining mixins.  
 -- mixin (примесь) is a type that class can impl in addition to its 
 "primary" type (e.g. Comparable is a mixin interface, *Aware)
- Adequate approach can be:  
 -- you have an interface  
 -- you have a skeletal implementation of this interface (e.g. AbstractList)    
 -- good documentation is must have for skeletal implementations  
 ----- you extend this implementation and complete implementation   
 
- Adding a default method to existing interface intended to be a safe way to extend interface  
-- it will work at compile time  
-- but it can fail in runtime  
------ e.g. implementation of interface makes each method call synchronised.  
But this new default method will not be synchronised for the current implementation.
- Adding default methods to existent interfaces should be avoided unless it is critical  