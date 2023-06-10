package contest343

fun isWinner(player1: IntArray, player2: IntArray): Int {
    var sumOne = 0
    var sumTwo = 0
    for (i in player1.indices) {
        sumOne += when (i) {
            0 -> {
                player1[i]
            }
            1 -> {
                if (player1[0] == 10) player1[i] * 2 else player1[i]
            }
            else -> {
                if (player1[i - 1] == 10 || player1[i - 2] == 10) player1[i] * 2 else player1[i]
            }
        }
        sumTwo += when (i) {
            0, 1 -> {
                if (i == 0) {
                    player2[0]
                } else {
                    if (player2[0] == 10) player2[i] * 2 else player2[i]                }
            }
            else -> {
                if (player2[i - 1] == 10 || player2[i - 2] == 10) player2[i] * 2 else player2[i]
            }
        }
    }
    println("sumOne: $sumOne, sumTwo: $sumTwo")
    return if (sumOne > sumTwo) {
        1
    } else if (sumTwo > sumOne) {
        2
    } else {
        0
    }
}

fun main() {
    println(isWinner(intArrayOf(4, 10, 7, 8), intArrayOf(6,5,2,3)))
    println(isWinner(intArrayOf(3, 5, 7, 6), intArrayOf(8,10,10,2)))
    println(isWinner(intArrayOf(2, 3), intArrayOf(1, 4)))
}