// http://exploringjs.com/impatient-js/ch_proto-chains-classes.html

/*
Prototypes are JavaScript’s only inheritance mechanism:
Each object has a prototype that is either null or an object. In the latter case, the object inherits all of the prototype’s properties.
In an object literal, you can set the prototype via the special property __proto__:
*/

const proto = {
    protoProp: 'a',
};

const obj = {
    __proto__: proto,
    objProp: 'b',
};
//Non-inherited properties are called own properties. obj has one own property, .objProp.

// obj inherits .protoProp:
assert.equal(obj.protoProp, 'a');
assert.equal('protoProp' in obj, true);


// When we set the inherited property obj.protoProp in line A, we “change” it by creating an own property:
// When reading obj.protoProp, the own property is found first and its value overrides the value of the inherited property.

assert.deepEqual(Object.keys(obj), ['objProp']);

obj.protoProp = 'x'; // (A)

// We created a new own property:
assert.deepEqual(Object.keys(obj), ['objProp', 'protoProp']);

// The inherited property itself is unchanged:
assert.equal(proto.protoProp, 'a');







// =====================================  Sharing data via prototypes

const jane = {
    name: 'Jane',
    describe() {
        return 'Person named '+this.name;
    },
};
const tarzan = {
    name: 'Tarzan',
    describe() {
        return 'Person named '+this.name;
    },
};

assert.equal(jane.describe(), 'Person named Jane');
assert.equal(tarzan.describe(), 'Person named Tarzan');

/*We have two objects that are very similar. Both have two properties whose names are .name and .describe.
Additionally, method .describe() is the same. How can we avoid that method being duplicated?
We can move it to a shared prototype, PersonProto:*/

const PersonProto = {
    describe() {
        return 'Person named ' + this.name;
    },
};
const janeNew = {
    __proto__: PersonProto,
    name: 'Jane',
};
const tarzanNew = {
    __proto__: PersonProto,
    name: 'Tarzan',
};

assert.equal(janeNew.describe(), 'Person named Jane');   // This way of dynamically looking for methods, is called dynamic dispatch.
assert.equal(tarzanNew.describe(), 'Person named Tarzan');

// you can also make a call
PersonProto.describe.call(janeNew)








