// let declares mutable variables.
// const declares constants (immutable variables). Only binding is immutable (e.g. assigned obj value can be later changed)
// Before ES6, there was also var. But it has several quirks, so it’s best to avoid it in modern JavaScript.

// all variables are block scoped => can only be accessed from within the block that the are declared in




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
//coercion
var z = 10 + "my" // will return '10my'
var zz = 10 + 30 + "my" // will return '40my'
var zzz = "my" + 10 + 30 // will return 'my1030' !!!!
//The JavaScript compiler works from left to right.

// Most operators only work with primitive values
// If an operand is an object, it is usually coerced to a primitive value.
// > [1,2,3] + [4,5,6]
// '1,2,34,5,6'
// Why? The plus operator first coerces its operands to primitive values:
// > String([1,2,3])
// '1,2,3'
// > String([4,5,6])
// '4,5,6'
// Next, it concatenates the two strings:
// > '1,2,3' + '4,5,6'
// '1,2,34,5,6'


var answer = "He is called 'Johnny'";    // Single quotes inside double quotes
var answer2 = 'He is called "Johnny"';
var x = "We are the so-called \"Vikings\" from the north.";     // escaping special characters

/*All string methods return a new string. They don't modify the original string.
Formally said: Strings are immutable: Strings cannot be changed, only replaced.*/

document.getElementById("demo").innerHTML = "Hello " +
    "Dolly!";      // make multiline string



// typeof & instanceof
// typeof distinguishes the 7 types of the specification
// instanceof tests which class created a given value
/*
typeof "John"                 // Returns "string"
typeof Symbol                 // Returns "symbol"
typeof 3.14                   // Returns "number"
typeof NaN                    // Returns "number"
typeof false                  // Returns "boolean"
typeof [1,2,3,4]              // Returns "object"
typeof {name:'John', age:34}  // Returns "object"
typeof new Date()             // Returns "object"
typeof function () {}         // Returns "function"     !!!!
typeof myCar                  // Returns "undefined" *
typeof null                   // Returns "object"       !!!!
typeof undefined              // Returns "undefined"

(function() {}) instanceof Function => true
({}) instance Object => true
[] instanceof Array => true
*/

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

let x; // mutable, ECMA6
const z = 8; // immutable








// =========================================================================================
// Comma operator
/*
«left» , «right»
The comma operator evaluates both operands and returns the result of right. Roughly, it does for expressions what the semicolon does for statements.

This example demonstrates that the second operand becomes the result of the operator:

> 123, 'abc'
'abc'
This example demonstrates that both operands are evaluated:

> var x = 0;
> var y = (x++, 10);

> x
1
> y
10
The comma operator is confusing. It’s better to not be clever and to write two separate statements whenever you can.
 */



// =========================================================================================
// void operator http://speakingjs.com/es5/ch09.html#comma_operator
/*
The syntax for the void operator is:

void «expr»
which evaluates expr and returns undefined. Here are some examples:

> void 0
undefined
> void (0)
undefined

> void 4+7  // same as (void 4)+7
NaN
> void (4+7)
undefined

> var x;
> x = 3
3
> void (x = 5)
undefined
> x
5
Thus, if you implement void as a function, it looks as follows:

function myVoid(expr) {
    return undefined;
}
The void operator is associated closely with its operand, so use parentheses as necessary. For example, void 4+7 binds as (void 4)+7.

What is void used for?
Under ECMAScript 5, void is rarely useful. Its main use cases are:

void 0 as a synonym for undefined
The latter can be changed, while the former will always have the correct value. However, undefined is reasonably safe from being changed under ECMAScript 5, which makes this use case less important (for details, see Changing undefined).
Discarding the result of an expression
In some situations, it is important to return undefined as opposed to the result of an expression. Then void can be used to discard that result. One such situation involves javascript: URLs, which should be avoided for links, but are useful for bookmarklets. When you visit one of those URLs, many browsers replace the current document with the result of evaluating the URL’s “content,” but only if the result isn’t undefined. Hence, if you want to open a new window without changing the currently displayed content, you can do the following:

javascript:void window.open("http://example.com/")
Prefixing an IIFE
An IIFE must be parsed as an expression. One of several ways to ensure that is by prefixing it with void (see IIFE Variation: Prefix Operators).[11]
Why does JavaScript have a void operator?
According to JavaScript creator Brendan Eich, he added it to the language to help with javascript: links (one of the aforementioned use cases):

I added the void operator to JS before Netscape 2 shipped to make it easy to discard any non-undefined value in a javascript: URL.[12]
 */



// =========================================================================================
// null and undefined

let myVar;
// assert.equal(myVar, undefined);

function func(x) {
    return x;
}
// assert.equal(func(), undefined);

const obj33 = {};
// assert.equal(obj33.unknownProp, undefined);

function func14() {}
//assert.equal(func14(), undefined);
// If you don’t explicitly specify the result of a function via the return operator, JavaScript returns undefined for you

/*
Checking for undefined or null
Checking for either:

if (x === null) ···
if (x === undefined) ···
Does x have a value?

if (x !== undefined && x !== null) {
  // ···
}
if (x) { // truthy?
  // x is neither: undefined, null, false, 0, NaN, ''
}
Is x either undefined or null?

if (x === undefined || x === null) {
  // ···
}
if (!x) { // falsy?
  // x is: undefined, null, false, 0, NaN, ''
}
Truthy means “is true if coerced to boolean”. Falsy means “is false if coerced to boolean”. Both concepts are explained properly in the chapter on booleans).
 */

//undefined and null don’t have properties


// =========================================================================================
// BOOLEAN
