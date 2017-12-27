//var name = prompt("What is your name?");
//alert("Nice to meet you " + name);
//console.log("Name is " + name);

// ----------------------------------------------------------------
// function declaration
function capitalise(argument) {
	return argument.charAt(0).toUpperCase() + argument.slice(1);
}

// function expression
var capitaliseFun = function(argument) {
	return argument.charAt(0).toUpperCase() + argument.slice(1);
}

// higher order function - which accepts another function as a input parameter. Example
setInterval(function(){
	console.log("this is anonymous function");
}, 2000);

// ----------------------------------------------------------------
if () {}
	else if () {}
		else {};

while(){};
// ----------------------------------------------------------------

// iterate over array
var colors = ["red", "green"];
colors.forEach(function(color){
	console.log(color);
})

//or you can define function beforehand
function doSmth(color){
	console.log(color);
}
colors.forEach(doSmth)

// ----------------------------------------------------------------
// Objects

var dog = {
	name: "Rusty",
	age: 3,
	add: function(x,y) {   // declaration of methods
		return x*y;
	}
}
dog.age // access
dog.street = "bla" // you actually add a field 'street' to the object with value 'bla'

// DOM is an interface between js and html_css
// SELECT - MANIPULATE
// Selectors
// document.getElementById()
// document.getElementsByClassName()
// document.getElementsByTagName() etc...

// Manipulating:
// getAttribute
// setAttribute("name", "value")

// Events
// var h1 = document.querySelector("h1");
// h1.addEventListener("click", function() {
// alert("clicked");
// })


