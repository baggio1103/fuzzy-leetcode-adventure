package dailyChallenge.year2024.january.january30

import java.util.*

fun evalRPN(tokens: Array<String>): Int {
    val stack = Stack<Int>()
    val operators = hashSetOf("+", "-", "/", "*")
    for (token in tokens) {
        if (token !in operators) {
            stack.push(token.toInt())
            continue
        }
        val secondOperand = stack.pop()
        val firstOperand = stack.pop()
        val result = when (token) {
            "+" -> firstOperand + secondOperand
            "-" -> firstOperand - secondOperand
            "*" -> firstOperand * secondOperand
            "/" -> firstOperand / secondOperand
            else -> throw IllegalArgumentException()
        }
        stack.push(result)
    }
    return stack.pop()
}

fun main() {
    println(
        evalRPN(arrayOf("2", "1", "+", "3", "*"))
    )
    println(
        evalRPN(arrayOf("4", "13", "5", "/", "+"))
    )
    println(
        evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"))
    )
}