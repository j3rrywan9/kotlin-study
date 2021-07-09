# Programming Kotlin

## Chapter 3 Working with Functions

Kotlin doesn't insist that you create classes for everything.
No one gets praise for duplicating code, but to reuse doesn't mean building a class hierarchy.
Unlike Java where a class is the smallest reusable piece, in Kotlin both standalone functions and classes can be reused.

Kotlin takes a highly pragmatic approach to creating good quality code - create small simple standalone functions where they suffice and roll your code into methods of classes only when necessary.

### Creating Functions

#### KISS FUNCTIONS

Function declarations start with the keyword `fun` - Kotlin wants you to remember to have fun every time you look at a function or a method.
The function name is followed by a parameter list, which may be empty.
If the function is a *single-expression function*, which is very short, then separate the body from the declaration using the `=` operator instead of using the `{}` block syntax.
For short functions, the return type can be inferred.
Also, the `return` keyword isn't allowed for single-expression functions, which are functions without a block body.

#### RETURN TYPE AND TYPE INFERENCE

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

## Chapter 6 Type Safety to Save the Day

Kotlin works hard to make your code more type safe and less error prone with enhanced null checks, smart type casting, and fluent type checking.

With Kotlin's design-by-contract approach, you clearly express if and when a function or a method may receive or return a `null` reference.
If a reference may possibly be `null`, then you're forced to perform a null check before you can access any useful methods or properties of the object that's referenced.
Also, Kotlin provides a number of operators to work with `null` types, which reduces the noise in code when dealing with references that may be `null`.
What's even more exciting about this capability is that these checks are purely at compile time and don't add anything to the bytecode.

Much like Java's `Object`, all classes in Kotlin inherit from the `Any` class.
This class brings under one fold a few common methods that are useful on instances of just about any class in Kotlin.

One of the more advanced concepts in Kotlin is the nice support for working with covariance and contravariance of generics parametric types.

### `Any` and `Nothing` Classes

Some methods like `equals()` and `toString()` are pervasive.
In Java you'd expect to find them in the Object base class.
In Kotlin, these methods are included in the `Any` class, along with a number of other methods that are useful on instances of any class.
`Any` is Kotlin's counterpart of Java's `Object` class, except `Any` has a lot of special methods that come in through extension functions.
Kotlin also has a class named `Nothing` that serves to stand in as type when a function literally is expected to return nothing - this is useful for type-checking methods when one or more branches is expected to return nothing.
Nothing in Java is equivalent to Kotlin’s Nothing.

#### ANY, THE BASE CLASS

#### NOTHING IS DEEPER THAN VOID

### Nullable References

#### NULL IS A SMELL

Kotlin handles this situation safely, elegantly, and gracefully.
To begin with, assigning `null` to a non-nullable reference or returning `null` where the reference type is non-nullable will result in a compilation error.

#### USING NULLABLE TYPES

Non-nullable types have a nullable counterpart.
Where the type is a non-nullable reference, you can pass only a valid reference that is non-null.
However, you may pass either a valid reference or a `null` to a nullable reference type.
On the receiving side, you can't use the object held by a nullable reference without first performing a `null` check.

The nullable types have a `?` suffix - that is, the counterpart for non-nullable `String` is `String?`.
Likewise, `Int` vs. `Int?`, `List<String>` vs. `List<String>?`, and `YourOwnClass` vs. `YourOwnClass?`.

Kotlin requires method calls on nullable references to be prefixed with either the safe-call operator or the non-null assertion operator - we'll see these operators soon.

#### SAFE-CALL OPERATOR

We can merge the null check and the call to a method or property into one step using `?.` — the safe-call operator.
If the reference is `null`, the safe-call operator will result in `null`.
Otherwise, the result will be the property or the result of the method call.
In any case, the type will be the nullable counterpart of the method's return type or property's type.

#### ELVIS OPERATOR

The Elvis operator will return the result of the expression to the left if it's not `null`, otherwise it will evaluate and return the result of the expression on the right.
The Elvis operator short circuits evaluation - that is, it doesn't evaluate what's on the right if that won't be used.

## Objects and Classes

Kotlin's facility to create and work with classes and objects is more akin to the features in Scala than in Java.
But Kotlin takes the low-ceremony approach further than Scala in a few ways.
You invoke class constructors like functions - there's no `new` keyword in Kotlin.
You don't waste your time and effort to define fields - that's an implementation detail that Kotlin takes care of.
Instead, you define properties, and Kotlin proceeds to generate the backing fields where necessary.
If your focus is on representing data rather than behavior, you can achieve that using data classes, for which Kotlin generates a few conventional methods.

### Objects and Singletons

By providing support for singletons directly, Kotlin removes the burden of implementing the pattern and the risks of getting it wrong.
When you need, you can directly create an object without being forced to first define a class.
For simple situations you can use objects, and for more complex cases, where you want to define an abstraction, you may create classes.

#### ANONYMOUS OBJECTS WITH OBJECT EXPRESSIONS

In its most basic form, an object expression is the keyword `object` followed by a block `{}`.

In Kotlin, use object expressions anywhere you'd use anonymous inner classes in Java.

#### SINGLETON WITH OBJECT DECLARATION

If you place a name between the `object` keyword and the block `{}`, then Kotlin considers the definition a statement or declaration instead of an expression.
Use an object expression to create an instance of an anonymous inner class and an object declaration to create a singleton - a class with a single instance.

### Creating Classes

The syntax for creating a class in Kotlin is closer to the facilities in Scala than in Java.
The number of options and flexibilities seem almost endless; let's start small and grow the code for creating a class incrementally.

#### SMALLEST CLASS

Here's the minimum syntax for a class—the class keyword followed by the name of the class:
```kotlin
class Car
```

#### READ-ONLY PROPERTIES

Let's define a property in the class:
```kotlin
class Car(val yearOfMake: Int)
```
By default, the access to the class and its members is public and the constructor is public as well.
In Kotlin, the line that defines the class is actually defining the primary constructor.
The keyword `constructor` isn't needed unless we want to change the access modifier or place an annotation for the primary constructor.

#### CREATING INSTANCES

Let's use the class to create an instance.
New in Kotlin, related to creating objects, is there's no `new` keyword.
To create an object use the class name like it's a function:
```kotlin
val car = Car(2019)
println(car.yearOfMake)
```
Much like `val` local variables, `val` properties are immutable too.

#### READ-WRITE PROPERTIES

Use `val` to define read-only properties and `var` for properties that may change.

#### A PEEK UNDER THE HOOD - FIELDS AND PROPERTIES

In Kotlin you access properties by providing the name of the property instead of the getter or setter.

#### CONTROLLING CHANGE TO PROPERTIES

### Companion Objects and Class Members

Companion objects are singletons defined within a class - they're singleton companions of classes.

#### CLASS-LEVEL MEMBERS

The members of the companion object of a class can be accessed using the class name as reference

#### ACCESSING THE COMPANION

#### COMPANION AS FACTORY

Whether you give an explicit name or not, the companion object can serve as a factory to create instances of the class they are part of.

To use a companion as a factory, provide a private constructor for the class.
Then, provide one or more methods in the companion object that creates the instance and carries out the desired steps on the object before returning to the caller.

### Creating Generics Classes

Following the class name, the parametric type and the constraint are specified within the angle brackets `<>`.

### Data Classes

Much like the case classes of Scala, the *data classes* of Kotlin are specialized classes that are intended to carry mostly data rather than behavior.
