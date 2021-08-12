# Learning Kotlin

## Installation

```bash
brew update

brew install kotlin
```

## Verify the Installation

```bash
kotlinc -version
```

## How to compile and run?

```kotlin
fun main() {
  println("Hello World!")
}
```

```bash
kotlinc Main.kt

java -cp .:/usr/local/Cellar/kotlin/1.5.21/libexec/lib/kotlin-stdlib.jar MainKt
```
