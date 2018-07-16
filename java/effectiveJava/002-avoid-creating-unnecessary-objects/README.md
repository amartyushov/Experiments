Extreme example:  
```java
String s = new String("bla")
```
"Bla" is already a created string, so you will create string twice.

~~  
Static factory methods can help not to create unnecessary objects.  

~~  
Prefer primitives to boxed primitives, and watch out for unintentional autoboxing.

~~  
When object is cheap to create, do not implement your own object pools for this instances. Current JVM GC will
be faster, when you just create a new object.  
Create object pools only for objecs, which are expensive to create (e.g. database connections)
 

