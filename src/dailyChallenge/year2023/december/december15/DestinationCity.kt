package dailyChallenge.december.december15

fun alternativeDestCity(paths: List<List<String>>): String {
    val map = paths.associate {
        it[0] to it[1]
    }
    paths.flatten().groupingBy { it }.eachCount()
        .filter { it.value == 1 }
        .forEach { (key, _) ->
            if (map[key] == null) {
                return key
            }
        }
    return ""
}

fun destCity(paths: List<List<String>>): String {
    val map = paths.associate {
        it[0] to it[1]
    }
    return paths.first {
        map[it[1]] == null
    }[1]
}

fun main() {
    println(
        destCity(
            listOf(listOf("B", "C"), listOf("D", "B"), listOf("C", "A"))
        )
    )
    println(
        destCity(
            listOf(
                listOf("London", "New York"),
                listOf("New York", "Lima"),
                listOf("Lima", "San Paulo"),
            )
        )
    )
}