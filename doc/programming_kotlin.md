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

## Using Collections

You can pretty much use any collection available in Java directly from within Kotlin.
But, Kotlin also offers a few view interfaces over Java collections, which provide a pleasant and a safer coding experience.

For example, Kotlin provides `Pair` and `Triple` for a collection of two or three values, respectively.

### Flavors of Collections

#### CONVENIENCE METHODS ADDED BY KOTLIN

Through the `kotlin.collectionS` package, of the standard library, Kotlin adds many useful convenience functions to various Java collections.
You can use the Java collections from within Kotlin, in ways you're familiar with.
For the same collections, when coding in Kotlin, you can also use the methods that Kotlin has added.

#### VIEWS

Kotlin provides two different views for lists, sets, and maps: the read-only or immutable view, and the read-write or mutable view.
Both views simply map to the same underlying collection in Java.
There's no runtime overhead, and there are no conversions at compile time or runtime when you use these views instead of the original collection.
The read-only view permits only read operations;
any attempt to write using a read-only reference will fail at compile time.

### Using `Pair` and `Triple`

Tuples are sequences of objects of small, finite size.
Unlike some languages that provide a way to create tuples of different sizes, Kotlin provides two specific types: `Pair` for a tuple of size two and `Triple` for a size of three.
Use these two when you want to quickly create two or three objects as a collection.

The ability to create a pair of objects with such concise syntax is useful. The need to work with a pair of objects is common in programming.

`Pair` is useful when working with two values.
While it looks special, it's just another class written in the Kotlin standard library.
You may create your own classes like that where you need.

If you have a need for three objects, then instead of `Pair` use `Triple`.

Both `Pair` and `Triple` are immutable and are useful to create a grouping of two and three values, respectively.
If you need to group more than three immutable values, then consider creating a *data class*.

### Arrays of Objects and Primitives

The easiest way to create an array is using the `arrayOf()` top-level function.
Once you create an array, you may access the elements using the index `[]` operator.

In addition to using the index operator `[]` to get and set values, you may determine the size of the array using the `size` property.
Also, you may use one of many functions on `Array` to conveniently work with arrays.

### Using List

As a first step in creating a list, Kotlin wants you to declare your intent - immutable or mutable.
To create an immutable list, use `listOf()` - immutability is implied, which should also be our preference when there's a choice.
But if you really need to create a mutable list, then use `mutableListOf()`.

To access an element in the list you may use the traditional `get()` method, but the index operator `[]`, which routes to the same method, may be used as well.

But, after enough thought and discussions, if you decide that's the right choice, you can create one using the `mutableListOf()` function.
All the operations you were able to perform on `List<T>` are readily available on the instance of `MutableList<T>` as well.

### Using Set

### Using Map

You may use `mapOf()` to create a map and get a reference to the read-only interface `Map<K, V>`.
Alternatively, use `mutableMapOf()` to get access to `MutableMap<K, V>`.
Also, you may obtain a reference to the JDK `HashMap` using `hashMapOf()`, `LinkedHashMap` using `linkedMapOf()`, and `SortedMap` using `sortedMapOf()`.

You may iterate over all the keys in the map using the `keys` property or all the values using the `values` property.
You may also check if a particular key or value exists using the `containsKey()` and `containsValue()` methods, respectively.
