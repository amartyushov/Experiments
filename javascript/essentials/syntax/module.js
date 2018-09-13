// e.g. there are two files
// file-tools.js
// main.js

// The module in file-tools.js exports its function isTextFilePath():
//
// export function isTextFilePath(filePath) {
//     return str.endsWith('.txt');
// }
// The module in main.js imports the whole module path and the function isTextFilePath():
//
// // Import whole module as namespace object `path`
// import * as path from 'path';
// // Import a single export of module file-tools.js
// import {isTextFilePath} from './file-tools.js';