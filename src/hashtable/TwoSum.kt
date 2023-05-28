package hashtable

class TwoSum {

    fun twoSum(array: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        array.forEachIndexed { index, value ->
            map[value]?.let {
                return intArrayOf(it, index)
            } ?: run {
                map[target - value] = index
            }
        }
        return intArrayOf()
    }

}

fun main() {

    val solution = TwoSum()
    solution.twoSum(
        intArrayOf(2, 11, 17, 20, 7),
        9
    ).let {
        if (it.isNotEmpty()) {
            println("Sum: ${it.sum()}. List: ${it.toList()}")
        }
    }
    solution.twoSum(
        intArrayOf(2, 7, 10, 20),
        9
    ).let {
        if (it.isNotEmpty()) {
            println("Sum: ${it.sum()}. List: ${it.toList()}")
        }
    }
    solution.twoSum(
        intArrayOf(3, 2, 4),
        7
    ).let {
        if (it.isNotEmpty()) {
            println("Sum: ${it.sum()}. List: ${it.toList()}")
        }
    }
    solution.twoSum(
        intArrayOf(-1,-2,-3,-4,-5),
        -8
    ).let {
        if (it.isNotEmpty()) {
            println("Sum: ${it.sum()}. List: ${it.toList()}")
        }
    }

}