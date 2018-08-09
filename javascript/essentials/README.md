JIT compiler

Rendering engine  
Javascript engine

###primitive types
* string ("", '')x
* decimals
    * 10
    * 10.1
* boolean
* null
* undefined
* NaN (not a number)

All API and declared variables are stored in 'window' object  
~~  
It is better to put loading of js file to the end of html, it will
make page time load less, because loading happens from top to bottom  
~~  
When separated by semicolons, multiple statements on one line are allowed:  
a = 5; b = 6; c = a + b;  
Ending statements with semicolon is not required, but highly recommended.  
~~  
#####Operators:  
=== equal value and equal type  
? ternary operator  
** ECMAScript 2015 (ES6) exponention 10**2  

### Events
e.g. 
* An HTML web page has finished loading
* An HTML input field was changed
* An HTML button was clicked, etc

```javascript
<button onclick="document.getElementById('demo').innerHTML = Date()">The time is?</button>
```
Changing HTML of itself  
```javascript
<button onclick="this.innerHTML = Date()">The time is?</button>
```
Calling a method
```javascript
<button onclick="displayDate()">The time is?</button>
```





