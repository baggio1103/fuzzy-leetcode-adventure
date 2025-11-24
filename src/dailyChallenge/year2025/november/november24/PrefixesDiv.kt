package dailyChallenge.year2025.november.november24

fun main() {
    println(
        prefixesDivBy5(
            intArrayOf(0, 1, 1)
        )
    )
    println(
        prefixesDivBy5(
            intArrayOf(1, 1, 1)
        )
    )
    println(
        prefixesDivBy5(
            intArrayOf(0, 1, 1, 1, 1, 1)
        )
    )
}

fun prefixesDivBy5(numbers: IntArray): List<Boolean> = buildList {
    var sum = 0
    for (number in numbers) {
        sum = ((sum shl 1) or number) % 5
        add(sum == 0)
    }
}

