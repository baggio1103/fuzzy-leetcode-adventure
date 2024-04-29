package dailyChallenge.year2024.april.april29.alt

fun minOperations(nums: IntArray, k: Int): Int {
    val result = Integer.toBinaryString(nums.reduce { a, b -> a xor b })
    val dest = Integer.toBinaryString(k)
    var count = 0
    for (i in 0 until maxOf(result.length, dest.length)) {
        if (result.lastIndex - i < 0) {
            if (dest[dest.lastIndex - i] == '1') count++
            continue
        }
        if (dest.lastIndex - i < 0) {
            if (result[result.lastIndex - i] == '1') count++
            continue
        }
        if (result[result.lastIndex - i] != dest[dest.lastIndex - i]) count++
    }
    return count
}