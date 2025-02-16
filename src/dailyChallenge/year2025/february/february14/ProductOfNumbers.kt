package dailyChallenge.year2025.february.february14

fun main() {
    val productOfNumbers = ProductOfNumbers()
    intArrayOf(3, 0, 2, 5, 4).forEach { productOfNumbers.add(it) }
    println(productOfNumbers.getProduct(1))
    println(productOfNumbers.getProduct(2))
    println(productOfNumbers.getProduct(3))
    println(productOfNumbers.getProduct(4))
    println(productOfNumbers.getProduct(5))
}

class ProductOfNumbers {

    private val productList = mutableListOf(1)
    private var size = 0

    fun add(num: Int) {
        if (num == 0) {
            size = 0
            productList.clear()
            productList.add(1)
            return
        }
        productList.add(productList[size] * num)
        size++
    }

    fun getProduct(k: Int): Int {
        return if (k > size) 0 else productList[size] / productList[size - k]
    }

}
