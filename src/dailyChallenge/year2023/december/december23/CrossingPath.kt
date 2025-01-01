package dailyChallenge.december.december23

fun isPathCrossing(path: String): Boolean {
    val set = hashSetOf<String>()
    var xPoint = 0
    var yPoint = 0
    set.add("0 - 0")
    path.forEach { direction ->
        when (direction) {
            'N' -> {
                yPoint++
                val key = "$xPoint - $yPoint"
                if (set.contains(key)) {
                    return true
                }
                set.add(key)
            }
            'S' -> {
                yPoint--
                val key = "$xPoint - $yPoint"
                if (set.contains(key)) {
                    return true
                }
                set.add(key)
            }
            'E' -> {
                xPoint++
                val key = "$xPoint - $yPoint"
                if (set.contains(key)) {
                    return true
                }
                set.add(key)
            }
            'W' -> {
                xPoint--
                val key = "$xPoint - $yPoint"
                if (set.contains(key)) {
                    return true
                }
                set.add(key)
            }
        }
    }
    return false
}

fun main() {
    println(
        isPathCrossing(
            "NES"
        )
    )
    println(
        isPathCrossing(
            "NESWW"
        )
    )
}

