package dailyChallenge.year2025.may.may7

//[0,2,1,5,3,4]
//[5,0,1,2,3,4]
fun main() {
    println(
        buildArray(intArrayOf(0, 2, 1, 5, 3, 4)).contentToString()
    )
    println(
        buildArray(intArrayOf(5, 0, 1, 2, 3, 4)).contentToString()
    )
    println(
        buildInPlaceArray(intArrayOf(0, 2, 1, 5, 3, 4)).contentToString()
    )
    println(
        buildInPlaceArray(intArrayOf(5, 0, 1, 2, 3, 4)).contentToString()
    )
}

fun buildArray(array: IntArray): IntArray = IntArray(array.size) { index -> array[array[index]] }

fun buildInPlaceArray(array: IntArray): IntArray {
    for (i in array.indices) {
        array[i] += 1000 * (array[array[i]] % 1000)
    }
    for (i in array.indices) {
        array[i] = array[i] / 1000
    }
    return array
}