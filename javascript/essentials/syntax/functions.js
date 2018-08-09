function name(my_var, second_var) {
    return my_var * second_var;
}

// ----------------------------
function toCelsius(fahrenheit) {
    return (5/9) * (fahrenheit-32);
}
document.getElementById("demo").innerHTML = toCelsius;
//In this case af raf as you call toCelsius without parentheses (),
// innerHTML will get body of the function

/* Functions can be invoked by:
    - event
    - js code
    - automatically
*/