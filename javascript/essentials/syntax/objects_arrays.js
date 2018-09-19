//Object literal
const obj = {
    first: 'Jane'
};
// obj is a reference, object itself is stored in the heap
obj.foo = 'abc'; // add a property
obj.foo = 'zzz'; // change a property

// square brackets operator ([ ]) for accessing the properties of an object can only handle strings and symbols. All other values are coerced to string
const obj10 = {};
obj10['true'] = 123;
// Coerce true to the string 'true'
assert.equal(obj[true], 123);


//Array literal
const myArray = ['a'];



// comparing of objects
const myObject = {};
assert.ok(myObject === myObject);
assert.ok({} !== {}); // two fresh, different objects

const a = {};
const b = a;
assert.ok(a === b); // b reference the same object
a.foo = 'aaa'; // changing a also changing b

// garbage collecting
let obj2 = {prop: 'value'};
obj2 = {};
// now value 'prop' is a garbage. JS will automatically garbage-collect it at some point.



//--------------------------------------------------------------------------
// OBJECT LITERAL
{
    foo: bar(3, 5)
}
// created object has single property (foo) with a value as a result of function bar(3,5)
// but it is also a code block that contains a single line: label foo followed by the function call bar(3,5)






// OLD SCHOOL:

//--------------------------------------------------------------------------
// methods in functions
// Methods are stored in properties as function definitions.
var man = {
    firstName: "John",
    lastName : "Doe",
    fullName : function() {
        return this.firstName + " " + this.lastName;
    }
};
man.fullName();
man.fullName;    // in this case you will get function definition

//--------------------------------------------------------------------------
// DO NOT DO THIS!!!
var x = new String();        // Declares x as a String object
var y = new Number();        // Declares y as a Number object
var z = new Boolean();       // Declares z as a Boolean object
// They complicate your code and slow down execution speed.

var xx = "John";
var yy = new String("John");
var zz = new String("John");
xx == yy // is true, because values are the same
xx === yy // is false, because type is different (string and object)
yy == zz // is false they are different objects



var x = 500;
var y = new Number(500);
var z = new Number(500);


// (x == y) is true because x and y have equal values
// (x === y) is false because x and y have different types
// (z == y) is false because objects cannot be compared

/*
Objects are coerced to primitives if (and only if!) the other operand is primitive:
> [1, 2, 3] == '1,2,3'
true
> ['1', '2', '3'] == '1,2,3'
true

If both operands are objects, they are only equal if they are the same object:
> [1, 2, 3] == ['1', '2', '3']
false
> [1, 2, 3] == [1, 2, 3]
false
 */










//--------------------------------------------------------------------------
// ARRAYS

//You can have objects in an Array. You can have functions in an Array. You can have arrays in an Array

var points = new Array();         // Bad
var points = [];                  // Good

var cars = ["Saab", "Volvo", "BMW"];  // array
// index is zero based
var cars = new Array("Saab", "Volvo", "BMW"); // DO NOT USE THIS WAY!!
// For simplicity, readability and execution speed, use the first one (the array literal method).

typeof cars // returns 'object'

var name = cars[0];
cars[0] = "Opel";  // This statement modifies the first element in cars:

var x = cars.length;   // The length property returns the number of elements
var y = cars.sort();   // The sort() method sorts arrays

cars.push("Lada");                // adds a new element
cars[cars.length] = "Niva";     // adds a new element as well
// Adding elements with high indexes can create undefined "holes" in an array

// JavaScript does not support arrays with named indexes.
//     In JavaScript, arrays always use numbered indexes.

    var txt = "a,b,c,d,e";   // String
txt.split(",");          // Split on commas, array in the result

//How to Recognize an Array
Array.isArray(fruits);     // returns true
car instanceof Array;     // returns true


// The Difference Between Arrays and Objects
// In JavaScript, arrays use numbered indexes.
// In JavaScript, objects use named indexes.