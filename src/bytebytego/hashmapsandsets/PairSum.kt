package bytebytego.hashmapsandsets

fun main() {
    println(twoSum(intArrayOf(-1, 3, 4, 2), 3).contentToString())
}

fun twoSum(numbers: IntArray, target: Int): IntArray {
    val hashMap = mutableMapOf<Int, Int>()
    for ((index, value) in numbers.withIndex()) {
        val complement = target - value
        if (complement in hashMap) return intArrayOf(hashMap.getValue(complement), index)
        hashMap[value] = index
    }
    return intArrayOf()
}
