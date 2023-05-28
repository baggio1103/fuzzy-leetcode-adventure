package hashtable

/**
 Apply Sliding Window Algorithm
 and on each step apply isAnagram algorithm
 on each substring. This algo works but is not optimized

 Apply sliding algorithm and save current results in a map
 Turning a string to map<Char, Int> is an expensive operation,
 hence save it a map.
 On each iteration, just remove occurrence of leftBoundChar from map
 and add occurrence of rightBoundChar.
 And then compare maps - (currentMap and pMap)
*/
class AllAnagramsInString {

    fun findAnagrams(s: String, p: String): List<Int> {
        val windowSize = p.length
        val list = mutableListOf<Int>()
        val pMap = turnStringToMap(p)
        val substringMap = turnStringToMap(s.substring(0, windowSize))
        if (isEqual(substringMap, pMap)) {
            list.add(0)
        }
        for (i in 1..s.lastIndex - windowSize + 1) {
            val leftBoundChar = s[i - 1]
            val rightBoundChar = s[i + windowSize - 1]
            substringMap[leftBoundChar]?.let {
                if (it == 1) {
                    substringMap.remove(leftBoundChar)
                } else {
                    substringMap[leftBoundChar] = it - 1
                }
            }
            substringMap[rightBoundChar]?.let {
                substringMap[rightBoundChar] = it + 1
            } ?: run {
                substringMap[rightBoundChar] = 1
            }
            if (isEqual(substringMap, pMap)) {
                list.add(i)
            }
        }
        return list
    }

    private fun turnStringToMap(string: String): MutableMap<Char, Int> {
        val charMap = mutableMapOf<Char, Int>()
        string.forEach { char ->
            charMap[char]?.let {
                charMap[char] = it + 1
            } ?: run {
                charMap[char] = 1
            }
        }
        return charMap
    }

    private fun isEqual(mapOne: Map<Char, Int>, mapTwo: Map<Char, Int>): Boolean {
        mapOne.forEach { (key, value) ->
            if (!mapTwo.containsKey(key)) {
                return false
            }
            if (mapTwo[key] != value) {
                return false
            }
        }
        return true
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

}

fun main() {

    val validator = AllAnagramsInString()
    println(
        validator.findAnagrams("cbaebabacd", "abc")
    )
    println(
        validator.findAnagrams("abab", "ab")
    )
    println(
        validator.findAnagrams("abab", "abab")
    )



}
