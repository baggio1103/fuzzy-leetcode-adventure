package dailyChallenge.year2024.may.may3

fun compareVersionTwoPointer(versionOne: String, versionTwo: String): Int {
    var i = 0
    var j = 0
    while (i < versionOne.length && j < versionTwo.length) {
        var vOne = 0
        while (i < versionOne.length && versionOne[i] != '.') {
            vOne += 10 * vOne + (versionOne[i] - '0')
            i++
        }
        var vTwo = 0
        while (j < versionTwo.length && versionTwo[j] != '.') {
            vTwo += 10 * vTwo + (versionTwo[j] - '0')
            j++
        }
        if (vOne < vTwo) return -1
        if (vOne > vTwo) return 1
        i++
        j++
    }
    if (i == versionOne.length && j == versionTwo.length) return 0
    var remainder = 0
    while (i < versionOne.length) {
        if (versionOne[i] == '.') {
            remainder = 0
            i++
            continue
        }
        remainder += 10 * remainder + (versionOne[i] - '0')
        if (remainder > 0) return 1
        i++
    }
    while (j < versionTwo.length) {
        if (versionTwo[j] == '.') {
            remainder = 0
            j++
            continue
        }
        remainder += 10 * remainder + (versionTwo[j] - '0')
        if (remainder > 0) return -1
        j++
    }
    return 0
}

fun main() {
    println(
        compareVersionTwoPointer("1", "1.1")
    )
    println(
        compareVersionTwoPointer("1.0.1", "1")
    )
    println(
        compareVersionTwoPointer("1.2", "1.10")
    )
    println(
        compareVersionTwoPointer("1.0", "1.0.0.0")
    )
    println(
        compareVersionTwoPointer("0.1", "0.0.1")
    )
    println(
        compareVersionTwoPointer("1", "0")
    )
    println(
        compareVersionTwoPointer("1.2", "1.10")
    )
}