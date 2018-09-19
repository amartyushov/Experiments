// basically a compact syntax for setting up prototype chains

// class declaration
class Person {
    constructor(name) {
        this.name = name;
    }
    describe() {
        return 'Person named '+this.name;
    }
}

const jane = new Person('Jane');
assert.equal(jane.describe(), 'Person named Jane');

const tarzan = new Person('Tarzan');
assert.equal(tarzan.describe(), 'Person named Tarzan');
assert.equal(tarzan.constructor.name, 'Person');


const cheeta = new jane.constructor('Cheeta');
assert.ok(cheeta instanceof Person);



// anonymous class expressions:
const Person = class {  };

// And named class expressions:
const Person = class MyClass {  };









// Class definitions: prototype properties
// The following code demonstrates all parts of a class definition Foo that create properties of Foo.prototype:

class Foo {
    constructor(prop) {
        this.prop = prop;
    }
    protoMethod() {
        return 'protoMethod';
    }
    get protoGetter() {
        return 'protoGetter';
    }
}
/*
Let’s examine them in order:

    .constructor() is called after creating a new instance of Foo, to set up that instance.
    .protoMethod() is a normal method. It is stored in Foo.prototype.
    .protoGetter is a getter that is stored in Foo.prototype.
*/






// Class definitions: static properties
// The following code demonstrates all parts of a class definition that create so-called static properties – properties of the class itself.

class Bar {
    static staticMethod() {
        return 'staticMethod';
    }
    static get staticGetter() {
        return 'staticGetter';
    }
}
/*
The static method and the static getter are used as follows.

> Bar.staticMethod()
'staticMethod'
> Bar.staticGetter
'staticGetter'*/







/*I recommend using classes for the following reasons:

Classes are a common standard for object creation and inheritance that is now widely supported across frameworks (React, Angular, Ember, etc.).
They help tools such as IDEs and type checkers with their work and enable new features.
They are a foundation for future features such as value objects, immutable objects, decorators, etc.
They make it easier for newcomers to get started with JavaScript.
JavaScript engines optimize them. That is, code that uses classes is usually faster than code that uses a custom inheritance library.
That doesn’t mean that classes are perfect. One issue I have with them, is:

Classes look different from what they are under the hood. In other words, there is a disconnect between syntax and semantics.*/







// Private data: naming convention
// The first technique makes a property private by prefixing its name with an underscore. This doesn’t protect the property in any way; it merely signals to the outside: “You don’t need to know about this property.”

// In the following code, the properties ._counter and ._action are private.

    class Countdown {
    constructor(counter, action) {
        this._counter = counter;
        this._action = action;
    }
    dec() {
        if (this._counter < 1) return;
        this._counter--;
        if (this._counter === 0) {
            this._action();
        }
    }
}

// The two properties aren’t really private:
assert.deepEqual(
    Reflect.ownKeys(new Countdown()),
    ['_counter', '_action']);
// With this technique, you don’t get any protection and private names can clash. On the plus side, it is easy to use.







// Private data: WeakMaps
// Another technique is to use WeakMaps.

let _counter = new WeakMap();
let _action = new WeakMap();

class Countdown {
    constructor(counter, action) {
        _counter.set(this, counter);
        _action.set(this, action);
    }
    dec() {
        let counter = _counter.get(this);
        if (counter < 1) return;
        counter--;
        _counter.set(this, counter);
        if (counter === 0) {
            _action.get(this)();
        }
    }
}

// The two pseudo-properties are truly private:
assert.deepEqual(
    Reflect.ownKeys(new Countdown()),
    []);
// This technique offers you considerable protection from outside access and there can’t be any name clashes. But it is also more complicated to use.












// ================================> subclassing
class Person {
    constructor(name) {
        this.name = name;
    }
    describe() {
        return `Person named ${this.name}`;
    }
    static logNames(persons) {
        for (const person of persons) {
            console.log(person.name);
        }
    }
}

class Employee extends Person {
    constructor(name, title) {
        super(name);
        this.title = title;
    }
    describe() {
        return super.describe() +
            ` (${this.title})`;
    }
}

const jane = new Employee('Jane', 'CTO');
assert.equal(
    jane.describe(),
    'Person named Jane (CTO)');
/*
Two comments:
Inside a .constructor() method, you must call the super-constructor via super(), before you can access this.
That’s because this doesn’t exist before the super-constructor was called (this phenomenon is specific to classes).

Static methods are also inherited. For example, Employee inherits the static method .logNames():

> 'logNames' in Employee
true
*/













/*Mixin classes (advanced)
JavaScript’s class system only supports single inheritance. That is, each class can have at most one superclass. A way around this limitation is via a technique called mixin classes (short: mixins).

The idea is as follows: Let’s assume there is a class C that extends a class S – its superclass. Mixins are class fragments that are inserted between C and S.

In JavaScript, you can implement a mixin Mix via function whose input is a class and whose output is the mixin class fragment – a new class that extends the input. To use Mix(), you create C as follows.

class C extends Mix(S) {
  ···
}
Let’s look at an example:

const Branded = S => class extends S {
  setBrand(brand) {
    this._brand = brand;
    return this;
  }
  getBrand() {
    return this._brand;
  }
};
We use this mixin to insert a class between Car and Object:

class Car extends Branded(Object) {
  constructor(model) {
    super();
    this._model = model;
  }
  toString() {
    return `${this.getBrand()} ${this._model}`;
  }
}
The following code confirms that the mixin worked: Car has method .setBrand() of Branded.

const modelT = new Car('Model T').setBrand('Ford');
assert.equal(modelT.toString(), 'Ford Model T');
Mixins are more flexible than normal classes:

First, you can use the same mixin multiple times, in multiple classes.
Second, you can use multiple mixins at the same time. As an example, consider an additional mixin called Stringifiable that helps with implementing .toString(). We could use both Branded and Stringifiable as follows:

class Car extends Stringifiable(Branded(Object)) {
  ···
}
*/









