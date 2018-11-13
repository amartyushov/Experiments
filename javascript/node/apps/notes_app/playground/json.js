// let obj = {
//   name: 'Alex'
// };
//
// let stringObj = JSON.stringify(obj);
// console.log(typeof stringObj);
// console.log(stringObj);

// let personString = '{"name": "Alex", "age": 25}'
// let json = JSON.parse(personString);
// console.log(typeof json);
// console.log(json);
// console.log(json.name);

const fs = require('fs');

let originalNote = {
  title: 'some title',
  body: 'some body'
};

let originalNoteString = JSON.stringify(originalNote);

fs.writeFileSync('notes.json', originalNoteString);

let noteString = fs.readFileSync('notes.json');
let note = JSON.parse(noteString);
console.log(typeof note);
console.log(note.title);
