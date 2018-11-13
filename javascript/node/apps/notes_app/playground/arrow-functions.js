let square = (x) => {
  let result = x * x;
  return result;
};

let sum = (x, y) => x+y;

console.log(square(9));
console.log(sum(1,2));


let user = {
  name: 'Alex',
  sayHi: () => {
    console.log(arguments);
    console.log(`Hi. I am ${this.name}`);  // does not work, it is undefined
  },
  sayHiAlt () {
    console.log(arguments);
    console.log(`Hi. I am ${this.name}`); // works! there is no semicolon!!
  }
};

user.sayHiAlt(1,2,3);
user.sayHi(1,2,3);
