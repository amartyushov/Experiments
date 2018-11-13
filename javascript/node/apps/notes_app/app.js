// nodejs.org/api

const fs = require('fs');
const _ = require('lodash');
const yargs = require('yargs');

const notes = require('./notes.js');

const titleOptions = {
  describe: 'Title of note',
  demand: true,   // is it optional or not
  alias: 't'
};

const bodyOptions = {
  describe: 'Body of the note',
  demand: true,
  alias: 'b'
}

const argv = yargs
  .command('add', 'Add a new note', {
    title: titleOptions,
    body: bodyOptions
  })
  .command('list', 'List all notes')
  .command('read', 'Read a note', {
    title: titleOptions
  })
  .command('remove', 'Remove a note', {
    title: titleOptions
  })
  .help()
  .argv;
// let command = process.argv[2]; // alternative way, bad actually
let command = argv._[0];

if (command === 'add') {
  let note = notes.addNote(argv.title, argv.body);
  note === undefined ? console.log('Duplicate note') : notes.logNote(note);

} else if (command === 'list') {
  let allNotes = notes.getAll();
  console.log(`Printing ${allNotes.length} note(s).`);
  allNotes.forEach((note) => notes.logNote(note));

} else if (command === 'read') {
  let note = notes.readNote(argv.title);
  note === undefined ? console.log('Note not found') : notes.logNote(note);

} else if (command === 'remove') {
  let removed = notes.removeNote(argv.title);
  removed ? console.log('removed') : console.log('Not removed');;

} else {
  console.log('command not recognised');
}
