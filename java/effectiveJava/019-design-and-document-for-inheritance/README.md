Class is designed and documented for inheritance:
1. Class must **document its self-use** of overridable methods (nonfinal public and protected).  
1.1. Super class should not self-use overridable methods => overriding a methods will not affect superclass 
2. Class must **not invoke overridable** methods **in constructor** directly or indirectly. (see code example)  
2.1. Private, final, static nonOverridable methods is ok to invoke in constructor.
3. Class designed for inheritance should not implement **Serialazible** and **Clonable**  
3.1. if you implement => neither **clone** nor **readObject** may invoke an overridable method


The only way to test a class designed for inheritance is to write a subclasses.

**To prepare class for subclassing requires great effort.**

How to prohibit class to be subclassed:
1. Declare it **final**
2. Make all constructors private or package-private and add public static factories instead.