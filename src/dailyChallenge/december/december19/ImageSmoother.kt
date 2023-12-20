package dailyChallenge.december.december19

fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
    val rows = img.size
    val columns = img[0].size
    val resultingArray = Array(rows) { _ ->
        IntArray(columns)
    }
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            resultingArray[i][j] = avgValue(i, j, rows, columns, img)
        }
    }
    return resultingArray
}

fun avgValue(i: Int, j: Int, rowSize: Int, columnSize: Int, img: Array<IntArray>): Int {
    var sum = 0
    var count = 0
    val rowRange = IntRange(0, rowSize - 1)
    val columnRange = IntRange(0, columnSize - 1)
    if (i - 1 in rowRange) {
        for (x in j - 1..j + 1) {
            if (x in columnRange) {
                sum += img[i - 1][x]
                count++
            }
        }
    }
    for (x in j - 1..j + 1) {
        if (x in columnRange) {
            sum += img[i][x]
            count++
        }
    }
    if (i + 1 in rowRange) {
        for (x in j - 1..j + 1) {
            if (x in columnRange) {
                sum += img[i + 1][x]
                count++
            }
        }
    }
    return sum / count
}


fun main() {
    imageSmoother(
        arrayOf(
            intArrayOf(100, 200, 100),
            intArrayOf(200, 50, 200),
            intArrayOf(100, 200, 100),
        )
    ).forEach {
        println(it.asList())
    }
}