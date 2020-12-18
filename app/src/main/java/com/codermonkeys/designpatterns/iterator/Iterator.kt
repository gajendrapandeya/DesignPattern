package com.codermonkeys.designpatterns.iterator

interface Iterator {
    fun hasNext(): Boolean
    fun current(): String
    fun next()
}