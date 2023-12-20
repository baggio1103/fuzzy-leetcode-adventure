package dailyChallenge.december.december20

import java.util.PriorityQueue

fun buyChoco(prices: IntArray, money: Int): Int {
    val priceQueue = PriorityQueue<Int>().apply {
        addAll(prices.asSequence())
    }
    val (firstChoco, secondChoco) = Pair(priceQueue.poll(), priceQueue.poll())
    val leftOver = money - (firstChoco + secondChoco)
    return if (leftOver < 0) money else leftOver
}

fun main() {
    println(
        buyChoco(
            intArrayOf(1, 2, 2), 3
        )
    )
    println(
        buyChoco(
            intArrayOf(3, 2, 3), 3
        )
    )

}