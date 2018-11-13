const fs = require('fs');

let fetchNotes = () => {
  try {
    let noteString = fs.readFileSync('notes-data.json');
    return JSON.parse(noteString);
  } catch (e) {
    return [];
  }
};

let saveNotes = (notes) => {
  fs.writeFileSync('notes-data.json', JSON.stringify(notes));
};

let addNote = (title, body) => {
  console.log('Adding note', title, body);
  let notes = fetchNotes();
  let note = {
    // title: title // below is an equivalent in es6
    title,
    body
  };

  // let duplicateNotes = notes.filter((note) => {
  //   return note.title === title;
  // });  es6 same:
  let duplicateNotes = notes.filter((note) => note.title === title);
  if (duplicateNotes.length === 0) {
    notes.push(note);
    saveNotes(notes);
    return note;
  }
};

let getAll = () => {
  return fetchNotes();
};

let readNote = (title) => {
  let notes = fetchNotes();
  let result = notes.filter((note) => note.title === title);
  return result[0];
};

let removeNote = (title) => {
  let notes = fetchNotes();
  let result = notes.filter((note) => note.title !== title);
  saveNotes(result);

  return notes.length !== result.length;
};

let logNote = (note) => {
  debugger;
  console.log(`Note is ${note.title} with body ${note.body}`);
};

// module.exports.addNote = function () {};
// will use instead
// module.exports.addNote = () => {
//   return 'New note';
// };

module.exports = {
  // addNote: addNote // in ES6 if names they are equals => you can use:
  addNote,
  getAll,
  readNote,
  removeNote,
  logNote
}
