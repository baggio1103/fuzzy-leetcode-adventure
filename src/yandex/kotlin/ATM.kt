package yandex.kotlin

import java.util.*

class ATM(notes: List<Note>) {

    private var overallCash: Long = notes.sumOf { it.value }

    private val noteMap: MutableMap<Note, Int> = TreeMap<Note, Int>(
        Comparator.comparing<Note, Long> { it.value }.reversed())
        .apply {
            this.putAll(
                notes.groupingBy { it }.eachCount()
            )
            println("ATM being initialized -> overallCash: $overallCash, notes: $this")
    }

    fun getCash(value: Long): Long {
        var cash = 0L
        if (overallCash < value) {
            println("ATM has no required amount - overallCash: $overallCash, required:$value")
            return 0
        }
        val withdrawnNotes = mutableMapOf<Note, Int>()
        noteMap.forEach { (note, noteCount) ->
            var count = noteCount
            if (note.value <= value) {
                while (count != 0) {
                    if (note.value > value - cash) {
                        break
                    }
                    cash += note.value
                    count--
                    noteMap[note] = count
                    withdrawnNotes[note] = noteCount
                    if (cash == value) {
                        overallCash -= value
                        println("""
                            Cash being withdrawn: $cash
                            Overall cash left: $overallCash, notes left: $noteMap
                        """.trimIndent())
                        return cash
                    }
                }
            }
        }
        withdrawnNotes.forEach { (note, noteCount) ->
            noteMap[note]?.let {
                noteMap[note] = noteCount
            }
        }
        println("""
            ATM cannot issue required value: $value
            Overall cash left: $overallCash, notes: $noteMap
        """.trimIndent())
        return 0
    }

}
