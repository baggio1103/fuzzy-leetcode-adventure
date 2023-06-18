package leetcodefavorites.robot

data class Coordinate(
    var x: Int = 0,
    var y: Int = 0
)

class Robot {

    fun walk(steps: Int) {
        val startPoint = Coordinate()

        left {

        }

        down {

        }

        right {

        }

        up {

        }

    }

    private inline fun left(function: () -> Unit) {
        TODO("Not yet implemented")
    }

    private inline fun right(function: () -> Unit) {
        TODO("Not yet implemented")
    }

    private inline fun down(function: () -> Unit) {
        TODO("Not yet implemented")
    }

    private inline fun up(function: () -> Unit) {
        TODO("Not yet implemented")
    }

}

fun main() {
    val value = readln()
    val robot = Robot()
    robot.walk(value.toInt())
}