package dailyChallenge.year2024.may.may3

fun compareVersion(versionOne: String, versionTwo: String): Int {
    val listOne = versionOne.split(".").map { it.toInt() }
    val listTwo = versionTwo.split(".").map { it.toInt() }
    repeat(minOf(listOne.size, listTwo.size)) {
        val vOne = listOne[it]
        val vTwo = listTwo[it]
        if (vOne < vTwo) return -1
        if (vOne > vTwo) return 1
    }
    return when {
        listOne.size == listTwo.size -> 0
        listOne.size < listTwo.size -> {
            for (i in listOne.size until listTwo.size) {
                if (listTwo[i] > 0) return -1
            }
            0
        }

        else -> {
            for (i in listTwo.size until listOne.size) {
                if (listOne[i] > 0) return 1
            }
            0
        }
    }
}

fun main() {
    println(
        compareVersion("1.0.1", "1")
    )
    println(
        compareVersion(
            "1.0",
            "1.0.0.0",
        )
    )
    println(
        compareVersion(
            "0.1",
            "0.0.1"
        )
    )
    println(
        compareVersion(
            "1",
            "0"
        )
    )
    println(
        compareVersion(
            "1.2",
            "1.10"
        )
    )
}