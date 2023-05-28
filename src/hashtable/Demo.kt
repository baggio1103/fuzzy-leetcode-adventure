package hashtable

/**
 * An approach that solves allAnagramsInAString problem,
 * however this approach is a bit slow
 * */

fun findAnagrams(s: String, p: String): List<Int> {
    val windowSize = p.length
    val list = mutableListOf<Int>()
    for (i in 0..s.lastIndex - windowSize + 1) {
        val substring = s.substring(i, i + windowSize)
        if (substring == p)  {
            list.add(i)
        } else {
            if (isAnagram(substring, p)) {
                list.add(i)
            }
        }
    }
    return emptyList()
}

private fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }
    val sMap = mutableMapOf<Char, Int>()
    val tMap = mutableMapOf<Char, Int>()
    s.forEach { char ->
        sMap[char]?.let {
            sMap[char] = it + 1
        } ?: run {
            sMap[char] = 1
        }
    }
    t.forEach { char ->
        tMap[char]?.let {
            tMap[char] = it + 1
        } ?: run {
            tMap[char] = 1
        }
    }
    sMap.forEach { (key, value) ->
        if (!tMap.containsKey(key)) {
            return false
        }
        if (tMap[key] != value) {
            return false
        }
    }
    return true
}

fun main() {
    print(
        findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa")
    )
}