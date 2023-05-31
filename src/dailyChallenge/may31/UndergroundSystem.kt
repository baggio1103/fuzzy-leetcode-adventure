package dailyChallenge.may31

class UndergroundSystem {

    private val travelDifference: MutableMap<String, MutableList<Int>> = mutableMapOf()

    private val checkInStationMap: MutableMap<Int, Pair<String, Int>> = mutableMapOf()

    fun checkIn(id: Int, stationName: String, checkInTime: Int) {
        checkInStationMap[id] = Pair(stationName, checkInTime)
    }

    private val key: (String, String) -> String = { a: String, b: String ->
        "$a->$b"
    }

    fun checkOut(id: Int, checkOutStationName: String, checkOutTime: Int) {
        val (checkInStationName, checkInTime) = checkInStationMap[id]
            ?: throw IllegalArgumentException("Value cannot be null")
        travelDifference[key(checkInStationName, checkOutStationName)]?.add(checkOutTime - checkInTime)
            ?: run {
                travelDifference[key(checkInStationName, checkOutStationName)] = mutableListOf(checkOutTime - checkInTime)
        }
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        return travelDifference[key(startStation, endStation)]?.average() ?: 0.0
    }

}
