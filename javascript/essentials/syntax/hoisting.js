
// In JavaScript, a variable can be declared after it has been used.

x = 5; // Assign 5 to x
elem = document.getElementById("demo"); // Find an element
elem.innerHTML = x;                     // Display x in the element
var x; // Declare x

// same result as
var y; // Declare x
y = 5; // Assign 5 to x
elem = document.getElementById("demo"); // Find an element
elem.innerHTML = y;                     // Display y in the element


// Hoisting is JavaScript's default behavior of moving all declarations to the top of the current scope
// (to the top of the current script or the current function).

//Variables and constants declared with let or const are not hoisted!

//JavaScript only hoists declarations, not initializations.
var x = 5; // Initialize x
elem = document.getElementById("demo"); // Find an element
elem.innerHTML = x + " " + y;           // Display x and y
var y = 7; // Initialize y
// result is: x is 5 and y is undefined

// To avoid bugs, always declare all variables at the beginning of every scope.

//"use strict"; Defines that JavaScript code should be executed in "strict mode".
//Strict mode is declared by adding "use strict"; to the beginning of a script or a function.
// Declared at the beginning of a script, it has global scope
// (all code in the script will execute in strict mode):

"use strict";
tt = 3.14;       // This will cause an error because tt is not declared

myFunction();
function myFunction() {
    d = 3.14;   // This will also cause an error because d is not declared
}

//-------------- CONSIDER FOLLOWING CODE IN ISOLATION (above "use strict" affects)
//Declared inside a function, it has local scope (only the code inside the function is in strict mode):
pp = 3.14;       // This will not cause an error.
myFunction();
function myFunction() {
    "use strict";
    rr = 3.14;   // This will cause an error
}
//------------------

//Strict mode makes it easier to write "secure" JavaScript.
