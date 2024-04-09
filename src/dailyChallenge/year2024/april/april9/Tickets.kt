package dailyChallenge.year2024.april.april9

import kotlin.math.min

fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
    val ticketCount = tickets[k]
    var time = 0
    for (i in 0 .. k) {
        time += min(tickets[i], ticketCount)
    }
    for (i in k + 1 until tickets.size) {
        time += min(ticketCount - 1, tickets[i])
    }
    return time
}

fun main() {
    println(
        timeRequiredToBuy(
            tickets = intArrayOf(
                15, 66, 3, 47, 71, 27, 54, 43, 97, 34, 94, 33, 54, 26, 15,
                52, 20, 71, 88, 42, 50, 6, 66, 88, 36, 99, 27, 82, 7, 72
            ),
            k = 18
        )
    )
    println(
        timeRequiredToBuy(
            tickets = intArrayOf(2, 3, 2),
            k = 2
        )
    )
    println(
        timeRequiredToBuy(
            tickets = intArrayOf(5, 1, 1, 1),
            k = 0
        )
    )
    println(
        timeRequiredToBuy(
            tickets = intArrayOf(84, 49, 5, 24, 70, 77, 87, 8),
            k = 3
        )
    )
}