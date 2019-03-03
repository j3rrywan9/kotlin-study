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

If the superclass constructor includes parameters, you must pass values for these parameters when you call the constructor.

### How (and when) to override properties

You override a property that's been inherited from a superclass by adding the property to the subclass, and prefixing it with the `override` keyword.

This means that if you define a property in the superclass using `val`, you *must* override it in the subclass if you want to assign a different value to it.

If a superclass property has been defined using `var`, you don’t need to override it in order to assign a new value to it, as `var` variables can be reused for other values.
You can instead assign it a new value in the subclass’s initializer block, as in this example:
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
A subclass type is guaranteed to do anything its superclass declares, so it’s safe to return a subclass where the superclass is expected.

### An overridden function or property stays open...

What we didn't tell you is that the function or property stays open in each of its subclasses, even if it's overridden, so you don't have to declare it as `open` further down the tree.

#### ...until it's declared `final`

If you want to stop a function or property from being overridden further down the class hierarchy, you can prefix it with `final`.

### Which function is called?

When you call a function on an object reference, you're calling the most specific version of the function for that object type: the one that's lowest on the inheritance tree.

## Chapter 6

If you want to fully exploit polymorphism, you need to design using abstract classes and interfaces.

### Some classes shouldn't be instantiated

#### Declare a class as abstract to stop it from being instantiated

If you want to prevent a class from being instantiated, you can mark the class as **abstract** by prefixing it with the `abstract` keyword.

Being an abstract class means that nobody can create any objects of that type, even if you've defined a constructor for it.
You can still use that abstract class as a declared variable type, but you don't have to worry about somebody creating objects of that type—the compiler stops it from happening:

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
*
*

### You MUST implement all abstract properties and functions

The first **concrete** class in the inheritance tree below the abstract superclass *must* implement all abstract properties and functions.

### Independent classes can have common behavior

When you have independent classes that exhibit common behavior, you can model this behavior using an **interface**.

### An interface lets you define common behavior OUTSIDE a superclass hierarchy

Interfaces are used to define a protocol for common behavior so that you can benefit from polymorphism without having to rely on a strict inheritance structure.
Interfaces are similar to abstract classes in that they can't be instantiated, and they can define abstract or concrete functions and properties, but there’s one key difference: a class can implement multiple interfaces, but can only inherit from a single direct superclass.
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

## Chapter 7

Most applications include classes whose main purpose is to store data, so to make your coding life easier, the Kotlin developers came up with the concept of a **data class**.

### `==` calls a function named `equals`

### `equals` is inherited from a superclass named `Any`

Each object has a function named `equals` because its class inherits the function from a class named **Any**.
Class `Any` is the mother of all classes: the ultimate superclass of everything.
Every class you define is a subclass of Any without you ever having to say it.

### The common behavior defined by `Any`

The `Any` class defines several functions that are inherited by every class.
* `equals(any: Any): Boolean`
* `hashCode(): Int`
* `toString(): String`

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

### Generated functions only use properties defined in the constructor

When the compiler generates implementations for data class functions, such as overriding the equals function and creating a copy function, it only includes the properties defined in the primary constructor.
So if you add properties to a data class by defining them in the class body, they won't be included in any of the generated functions.

### Overloading a function

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

### How to access a nullable type's functions and properties

Suppose you have a variable whose type is nullable, and you want to access its object's properties and functions.
You can't make function calls or refer to the properties of a null value as it doesn't have any.
To stop you from performing any operations that are invalid, the compiler insists that you check that the variable is not null before giving you access to any functions or properties.

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

#### ...you can use the safer Elvis operator

The Elvis operator `?:` is a safe alternative to an if expression.
It's called the Elvis operator because when you tip it on its side, it looks a bit like Elvis.

The Elvis operator first checks the value on its left.
If this value is not null, the Elvis operator returns it.
If the value on the left is null, however, the Elvis operator returns the value on its right instead

## Chapter 9

Kotlin comes with a bunch of useful collections that give you more flexibility and greater control over how you store and manage groups of objects.

### When in doubt, go to the Library

Kotlin ships with hundreds of pre-built classes and functions that you can use in your code.

In the Kotlin Standard Library, classes and functions are grouped into packages.
Every class belongs to a package, and each package has a name.

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

### How to create a Set

If you need a collection that doesn't allow duplicates, you can use a **Set**: an unordered collection with no duplicate values.

You create a `Set` by calling a function named `setOf`, passing in the values you want the `Set` to be initialized with.

The compiler infers the `Set`'s type by looking at the values that are passed to it when it's created.

### Time for a Map

A `Map` is a collection that acts like a property list.
You give it a key, and the `Map` gives you back the value associated with that key.

Each entry in a `Map` is actually two objects - a key and a value.
Each key has a single value associated with it.
You can have duplicate values, but you can't have duplicate keys.

#### How to create a Map

### How to use a Map

### Create a MutableMap

## Chapter 10

### Collections use generics

### Use `out` to make a generic type covariant

If you want to be able to use a generic subtype object in a place of a generic supertype, you can do so by prefixing the generic type with `out`.

### Use `in` to make a generic type contravariant

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

#### You can replace a single parameter with `it`

If you have a lambda which has a single parameter, and the compiler can infer its type, you can omit the parameter, and refer to it in the lambda body using the keyword `it`.

### Use the right lambda for the variable's type

### You can pass a lambda to a function

As well as assigning a lambda to a variable, you can also use one or more as function parameters.
Doing so allows you to pass specific behavior to a more generalized function.

#### Call the function by passing it parameter values

### A function can return a lambda

## Chapter 12

### Kotlin has a bunch of built-in higher-order functions

Kotlin comes with a bunch of built-in higher-order functions that take a lambda parameter, many of which deal with collections.

Each higher-order function has a generalized implementation, and its specific behavior is defined by the lambda that you pass to it.
