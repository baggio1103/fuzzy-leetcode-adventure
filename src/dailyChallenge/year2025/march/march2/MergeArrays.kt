package dailyChallenge.year2025.march.march2

fun mergeArrays(arrayOne: Array<IntArray>, arrayTwo: Array<IntArray>): Array<IntArray> {
    var indexOne = 0
    var indexTwo = 0
    val resultingArray = mutableListOf<IntArray>()
    while (indexOne < arrayOne.size && indexTwo < arrayTwo.size) {
        val (idOne, valueOne) = arrayOne[indexOne]
        val (idTwo, valueTwo) = arrayTwo[indexTwo]
        val element = when {
            idOne == idTwo -> {
                indexOne++
                indexTwo++
                intArrayOf(idOne, valueOne + valueTwo)
            }

            idOne > idTwo -> {
                indexTwo++
                intArrayOf(idTwo, valueTwo)
            }

            else -> {
                indexOne++
                intArrayOf(idOne, valueOne)
            }
        }
        resultingArray.add(element)
    }
    while (indexOne < arrayOne.size) {
        resultingArray.add(arrayOne[indexOne])
        indexOne++
    }
    while (indexTwo < arrayTwo.size) {
        resultingArray.add(arrayTwo[indexTwo])
        indexTwo++
    }
    return resultingArray.toTypedArray()
}