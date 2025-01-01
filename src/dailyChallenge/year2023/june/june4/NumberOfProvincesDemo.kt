package dailyChallenge.june.june4

fun main() {
    val numberOfProvinces = NumberOfProvinces()

    println("-=-=-=-= n: [1, 2, 3], p:[0]")
    numberOfProvinces.findCircleNum(
        arrayOf(
            intArrayOf(1, 0, 0, 1),
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 0, 1, 1),
        )
    )

    println("-=-=-=-= n: 1 p:[0, 2]")
    numberOfProvinces.findCircleNum(
        arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1),
        )
    )
    println("-=-=-=-= n:[], p:[0, 1, 2]")
    numberOfProvinces.findCircleNum(
        arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
        )
    )

    println("-=-=-=-= n:[1, 2, 3, 4] p: [0, 5]")
    numberOfProvinces.findCircleNum(
        arrayOf(
            intArrayOf(1, 1, 0, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 0, 0),
            intArrayOf(0, 1, 1, 0, 0, 0),
            intArrayOf(0, 1, 0, 1, 1, 0),
            intArrayOf(0, 0, 0, 1, 1, 0),
            intArrayOf(0, 0, 0, 0, 0, 1),
        )
    )

    numberOfProvinces.findCircleNum(
        arrayOf(
            intArrayOf(1, 1, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 1, 0, 0),
            intArrayOf(0, 0, 1, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 1, 1),
            intArrayOf(0, 0, 0, 0, 1, 1),
        )
    )

}