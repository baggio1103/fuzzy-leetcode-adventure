package bytebytego.slowfastpointers

fun main() {
    println(isHappy(19)) // true
    println(isHappy(2)) // false
    println(isHappy(23)) // true
    println(isHappy(10)) // true
}

fun isHappy(n: Int): Boolean {
    var fast = n
    var slow = n
    while (true) {
        fast = nextNumber(nextNumber(fast))
        slow = nextNumber(slow)
        if (fast == 1) return true
        if (fast == slow) return false
    }
}

fun nextNumber(number: Int): Int {
    var n = number
    var sum = 0
    while (n != 0) {
        val digit = n % 10
        sum += digit * digit
        n /= 10
    }
    return sum
}
