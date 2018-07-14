Public static factory method instead of constructor:  
`+`
- Method has a name (constructor does not)
- There can be several methods with same signature,
but named differently
- Methods are not required to create a new object 
(can be perfirmance optimisation)
- Method can return object of any subtype of their 
return type (Collections class is example)

`-`
- class, which has only static factory methods, but without public or protected constructors,
cannot be subclassed (but it is even better, because composition is better than inheritance)
- methods are not readily distinguishable from other static methods 


Service provider frameworks (e.g. JDBC) consist of:
* service interface (provides impl) (Connection)
* provider registration API (used to register implementaitons) (DriverManager.registerDriver)
* service access API (clients use to obtain an instance of service) (DriverManager.getConnection)
* (optional) service provider interface (providers implement it to
create instances of their service implementation) (Driver)
--------------------------------------------------------------------
JavaBeans way of constructing (setters):  
`-`  
- object can be in inconsistent state partway through its construction
- pattern excludes possibility of making a class immutable (thread-safety)
--------------------------------------------------------------------
Builder:  
`+`   
- builder can have method, which can be called many times and fulfil the collection under the hood  
`-`  
- builder as a class also have to be created, it is cheap, but sometimes performance is super important
- builder is verbose  
Use it when class needs to set many fields, especially of the same type

