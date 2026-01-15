package dailyChallenge.year2026.january.january15

fun main() {
    println(maximizeSquareHoleArea(2, 1, intArrayOf(2, 3), intArrayOf(2)))
    println(maximizeSquareHoleArea(2, 3, intArrayOf(2, 3), intArrayOf(2)))
}

fun maximizeSquareHoleArea(n: Int, m: Int, hBars: IntArray, vBars: IntArray): Int {
    hBars.sort()
    vBars.sort()
    var hMax = 1
    var hCur = 1
    var vMax = 1
    var vCur = 1
    for (i in 1 until hBars.size) {
        if (hBars[i] == hBars[i - 1] + 1) {
            hCur++
        } else
            hCur = 1
        hMax = maxOf(hMax, hCur)
    }
    for (i in 1 until vBars.size) {
        if (vBars[i] == vBars[i - 1] + 1) {
            vCur++
        } else
            vCur = 1
        vMax = maxOf(vMax, vCur)
    }
    val side = minOf(hMax, vMax) + 1
    return side * side
}
