# MOCK

Mocked object by default returns following:
* **null** - for objects as a return type
* **0** - for primitive return types
* **Empty_Collection** - for collection return type
* **null** - for arrays (primitive or objective) as a return type
(This can be configured using MockingSettings class)

# SPY
If you want to override behaviour of real instance, but only for several methods.  
Usually this is a sign of bad design of the  class, but anyway.  
Spy is not a wrapper of the object => invocation of spy method will not affect state of initial instance.


# Settings
Create file `test/resources/mockito-extensions/org.mockito.plugins.MockMaker` and add a string here `mock-maker-inline`  
 => after this you can imitate  
 * final classes
 * enums
 * override final methods
 
 
 
 

