package com.codermonkeys.designpatterns.memento

fun main() {

    val editor = Editor("a")
    val history = History()

    editor.content = "a"
    history.push(editor.createState())

    editor.content = "b"
    history.push(editor.createState())

    editor.content = "c"
    editor.restore(history.pop())
    editor.restore(history.pop())

    println(editor.content)

}

class Editor(var content: String) {

    fun createState(): EditorState = EditorState(content)
    fun restore(state: EditorState) {
        content = state.content
    }
}

class EditorState(val content: String)

class History {

    private val states = ArrayList<EditorState>()

    fun push(state: EditorState) = states.add(state)

    fun pop(): EditorState {
        val lastIndex = states.size - 1
        val lastState = states[lastIndex]
        states.remove(lastState)
        return lastState
    }
}