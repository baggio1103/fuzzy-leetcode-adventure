package dailyChallenge.year2024.february.february1

fun divideArray(numbers: IntArray, k: Int): Array<IntArray> {
    numbers.sort()
    var leftIndex = 0
    var rightIndex = 2
    val array = Array(numbers.size / 3) { _ -> intArrayOf() }
    var count = 0
    while (true) {
        if (leftIndex + 3 > numbers.size) {
            break
        }
        if (numbers[rightIndex] - numbers[leftIndex] <= k) {
            array[count] = intArrayOf(numbers[leftIndex], numbers[leftIndex + 1], numbers[rightIndex])
            leftIndex += 3
            rightIndex += 3
            count++
            continue
        }
        return arrayOf()
    }
    return array
}

fun main() {
    divideArray(
        intArrayOf(1, 3, 4, 8, 7, 9, 3, 5, 1),
        2
    )
    divideArray(
        intArrayOf(1, 3, 3, 2, 7, 3),
        3
    )
}