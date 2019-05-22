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
As an example, here’s how you print the value of the first item:
```kotlin
println(myArray[0])
```
And if you want to get the size of the array, use
```kotlin
myArray.size
```

## Chapter 3

### How you create functions

As you learned back in Chapter 1, you define new functions using the `fun` keyword, followed by the name of the function.

### You can send things to a function

You tell the compiler what values a function can accept by specifying one or more **parameters**.

Each parameter must have a name and type.

### You can send more than one thing to a function

If you want your function to have multiple parameters, you separate them with commas when you declare them, and separate the arguments with commas when you pass them to the function.
Most importantly, if a function has multiple parameters, you must pass arguments of the right type in the right order.

### You can get things back from a function

If you want to get something back from a function, you need to declare it.

If you declare that a function returns a value, then you must return a value of the declared type.

#### Functions with no return value

If you don't want your function to return a value, you can either omit the return type from the function declaration, or specify a return type of `Unit`.
Declaring a return type of `Unit` means that the function returns no value.

### How `for` loops work

A `for` loop is useful in situations where you want to loop through a fixed range of numbers, or through every item in an array (or some other type of collection.

#### Looping through a range of numbers

To loop through a range of numbers, you first specify a name for the variable the loop should use.

You specify the range of values using the `..` operator.

Note that the `..` operator includes the end number in its range.
If you wanted to exclude it, you would replace the `..` operator with `until`.

#### Use `downTo` to reverse the range

If you want to loop through a range of numbers in reverse order, you use `downTo` instead of `..` or `until`.

#### Use `step` to skip numbers in the range

By default, the `..` operator, `until` and `downTo` step through the range one number at a time.
If you want, you can increase the size of the step using `step`.

#### Looping through the items in an array

You can also use a `for` loop to iterate through the items in an array.

## Chapter 4

Classes are *templates* that allow you to **create your own types of objects**, and define their properties and functions.

### Object types are defined using classes

A class is a template that defines what properties and functions are associated with objects of that type.

#### You can define your own classes

If you want your application to deal with types of objects that Kotlin doesn't have, you can define your own types by writing new classes.

### How to design your own classes

When you want to define your own class, you need to think about the objects that will be created from that class.
You need to consider:
* The things each object knows about itself.
* The things each object can do.

The things an object knows about itself are its **properties**.
They represent an object's state (the data), and each object of that type can have unique values.

The things an object can do are its **functions**.
They determine an object's behavior, and may use the object's properties.

### How to access properties and functions

Once you've created an object, you can access its properties using the dot operator (`.`).

You can also update any properties that you have defined using the `var` keyword.

Note that the compiler won't let you update any properties that you've defined using the `val` keyword.

You can also use the dot operator to call an object's functions.

### How objects are created

When we define an object using code like:
```kotlin
var myDog = Dog("Fido", 70, "Mixed")
```
it looks like we're calling a function named `Dog`.
But even though it looks and feels a lot like a function, it's not.
Instead, we're calling the `Dog` **constructor**.

A constructor contains the code that's needed to initialize an object.
It runs before the object can be assigned to a reference, which means that you get a chance to step in, and do things to make the object ready for use.
Most people use constructors to define an object's properties and assign values to them.

Each time you create a new object, the constructor for that object's class is invoked.

#### What the `Dog` constructor looks like

When we created our `Dog` class, we included a constructor; it's the parentheses and the code in between in the class header:
```kotlin
class Dog(val name: String, var weight: Int, val breed: String) {

}
```

#### That's right - a property is a variable that's local to the object.

This means that everything you've already learned about variables applies to properties.
If you define a property using the `val` keyword, for example, this means that you can't assign a new value to it.
You can, however, update any properties that have been defined using `var`.

### How to use initializer blocks

If you need to initialize a property to something more complex than a simple expression, or if there's extra code you want to run when each object is created, you can use one or more **initializer blocks**.
Initializer blocks are executed when the object is initialized, immediately after the constructor is called, and they're prefixed with the `init` keyword.

### You MUST initialize your properties

This also applies to any properties you define in a class: you must initialize properties before you try to use them.
This is so important that if you declare a property without initializing it in either the property declaration or the initializer block, the compiler will get very upset and refuse to compile your code.

### How to write a custom getter

Technically, getters and setters are optional parts of the property declaration.

### How to write a custom setter

A setter is a function named **set** that's added to the property by writing it beneath the property declaration.
A setter has one parameter - usually named `value` — which is the proposed new value of the property.

The setter updates the value of the property by means of the **field** identifier.
`field` refers to the property's backing field, which you can think of as being a reference to the underlying value of the property.
Using field in your getters and setters in place of the property name is important, as it stops you getting stuck in an endless loop.

## Chapter 5

### Declare the superclass and its properties and functions as open

Before a class can be used as a superclass, you have to explicitly tell the compiler that this is allowed.
You do this by prefixing the name of the class — and any properties or functions you want to override — with the keyword `open`.
This tells the compiler that you've designed the class to be a superclass, and that you're happy for the properties and functions you've declared as `open` to be overridden.

### How a subclass inherits from a superclass

To make a class inherit from another, you add a colon (`:`) to the class header followed by the name of the superclass.
This makes the class a subclass, and gives it all the properties and functions of the class it inherits from.

Calling the superclass constructor is mandatory: if the superclass has a primary constructor, then you *must* call it in the subclass header or your code won't compile.
And even if you haven't explicitly added a constructor to your superclass, remember that the compiler automatically creates an empty one for you when the code gets compiled.

If the superclass constructor includes parameters, you must pass values for these parameters when you call the constructor.

### How (and when) to override properties

You override a property that's been inherited from a superclass by adding the property to the subclass, and prefixing it with the `override` keyword.

This means that if you define a property in the superclass using `val`, you *must* override it in the subclass if you want to assign a different value to it.

If a superclass property has been defined using `var`, you don't need to override it in order to assign a new value to it, as `var` variables can be reused for other values.
You can instead assign it a new value in the subclass's initializer block, as in this example:
```kotlin
open class Animal {
    val image = ""
}

class Hippo : Animal() {
    init {
        image = "hippo.jpg"
    }
}
```

### How to override functions

You override a function in a similar way to how you override a property: by adding the function to the subclass, prefixed with `override`.

#### The rules for overriding functions

When you override a function, there are two rules that you must follow:
* The function parameters in the subclass must match those in the superclass.
* The function return types must be compatible.

Whatever the superclass function declares as a return type, the overriding function must return either the same type, or a subclass type.
A subclass type is guaranteed to do anything its superclass declares, so it's safe to return a subclass where the superclass is expected.

### An overridden function or property stays open...

What we didn't tell you is that the function or property stays open in each of its subclasses, even if it's overridden, so you don't have to declare it as `open` further down the tree.

#### ...until it's declared `final`

If you want to stop a function or property from being overridden further down the class hierarchy, you can prefix it with `final`.
```kotlin
open class Car : Vehicle() {
    final override fun lowerTemperature() {
        println("Turn on air conditioning")
    }
}
```

### Which function is called?

When you call a function on an object reference, you're calling the most specific version of the function for that object type: the one that's lowest on the inheritance tree.

### Inheritance guarantees that all subclasses have the functions and properties defined in the superclass

When you define a set of properties and functions in a superclass, you're guaranteeing that all its subclasses also have these properties and functions.
In other words, you define a common protocol, or contract, for a set of classes that are related by inheritance.

#### Any place where you can use a superclass, you can use one of its subclasses instead

When you define a supertype for a group of classes, you can use any subclass in place of the superclass it inherits from.

### You can use a supertype for a function's parameters and return type

Being able to use one type of object in a place that explicitly expects a different type is called **polymorphism**.
It's the ability to provide different implementations for functions that have been inherited from somewhere else.

## Chapter 6

If you want to fully exploit polymorphism, you need to design using abstract classes and interfaces.

### Some classes shouldn't be instantiated

#### Declare a class as abstract to stop it from being instantiated

If you want to prevent a class from being instantiated, you can mark the class as **abstract** by prefixing it with the `abstract` keyword.

Being an abstract class means that nobody can create any objects of that type, even if you've defined a constructor for it.
You can still use that abstract class as a declared variable type, but you don't have to worry about somebody creating objects of that type - the compiler stops it from happening:

If a superclass is marked as abstract, you don't need to declare that it's open.

### Abstract or concrete?

A class that's not abstract is called **concrete**.

In general, whether a class should be abstract or concrete depends on the context of your application.

### An abstract class can have abstract properties and functions

In an abstract class, you can choose to mark properties and functions as abstract.
This is useful if the class has behaviors that don't make sense unless they're implemented by a more specific subclass, and you can't think of a generic implementation that might be useful for subclasses to inherit.

An abstract class can contain abstract and non-abstract properties and functions.
It's possible for an abstract class to have no abstract members.

Abstract properties and functions don't need to be marked as open.

If you mark a property or function as abstract, you must mark the class as abstract too.

#### Abstract properties and functions define a common protocol so that you can use polymorphism

Abstract functions are useful because even though they don't contain any actual function code, they define the protocol for a group of subclasses which you can use for polymorphism.

### How to implement an abstract class

You declare that a class inherits from an abstract superclass in the same way that you say that a class inherits from a normal superclass: by adding a colon to the class header followed by the name of the abstract class.

You implement abstract properties and functions by overriding each one and providing an implementation.
This means that you need to initialize any abstract properties, and you need to provide a body for any abstract functions.

When you implement abstract properties and functions, you must follow the same rules for overriding that you use for overriding normal properties and functions:
* When you implement an abstract *property*, it must have the same name, and its type must be compatible with the type defined in the abstract superclass.
In other words, it must be the same type, or one of its subtypes.
* When you implement an abstract *function*, it must have the same function signature (name and arguments) as the function that's defined in the abstract superclass.
Its return type must be compatible with the declared return type.

### You MUST implement all abstract properties and functions

The first **concrete** class in the inheritance tree below the abstract superclass *must* implement all abstract properties and functions.

With **abstract** subclasses, you have a choice: you can either implement the abstract properties and functions, or pass the buck to its subclasses.

### Independent classes can have common behavior

When you have independent classes that exhibit common behavior, you can model this behavior using an **interface**.

### An interface lets you define common behavior OUTSIDE a superclass hierarchy

Interfaces are used to define a protocol for common behavior so that you can benefit from polymorphism without having to rely on a strict inheritance structure.
Interfaces are similar to abstract classes in that they can't be instantiated, and they can define abstract or concrete functions and properties, but there's one key difference: a class can implement multiple interfaces, but can only inherit from a single direct superclass.
So using interfaces can provide the same benefits as using abstract classes, but with more flexibility.

#### Interface functions can be abstract or concrete

You add functions to interfaces by including them in the interface body (inside the curly braces `{}`).

When you add an abstract function to an interface, there's no need to prefix the function name with the `abstract` keyword, as you would if you were adding an abstract function to an abstract class.
With an interface, the compiler automatically infers that a function with no body must be abstract, so you don't have to mark it as such.

You can also add concrete functions to interfaces by providing the function with a body.

### How to define interface properties

You add a property to an interface by including it in the interface body.
This is the only way in which you can define an interface property, as unlike abstract classes, interfaces can't have constructors.

Unlike properties in abstract classes, properties that are defined in an interface can't store state, and therefore can't be initialized.

Another restriction is that interface properties don't have backing fields.

### Declare that a class implements an interface...

You mark that a class implements an interface in a similar way to how you mark that a class inherits from a superclass: by adding a colon to the class header followed by the name of the interface.

Unlike when you declare that a class inherits from a superclass, you don't put parentheses after the interface name.
This is because the parentheses are only needed in order to call the superclass constructor, and interfaces don't have constructors.

#### ...then override its properties and functions

Declaring that a class implements an interface gives the class all the properties and functions that are in that interface.
You can override any of these properties and functions, and you do this in exactly the same way that you would override properties and functions inherited from a superclass.

Just like abstract superclasses, any concrete classes that implement the interface must have a concrete implementation for any abstract properties and functions.
If the class that implements the interface is abstract, however, the class can either implement the properties and functions itself, or pass the buck to its subclasses.

Note that a class that implements an interface can still define its own properties and functions.

### How to implement multiple interfaces

You declare that a class (or interface) implements multiple interfaces by adding each one to the class header, separating each one with a comma.

If a class inherits multiple implementations of the same function or property, the class must provide its own implementation, or specify which version of the function or property it should use.

### Interfaces let you use polymorphism

You already know that using interfaces means that your code can benefit from polymorphism.

#### Access uncommon behavior by checking an object's type

You can access behavior that's not defined by a variable's type by first using the **is** operator to check the type of the underlying object.
If the underlying object is of the appropriate type, the compiler then lets you access behavior that's appropriate for that type.

You can use the `is` operator in a variety of situations.

### Where to use the `is` operator

### Use `when` to compare a variable against a bunch of options

A `when` statement is useful if you want to compare a variable against a set of different options.
It's like using a chain of `if`/`else` expressions, but more compact and readable.

If you want to run different code depending on the underlying type of an object, you can use the `is` operator inside a `when` statement.

### The `is` operator usually performs a smart cast

In most circumstances, the `is` operator performs a **smart cast**.
*Casting* means that the compiler treats a variable as though its type is different to the one that it's declared as, and *smart casting* means that the compiler automatically performs the cast on your behalf.

The `is` operator performs a smart cast whenever the compiler can guarantee that the variable can't change between checking the object's type and when it's used.

### Use `as` to perform an explicit cast

If you want to access the behavior of an underlying object but the compiler can't perform a smart cast, you can explicitly cast the object into the appropriate type.

## Chapter 7

Most applications include classes whose main purpose is to store data, so to make your coding life easier, the Kotlin developers came up with the concept of a **data class**.

### `==` calls a function named `equals`

As you already know, you can use the `==` operator to check for equality.
Behind the scenes, each time you use the `== `operator, it calls a function named `equals`.
Every object has an `equals` function, and the implementation of this function determines how the `==` operator will behave.

By default, the `equals` function checks for equality by checking whether two variables hold references to the same underlying object.

### `equals` is inherited from a superclass named `Any`

Each object has a function named `equals` because its class inherits the function from a class named **Any**.
Class `Any` is the mother of all classes: the ultimate superclass of everything.
Every class you define is a subclass of Any without you ever having to say it.

#### The importance of being `Any`

Having `Any` as the ultimate superclass has two key benefits:
* It ensures that every class inherits common behavior.
* It means you can use polymorphism with any object.
Every class is a subclass of `Any`, so every object you create has `Any` as its ultimate supertype.
This means that you can create a function with `Any` parameters, or an `Any` return type, so that it will work with all types of object.
It also means that you can create polymorphic arrays to hold objects of any type using code like this:
```kotlin
val myArray = arrayOf(Car(), Guitar(), Giraffe())
```

### The common behavior defined by `Any`

The `Any` class defines several functions that are inherited by every class.
Here are the ones we care about most, along with an example of its default behavior:
* `equals(any: Any): Boolean`
Tells you if two objects are considered "equal".
By default, it returns true if it's used to test the same object, and false if it's used to test separate objects.
Behind the scenes, the `equals` function gets called each time you use the `==` operator.
* `hashCode(): Int`
Returns a hash code value for the object.
* `toString(): String`
Returns a `String` message that represents the object.
By default, this is the name of the class and some other number that we rarely care about.

The `Any` class provides a default implementation for each of the above functions, and these implementations are inherited by every class.
They can, however, be overridden if you want to change the default behavior of any of these functions.

### We might want `equals` to check whether two objects are equivalent

There are some situations in which you might want to change the implementation of the `equals` function in order to change how the `==` operator behaves.

While you *could* change the behavior of the `==` operator by writing extra code to override the equals function, the Kotlin developers came up with a better approach: they came up with the concept of a **data class**.

### A data class lets you create data objects

A *data* class is one that lets you create objects whose main purpose is to store data.
It includes features that are helpful when you're dealing with data, such as a new implementation of the `equals` function that checks whether two data objects hold the same property values.
This is because if two objects store the same data, they can be considered equal.

You define a data class by prefixing a normal class definition with the `data` keyword.

#### How to create objects from a data class

You create objects from a data class in the same way that you create objects from a normal class: by calling its constructor.

Data classes automatically override their `equals` function in order to change the behavior of the `==` operator so that it checks for object equality **based on the values of each object's properties**.

In addition to providing a new implementation of the equals function it inherits from the `Any` superclass, data classes also override the `hashCode` and `toString` functions.

### Data classes override their inherited behavior

A data class needs its objects to play well with data, so it automatically provides the following implementations for the `equals`, `hashCode` and `toString` functions it inherits from the Any superclass:

#### The `equals` function compares property values

Data objects are considered equal if their properties hold the same values.

#### Equal objects return the same `hashCode` value

#### `toString` returns the value of each property

Finally, the `toString` function no longer returns the name of the class followed by a number.
Instead, it returns a useful String that contains the value of each property that's defined in the data class constructor:

### Copy data objects using the `copy` function

If you want to create a new copy of a data object, altering some of its properties but leaving the rest intact, you can do so using the **copy** function.
To use, you call the function on the object you want to copy, passing in the names of any properties you wish to alter along with their new values.

As well as the `copy` function, data classes also provide a set of functions that allow you to split a data object into its component property values in a process called **destructuring**.

### Data classes define `componentN` functions...

When you define a data class, the compiler automatically adds a set of functions to the class that you can use as an alternate way of accessing its object's property values.
These are known as `componentN` functions, where `N` represents the number of the property whose value you wish to retrieve (in order of declaration).

#### ...that let you destructure data objects

Having generic `componentN` functions is useful as it provides a quick way of splitting a data object into its component property values, or **destructuring** it.

#### The `===` operator always lets you check whether two variables refer to the same underlying object

If you want to check whether two variables refer to the same underlying object, irrespective of their type, you should use the `===` operator instead of `==`.
This is because the `===` operator always evaluates to `true` if (and only if) the two variables hold a reference to the same underlying object.

Unlike the `==` operator, the `===` operator doesn't rely on the `equals` function for its behavior.
The `===` operator always behaves in this way irrespective of the type of class.

### Generated functions only use properties defined in the constructor

When the compiler generates implementations for data class functions, such as overriding the `equals` function and creating a `copy` function, it only includes the properties defined in the primary constructor.
So if you add properties to a data class by defining them in the class body, they won't be included in any of the generated functions.

### Initializing many properties can lead to cumbersome code

#### Default parameter values to the rescue!

If your constructor defines many properties, you can simplify calls to it by assigning a default value or expression to one or more property definitions in the constructor.

### How to use a constructor's default values

When you have a constructor that uses default values, there are two main ways of calling it: by passing values in order of declaration, and by using named arguments.

### Overloading a function

**Function overloading** is when you have two or more functions with the same name but with different argument lists.

## Chapter 8

### Remove an object reference using `null`

By default, types in Kotlin won't accept null values.
If you want a variable to hold null values, you must explicitly declare that its type is nullable.

#### Why have nullable types?

A nullable type is one that allows null values.
Unlike other programming languages, Kotlin tracks values that can be null to stop you from performing invalid actions on them.
Performing invalid actions on null values is the most common cause of runtime problems in other languages such as Java, and can cause your application to crash in a heap when you least expect it.
These problems, however, rarely happen in Kotlin because of its clever use of nullable types.

You declare that a type is nullable by adding a question mark (`?`) to the end of the type.

### You can use a nullable type everywhere you can use a non-nullable type

Every type you define can be turned into a nullable version of that type by simply adding a `?` to the end of it.
You can use nullable types in the same places that you would use plain old non-nullable types:
* When defining variables and properties.
* When defining parameters.
* When defining function return types.
A function can have a nullable return type.

### How to access a nullable type's functions and properties

Suppose you have a variable whose type is nullable, and you want to access its object's properties and functions.
You can't make function calls or refer to the properties of a null value as it doesn't have any.
To stop you from performing any operations that are invalid, the compiler *insists* that you check that the variable is not null before giving you access to any functions or properties.

To access the underlying object's functions and properties, you first have to establish that the variable's value is not `null`.
One way of achieving this is to check the value of the variable inside an `if`.

### Keep things safe with safe calls

If you want to access a nullable type's properties and functions, an alternative approach is to use a **safe call**.
A safe call lets you access functions and properties in a single operation without you having to perform a separate null-check.

`?.` is the safe call operator.
It lets you safely access a nullable type's functions and properties.

### You can chain safe calls together

Another advantage of using safe calls is that you can chain them together to form expressions that are powerful yet concise.

### Use `let` to run code if values are not `null`

The `let` keyword used in conjunction with the safe call operator `?.` tells the compiler that you want to perform some action when the value it's operating on is not `null`.

Once you've established that the value is not `null`, you can refer to it in the body of the `let` using **it**.

### Instead of an `if` expression...

Another thing you may want to do when you have nullable types is use an `if` expression that specifies an alternate value for something that's `null`.

#### ...you can use the safer Elvis operator

The Elvis operator `?:` is a safe alternative to an if expression.
It's called the Elvis operator because when you tip it on its side, it looks a bit like Elvis.

The Elvis operator first checks the value on its left.
If this value is not `null`, the Elvis operator returns it.
If the value on the left is `null`, however, the Elvis operator returns the value on its right instead

### The `!!` operator deliberately throws a `NullPointerException`

The not-null assertion operator, or `!!`, is different to the other methods for dealing with nulls that we've looked at over the past few pages.
Instead of making sure that your code is safe by handling any null values, the not-null assertion operator deliberately throws a `NullPointerException` if something turns out to be `null`.

### Catching exceptions using a `try`/`catch`

You catch exceptions by wrapping the risky code in a `try`/`catch` block.
A `try`/`catch` block tells the compiler that you know an exceptional thing could happen in the code you want to execute, and that you're prepared to handle it.
The compiler doesn't care how you handle it; it cares only that you say you're taking care of it.

The `try` part of the `try`/`catch` block contains the risky code that might cause an exception.

The `catch` part of the block specifies the exception that you want to catch, and includes the code you want to run if it catches it.

## Chapter 9

Kotlin comes with a bunch of useful collections that give you more flexibility and greater control over how you store and manage groups of objects.

### When in doubt, go to the Library

Kotlin ships with hundreds of pre-built classes and functions that you can use in your code.

In the Kotlin Standard Library, classes and functions are grouped into packages.
Every class belongs to a package, and each package has a name.

The package we're interested in here is the kotlin.collections package.
This package includes a number of classes that let you group objects together in a collection.

### List, Set and Map

### Fantastic Lists...

You create a List in a similar way to how you create an array: by calling a function named `listOf`, passing in the values you want the `List` to be initialized with.

The compiler infers the type of object each `List` should contain by looking at the type of each value that's passed to it when it's created.

#### ...and how to use them

Once you've created a List, you can access the items it contains using the `get` function.

As you can see, using a `List` is a lot like using an array.
The big difference, however, is that a List is immutable - you can't update any of the references it stores.

### Create a `MutableList`...

If you want a `List` whose values you can update, you need to use a `MutableList`.
You define a `MutableList` in a similar way to how you define a `List`, except this time, you use the `mutableListOf` function instead:
```kotlin
val mShopping = mutableListOf("Tea", "Eggs")
```
`MutableList` is a subtype of `List`, so you can call the same functions on a `MutableList` that you can on a `List`.
The big difference, however, is that `MutableList`s have extra functions that you can use to add or remove values, or update or rearrange existing ones.

#### ...and add values to it

You add new values to a `MutableList` using the `add` function.
If you want to add a new value to the end of the `MutableList`, you pass the value to the `add` function as a single parameter.

If you want to insert a value at a specific index instead, you can do so by passing the index value to the `add` function in addition to the value.

### You can remove a value...

#### ...and replace one value with another

### Lists allow duplicate values

As you've already learned, using a `List`, or `MutableList`, gives you more flexibility than using an array.
Unlike an array, you can explicitly choose whether the collection should be immutable, or whether your code can add, remove and update its values.

### How to create a Set

If you need a collection that doesn't allow duplicates, you can use a **Set**: an unordered collection with no duplicate values.

You create a `Set` by calling a function named `setOf`, passing in the values you want the `Set` to be initialized with.

The compiler infers the `Set`'s type by looking at the values that are passed to it when it's created.

#### How to use a `Set`'s values

A `Set`'s values are unordered, so unlike a `List`, there's no `get` function you can use to get the value at a specified index.
You can, however, still use the `contains` function to check whether a `Set` contains a particular value using code like this:
```kotlin
val isFredGoing = friendSet.contains("Fred")
```

A `Set` is immutable, so you can't add values to it, or remove existing ones.
To do this kind of thing, you'd need to use a `MutableSet` instead.

### How to use a `MutableSet`

A `MutableSet` is a subtype of Set, but with extra functions that you can use to add and remove values.

### Time for a Map

A `Map` is a collection that acts like a property list.
You give it a key, and the `Map` gives you back the value associated with that key.

Each entry in a `Map` is actually two objects - a key and a value.
Each key has a single value associated with it.
You can have duplicate values, but you can't have duplicate keys.

#### How to create a `Map`

### How to use a Map

There are three main things you might want to do with a `Map`: check whether it contains a specific key or value, retrieve a value for a specified key, or loop through the `Map`'s entries.

A `Map` is immutable, so you can't add or remove key/value pairs, or update the value held against a specific key.
To perform this kind of action, you need to use a `MutableMap` instead.

### Create a `MutableMap`

You define a `MutableMap` in a similar way to how you define a `Map`, except that you use the `mutableMapOf` function instead of `mapOf`.

`MutableMap` is a subtype of `Map`, so you can call the same functions on a `MutableMap` that you can on a `Map`.
A `MutableMap`, however, has extra functions that you can use to add, remove and update key/value pairs.

#### Put entries in a `MutableMap`

You put entries into a `MutableMap` using the `put` function.

### You can remove entries from a `MutableMap`

## Chapter 10

### Collections use generics

As you learned in the previous chapter, each time you explicitly declare a collection's type, you must specify both the kind of collection you want to use, and the type of element it contains.

### Use `out` to make a generic type covariant

If you want to be able to use a generic subtype object in a place of a generic supertype, you can do so by prefixing the generic type with `out`.

When we prefix a generic type with `out`, we say that the generic type is **covariant**.
In other words, it means that a subtype can be used in place of a supertype.

### Use `in` to make a generic type contravariant

### A generic type can be locally contravariant

As you've seen, prefixing a generic type with in as part of the class or interface declaration makes the generic type globally contravariant.
You can, however, restrict this behavior to specific properties or functions.

When a generic type has no `in` or `out` prefix, we say that the type is **invariant**.
An invariant type can only accept references of that specific type.

## Chapter 11

### Introducing lambdas

### What lambda code looks like

The lambda starts and ends with curly braces `{}`.
All lambdas are defined within curly braces, so they can't be omitted.

### You can assign a lambda to a variable

You assign a lambda to a variable in the same way that you assign any other sort of object to a variable: by defining the variable using `val` or `var`, then assigning the lambda to it.

### Lambda expressions have a type

Instead, it specifies the type of the lambda's parameters and return value.

A lambda's type is also known as a function type.

A lambda's type takes the form:
```kotlin
(parameters) -> return_type
```

### The compiler can infer lambda parameter types

When you explicitly declare a variable's type, you can leave out any type declarations from the lambda that the compiler can infer.

#### You can replace a single parameter with `it`

If you have a lambda which has a single parameter, and the compiler can infer its type, you can omit the parameter, and refer to it in the lambda body using the keyword `it`.

Note that you can only use the `it` syntax in situations where the compiler can infer the type of the parameter.

### Use the right lambda for the variable's type

#### Use `Unit` to say a lambda has no return value

If you want to specify that a lambda has no return value, you can do so by declaring that its return type is `Unit`.

### You can pass a lambda to a function

As well as assigning a lambda to a variable, you can also use one or more as function parameters.
Doing so allows you to pass specific behavior to a more generalized function.

#### Add a lambda parameter to a function by specifying its name and type

You define a lambda parameter in the same way that you define any other sort of function parameter: by specifying the parameter's type, and giving it a name.

#### Call the function by passing it parameter values

You call a function with a lambda parameter in the same way that you call any other sort of function: by passing it a value for each argument.

### A function can return a lambda

As well as using a lambda as a parameter, a function can also return one by specifying the lambda's type as its return type.

### Use typealias to provide a different name for an existing type

A **type alias** lets you provide an alternative name for an existing type, which you can then use in your code.

You define a type alias using the `typealias` keyword.

## Chapter 12

### Kotlin has a bunch of built-in higher-order functions

Kotlin comes with a bunch of built-in higher-order functions that take a lambda parameter, many of which deal with collections.

Each higher-order function has a generalized implementation, and its specific behavior is defined by the lambda that you pass to it.

### The `min` and `max` functions work with basic types

As you already know, if you have a collection of basic types, you can use the `min` and `max` functions to find the lowest or highest value.

The `min` and `max` functions work with Kotlin's basic types because they have a natural order.

#### The `minBy` and `maxBy` functions work with ALL types

If you want to find the lowest or highest value of a type that's more complex, you can use the `minBy` and `maxBy` functions.
These functions work in a similar way to `min` and `max`, except that you can pass them criteria.

The `minBy` and `maxBy` functions each take one parameter: a lambda that tells the function which property it should use in order to determine which item has the lowest or highest value.

The lambda expression that you pass to the minBy or maxBy function must take a specific form in order for the code to compile and work correctly.

### A closer look at `minBy` and `maxBy`'s lambda parameter

When you call the minBy or maxBy function, you must provide it with a lambda which takes the following form:
```kotlin
{ i: item_type -> criteria }
```
The lambda must have one parameter, which we’ve denoted above using `i: item_type`.
The parameter's type must match the type of item that the collection deals with.

As each lambda has a single parameter of a known type, we can omit the parameter declaration entirely, and refer to the parameter in the lambda body using `it`.

The lambda body specifies the criteria that should be used to determine the lowest or highest value in the collection.
This criteria is normally the name of a property.

### The `sumBy` and `sumByDouble` functions

### Meet the `filter` function

The next stop on our tour of Kotlin's higher-order functions is `filter`.
This function lets you search, or filter, a collection according to some criteria that you pass to it using a lambda.

For most collections, `filter` returns a List that includes all the items that match your criteria, which you can then use elsewhere in your code.
If it's being used with a `Map`, however, it returns a `Map`.

### Use `map` to apply a transform to your collection

The `map` function takes the items in a collection, and transforms each one according to some formula that you specify.
It returns the results of this transformation as a new `List`.

#### You can chain function calls together

### `forEach` works like a `for` loop

The `forEach` function works in a similar way to a `for` loop, as it allows you to perform one or more actions against each item in a collection.
You specify these actions using a lambda.
