package designProblems.bitset

class Bitset(private val size: Int) {

    private var count = 0

    private var zeroArray = IntArray(size)

    private var oneArray = List(size) {
        1
    }.toIntArray()

    private var zeroArrayStringBuilder = StringBuilder(
        zeroArray.joinToString(separator = "") { "$it" }
    )

    private var oneArrayStringBuilder = StringBuilder(
        oneArray.joinToString(separator = "") { "$it" }
    )


    fun fix(index: Int) {
        if (zeroArray[index] == 1) {
            return
        }
        zeroArray[index] = 1
        zeroArrayStringBuilder.setCharAt(index, '1')

        oneArray[index] = 0
        oneArrayStringBuilder.setCharAt(index, '0')
        count++
    }

    fun unfix(index: Int) {
        if (zeroArray[index] == 0) {
            return
        }
        zeroArray[index] = 0
        zeroArrayStringBuilder.setCharAt(index, '0')

        oneArray[index] = 1
        oneArrayStringBuilder.setCharAt(index, '1')

        count--
    }

    fun flip() {
        val tempArray = zeroArray
        zeroArray = oneArray
        oneArray = tempArray
        count = size - count

        val tempString = zeroArrayStringBuilder
        zeroArrayStringBuilder = oneArrayStringBuilder
        oneArrayStringBuilder = tempString
    }

    fun all(): Boolean {
       return count == size
    }

    fun one(): Boolean {
        return count > 0
    }

    fun count(): Int {
        return count
    }

    override fun toString(): String {
        return zeroArrayStringBuilder.toString()
    }

}
