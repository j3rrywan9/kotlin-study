# Head First Kotlin

## Chapter 1

Kotlin lets you create object-oriented code that uses classes, inheritance and polymorphism, just as you can in Java.
But it also supports functional programming, giving you the best of both worlds.

Kotlin code can be compiled to JVM (Java Virtual Machine) bytecode, so you can use Kotlin practically anywhere that you can use Java.
Kotlin is 100% interoperable with Java, so you can use existing Java libraries with it.

### Anatomy of the main function

Whenever you write a Kotlin application, you *must* add a function to it called `main`, which starts your application.
When you run your code, the JVM looks for this function, and executes it.

The `fun` keyword is followed by the name of the function, in this case `main`.
Naming the function `main` means that it will be automatically executed when you run the application.

The code in the braces `()` after the function name tells the compiler what arguments (if any) the function takes.
Here, the code `args: Array<String>` specifies that the function accepts an array of `String`s, and this array is named `args`.

From Kotlin 1.3, however, you can omit `main`'s parameters so that the function looks like this:
```kotlin
fun main() {
    // Your code goes here
}
```

### Loop and loop and loop...

### Conditional branching

### Using `if` to return a value

In Kotlin, you can use `if` as an expression, so that it returns a value.
When you use `if` as an expression, you MUST include an `else` clause.

## Chapter 2

### Kotlin's basic types

#### Integers

Kotlin has four basic integer types: `Byte`, `Short`, `Int` and `Long`.
Each type can hold a fixed number of bits.

#### Floating points

There are two basic floating-point types: **Float** and **Double**.
`Float`s can hold 32 bits, whereas `Double`s can hold 64 bits.

#### Booleans

**Boolean** variables are used for values that can either be `true` or `false`.

#### Characters and Strings

There are two more basic types: **Char** and **String**.

### How to explicitly declare a variable's type

Instead of letting the compiler infer the variable’s type from its value, you put a colon (`:`) after the variable's name, followed by the type you want it to be.

### Assigning a value to another variable

### Store multiple values in an array

#### How to create an array

You create an array using the `arrayOf()` function.

You can get the value of an item in the array by referencing the array variable with an index.

## Chapter 3

### You can get things back from a function

If you want to get something back from a function, you need to declare it.

If you declare that a function returns a value, then you must return a value of the declared type.

#### Functions with no return value

If you don't want your function to return a value, you can either omit the return type from the function declaration, or specify a return type of `Unit`.
Declaring a return type of `Unit` means that the function returns no value.

## Chapter 4

Classes are *templates* that allow you to **create your own types of objects**, and define their properties and functions.

### Object types are defined using classes

A class is a template that defines what properties and functions are associated with objects of that type.

#### You can define your own classes

### How to design your own classes

### How to access properties and functions

Once you've created an object, you can access its properties using the dot operator (`.`).

You can also update any properties that you have defined using the `var` keyword.

Note that the compiler won't let you update any properties that you've defined using the `val` keyword.

You can also use the dot operator to call an object's functions.

### How objects are created

A constructor contains the code that's needed to initialize an object.
It runs before the object can be assigned to a reference, which means that you get a chance to step in, and do things to make the object ready for use.
Most people use constructors to define an object's properties and assign values to them.

Each time you create a new object, the constructor for that object's class is invoked.

### How to write a custom setter

A setter is a function named **set** that's added to the property by writing it beneath the property declaration.
A setter has one parameter - usually named `value` — which is the proposed new value of the property.

The setter updates the value of the property by means of the **field** identifier.
`field` refers to the property's backing field, which you can think of as being a reference to the underlying value of the property.
Using field in your getters and setters in place of the property name is important, as it stops you getting stuck in an endless loop.

## Chapter 5

### Declare the superclass and its properties and functions as open

Before a class can be used as a superclass, you have to explicitly tell the compiler that this is allowed.
You do this by prefixing the name of the class—and any properties or functions you want to override — with the keyword **open**.
This tells the compiler that you've designed the class to be a superclass, and that you're happy for the properties and functions you've declared as `open` to be overridden.

### How a subclass inherits from a superclass

To make a class inherit from another, you add a colon (`:`) to the class header followed by the name of the superclass.
This makes the class a subclass, and gives it all the properties and functions of the class it inherits from.

Calling the superclass constructor is mandatory: if the superclass has a primary constructor, then you *must* call it in the subclass header or your code won't compile.
And even if you haven't explicitly added a constructor to your superclass, remember that the compiler automatically creates an empty one for you when the code gets compiled.
