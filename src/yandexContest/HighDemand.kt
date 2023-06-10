package yandexContest

import kotlin.math.absoluteValue

fun main() {
    val input = readln()
    val (count, area) = input.split(" ").map { it.toInt() }.let {
        Pair(it[0], it[1])
    }
    val coordinates = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until count) {
        coordinates.add(readln().split(" ").map { it.toInt() }.let { Pair(it[0], it[1]) })
    }
    val suitableCoordinates = mutableListOf<Coordinate>()
    for (i in 0 until count) {
        for (j in i until count) {
            coordinates.let {
                if (it[i].first == it[j].first || it[i].second == it[j].second) {
                    return@let
                }
                val xLength = (it[j].first - it[i].first).absoluteValue
                val yLength = (it[j].second - it[i].second).absoluteValue
                println("X: $xLength, Y: $yLength")
                if (xLength * yLength > area || xLength * yLength < 1) {
                    return@let
                }
                suitableCoordinates.add(Coordinate(it[i], it[j]))
            }
        }
    }
    println(coordinates)
    println("Area $area")
    println(suitableCoordinates)
}

data class Coordinate(val aPoint: Pair<Int, Int>, val bPoint: Pair<Int, Int>,
                      val matches: MutableList<Coordinate> = mutableListOf())

/***
 *
 *
 * 5 1
 * 0 0
 * 0 2
 * 2 0
 * 1 1
 * 2 2
 *
 * **/