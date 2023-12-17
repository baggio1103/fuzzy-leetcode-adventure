package dailyChallenge.december.december17

import kotlin.math.min

fun main() {
    val foodRatingSystem = FoodRatingSystem(
        arrayOf("cpctxzh", "bryvgjqmj", "wedqhqrmyc", "ee", "lafzximxh", "lojzxfel", "flhs"),
        arrayOf("wbhdgqphq", "wbhdgqphq", "mxxajogm", "wbhdgqphq", "wbhdgqphq", "mxxajogm", "mxxajogm"),
        intArrayOf(15, 5, 7, 16, 16, 10, 13)
    )
    foodRatingSystem.changeRating("lojzxfel", 1)


    println(
        foodRatingSystem.highestRated("mxxajogm")
    )

    println(foodRatingSystem.highestRated("wbhdgqphq"))

    println(
        foodRatingSystem.highestRated("mxxajogm")
    )
}
