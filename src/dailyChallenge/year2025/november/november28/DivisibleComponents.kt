package dailyChallenge.year2025.november.november28


fun main() {
    println(
        maxKDivisibleComponents(
            5,
            arrayOf(
                intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 4)
            ),
            intArrayOf(1, 8, 1, 4, 4),
            6
        )
    )
}

fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
    val adj = Array(n) { mutableListOf<Int>() }
    for ((u, v) in edges) {
        adj[u].add(v)
        adj[v].add(u)
    }
    val componentCount = intArrayOf(0)
    fun dfs(
        node: Int,
        parent: Int
    ): Int {
        var sum = 0

        for (child in adj[node]) {
            if (child != parent) {
                sum += dfs(child, node)
            }
        }
        sum = (sum + values[node]) % k
        if (sum == 0) componentCount[0]++
        return sum
    }
    dfs(node = 0, parent = -1)
    return componentCount[0]
}
