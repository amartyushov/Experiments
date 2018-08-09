// IF LOOP
if (condition1) {

} else if (condition2) {

} else {

}



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



//-------------------------------------------------
// FOR LOOP
for (i = 0; i < cars.length; i++) {
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



//-------------------------------------------------
// FOR/IN LOOP
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



//-------------------------------------------------
// DO/WHILE LOOP
do {
    // code block executed at least once
}
while (condition);



// The break statement breaks the loop and continues executing the code after the loop (if any)
// The continue statement breaks one iteration (in the loop), if a specified condition occurs,
// and continues with the next iteration in the loop.

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


