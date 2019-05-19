package me.jerrywang.kotlin.study.examples.generics

interface Retailer<out T> {
    fun sell(): T
}
