package dailyChallenge.year2025.march.march18

fun main() {
//    1,3,8,48,10]
//    [3,1,5,11,13]

    println(
        longestNiceSubarray(intArrayOf(1, 3, 8, 48, 10))
    )
    println((3 xor 8 xor 48) and 10)
//
//    println(
//        longestNiceSubarray(intArrayOf(3, 1, 5, 11, 13))
//    )
}

fun longestNiceSubarray(array: IntArray): Int {
    var j = 0
    var length = 1
    var usedBits = 0
    for ((i, value) in array.withIndex()) {
        while (usedBits and   value != 0) {
            usedBits = usedBits xor array[j]
            j++
        }
        usedBits = usedBits xor value
        length = maxOf(length, i - j + 1)
    }
    return length
}