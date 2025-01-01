package dailyChallenge.july

class FairDistribution {

    fun distributeCookies(cookies: IntArray, k: Int): Int {
        val sum = cookies.sum()
        if (sum % k == 0) {
            return sum / k
        }
        val quotient = sum / k
        val list = MutableList(k) {
            _ -> quotient
        }
        var distributionSum = quotient * k
        var i = list.lastIndex
        while (distributionSum != sum) {
            list[i] = list[i] + 1
            i--
            distributionSum++
        }
        return list[i + 1]
    }

}

fun main() {
    val fairDistribution = FairDistribution()
    println(
        fairDistribution.distributeCookies(
            intArrayOf(8, 15, 10, 20, 8),
            2
        )
    )
    println(
        fairDistribution.distributeCookies(
            intArrayOf(6, 1, 3, 2, 2, 4, 1, 2),
            3
        )
    )
}