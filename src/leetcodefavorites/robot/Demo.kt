package leetcodefavorites.robot

import java.io.File

fun main() {
    val robot = Robot()
    val input = File("input.txt").readLines().first()
    val coordinate = robot.defineCoordinate(input.toInt())
    File("output.txt").writeText("${coordinate.x} ${coordinate.y}")
}