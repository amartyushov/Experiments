/*
* The try statement lets you test a block of code for errors.

The catch statement lets you handle the error.

The throw statement lets you create custom errors.
    JavaScript will actually create an Error object with two properties: name and message.
    throw "Too big";    // throw a text
    throw 500;          // throw a number

The finally statement lets you execute code, after try and catch, regardless of the result.
*/

try {
    // Block of code to try
}
catch(err) {
    // Block of code to handle errors
}
finally {
    // Block of code to be executed regardless of the try / catch result
}