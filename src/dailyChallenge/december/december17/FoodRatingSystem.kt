package dailyChallenge.december.december17

import java.util.PriorityQueue
import kotlin.math.min

class FoodRatingSystem(
    foods: Array<String>,
    private val cuisines: Array<String>,
    ratings: IntArray,
) {

    private val comparator: Comparator<Pair<Int, String>> = Comparator { a, b ->
        val value = compareLexicographically(a.second, b.second)
        when (value) {
            a.second -> {
                -1
            }

            b.second -> {
                1
            }

            else -> 0
        }
    }

    private val cuisineMap = mutableMapOf<String, PriorityQueue<Pair<Int, String>>>()

    private val foodIndexMap = foods.mapIndexed { index, food -> Pair(food, index) }.toMap()

    private val foodRatingMap = foods.mapIndexed { index, value -> Pair(value, ratings[index]) }.toMap(mutableMapOf())

    init {
        foods.forEachIndexed { index, food ->
            val cuisine = cuisines[index]
            cuisineMap[cuisine]?.add(Pair(ratings[index], food)) ?: run {
                cuisineMap[cuisine] = PriorityQueue(
                    Comparator.comparing<Pair<Int, String>?, Int?> { it.first }.reversed().then(comparator)
                )
                    .apply {
                    add(Pair(ratings[index], food))
                }
            }
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val indexOfFood = foodIndexMap[food] ?: throw IllegalArgumentException()
        val cuisine = cuisines[indexOfFood]
        val currentRating = foodRatingMap[food] ?: throw IllegalArgumentException()
        cuisineMap[cuisine]?.remove(Pair(currentRating, food))
        cuisineMap[cuisine]?.add(Pair(newRating, food))
        foodRatingMap[food] = newRating
    }

    fun highestRated(cuisine: String): String {
        return cuisineMap[cuisine]?.peek()?.second ?: throw IllegalArgumentException()
    }

    private fun compareLexicographically(a: String, b: String): String {
        for (i in 0 until min(a.length, b.length)) {
            if (a[i] < b[i]) {
                return a
            }
            if (a[i] > b[i]) {
                return b
            }
        }
        return a
    }

}

fun main() {
    val foodRatingSystem = FoodRatingSystem(
        arrayOf("kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"),
        arrayOf("korean", "japanese", "japanese", "greek", "japanese", "korean"),
        intArrayOf(9, 12, 8, 15, 14, 7)
    )

    println(
        foodRatingSystem.highestRated("korean")
    )
    println(
        foodRatingSystem.highestRated("japanese")
    )
    foodRatingSystem.changeRating("sushi", 16)
    println(
        foodRatingSystem.highestRated("japanese")
    )
    foodRatingSystem.changeRating("ramen", 16)
    println(
        foodRatingSystem.highestRated("japanese")
    )

}