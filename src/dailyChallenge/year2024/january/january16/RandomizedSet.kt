package dailyChallenge.year2024.january.january16

class RandomizedSet {

    private val randomMap = mutableMapOf<Int, Int>()

    private val values = mutableListOf<Int>()

    fun insert(`val`: Int): Boolean {
        if (randomMap[`val`] != null) {
            return false
        }
        randomMap[`val`] = values.size
        values.add(`val`)
        return true
    }

    fun remove(`val`: Int): Boolean {
        val index = randomMap[`val`] ?: return false
        val lastElement = values.last()
        randomMap[lastElement] = index
        values[index] = lastElement
        values.removeLast()
        randomMap.remove(`val`)
        return true
    }

    fun getRandom(): Int {
        return values.random()
    }

}

fun main() {

    val randomizedSet = RandomizedSet()
    println(
        randomizedSet.insert(5)
    )
    println(
        randomizedSet.insert(8)
    )
    println(
        randomizedSet.insert(9)
    )
    println(
        randomizedSet.insert(10)
    )
    println(
        randomizedSet.insert(7)
    )
    println(
        randomizedSet.insert(3)
    )
    println(
        randomizedSet.remove(10)
    )
    println(
        randomizedSet.getRandom()
    )
}