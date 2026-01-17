package bytebytego.twopointers

fun main() {
    val arrayOne = intArrayOf(0, 1, 0, 3, 2)
    moveZeroes(arrayOne)
    println(arrayOne.contentToString())

    val arrayTwo = intArrayOf(0, 0)
    moveZeroes(arrayTwo)
    println(arrayTwo.contentToString())

    val arrayThree = intArrayOf(0, 0, 1)
    moveZeroes(arrayThree)
    println(arrayThree.contentToString())

    val arrayFour = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(arrayFour)
    println(arrayFour.contentToString())

    val arrayFive = intArrayOf(1, 0, 1)
    moveZeroes(arrayFive)
    println(arrayFive.contentToString())

    val arraySix = intArrayOf(4, 2, 4, 0, 0, 3, 0, 5, 1, 0)
    moveZeroes(arraySix)
    println(arraySix.contentToString())

}

fun moveZeroes(numbers: IntArray) {
    var l = 0
    for (r in numbers.indices) {
        if (numbers[r] != 0) {
            if (numbers[l] == 0 && numbers[r] != 0) {
                numbers[l] = numbers[r]
                numbers[r] = 0
            }
            l++
        }
    }
}
