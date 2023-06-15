package designProblems.stack

fun main() {
    val maxStack = MaxStack<Int>()
    maxStack.push(8)
    maxStack.push(2)
    maxStack.push(4)
    maxStack.push(6)
    println(
        maxStack.max()
    )
    maxStack.push(9)
    maxStack.push(3)
    println(
        "Peek: ${        maxStack.peek()
        }"
    )
    println(
        maxStack.max()
    )
    println(
        "Size: ${maxStack.size} Pop must be 3 - ${
            maxStack.pop()
        } Size: ${maxStack.size}"
    )
    println(
        "Shit: ${        maxStack.pop()
        }"
    )
    maxStack.pop()
    println(maxStack.max())
}