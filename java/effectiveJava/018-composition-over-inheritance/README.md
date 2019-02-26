1. It is safe to use inheritance within a package 
(same programmers control the code)
2. It is safe to extend classes which were designed to be extendable
3. Inheritance should exist only if A class is really "is-a" class B.

Composition: Instead of extending a class, give your class a private field that
references an instance of existing class.
* Resulting class does not depend on impl of the existing class 


"-" Cons:
1. Inheritance violates encapsulation
	* subclass depends on implementation details of super class
	* if superclass is changed => subclass can be broken (eventhough
	it was not even touched)
	
	
Caveat of wrapper class:
1. Wrapper class is not suited to be used in callback framework,
wherein objects pass self-references to other objects for subsequent
invocations.

