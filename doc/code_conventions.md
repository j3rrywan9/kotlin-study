# Code Conventions

## Formatting

In most cases, Kotlin follows the Java coding conventions.

Use 4 spaces for indentation.
Do not use tabs.

For curly braces, put the opening brace in the end of the line where the construct begins, and the closing brace on a separate line aligned horizontally with the opening construct.

### Horizontal whitespace

Put spaces around binary operators `(a + b)`.
Exception: don't put spaces around the "range to" operator `(0..i)`.

### Colon

Put a space before `:` in the following cases:
* when it's used to separate a type and a supertype;
* when delegating to a superclass  constructor or a different constructor of the same class;
* after the `Object` keyword.

Don't put a space before `:` when it separates a declaration and its type.

Always put a space after `:`.
