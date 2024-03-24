package dailyChallenge.year2024.march.march24

fun findDuplicate(array: IntArray): Int {
    var tortoise = array[0]
    var hare = array[0]
    do {
        tortoise = array[tortoise]
        hare = array[array[hare]]
    } while (tortoise != hare)

    hare = array[0]
    while (tortoise != hare) {
        tortoise = array[tortoise]
        hare = array[hare]
    }
    return tortoise
}

fun main() {
    println(
        findDuplicate(
            intArrayOf(1, 2, 3, 4, 2)
        )
    )
    println(
        findDuplicate(intArrayOf(4, 3, 1, 4, 2))
    )
    println(
        findDuplicate(
            intArrayOf(3, 1, 3, 4, 2)
        )
    )
    println(
        findDuplicate(
            intArrayOf(3, 3, 3)
        )
    )
}