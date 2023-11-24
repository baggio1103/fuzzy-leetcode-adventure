package dailyChallenge.november.november24

fun maxCoins(piles: IntArray): Int {
    piles.sortDescending()
    var alice = 0
    var bob = piles.lastIndex
    var myPile = 0
    for (i in piles.indices step 3) {
        myPile += piles[alice + 1]
        alice += 2
        bob--
    }
    return myPile
}

fun main() {
    maxCoins(intArrayOf(2, 4, 1, 2, 7, 8))
    maxCoins(intArrayOf(2, 4, 5))
    maxCoins(intArrayOf(9, 8, 7, 6, 5, 1, 2, 3, 4))
}
