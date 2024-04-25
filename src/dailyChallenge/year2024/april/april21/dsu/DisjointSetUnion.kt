package dailyChallenge.year2024.april.april21.dsu

class DisjointSetUnion(
    val array: IntArray
) {

    fun union(x: Int, y: Int) {
        array[y] = array[x]
    }

    // returns parent of x
    fun find(x: Int): Int {
        if (x == array[x]) {
            return x
        }
        return find(array[x])
    }

    fun isConnected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }

}

fun main() {
    val nodes = intArrayOf(0, 1, 2, 3, 4, 5)
    val dsu = DisjointSetUnion(nodes)
    dsu.union(0, 1)
    println(
        nodes.asList()
    )
    println(
        dsu.isConnected(0, 1)
    )
    println(
        dsu.isConnected(0, 5)
    )
}

