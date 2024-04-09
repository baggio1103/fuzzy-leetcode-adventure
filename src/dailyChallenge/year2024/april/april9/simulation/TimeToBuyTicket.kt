package dailyChallenge.year2024.april.april9.simulation

fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
    var time = 0
    while (tickets[k] != 0) {
        for (i in tickets.indices) {
            if (tickets[i] != 0) {
                tickets[i]--
                time++
            }
            if (tickets[k] == 0) return time
        }
    }
    return time
}

fun main() {
    println(
        timeRequiredToBuy(
            tickets = intArrayOf(5, 1, 1, 1),
            0
        )
    )
    println(
        timeRequiredToBuy(
            tickets = intArrayOf(84, 49, 5, 24, 70, 77, 87, 8),
            k = 3
        )
    )

}