package bytebytego.intervals

fun main() {
    println(
        intervalIntersection(
            arrayOf(intArrayOf(1, 4), intArrayOf(5, 6), intArrayOf(9, 10)),
            arrayOf(intArrayOf(2, 7), intArrayOf(8, 9)),
        ).contentDeepToString()
    )
}

fun intervalIntersection(intervalsOne: Array<IntArray>, intervalsTwo: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    var i = 0
    var j = 0
    while (i < intervalsOne.size && j < intervalsTwo.size) {
        // check who starts first
        val (a, b) = if (intervalsOne[i][0] <= intervalsTwo[j][0])
            intervalsOne[i] to intervalsTwo[j]
        else
            intervalsTwo[j] to intervalsOne[i]

        if (a[1] >= b[0])
            result.add(intArrayOf(b[0], minOf(a[1], b[1])))

        if (intervalsOne[i][1] < intervalsTwo[j][1]) i++ else j++
    }
    return result.toTypedArray()
}
