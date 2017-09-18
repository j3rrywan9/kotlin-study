# Learning Kotlin

## Installation

```bash
brew update

brew install kotlin
```

## How to compile and run?

```kotlin
fun main(args: Array<String>) {
  println("Hello World!")
}
```

```bash
kotlinc Main.kt

java -cp .:/usr/local/Cellar/kotlin/1.1.4-3/libexec/lib/kotlin-runtime.jar MainKt
```

