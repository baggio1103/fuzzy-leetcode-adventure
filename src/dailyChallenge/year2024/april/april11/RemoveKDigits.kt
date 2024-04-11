package dailyChallenge.year2024.april.april11

fun removeKDigits(num: String, k: Int): String {
    if (k >= num.length) return "0"
    val stack = CharArray(num.length)
    var size = 0
    var count = k
    num.forEach {
        while (k > 0 && size > 0 && it < stack[size - 1]) {
            size--
            count--
        }
        if (it != '0' || size > 0) {
            stack[size] = it
            size++
        }
    }

    while (k > 0 && size > 0) {
        size--;
        count--
    }

    if (size == 0) return "0"
    return buildString {
        for (i in 0 until size) append(stack[i])
    }
}

fun main() {
    println(
        removeKDigits(
            "1432219", 3
        )
    )
}