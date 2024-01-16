package dailyChallenge.year2024.january.january16

class RandomizedSet {

    private val randomSet = hashSetOf<Int>()

    fun insert(`val`: Int): Boolean {
        return randomSet.add(`val`)
    }

    fun remove(`val`: Int): Boolean {
        return randomSet.remove(`val`)
    }

    fun getRandom(): Int {
        return randomSet.random()
    }

}

fun main() {

    val randomizedSet = RandomizedSet()
    println(
        randomizedSet.insert(0)
    )
    println(
        randomizedSet.insert(1)
    )
    println(
        randomizedSet.remove(0)
    )
    println(
        randomizedSet.insert(2)
    )
    println(
        randomizedSet.remove(1)
    )
    println(
        randomizedSet.getRandom()
    )
}