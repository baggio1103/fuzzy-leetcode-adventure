package leetcodeproblemset

fun reverse(x: Int): Int {
    var div = x
    var long = 0L
    var remainder: Int
    while (div != 0) {
        remainder = div % 10
        long = 10 * long + remainder
        div /= 10
    }
    if (long !in Int.MIN_VALUE .. Int.MAX_VALUE) {
        return 0
    }
    return long.toInt()
}

fun main() {
    println(
        reverse(123)
    )
    println(
        reverse(-123)
    )
    println(
        reverse(120)
    )
}