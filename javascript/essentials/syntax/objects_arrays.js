var object_x = {firstName:"John", lastName:"Doe"}; // object
var person = {
    firstName:"John",
    lastName:"Doe",
    age:50,
    eyeColor:"blue"
};
//accessing
person.eyeColor;
person["age"];

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
//     In JavaScript, objects use named indexes.

