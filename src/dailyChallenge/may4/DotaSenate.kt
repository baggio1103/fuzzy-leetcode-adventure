package dailyChallenge.may4

class DotaSenate {

    fun predictPartyVictory(senate: String): String {
        val senators = List(senate.length) {
            _ -> 0
        }.toMutableList()
        val radiantIndices = mutableListOf<Int>()
        val direIndices = mutableListOf<Int>()
        senate.forEachIndexed { index, char ->
            when (char) {
                'D' -> direIndices.add(index)
                'R' -> radiantIndices.add(index)
            }
        }
        var activeSenators = senate.length
        while (true) {
            senate.forEach { char ->
                when (char) {
                    'D' -> {
                        for (i in 0 until radiantIndices.size) {
                            if (senators[radiantIndices[i]] == 0) {
                                senators[radiantIndices[i]] = -1
                                activeSenators--
                                if (activeSenators == 1) {
                                    return "Radiant"
                                }
                                break
                            }
                        }
                    }
                    'R' -> {
                        for (i in 0 until direIndices.size) {
                            if (senators[direIndices[i]] == 0) {
                                senators[direIndices[i]] = -1
                                activeSenators--
                                if (activeSenators == 1) {
                                    return "Dire"
                                }
                                break
                            }
                        }
                    }
                }
            }
        }
    }

//    fun predictPartyVictory(senate: String): String {
//        // Pair(count, sumOfIndices)
//        val radiantParty = Party(0, 0)
//        val direParty = Party(0, 0)
//        senate.forEachIndexed { index, char ->
//            when (char) {
//                'R' -> radiantParty.accumulate(index)
//                'D' -> direParty.accumulate(index)
//            }
//        }
//        return when {
//            radiantParty.count > direParty.count -> "Radiant"
//            direParty.count > radiantParty.count -> "Dire"
//            else -> if (radiantParty.sumOfIndices < direParty.sumOfIndices) "Radiant" else "Dire"
//        }
//    }
//
//    data class Party(
//        var count: Int,
//        var sumOfIndices: Int
//    ) {
//        fun accumulate(index: Int) {
//            count++
//            sumOfIndices += index
//        }
//    }

//    fun predictPartyVictory(senate: String): String {
//        var radiant = 0
//        var dire = 0
//        val partyCount = mutableMapOf(
//            'R' to Pair(0, -1),
//            'D' to Pair(0, -1)
//        )
//        var r = Triple('R', 0, -1)
//        var rCurrent = Triple('R', 0, -1)
//
//        var d = Triple('D', 0, -1)
//        var dCurrent = Triple('D', 0, -1)
//
//        for (i in 0 until senate.length - 1) {
//            if (senate[i] == senate[i + 1]) {
//                when (senate[i]) {
//                    'R' -> {
//                        partyCount['R']
//                    }
//                    'D' -> dire++
//                }
//            } else {
//                when (senate[i]) {
//                    'R' -> {
//                        partyCount['R']
//                    }
//                    'D' -> dire++
//                }
//
//            }
//        }
//        senate.forEachIndexed { index, char ->
//            if (index != senate.lastIndex) {
//
//            }
//            when (char) {
//                'R' -> radiant++
//                'D' -> dire++
//            }
//        }
//        return if (radiant > dire) "Radiant" else "Dire"
//    }

}

fun main() {
    val dotaSenate = DotaSenate()
//    val senate = "RDD"
//    println(dotaSenate.predictPartyVictory(senate))
//
    println("Result of RD must be 'Radiant' == '${dotaSenate.predictPartyVictory("RD")}'")

    println("Result of DRD must be 'Dire' == '${dotaSenate.predictPartyVictory("DRD")}'")

    println(dotaSenate.predictPartyVictory("DDRRR"))

}