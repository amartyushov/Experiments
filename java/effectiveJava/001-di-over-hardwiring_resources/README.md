#### Static untility classes and Singletons are inappropriate for classes whose behavior is parameterized but underlying classes/resources

E.g. dependency injection can be used for it.  
If there is a SpellChecker, which depends on Dictionary, you can just create an instance of SpellChecker 
for each Dictionary. By providing Dictionary to constructor of SpellChecker (io.mart.As_dependency_injection).
  
A useful case is to pass a resource factory to the constructor. 
```java
Supplier<T>
```
Is perfect for representing factories.
