package contest343

import kotlin.math.absoluteValue
import kotlin.math.min

fun minimumCost(start: IntArray, target: IntArray, specialRoads: Array<IntArray>): Int {
    val map = mutableMapOf<String, Int>()
    var specialRoadCost = 0
    specialRoadCost += (specialRoads[0][0] - start[0]).absoluteValue
        .plus((specialRoads[0][1] - start[1].absoluteValue))
    specialRoads.forEachIndexed { index, roads ->
        if (index > 0) {
            val edgeRoadCost = (specialRoads[index - 1][3] - roads[0]).absoluteValue
                .plus((specialRoads[index - 1][3] - roads[1]).absoluteValue)
            specialRoadCost += edgeRoadCost
        }
        specialRoadCost += roads[4]
        if (index == specialRoads.size - 1) {
            specialRoadCost += (target[0] - roads[2]).absoluteValue + (target[1] - roads[3]).absoluteValue
        }
    }

    val directRoadCost = target[0] - start[0] + target[1] - start[1]
    return min(specialRoadCost, directRoadCost)
}


//[1,1]
//[5,10]
//[[3,4,5,2,5],[4,5,3,8,3],[3,2,5,3,1]]
fun main() {
    val start = intArrayOf(1, 1)
    val target = intArrayOf(4, 5)

    val specialRoads : Array<IntArray> = arrayOf(
        intArrayOf(1, 2, 3, 3, 2),
        intArrayOf(3, 4, 4, 5, 1)
    )
    println(minimumCost(start, target, specialRoads))

    val startTwo = intArrayOf(1, 1)
    val targetTwo = intArrayOf(5, 10)
    val specialRoadsTwo = arrayOf(
        intArrayOf(3,4,5,2,5),
        intArrayOf(4,5,3,8,3),
        intArrayOf(3,2,5,3,1)
    )
    println(minimumCost(startTwo, targetTwo, specialRoadsTwo))
}