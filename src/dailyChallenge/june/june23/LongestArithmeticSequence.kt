package dailyChallenge.june.june23

class LongestArithmeticSequence {

    fun longestArithmeticSeqLength(array: IntArray): Int {
        array.sort()
        var size = 2
        var sequenceMap = mutableMapOf<Key, Value>()
        val prefixes = hashSetOf<String>()
        array.forEach { arrValue ->
            val newSequence = mutableMapOf<Key, Value>()
            sequenceMap.forEach { (key, value) ->
                if (!key.key.contains('>')) {
                    val prefix = "${key.key}->$arrValue"
                    newSequence[key] = value
                    if (!prefixes.contains(prefix)) {
                        newSequence[Key("${key.key}->$arrValue")] = Value(arrValue - key.key.toInt(), 2)
                    }
                } else {
                    val lastValue = key.key.split("->").let {
                        it[1].toInt()
                    }
                    if (arrValue - lastValue == value.diff) {
                        key.key = "$lastValue->$arrValue"
                        value.size += 1
                        size = maxOf(size, value.size)
                        prefixes.add("$lastValue->$arrValue")
                    }
                }
            }
            newSequence[Key("$arrValue")] = Value(0, 1)
            sequenceMap = (sequenceMap + newSequence) as MutableMap<Key, Value>
        }
        println("Size: $size")
        println(sequenceMap)
        return size
    }

    data class Key(var key: String) {
        override fun toString(): String {
            return key
        }

    }

    data class Value(
        val diff: Int = 0,
        var size: Int = 1
    ) {
        override fun toString(): String {
            return "$diff-$size"
        }


    }

}

fun main() {
    val array = intArrayOf(1, 6, 10, 11)
    val solution = LongestArithmeticSequence()
    solution.longestArithmeticSeqLength(intArrayOf(0,8,45,88,48,68,28,55,17,24))
    solution.longestArithmeticSeqLength(array)
    solution.longestArithmeticSeqLength(intArrayOf(3,6,9,12))
    solution.longestArithmeticSeqLength(intArrayOf(9,4,7,2,10))
    solution.longestArithmeticSeqLength(intArrayOf(20,1,15,3,10,5,8))
    solution.longestArithmeticSeqLength(intArrayOf(9, 4, 7, 2, 10))
}

