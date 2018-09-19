// =================================================================
// ordinary functions
function ordinary(my_var, second_var) {
    return my_var + second_var;
    //ordinary(my_var, second_var) is the head of the function declaration
}
/*
Three roles of such function:
1. real function: invoked via a function call. ordinary(3,4)
2. method: stored in property, invoked via a method  call.
const obj = { multiplyAsMethod: ordinary };
assert.equal(obj.multiplyAsMethod(2, 4), 6);
3. Constructor function/class: invoked via new.
const inst = new ordinary();
assert.equal(inst instanceof ordinary, true);
 */

// Anonymous function expression
const ordinary2 = function (a, b, c) {
    // result of this function will be assigned to variable ordinary2
};

// Named function expression
const ordinary3 = function myName(a, b, c) {
    // benefits:
    // 1. names show up in stack trace
    // 2. you can refer to the function name here (recursion). myName exists only inside of the function
};





// =================================================================
// Specialized functions
// Specialized functions are specialized versions of ordinary functions. Each one of them only plays a single role:

// An arrow function can only be a real function:
const add2 = (a,b) => a + b;
assert.equal(add2(5,2), 7);
const add3 = (a,b) => {return a + b}; // the body of add3 is code block

const func1 = () => ({a: 1});
assert.deepEqual(func1(), { a: 1 });
// If you don’t, JavaScript thinks, the arrow function has a block body (that doesn’t return anything):
const func2 = () => {a: 1};
assert.deepEqual(func2(), undefined);


// A method can only be a method:
const obj = { method() { return 'abc' } };
assert.equal(obj.method(), 'abc');

// A class can only be a constructor function:
class MyClass { /* ··· */ }
const inst = new MyClass();


/* It’s important to note that arrow functions, methods and classes are still categorized as functions:
> (() => {}) instanceof Function
true
> ({ method() {} }.method) instanceof Function
true
> (class SomeClass {}) instanceof Function
true
*/


/*
- in ordinary functions "this" is an implicit (dynamic) parameter
- arrow functions get "this" from their surrounding scopes (lexically)
 */




// ----------------------------
function toCelsius(fahrenheit) {
    return (5/9) * (fahrenheit-32);
}
document.getElementById("demo").innerHTML = toCelsius;
//In this case as far as you call toCelsius without parentheses (),
// innerHTML will get body of the function

/* Functions can be invoked by:
    - event
    - js code
    - automatically
*/




// Too many or not enough parameters
// JavaScript does not complain if a function call provides a different number of arguments than expected by the function definition:
// Extra arguments are ignored.
// Missing parameters are set to undefined.
    function foo(x, y) {
        return [x, y];
    }

// Too many arguments:
assert.deepEqual(foo('a', 'b', 'c'), ['a', 'b']);

// The expected number of arguments:
assert.deepEqual(foo('a', 'b'), ['a', 'b']);

// Not enough arguments:
assert.deepEqual(foo('a'), ['a', undefined]);





// Parameter default values
function f(x, y=0) {
    return [x, y];
}

assert.deepEqual(f(1), [1, 0]);
assert.deepEqual(f(), [undefined, 0]);
assert.deepEqual(f(undefined, undefined), [undefined, 0]);



// Rest parameters
function f(x, ...y) {
    return [x, y];
}
assert.deepEqual(f('a', 'b', 'c'), ['a', ['b', 'c']]);
assert.deepEqual(f(), [undefined, []]);




// Spreading (...) into function calls
function func(x, y) {
    console.log(x);
    console.log(y);
}
const someIterable = ['a', 'b'];
func(...someIterable);

Math.max(-1, 5, 11, 3)
Math.max(...[-1, 5, 11, 3])
Math.max(-1, ...[-5, 11], 3)

const arr1 = ['a', 'b'];
const arr2 = ['c', 'd'];

arr1.push(...arr2);
assert.deepEqual(arr1, ['a', 'b', 'c', 'd']);





// Enforcing an arity via a rest parameter
function bar(a, b) {
}
// How to enforce to always provide two parameters
function bar(...args) {
    if (args.length !== 2) {
        throw new Error('Please provide exactly 2 arguments!');
    }
    const [a, b] = args;
}





// Named parameters
// JavaScript doesn’t have real named parameters. The official way of simulating them is via object literals:
blabla({start: 3, end: 20, step: 2})

function selectEntries({start=0, end=-1, step=1}) {
    // This function uses destructuring to access the properties of its single parameter
    // The pattern it uses is an abbreviation for the following pattern:
    // {start: start=0, end: end=-1, step: step=1}
    return {start, end, step};
}

/* This destructuring pattern works for empty object literals:
>selectEntries({})
{ start: 0, end: -1, step: 1 }

But it does not work if you call the function without any parameters:
> selectEntries()
TypeError: Cannot destructure property `start` of 'undefined' or 'null'.

You can fix this by providing a default value for the whole pattern. This default value works the same as default values for simpler parameter definitions: If the parameter is missing, the default is used.
function selectEntries({start=0, end=-1, step=1} = {}) {
    return {start, end, step};
}
assert.deepEqual(selectEntries(), { start: 0, end: -1, step: 1 });
*/






/*
In order to better understand JavaScript’s many callable values, it is helpful to distinguish between:

Syntax: what is written in source code?
Semantics: what is the result of executing the source code?
The following two concepts help with categorizing callable values:


Role: What role does a callable value play? The roles are:
Real function
Method
Class (constructor function)

Mode: What mode does a callable value operate in?
Is the real function or method synchronous or asynchronous?
Is the real function or method a generator or not?
Let’s look at a few examples:

function foo() {}
Syntax: sync function declaration
Semantics: ordinary function
Potential roles: real function, method, class
Mode: synchronous, not a generator

* m() {}
Syntax: generator method definition
Semantics: generator method
Potential roles: method
Mode: synchronous generator

() => {}
Syntax: arrow function expression
Semantics: arrow function
Potential roles: real function
Mode: synchronous, not a generator

async () => {}
Syntax: async arrow function expression
Semantics: async arrow function
Potential roles: real function
Mode: asynchronous, not a generator
 */