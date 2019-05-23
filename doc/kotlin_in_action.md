# Kotlin in Action

## Chapter 1

What is Kotlin all about?
It's a new programming language targeting the Java platform.
Kotlin is concise, safe, pragmatic, and focused on interoperability with Java code.

### Kotlin's primary traits

####

The primary goal of Kotlin is to provide a more concise, more productive, safer alternative to Java that's suitable in all contexts where Java is used today.

#### Statically typed

Just like Java, Kotlin is a *statically typed* programming language.
This means the type of every expression in a program is known at compile time, and the compiler can validate that the methods and fields you're trying to access exist on the objects you're using.

On the other hand, in contrast to Java, Kotlin doesn't require you to specify the type of every variable explicitly in your source code.
In many cases, the type of a variable can automatically be determined from the context, allowing you to omit the type declaration.

The ability of the compiler to determine types from context is called *type inference*.

#### Functional and object-oriented

#### Free and open source

The Kotlin language, including the compiler, libraries, and all related tooling, is entirely open source and free to use for any purpose.

### Kotlin applications

### The philosophy of Kotlin

#### Pragmatic

#### Concise

It's common knowledge that developers spend more time reading existing code than writing new code.

The simpler and more concise the code is, the faster you'll understand what's going on.

#### Safe

In general, when we speak of a programming language as *safe*, we mean its design prevents certain kinds of errors in a program.

Most important, Kotlin strives to remove the `NullPointerException` from your program.
Kotlin's type system tracks values that can and can't be `null` and forbids operations that can lead to a `NullPointerException` at runtime.
The additional cost required for this is minimal: marking a type as nullable takes only a single character, a question mark at the end:
```kotlin
val s: String? = null
val s2: String = ""
```
In addition, Kotlin provides many convenient ways to handle nullable data.
This helps greatly in eliminating application crashes.

#### Interoperable

### Using the Kotlin tools

## Chapter 2

### Basic elements

#### Functions

#### Variables

By default, you should strive to declare all variables in Kotlin with the `val` keyword.
Change it to `var` only if necessary.
Using immutable references, immutable objects, and functions without side effects makes your code closer to the functional style.

#### String templates

### Classes and properties

### Representing and handling choices: enums and "when"

#### Declaring enum classes

In Kotlin, `enum` is a so-called *soft keyword*: it has a special meaning when it comes before `class`, but you can use it as a regular name in other places.

Note that this example shows the only place in the Kotlin syntax where you're required to use semicolons: if you define any methods in the enum class, the semicolon separates the enum constant list from the method definitions.

### Exceptions in Kotlin

Exception handling in Kotlin is similar to the way it’s done in Java and many other languages.
A function can complete in a normal way or throw an exception if an error occurs.
The function caller can catch this exception and process it; if it doesn't, the exception is rethrown further up the stack.

## Chapter 3

### Creating collections in Kotlin

As you can see, Kotlin uses the standard Java collection classes.
This is good news for Java developers: Kotlin doesn't have its own set of collection classes.
All of your existing knowledge about Java collections still applies here.

Even though Kotlin's collections are exactly the same classes as Java collections, you can do much more with them in Kotlin.

### Making functions easier to call

#### Named arguments

When calling a function written in Kotlin, you can specify the names of some arguments that you're passing to the function.
If you specify the name of an argument in a call, you should also specify the names for all the arguments after that, to avoid confusion.

#### Default parameter values

### Working with collections

#### Varargs: functions that accept an arbitrary number of arguments

You're probably familiar with Java's varargs: a feature that allows you to pass an arbitrary number of values to a method by packing them in an array.
Kotlin's varargs are similar to those in Java, but the syntax is slightly different: instead of three dots after the type, Kotlin uses the `vararg` modifier on the parameter.

One other difference between Kotlin and Java is the syntax of calling the function when the arguments you need to pass are already packed in an array.
In Java, you pass the array as is, whereas Kotlin requires you to explicitly unpack the array, so that every array element becomes a separate argument to the function being called.
Technically, this feature is called using a *spread operator*, but in practice it's as simple as putting the `*` character before the corresponding argument:
```kotlin
fun main(args: Array<String>) {
    val list = listOf("args: ", *args)
    println(list)
}
```
