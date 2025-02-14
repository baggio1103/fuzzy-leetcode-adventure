package dailyChallenge.year2025.february.february14

fun main() {

}

class ProductOfNumbers {

    private var size = 0
    private val productList = mutableListOf(1)

    fun add(num: Int) {
        if (num == 0) {
            size = 0
            productList.clear()
            productList.add(1)
        } else {
            productList.add( productList[size] * num )
            size++
        }

    }

    fun getProduct(k: Int): Int {
        if (k > size) return 0
        return productList[size] / productList[size - k]
    }

}
