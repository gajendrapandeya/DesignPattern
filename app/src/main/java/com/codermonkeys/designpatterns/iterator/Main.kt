package com.codermonkeys.designpatterns.iterator

fun main() {
    val history = BrowseHistory(ArrayList(10))
    history.push("a")
    history.push("b")
    history.push("c")

    val iterator = history.createIterator()
    while (iterator.hasNext()) {
        val current = iterator.current()
        println(current)
        iterator.next()
    }

}

class BrowseHistory( val urls: ArrayList<String>) {

    fun push(url: String) {
        urls.add(url)
    }

    fun pop(): String {
        val lastIndex = urls.size - 1
        val lastUrl = urls[lastIndex]
        urls.remove(lastUrl)
        return lastUrl
    }

    fun createIterator(): ListIterator {
        return ListIterator(this)
    }

    inner class ListIterator(val history: BrowseHistory): Iterator {
        private var index = 0
        override fun hasNext(): Boolean {
            return (index < history.urls.size)
        }

        override fun current(): String {
            return history.urls[index]
        }

        override fun next() {
            index++
        }
    }

}