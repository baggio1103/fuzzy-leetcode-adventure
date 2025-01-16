package dailyChallenge.year2025.january.january16

fun main() {
    val a = 2
    val b = 3
    val c = a xor a xor a xor a xor a xor a xor b
    println(c)
    // 1 2 3 4 2 1
    // 2 3 2 8 9 7
    // --->>> 1 xor (2 3 2 8 9 7) xor 2 xor (2 3 2 8 9 7)



    println(
        xorAllNums(
            arrayOne = intArrayOf(1, 2),
            arrayTwo = intArrayOf(3, 4),
        )
    )
}

fun xorAllNums(arrayOne: IntArray, arrayTwo: IntArray): Int {
    var result = 0
    val frequencyMap = mutableMapOf<Int, Int>()
    for (value in arrayOne) {
        frequencyMap[value] = frequencyMap.getOrDefault(value, 0) + arrayTwo.size
    }
    for (value in arrayTwo) {
        frequencyMap[value] = frequencyMap.getOrDefault(value, 0) + arrayOne.size
    }
    frequencyMap.forEach { (key, value) ->
        if (value % 2 == 1) {
            result = result xor key
        }
    }
    return result
}