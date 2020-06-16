# Programming Kotlin

## Working with Functions

Kotlin doesn't insist that you create classes for everything.
No one gets praise for duplicating code, but to reuse doesn't mean building a class hierarchy.
Unlike Java where a class is the smallest reusable piece, in Kotlin both standalone functions and classes can be reused.

### Creating Functions

#### DEFINING PARAMETERS

Kotlin insists on specifying the types for parameters to functions and methods.
Provide the type of the parameter right after the parameter's name, separated by `:`.

Kotlin doesn't want us to make a choice here for function and method parameters;
it decided that modifying parameters passed to functions is a bad idea.
You can't say `val` or `var` for parameters - they're implicitly `val`, and any effort to change the parameters' values within functions or methods will result in compilation errors.

#### FUNCTIONS WITH BLOCK BODY

### Default and Named Arguments

The default argument doesn't have to be a literal;
it may be an expression.
Also, you may compute the default arguments for a parameter using the parameters to its left.

Named arguments make method calls readable and also eliminate potential errors when adding new parameters to existing functions.
Use them when the parameters passed in aren't obvious.

### varargs and Spread

#### VARIABLE NUMBER OF ARGUMENTS

In Kotlin, functions may take a variable number of arguments.

### Destructuring

Destructuring is the opposite - to extract values into variables from within an existing object.

## External Iteration and Argument Matching

### Range and Iteration

#### RANGE CLASSES

Kotlin raises the level of abstraction to iterate over a range of values with specialized classes.

#### FORWARD ITERATION

#### REVERSE ITERATION

### Iterating over Arrays and Lists

You can seamlessly use any of the JDK collection classes and interfaces in Kotlin.
Thus, you can use Java's array and `java.util.List` in Kotlin as well.
Creating instances of these in Kotlin is simpler than in Java, and you can iterate over the values in these collections with greater ease in Kotlin.

To create an array of values, use the `arrayOf()` function that belongs to the kotlin package.

Since all the values given are of type `Int`, the array created in this example is an array of `Integer` values.
To create a primitive int array, instead of an array of `Integer` objects, use the `intArrayOf()` function.

The `indices` property provides a range of index values.

Alternatively, we can get both the index and the position in one shot, using the `withIndex()` function along with an application of destructuring, like so:
```kotlin
for ((index, name) in names.withIndex()) {
  println("Position of $name is $index")
}
```

### When It's Time to Use `when`

#### WHEN AS AN EXPRESSION

#### WHEN AS A STATEMENT
