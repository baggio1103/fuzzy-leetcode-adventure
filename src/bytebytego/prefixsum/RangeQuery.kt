package bytebytego.prefixsum

fun main() {
    val numArray = NumArray(intArrayOf(3, -7, 6, 0, -2, 5))
    println(numArray.sumRange(0, 3))
    println(numArray.sumRange(2, 4))
    println(numArray.sumRange(2, 2))
}

class NumArray(nums: IntArray) {

    private val prefixSum = IntArray(nums.size + 1)

    init {
        for (i in 1 until prefixSum.size) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return prefixSum[right + 1] - prefixSum[left]
    }

}
