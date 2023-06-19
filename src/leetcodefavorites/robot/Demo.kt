package leetcodefavorites.robot

import java.io.File

fun main() {
    println("-=-=-=-=-")
    inputFromFile()
    println("-=-=-=-=-")
    stdInput()
}

fun inputFromFile() {
    val robot = Robot()
    val input = File("input.txt").readLines().first()
    val coordinate = robot.defineCoordinate(input.toInt())
    File("output.txt").writeText("${coordinate.x} ${coordinate.y}")
}

fun stdInput() {
    val robot = Robot()
    val coordinate = robot.defineCoordinate(10)
    println(coordinate)
}