package leetcodefavorites

class GasStation {


    private fun findIndex(gas: IntArray, cost: IntArray): Int {
        gas.forEachIndexed { index, value ->
            if (value >= cost[index]) {
                return index
            }
        }
        return -1
    }

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        if (gas.sum() < cost.sum()) {
            return -1
        }
        val size = gas.size
        val index = findIndex(gas, cost)
        for (i in index until size) {
            var counter = 0
            var sum = 0
            var startingIndex = i
            while (counter < size) {
                if (startingIndex == i && counter == 0) {
                    sum += gas[startingIndex]
                }
                sum -= cost[startingIndex]
                if (sum < 0) {
                    counter = size
                }
                if (startingIndex == size - 1) {
                    startingIndex = 0
                } else {
                    startingIndex++
                }
                sum += gas[startingIndex]
                counter++
                if (counter == size) {
                    return i
                }
            }
        }
        return -1
    }

}


fun main() {

    val station = GasStation()
    println(
        station.canCompleteCircuit(
            gas = intArrayOf(2, 3, 4),
            cost = intArrayOf(3, 4, 3)
        )
    )
    println("--=-=-=-=")
    println(
        station.canCompleteCircuit(
            gas = intArrayOf(2, 3, 5),
            cost = intArrayOf(3, 4, 3)
        )
    )

    println(
        station.canCompleteCircuit(
            gas = intArrayOf(1, 2, 3, 4, 5),
            cost = intArrayOf(3, 4, 5, 1, 2)
        )
    )

    println(
        station.canCompleteCircuit(
            gas = intArrayOf(5),
            cost = intArrayOf(4)
        )
    )


    println(
        station.canCompleteCircuit(
            gas = intArrayOf(5,1,2,3,4),
            cost = intArrayOf(4,4,1,5,1)
        )
    )

}