// Immediately-Invoked Function Expression (IIFE) ("iffy")

eval("function () { result = 'success' }();");
// Uncaught SyntaxError: Unexpected token (
// incorrectly interpreted as a statement. That causes a syntax error, because function declarations can’t be invoked immediately.
// solution:
let result;
(function f() { result = 'success' })();
// if you check later result variable => it will be 'success'



//--------------------------------------------------------------------------
//immediate method call
eval("{ m() {result2 = 'yes'} }.m(); "); // Unexpected token (
// JavaScript thinks the initial open brace starts a code block (a statement) and not an object literal.
// solution:
let result2;
({ m() { result2 = 'yes' } }.m());



//--------------------------------------------------------------------------
// destructuring via an object pattern
eval('{prop: p} = {prop: 123};'); // Unexpected token =
//JavaScript thinks the first open brace starts a code block
// fix:
let p;
({prop: p} = { prop: 123 });


//--------------------------------------------------------------------------
// an arrow function that returns an object literal
const funcA = () => ({prop: 123});
// assert.deepEqual(func(), { prop: 123 });
//If you don’t use parentheses, JavaScript thinks the arrow function has a block body:
const funcB = () => { prop: 123 };
//assert.deepEqual(func(), undefined);
