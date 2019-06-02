package me.jerrywang.kotlin.study.examples.reflection

import java.io.File
import java.io.FileNotFoundException
import java.nio.file.Paths

const val TEST_TXT = "test.txt"

fun main() {
    // The runtime Java class of this anonymous object
    val javaClass = object {}.javaClass

    val fileUri = javaClass.getResource("/$TEST_TXT")
            ?: throw FileNotFoundException("File \"$TEST_TXT\" cannot be found on classpath")

    File(Paths.get(fileUri.path).toString()).readLines().forEach { println(it) }
}
