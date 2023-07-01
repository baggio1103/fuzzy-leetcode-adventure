package dailyChallenge.may29

class ParkingSystem(small: Int, medium: Int, big: Int) {

    private val parkingSpaces = mutableMapOf(
        1 to Pair(0, big),
        2 to Pair(0, medium),
        3 to Pair(0, small)
    )

    fun addCar(carType: Int): Boolean {
        when(carType) {
            1 -> {
                parkingSpaces[1]?.let { (busy, max) ->
                    if (busy + 1 > max) {
                        return false
                    } else {
                        parkingSpaces[1] = Pair(busy + 1, max)
                        return true
                    }
                }
            }
            2 -> {
                parkingSpaces[2]?.let { (busy, max) ->
                    if (busy + 1 > max) {
                        return false
                    } else {
                        parkingSpaces[2] = Pair(busy + 1, max)
                        return true
                    }
                }
            }
            3 -> {
                parkingSpaces[3]?.let { (busy, max) ->
                    if (busy + 1 > max) {
                        return false
                    } else {
                        parkingSpaces[3] = Pair(busy + 1, max)
                        return true
                    }
                }
            }
        }
        return false
    }

}

fun main() {
    val parkingSystem = ParkingSystem(1, 1, 0)
    intArrayOf(1, 2, 3, 1).forEach { value ->
        println(
            parkingSystem.addCar(value)
        )
    }
}