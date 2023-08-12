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

java -cp .:/opt/homebrew/Cellar/kotlin/1.9.0/libexec/lib/kotlin-stdlib.jar MainKt
```
