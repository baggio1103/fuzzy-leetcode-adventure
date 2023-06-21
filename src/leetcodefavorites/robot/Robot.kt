package leetcodefavorites.robot

data class Coordinate(
    var x: Int = 0,
    var y: Int = 0
)

class Robot {

    fun defineCoordinate(steps: Int): Coordinate {
        val startPoint = Coordinate()
        var movement = 0
        var turns = 0
        while (true) {
            turns++
            left {
                repeat(turns) {
                    if (movement == steps) {
                        println(startPoint)
                        return startPoint
                    }
                    movement++
                    startPoint.x--
                }
            }

            down {
                repeat(turns) {
                    if (movement == steps) {
                        println(startPoint)
                        return startPoint
                    }
                    movement++
                    startPoint.y--
                }
            }
            turns++
            right {
                repeat(turns) {
                    if (movement == steps) {
                        println(startPoint)
                        return startPoint
                    }
                    movement++
                    startPoint.x++
                }

            }

            up {
                repeat(turns) {
                    if (movement == steps) {
                        println(startPoint)
                        return startPoint
                    }
                    movement++
                    startPoint.y++
                }
            }
        }
    }

    private inline fun left(function: () -> Unit) {
        function()
    }

    private inline fun right(function: () -> Unit) {
        function()
    }

    private inline fun down(function: () -> Unit) {
        function()
    }

    private inline fun up(function: () -> Unit) {
        function()
    }

}