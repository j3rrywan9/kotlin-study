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

## Chapter 4

### Defining class hierarchies

#### Interfaces in Kotlin

Kotlin interfaces are similar to those of Java 8: they can contain definitions of abstract methods as well as implementations of non-abstract methods (similar to the Java 8 default methods), but they can't contain any state.

To declare an interface in Kotlin, use the `interface` keyword instead of `class`.

The `override` modifier, similar to the `@Override` annotation in Java, is used to mark methods and properties that override those from the superclass or interface.
Unlike Java, using the `override` modifier is mandatory in Kotlin.
This saves you from accidentally overriding a method if it's added after you wrote your implementation; your code won't compile unless you explicitly mark the method as `override` or rename it.

An interface method can have a default implementation.
Unlike Java 8, which requires you to mark such implementations with the `default` keyword, Kotlin has no special annotation for such methods: you just provide a method body.

#### Open, final, and abstract modifiers: final by default

Kotlin follows the same philosophy.
Whereas Java's classes and methods are open by default, Kotlin's are `final` by default.

If you want to allow the creation of subclasses of a class, you need to mark the class with the `open` modifier.
In addition, you need to add the `open` modifier to every property or method that can be overridden.

Note that if you override a member of a base class or interface, the overriding member will also be `open` by default.
If you want to change this and forbid the subclasses of your class from overriding your implementation, you can explicitly mark the overriding member as `final`.

#### Visibility modifiers: public by default

Basically, visibility modifiers in Kotlin are similar to those in Java.
You have the same `public`, `protected`, and `private` modifiers.
But the default visibility is different: if you omit a modifier, the declaration becomes `public`.

#### Inner and nested classes: nested by default

A nested class in Kotlin with no explicit modifiers is the same as a static nested class in Java.
To turn it into an inner class so that it contains a reference to an outer class, you use the `inner` modifier.

#### Sealed classes: defining restricted class hierarchies

Kotlin provides a solution to this problem: `sealed` classes.
You mark a superclass with the `sealed` modifier, and that restricts the possibility of creating subclasses.
All the direct subclasses must be nested in the superclass:
```kotlin
sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}
```
If you handle all subclasses of a `sealed` class in a `when` expression, you don't need to provide the default branch.
Note that the `sealed` modifier implies that the class is open; you don't need an explicit `open` modifier.

When you use `when` with `sealed` classes and add a new subclass, the `when` expression returning a value fails to compile, which points you to the code that must be changed.

### Declaring a class with nontrivial constructors or properties

In Java, as you know, a class can declare one or more constructors.
Kotlin is similar, with one additional change: it makes a distinction between a *primary* constructor (which is usually the main, concise way to initialize a class and is declared outside of the class body) and a *secondary* constructor (which is declared in the class body).
It also allows you to put additional initialization logic in *initializer blocks*.

#### Initializing classes: primary constructor and initializer blocks

#### Secondary constructors: initializing the superclass in different ways

Generally speaking, classes with multiple constructors are much less common in Kotlin code than in Java.
The majority of situations where you'd need overloaded constructors in Java are covered by Kotlin's support for default parameter values and named argument syntax.

### The "object" keyword: declaring a class and creating an instance, combined

The object keyword comes up in Kotlin in a number of cases, but they all share the same core idea: the keyword defines a class and creates an instance (in other words, an object) of that class at the same time.
Let's look at the different situations when it's used:
* *Object declaration* is a way to define a singleton.
* *Companion objects* can contain factory methods and other methods that are related to this class but don't require a class instance to be called.
Their members can be accessed via class name.
* *Object expression* is used instead of Java's anonymous inner class.

#### Object declarations: singletons made easy

Kotlin provides first-class language support for this using the *object declaration* feature.
The *object declaration* combines a *class declaration* and a declaration of a *single instance* of that class.

Object declarations are introduced with the `object` keyword.
An object declaration effectively defines a class and a variable of that class in a single statement.

Just like a class, an object declaration can contain declarations of properties, methods, initializer blocks, and so on.
The only things that aren't allowed are constructors (either primary or secondary).
Unlike instances of regular classes, object declarations are created immediately at the point of definition, not through constructor calls from other places in the code.
Therefore, defining a constructor for an object declaration doesn't make sense.

#### Companion objects: a place for factory methods and static members

One of the objects defined in a class can be marked with a special keyword: `companion`.
If you do that, you gain the ability to access the methods and properties of that object directly through the name of the containing class, without specifying the name of the object explicitly.
The resulting syntax looks exactly like static method invocation in Java.

The companion object has access to all `private` members of the class, including the `private` constructor, and it's an ideal candidate to implement the Factory pattern.

#### Object expressions: anonymous inner classes rephrased

The `object` keyword can be used not only for declaring named singleton-like objects, but also for declaring *anonymous objects*.
Anonymous objects replace Java's use of anonymous inner classes.

The syntax is the same as with object declarations, except that you omit the name of the object.
The object expression declares a class and creates an instance of that class, but it doesn't assign a name to the class or the instance.
Typically, neither is necessary, because you'll use the object as a parameter in a function call.

## Chapter 5

Lambda expressions, or simply lambdas, are essentially small chunks of code that can be passed to other functions.
With lambdas, you can easily extract common code structures into library functions, and the Kotlin standard library makes heavy use of them.
One of the most common uses for lambdas is working with collections, and in this chapter you'll see many examples of replacing common collection access patterns with lambdas passed to standard library functions.

### Lambda expressions and member references

#### Introduction to lambdas: blocks of code as function parameters

#### Lambdas and collections

#### Syntax for lambda expressions

#### Accessing variables in scope

#### Member references

Note that, regardless of whether you're referencing a function or a property, you shouldn't put parentheses after its name in a member reference.
