package dailyChallenge.year2025.january.january14

fun main() {
    println(
        findThePrefixCommonArray(
            intArrayOf(1, 3, 2, 4),
            intArrayOf(3, 1, 2, 4)
        ).contentToString()
    )
}

fun findThePrefixCommonArray(arrayOne: IntArray, arrayTwo: IntArray): IntArray {
    val prefixArray = IntArray(arrayOne.size)
    val setOne = mutableSetOf<Int>()
    val setTwo = mutableSetOf<Int>()
    var count = 0
    repeat(arrayOne.size) {
        val elementOne = arrayOne[it]
        val elementTwo = arrayTwo[it]
        if (elementOne == elementTwo) {
            count++
        } else {
            setOne.add(elementOne)
            setTwo.add(elementTwo)
            if (elementOne in setTwo) count++
            if (elementTwo in setOne) count++
        }
        prefixArray[it] = count
    }
    return prefixArray
}