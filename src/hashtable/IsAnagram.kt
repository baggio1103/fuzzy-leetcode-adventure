package hashtable

class IsAnagram {

    // First form a map for s and t, such that Map<Char, Count>
    // then iterate over any of sMap or tMap to check that
    // any char is present in both of maps and count of that char is also equal,
    // Otherwise false
    fun isAnagram(s: String, t: String): Boolean {
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

}

fun main() {
    val validator = IsAnagram()
    println(
        validator.isAnagram("cat", "rat")
    )
    println(
        validator.isAnagram("anagram", "nagaram")
    )
    println(
        validator.isAnagram("aacc", "ccac")
    )
}