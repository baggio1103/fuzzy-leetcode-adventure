package designProblems.stack

fun main() {
    println("-=-=-=-=-=-=-=-=")
    exampleOne()
    println("-=-=-=-=-=-=-=-=")
    exampleTwo()
    println("-=-=-=-=-=-=-=-=")
    exampleThree()
    val aPair = Pair("1", 12345)
    val bPair = Pair("1", 12345)
    println(aPair === bPair)
}

fun exampleOne() {
    val maxStack = MaxStack<Int>()
    maxStack.push(8)
    maxStack.push(2)
    maxStack.push(4)
    maxStack.push(6)
    println(maxStack.max()) // 8
    maxStack.push(9)
    maxStack.push(3)
    println(maxStack.max()) // 9
    maxStack.pop()
    maxStack.pop()
    println(maxStack.max()) // 8
    maxStack.pop()
    maxStack.pop()
    maxStack.pop()
    println(maxStack.max()) // 8
    maxStack.pop()
    println(maxStack.size) // Size = 0
}

fun exampleTwo() {
    val stack = MaxStack<Int>()
    repeat(5) {
        stack.push(it * 3)
    }
    println(stack.size) // 5
    println(stack.max()) // 12
    stack.pop()
    println(stack.max()) // 9
    stack.pop()
    println(stack.max()) // 6
}

fun exampleThree() {
    val stack = MaxStack<Int>()
    stack.push(5)
    stack.push(0)
    stack.push(5)
    println(stack.max()) // 5
    stack.pop()
    println(stack.max()) // 5
}