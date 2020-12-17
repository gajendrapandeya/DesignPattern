package com.codermonkeys.designpatterns.memento.state

fun main() {

    val selectionCanvas = Canvas(SelectionTool())
    //Invokes corresponding method from SelectionTool
    selectionCanvas.mouseUp()
    selectionCanvas.mouseDown()

    val brushCanvas = Canvas(BrushTool())
    //Invokes corresponding method from BrushTool
    brushCanvas.mouseUp()
    brushCanvas.mouseDown()

    val erasorCanvas = Canvas(EraseTool())
    //Invokes corresponding method from ErasorTool
    erasorCanvas.mouseUp()
    erasorCanvas.mouseDown()

}

class Canvas(val tool: Tool) {
    fun mouseUp() {
        tool.mouseUp()
    }

    fun mouseDown() {
        tool.mouseDown()
    }
}

open class SelectionTool : Tool {
    override fun mouseDown() {
        println("Draw dashed rectangle")

    }

    override fun mouseUp() {
        println("Selection Icon")
    }
}

class BrushTool : Tool {
    override fun mouseDown() {
        println("Draw a line")
    }

    override fun mouseUp() {
        println("Brush Icon")

    }
}

class EraseTool: Tool {
    override fun mouseDown() {
        println("Erased Something..")
    }

    override fun mouseUp() {
        println("Erasor Icon")
    }
}