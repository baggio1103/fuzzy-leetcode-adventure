package dailyChallenge.december.december19

fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
    val rows = img.size
    val columns = img[0].size
    val resultingArray = Array(rows) {
        _ -> IntArray(columns)
    }
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            resultingArray[i][j] = avgValue(i, j)
        }
    }

    return arrayOf()
}

fun avgValue(i: Int, j: Int): Int {
    TODO("Not yet implemented")
}


fun main() {

}