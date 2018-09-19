/*
e.g. there are two files
file-tools.js
main.js

The module in file-tools.js exports its function isTextFilePath():

export function isTextFilePath(filePath) {
    return str.endsWith('.txt');
}
The module in main.js imports the whole module path and the function isTextFilePath():

// Import whole module as namespace object `path`
import * as path from 'path';
// Import a single export of module file-tools.js
import {isTextFilePath} from './file-tools.js';

*/


/*
Old way======================>
CommonJS:
Designed for servers.
Modules are meant to be loaded synchronously.
Compact syntax.

AMD (Asynchronous Module Definition) modules:
Designed for browsers.
Modules are meant to be loaded asynchronously. That’s a crucial requirement for browsers, where code can’t wait until a module has finished downloading. It has to be notified once the module is available.
The syntax is slightly more complicated. On the plus side, AMD modules can be executed directly, without customized creation and execution of source code (think eval()). That is not always permitted on the web.


ECMAScript modules===========>
ECMAScript modules comprise three parts:

- Declarative module syntax: What is a module? How are imports and exports declared?
- The semantics of the syntax: How are the variable bindings handled that are created by imports? How are exported variable bindings handled?
- A programmatic loader API for configuring module loading.
Parts 1 and 2 were introduced with ES6. Work on Part 3 is ongoing.
 */



/*
Default exports

my-func.js
main.js
Module my-func.js has a default export:

export default function () {
  return 'Hello!';
}
Module main.js default-imports the exported function:

import myFunc from './my-func.js';
assert.equal(myFunc(), 'Hello!');

Note the syntactic difference: The curly braces around named imports indicate that we are reaching into the module, while a default import is the module.

The most common use case for a default export is a module that contains a single function or a single class.

==============================

The two styles of default-exporting
There are two styles of doing default exports.

First, you can label existing declarations with export default:
export default function foo() {} // no semicolon!
export default class Bar {} // no semicolon!

Second, you can directly default-export values. In that style, export default is itself much like a declaration.
export default 'abc';
export default foo();
export default /^xyz$/;
export default 5 * 7;
export default { no: false, yes: true };
Why are there two default export styles? The reason is that export default can’t be used to label const: const may define multiple values, but export default needs exactly one value.

// Not legal JavaScript!
export default const foo = 1, bar = 2, baz = 3;
With this hypothetical code, you don’t know which one of the three values is the default export.
 */






/*
Module specifiers:
One key rule is:

All ES modules specifiers must be valid URLs.

That means that paths to sibling files must include file name extensions. Beyond that, everything is still in flux. CommonJS distinguishes several kinds of module specifiers:

Relative paths: start with a dot. Examples:

'./some/other/module.js'
'../../lib/counter.js'
Absolute paths: start with a slash. Example:

'/home/jane/file-tools.js'
URLs: include a protocol (technically, paths are URLs, too). Example:

'https://example.com/some-module.js'
Bare paths: do not start with a dot, a slash or a protocol. Additionally, Node.js set the precedence of them never having file name extensions.

'lodash'
'mylib/string-tools'
In Node.js, module specifiers are handled as follows:

Relative and absolute paths are interpreted as expected. In Node.js, module specifiers often have no file name extension.
Only file: URLs are supported, at the moment.
Bare paths are looked up in node_modules, where npm installs packages.
Browsers handle module specifiers as follows:

Relative paths, absolute paths and URLs are straightforward and handled as expected. You must include a file name extension.
How bare paths will end up being handled is not yet clear. You may eventually be able to map them to other specifiers via lookup tables.
Note that bundling tools such as browserify and webpack that compile multiple modules into single files are less restrictive w.r.t. module specifiers than browsers, because they operate at compile time, not at runtime.


 */




/*
Syntactic pitfall: importing is not destructuring
Both importing and destructuring look similar:

import {foo} from './bar.js'; // import
const {foo} = require('./bar.js'); // destructuring
But they are quite different:

You can destructure again inside a destructuring pattern, but the {} in an import statement can’t be nested.
Imports don’t lose the connection to their exports.
The syntax for renaming is different:

import {foo as f} from './bar.js'; // importing
const {foo: f} = require('./bar.js'); // destructuring
Rationale: Destructuring is reminiscent of an object literal (incl. nesting), while importing evokes the idea of renaming.
 */