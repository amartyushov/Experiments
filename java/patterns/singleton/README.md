# Singleton
It is a class which is instantiated only once.  
Making a class a singleton can make it difficult to test its clients, because it is impossible 
to substitute a mock implementation for a singleton unless it implements an interface 
that serves as its type.  

If you use static factory way of returning INSTANCE, it is more flexible. Because e.g.
later you can change your mind whether it should be a singleton or not.   
Just reimplement method getInstance()  
For example getInstance() can return a new instance for each thread.  

You can also use method reference Bla::getInstance as a supplier.  
If you do not need it => use public field approach for singleton.  

Keep in mind about serialisation of singleton. It is not enough to just implement Serializable.  
- declare all singleton fields "transient"
- provide "readResolve()" method  
```java
private Object readResolve() {
	return INSTANCE;
}
```
Otherwise each time serialized singleton is deserialized => you get a new instance

--------------------------------------------------------------------
The best way to make a singleton is single_element_enum, because:
 * Concise
 * Provider serialization for free
 * guarantee against multiple instantiation  
 
 You can not use this approach, if your singleton must extend a superclass other than Enum


 