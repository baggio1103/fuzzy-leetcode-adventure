package dailyChallenge.may4

class DotaSenate {

    fun predictPartyVictory(senate: String): String {
        val senators = List(senate.length) { _ ->
            0
        }.toMutableList()
        val radiantIndices = mutableListOf<Int>()
        val direIndices = mutableListOf<Int>()
        senate.forEachIndexed { index, char ->
            when (char) {
                'D' -> direIndices.add(index)
                'R' -> radiantIndices.add(index)
            }
        }
        if (radiantIndices.size == 0) {
            return "Dire"
        }
        if (direIndices.size == 0) {
            return "Radiant"
        }
        var radiantSenators = radiantIndices.size
        var direSenators = direIndices.size
        while (true) {
            senate.forEachIndexed { index, char ->
                when (char) {
                    'D' -> {
                        if (senators[index] == 0) {
                            if (senators[index] == 0) {
                                val nextRadiant = radiantIndices.firstOrNull { it > index && senators[it] == 0 }
                                nextRadiant?.let { radiant ->
                                    senators[radiant] = -1
                                    radiantSenators--
                                    if (radiantSenators == 0) {
                                        return "Dire"
                                    }
                                } ?: run {
                                    val previousRadiant = radiantIndices.firstOrNull { it < index && senators[it] == 0 }
                                    previousRadiant?.let { radiant ->
                                        senators[radiant] = -1
                                        radiantSenators--
                                        if (radiantSenators == 0) {
                                            return "Dire"
                                        }
                                    }
                                }
                            }
                        }
                    }

                    'R' -> {
                        if (senators[index] == 0) {
                            val nextDire = direIndices.firstOrNull { it > index && senators[it] == 0 }
                            nextDire?.let { dire ->
                                senators[dire] = -1
                                direSenators--
                                if (direSenators == 0) {
                                    return "Radiant"
                                }
                            } ?: run {
                                val previousDire = direIndices.firstOrNull { it < index && senators[it] == 0 }
                                previousDire?.let {dire ->
                                    senators[dire] = -1
                                    direSenators--
                                    if (direSenators == 0) {
                                        return "Radiant"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

fun main() {
    val dotaSenate = DotaSenate()

    println("\nResult of RD must be 'Radiant' => '${dotaSenate.predictPartyVictory("RD")}'")

    println("\nResult of DRD must be 'Dire' => '${dotaSenate.predictPartyVictory("DRD")}'")

    println("\nResult of RDD must be 'Dire' => '${dotaSenate.predictPartyVictory("RDD")}'")

    println("\nResult of DDRRR must be 'Dire' => '${dotaSenate.predictPartyVictory("DDRRR")}'")

    println("\nResult of D must be 'Dire' => '${dotaSenate.predictPartyVictory("D")}'")

    println("\nResult of DRRD RDRD RDDR DRDR must be 'Dire' => '${dotaSenate.predictPartyVictory("D")}'")

    println("\nResult of DRRDRDRDRDDRDRDR must be 'Radiant' => '${dotaSenate.predictPartyVictory("DRRDRDRDRDDRDRDR")}'")
}