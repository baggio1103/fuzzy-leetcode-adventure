package dailyChallenge.year2024.april.april29

fun minOperations(nums: IntArray, k: Int): Int {
    val result = Integer.toBinaryString(nums.reduce { a, b -> a xor b })
    val dest = Integer.toBinaryString(k)
    var count = 0
    var index = 0
    if (result.length > dest.length) {
        while (result.length - index > dest.length) {
            if (result[index] == '1') {
                count++
            }
            index++
        }
        for ((i, ch) in dest.withIndex()) {
            if (result[i + index] != ch) count++
        }
        return count
    }
    while (dest.length - index > result.length) {
        if (dest[index] == '1') {
            count++
        }
        index++
    }
    for ((i, ch) in result.withIndex()) {
        if (dest[i + index] != ch) count++
    }
    return count
}

fun main() {
    println(
        minOperations(
            intArrayOf(2, 1, 3, 4),
            1
        )
    )
    println(
        minOperations(
            intArrayOf(2, 0, 2, 0),
            0
        )
    )
}