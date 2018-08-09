var name = "Lavrence";
name = 10;
name = true;
// loosely typed language. Variable can be not initialised in the beginning
var blank; // in this case value is 'undefined'

// ----------------------------

const my_constant = "bla";
// this is a contant and must be initialised
//my_constant = 10; this is not allowed

// ----------------------------

var z = 10 + "my" // will return '10my'
var zz = 10 + 30 + "my" // will return '40my'
var zzz = "my" + 10 + 30 // will return 'my1030' !!!!
//The JavaScript compiler works from left to right.



var answer = "He is called 'Johnny'";    // Single quotes inside double quotes
var answer2 = 'He is called "Johnny"';
var x = "We are the so-called \"Vikings\" from the north.";     // escaping special characters

/*All string methods return a new string. They don't modify the original string.
Formally said: Strings are immutable: Strings cannot be changed, only replaced.*/

document.getElementById("demo").innerHTML = "Hello " +
    "Dolly!";      // make multiline string





typeof ""           // will return 'string'
typeof null         // will return 'object' Just remember!!!
typeof [1,2,3,4]    // will return 'object' !!

// ----------------------------
//Undefined and null are equal in value but different in type:

typeof undefined           // undefined
typeof null                // object

null === undefined         // false
null == undefined          // true





// ----------------------------
// Numbers
var xx = 3.14;    // A number with decimals
var yy = 3;       // A number without decimals
var xxx = 123e5;    // 12300000
var yyy = 123e-5;   // 0.00123

//Numbers are Always 64-bit Floating Point
//floating point arithmetic is not always 100% accurate:
var n = 0.2 + 0.1;         // x will be 0.30000000000000004
// solution is
var nn = (0.2 * 10 + 0.1 * 10) / 10;       // x will be 0.3

// JavaScript will try to convert strings to numbers in all numeric operations:
// with JavaScript, methods and properties are also available to primitive values,
// because JavaScript treats primitive values as objects when executing methods and properties.
var x = 123; x.toString();            // returns 123 from variable x
(123).toString();        // returns 123 from literal 123
(100 + 23).toString();   // returns 123 from expression 100 + 23

var x = 9.656; x.toFixed(2);           // returns 9.66
var x = 9.656; x.toPrecision(2);       // returns 9.7

Number(true);          // returns 1
Number(false);         // returns 0
Number("10");          // returns 10
Number("  10");        // returns 10
Number(new Date("2017-09-30"));    // returns 1506729600000

parseInt("10");         // returns 10
parseInt("10.33");      // returns 10
parseInt("10 20 30");   // returns 10
parseInt("10 years");   // returns 10
parseInt("years 10");   // returns NaN

parseFloat("10");        // returns 10
parseFloat("10.33");     // returns 10.33
parseFloat("10 20 30");  // returns 10
parseFloat("10 years");  // returns 10
parseFloat("years 10");  // returns NaN






// ----------------------------
// NaN is a JavaScript reserved word indicating that a number is not a legal number.
var x = 100 / "Apple";  // x will be NaN (Not a Number)
isNaN(x) // true
var x = 100 / "10";     // x will be 10
var x = NaN; var y = 5; var z = x + y;         // z will be NaN
var x = NaN; var y = "5"; var z = x + y;         // z will be NaN5
typeof NaN;            // returns "number"

//Infinity (or -Infinity) is the value JavaScript will return if you calculate a number outside the largest possible number.
//Division by 0 (zero) also generates Infinity:
var x =  2 / 0;          // x will be Infinity
var y = -2 / 0;          // y will be -Infinity
typeof Infinity;        // returns "number"

//JavaScript interprets numeric constants as hexadecimal if they are preceded by 0x.
var x = 0xFF;           // x will be 255

// Never write a number with a leading zero (like 07).
// Some JavaScript versions interpret numbers as octal if they are written with a leading zero.
// By default, JavaScript displays numbers as base 10 decimals.
//     But you can use the toString() method to output numbers from base 2 to base 36.
// Hexadecimal is base 16. Decimal is base 10. Octal is base 8. Binary is base 2.
var myNumber = 32;
myNumber.toString(10);   // returns 32
myNumber.toString(32);  // returns 10
myNumber.toString(16);  // returns 20
myNumber.toString(8);   // returns 40
myNumber.toString(2);   // returns 100000





/*
* In JavaScript there are 5 different data types that can contain values:
string
number
boolean
object
function

There are 3 types of objects:
Object
Date
Array

And 2 data types that cannot contain values:
null
undefined

typeof "John"                 // Returns "string"
typeof 3.14                   // Returns "number"
typeof NaN                    // Returns "number"
typeof false                  // Returns "boolean"
typeof [1,2,3,4]              // Returns "object"
typeof {name:'John', age:34}  // Returns "object"
typeof new Date()             // Returns "object"
typeof function () {}         // Returns "function"
typeof myCar                  // Returns "undefined" *
typeof null                   // Returns "object"
*/