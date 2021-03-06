// IF LOOP
if (condition1) {

} else if (condition2) {

} else {

}
/*
if (x == 123) {
  // x is either 123 or '123'
}
I prefer either of the following two alternatives:
if (x === 123 || x === '123') ···
if (Number(x) === 123) ···
You can also convert x to a number when you first encounter it.
 */

/*
Another use case for == is to check if a value x is either undefined or null:
if (x == null) {
  // x is either null or undefined
}
The problem with this code is that you can’t be sure if someone meant to write it that way or if they made a typo and meant === null.
I prefer either of the following two alternatives:

if (x === undefined || x === null) ···
if (x) ···
The second alternative is even more sloppy than using ==, but it is a well-established pattern in JavaScript
 */



//-------------------------------------------------
// SWITCH LOOP
switch(expression) {
    case n:
        // code block
        break;
    case nn:
        // code block
        break;
    default:
        // code block
}
//Switch cases use strict comparison (===).
// do not forget to return or break







//-------------------------------------------------
// FOR LOOP
for (let i = 0; i < cars.length; i++) {
    text += cars[i] + "<br>";
}

//you can init many var: i, len, text
for (i = 0, len = cars.length, text = ""; i < len; i++) {
    text += cars[i] + "<br>";
}

var i = 2; var len = cars.length; var text = "";
for (; i < len; i++) {
    text += cars[i] + "<br>";
}

var i = 0; var len = cars.length;
for (; i < len; ) {
    text += cars[i] + "<br>"; i++;
}

// infinite loop
for (;;) {
}

// for-of
const iterable = ['hello', 'world'];
for (const elem of iterable) {
    // elem can be const, because it is just new declaration in fresh loop
}


// Iterating over [index, element] pairs of Arrays
const arr5 = ['a', 'b', 'c'];
for (const [index, elem] of arr5.entries()) {
    console.log(`${index} -> ${elem}`);
}


// for-await-of (can only be used inside async functions and async generators.)
for await (const item of asyncIterable) {
    // ···
}


// FOR/IN LOOP (it is usually best to avoid it)
var person = {fname:"John", lname:"Doe", age:25};
// iterate through the properties of object
var text = ""; var x;
for (x in person) {
    text += person[x];
}







//-------------------------------------------------
// WHILE LOOP
while (i < 10) {
    text += "The number is " + i;
    i++;
}

// If you want a loop to have an empty body, your first option is an empty statement (which is just a semicolon):

while (processNextItem() > 0);
// Your second option is an empty block:

while (processNextItem() > 0) {}

//-------------------------------------------------
// DO/WHILE LOOP
do {
    // code block executed at least once
}
while (condition);



// The break statement breaks the loop and continues executing the code after the loop (if any)
// With a label reference, the break statement can be used to jump out of any code block:
var cars = ["BMW", "Volvo", "Saab", "Ford"];
list: {
    text += cars[0] + "<br>";
    text += cars[1] + "<br>";
    break list;
    text += cars[4] + "<br>";
    text += cars[5] + "<br>";
}
// A code block is a block of code between { and }.
// good example of break with label statement
function search(stringArray, suffix) {
    let result;
    search_block: {
        for (const str of stringArray) {
            if (str.endsWith(suffix)) {
                // Success
                result = str;
                break search_block; // exits the block code which is labeled as search_block
            }
        } // for
        // Failure
        result = '(Untitled)';
    } // search_block

    return { suffix, result };
    // same as: {suffix: suffix, result: result}
}






// CONTINUE
// It immediately leaves the current loop iteration and continues with the next one.
