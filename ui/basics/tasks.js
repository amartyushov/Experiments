function printReverse(arr) {
	for (var i = arr.length-1; i>=0; i--){
		console.log(arr[i]);
	}
}

function isUniform(arr) {
	if (arr.constructor !== Array) {
		console.log("is not an array");
		return;
	}

	var ref = arr[0];
	for (var i = 1; i<arr.length; i++) {
		if (arr[0] !== arr[i]) {
			console.log("array is not uniform");
			return;
		}
	}
	console.log("array is uniform");
}

function sum(argument) {
	var sum = 0;
	argument.forEach(function(element) {
		sum += element;
	})
	return sum;
}

function max(argument) {
	var max = argument[0];
	argument.forEach(function(element) {
		if (element > max) {
			max = element;
		}
	})
	return max;
}
