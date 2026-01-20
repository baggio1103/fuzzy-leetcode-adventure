package bytebytego.hashmapsandsets

fun main() {
    println(
        geometricSequenceTriplet(intArrayOf(2, 1, 2, 4, 8, 8), 2)
    )
    println(
        geometricSequenceTripletCount(intArrayOf(2, 1, 2, 4, 8, 8), 2)
    )
}

fun geometricSequenceTriplet(array: IntArray, ratio: Int): List<Triple<Int, Int, Int>> {
    val map = array.foldIndexed(mutableMapOf<Int, MutableList<Int>>()) { index, map, value ->
        map.getOrPut(value, ::mutableListOf).add(index)
        map
    }
    val triplets = mutableListOf<Triple<Int, Int, Int>>()
    for ((b, value) in array.withIndex()) {
        if (value / ratio in map && value * ratio in map) {
            val aIndices = map.getValue(value / 2)
            val cIndices = map.getValue(value * 2)
            for (a in aIndices) {
                if (a < b) {
                    for (c in cIndices) {
                        if (c > b) {
                            triplets.add(Triple(a, b, c))
                        }
                    }
                }
            }
        }
    }
    return triplets
}

fun geometricSequenceTripletCount(array: IntArray, ratio: Int): Int {
    val leftMap = mutableMapOf<Int, Int>()
    val rightMap = mutableMapOf<Int, Int>()
    for (number in array) rightMap[number] = rightMap.getOrDefault(number, 0) + 1
    var count = 0
    for (number in array) {
        rightMap[number] = rightMap.getValue(number) - 1
        if (number % ratio == 0) {
            count += (leftMap.getOrDefault(number / ratio, 0) * rightMap.getOrDefault(number * ratio, 0))
        }
        leftMap[number] = leftMap.getOrDefault(number, 0) + 1
    }
    return count
}
