# Kotlin in Action

## Chapter 1

What is Kotlin all about?
It's a new programming language targeting the Java platform.
Kotlin is concise, safe, pragmatic, and focused on interoperability with Java code.

### Kotlin's primary traits

#### Target platforms: server-side, Android, anywhere Java runs

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

## Chapter 2. Kotlin basics

### 2.1 Basic elements: functions and variables

#### 2.1.2 Functions

You saw how to declare a function that has nothing to return.
But where should you put a return type for a function that has a meaningful result?
You can guess that it should go somewhere after the parameter list:
```kotlin
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
```
The function declaration starts with the `fun` keyword, followed by the function name: `max`, in this case.
It's followed by the parameter list in parentheses.
The return type comes after the parameter list, separated from it by a colon.

#### 2.1.3 Variables

By default, you should strive to declare all variables in Kotlin with the `val` keyword.
Change it to `var` only if necessary.
Using immutable references, immutable objects, and functions without side effects makes your code closer to the functional style.

#### 2.1.4 Easier string formatting: string templates

This example introduces a feature called *string templates*.
In the code, you declare a variable name and then use it in the following string literal.
Like many scripting languages, Kotlin allows you to refer to local variables in string literals by putting the `$` character in front of the variable name.

### 2.2 Classes and properties

You probably aren't new to object-oriented programming and are familiar with the abstraction of a *class*.
Kotlin's concepts in this area will be familiar to you, but you'll find that many common tasks can be accomplished with much less code.

Note that the modifier `public` disappeared during the conversion from Java to Kotlin.
In Kotlin, `public` is the default visibility, so you can omit it.

#### 2.2.1 Properties

In Kotlin, properties are a first-class language feature, which entirely replaces fields and accessor methods.

#### 2.2.2 Custom accessors

This section shows you how to write a custom implementation of a property accessor.

#### 2.2.3 Kotlin source code layout: directories and packages

You can also import all declarations defined in a particular package by putting `.*` after the package name.
Note that this star import will make visible not only classes defined in the package, but also top-level functions and properties.

In Kotlin, you can put multiple classes in the same file and choose any name for that file.
Kotlin doesn't impose any restrictions on the layout of source files on disk;
you can use any directory structure to organize your files.

In most cases, however, it's still a good practice to follow Java's directory layout and to organize source files into directories according to the package structure.
Sticking to that structure is especially important in projects where Kotlin is mixed with Java, because doing so lets you migrate the code gradually without introducing any surprises.
But you shouldn't hesitate to pull multiple classes into the same file, especially if the classes are small (and in Kotlin, they often are).

### 2.3 Representing and handling choices: enums and "when"

#### 2.3.1 Declaring enum classes

In Kotlin, `enum` is a so-called *soft keyword*: it has a special meaning when it comes before `class`, but you can use it as a regular name in other places.

Note that this example shows the only place in the Kotlin syntax where you're required to use semicolons: if you define any methods in the enum class, the semicolon separates the enum constant list from the method definitions.

#### Using `when` to deal with enum classes

In Java, you can use a `switch` statement for this.
The corresponding Kotlin construct is `when`.

### Iterating over things: "while" and "for" loops

#### The "while" loop

Kotlin has `while` and `do-while` loops, and their syntax doesn't differ from the corresponding loops in Java.

#### Iterating over numbers: ranges and progressions

As we just mentioned, in Kotlin there's no regular Java `for` loop, where you initialize a variable, update its value on every step through the loop, and exit the loop when the value reaches a certain bound.
To replace the most common use cases of such loops, Kotlin uses the concepts of *ranges*.

A range is essentially just an interval between two values, usually numbers: a start and an end.
You write it using the `..` operator:
```kotlin
val oneToTen = 1..10
```
Note that ranges in Kotlin are *closed* or *inclusive*, meaning the second value is always a part of the range.

In many cases, it's more convenient to iterate over half-closed ranges, which don't include the specified end point.
To create such a range, use the `until` function.

### Exceptions in Kotlin

Exception handling in Kotlin is similar to the way it’s done in Java and many other languages.
A function can complete in a normal way or throw an exception if an error occurs.
The function caller can catch this exception and process it; if it doesn't, the exception is rethrown further up the stack.

## Chapter 3

### 3.1 Creating collections in Kotlin

As you can see, Kotlin uses the standard Java collection classes.
This is good news for Java developers: Kotlin doesn't have its own set of collection classes.
All of your existing knowledge about Java collections still applies here.

Even though Kotlin's collections are exactly the same classes as Java collections, you can do much more with them in Kotlin.

### 3.2 Making functions easier to call

#### 3.2.1 Named arguments

The first problem we'll address concerns the readability of function calls.

When calling a function written in Kotlin, you can specify the names of some arguments that you're passing to the function.
If you specify the name of an argument in a call, you should also specify the names for all the arguments after that, to avoid confusion.

#### 3.2.2 Default parameter values

Another common Java problem is the overabundance of overloaded methods in some classes.

In Kotlin, you can often avoid creating overloads because you can specify default values for parameters in a function declaration.

When using the regular call syntax, you have to specify the arguments in the same order as in the function declaration, and you can omit only trailing arguments.
If you use named arguments, you can omit some arguments from the middle of the list and specify only the ones you need, in any order you want:
```kotlin
joinToString(list, suffix = ";", prefix = "#")
```

##### Default values and Java

Given that Java doesn't have the concept of default parameter values, you have to specify all the parameter values explicitly when you call a Kotlin function with default parameter values from Java.
If you frequently need to call a function from Java and want to make it easier to use for Java callers, you can annotate it with `@JvmOverloads`.
This instructs the compiler to generate Java overloaded methods, omitting each of the parameters one by one, starting from the last one.

#### 3.2.3 Getting rid of static utility classes: top-level functions and properties

In Kotlin, you don't need to create all those meaningless classes.
Instead, you can place functions directly at the top level of a source file, outside of any class.
Such functions are still members of the package declared at the top of the file, and you still need to import them if you want to call them from other packages, but the unnecessary extra level of nesting no longer exists.

### 3.3 Adding methods to other people's classes: extension functions and properties

#### 3.3.1 Imports and extension functions

#### 3.3.2 Calling extension functions from Java

#### 3.3.3 Utility functions as extensions

#### 3.3.4 No overriding for extension functions

#### 3.3.5 Extension properties

Extension properties provide a way to extend classes with APIs that can be accessed using the property syntax, rather than the function syntax.
Even though they're called *properties*, they can't have any state, because there's no proper place to store it: it's not possible to add extra fields to existing instances of Java objects.
But the shorter syntax is still sometimes handy.

### 3.4 Working with collections: varargs, infix calls, and library support

#### 3.4.1 Extending the Java Collections API

#### 3.4.2 Varargs: functions that accept an arbitrary number of arguments

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

### 4.1 Defining class hierarchies

#### 4.1.1 Interfaces in Kotlin

Kotlin interfaces are similar to those of Java 8: they can contain definitions of abstract methods as well as implementations of non-abstract methods (similar to the Java 8 default methods), but they can't contain any state.

To declare an interface in Kotlin, use the `interface` keyword instead of `class`.
```kotlin
interface Clickable {
    fun click()
}
```
This declares an interface with a single abstract method named click.
All non-abstract classes implementing the interface need to provide an implementation of this method.Here's how you implement the interface.
```kotlin
class Button : Clickable {
    override fun click() = println("I was clicked")
}
```
Kotlin uses the colon after the class name to replace both the `extends` and `implements` keywords used in Java.
As in Java, a class can implement as many interfaces as it wants, but it can extend only one class.

The `override` modifier, similar to the `@Override` annotation in Java, is used to mark methods and properties that override those from the superclass or interface.
Unlike Java, using the `override` modifier is mandatory in Kotlin.
This saves you from accidentally overriding a method if it's added after you wrote your implementation; your code won't compile unless you explicitly mark the method as `override` or rename it.

An interface method can have a default implementation.
Unlike Java 8, which requires you to mark such implementations with the `default` keyword, Kotlin has no special annotation for such methods: you just provide a method body.

#### 4.1.2 Open, final, and abstract modifiers: final by default

Kotlin follows the same philosophy.
Whereas Java's classes and methods are open by default, Kotlin's are `final` by default.

If you want to allow the creation of subclasses of a class, you need to mark the class with the `open` modifier.
In addition, you need to add the `open` modifier to every property or method that can be overridden.

Note that if you override a member of a base class or interface, the overriding member will also be `open` by default.
If you want to change this and forbid the subclasses of your class from overriding your implementation, you can explicitly mark the overriding member as `final`.

#### 4.1.3 Visibility modifiers: public by default

Basically, visibility modifiers in Kotlin are similar to those in Java.
You have the same `public`, `protected`, and `private` modifiers.
But the default visibility is different: if you omit a modifier, the declaration becomes `public`.

The default visibility in Java, package-private, isn't present in Kotlin.
Kotlin uses packages only as a way of organizing code in namespaces; it doesn't use them for visibility control.

As an alternative, Kotlin offers a new visibility modifier, `internal`, which means "visible inside a module."
A module is a set of Kotlin files compiled together.
It may be an IntelliJ IDEA module, an Eclipse project, a Maven or Gradle project, or a set of files compiled with an invocation of the Ant task.

#### 4.1.4 Inner and nested classes: nested by default

A nested class in Kotlin with no explicit modifiers is the same as a static nested class in Java.
To turn it into an inner class so that it contains a reference to an outer class, you use the `inner` modifier.

#### 4.1.5 Sealed classes: defining restricted class hierarchies

Kotlin provides a solution to this problem: `sealed` classes.
You mark a superclass with the `sealed` modifier, and that restricts the possibility of creating subclasses.
All the direct subclasses must be nested in the superclass:
```kotlin
sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
    when (e) {
        is Expr.Num -> e.value
        is Expr.Sum ->
    }
```
If you handle all subclasses of a `sealed` class in a `when` expression, you don't need to provide the default branch.
Note that the `sealed` modifier implies that the class is open; you don't need an explicit `open` modifier.

When you use `when` with `sealed` classes and add a new subclass, the `when` expression returning a value fails to compile, which points you to the code that must be changed.

### 4.2 Declaring a class with nontrivial constructors or properties

In Java, as you know, a class can declare one or more constructors.
Kotlin is similar, with one additional change: it makes a distinction between a *primary* constructor (which is usually the main, concise way to initialize a class and is declared outside of the class body) and a *secondary* constructor (which is declared in the class body).
It also allows you to put additional initialization logic in *initializer blocks*.

#### 4.2.1 Initializing classes: primary constructor and initializer blocks

#### 4.2.2 Secondary constructors: initializing the superclass in different ways

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
