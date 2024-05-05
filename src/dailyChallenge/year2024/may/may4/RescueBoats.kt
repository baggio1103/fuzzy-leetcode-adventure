package dailyChallenge.year2024.may.may4

fun numRescueBoats(people: IntArray, limit: Int): Int {
    people.sortDescending()
    var left = 0
    var right = people.lastIndex
    var boats = 0
    while (left <= right) {
        boats++
        if (people[left] + people[right] <= limit) {
            left++
            right--
            continue
        }
        left++
    }
    return boats
}

fun main() {
    println(
        numRescueBoats(
            people = intArrayOf(3, 2, 2, 1),
            limit = 3
        )
    )
    println(
        numRescueBoats(
            people = intArrayOf(3, 5, 3, 4),
            limit = 5
        )
    )
    println(
        numRescueBoats(
            people = intArrayOf(1, 2),
            limit = 3
        )
    )
}