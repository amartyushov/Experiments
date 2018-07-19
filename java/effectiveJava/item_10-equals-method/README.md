Do NOT override "equals" method if
* Each instance of the class is basically unique
* There is no need for the class to provide a "logical equality" test
* Super class has overridden "equals", and super class behaviour is appropriate for this class
 (e.g. Map implementations inherit from AbstractMap)
* Class is private or package-private, and you are sure that its "equals" method will never
be invoked

When to Override?
Generally a case for value classes. When you want to check that objects are logically 
equivalent, not whether they reference to the same object.  
Very useful for map keys, sets.

You do not need to override method for Enums.

If you override "equals" -> properties are:
* reflexive: x.equals(x) is true
* symmetric: x.equals(y) is true if and only if y.equals(x) is true
* transitive: if x.equals(y) is true, and y.equals(z) is true => x.equals(z) is true  
    * !!! There is no way to extend an instantiable class and add a value component
    while preserving the equals contract
    * as super class is abstract and has no fields (e.g. Shape). And subclasses Circle (with radius)
    and Rectangle(with length and width) => there is no problem. Until you can instantiate superclass.
* consistent: x.equals(y) should return consistent result after multiple invocations
* x.equals(null) is false

~~
### Always override hashCode() is you override equals()
Instances which are equal from "equal()" POV should return same hashCode() results