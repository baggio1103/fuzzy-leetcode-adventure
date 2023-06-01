package designProblems.bitset

class Bitset(size: Int) {

    private val memory = IntArray(size)

    fun fix(index: Int) {
        if (memory[index] == 1) {
            return
        }
        memory[index] = 1
    }

    fun unfix(index: Int) {
        if (memory[index] == 0) {
            return
        }
        memory[index] = 0
    }

    fun flip() {
        memory.forEachIndexed { index, value ->
            if (value == 0) {
                memory[index] = 1
            } else {
                memory[index] = 0
            }
        }
    }

    fun all(): Boolean {
       return memory.all {
            it == 0
        }
    }

    fun one(): Boolean {
        return memory.any {
            it == 1
        }
    }

    fun count(): Int {
        return memory.count { it == 1 }
    }

    override fun toString(): String {
        return memory.joinToString(separator = "") {"$it" }
    }

}
