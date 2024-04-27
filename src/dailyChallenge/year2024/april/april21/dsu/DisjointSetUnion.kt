package dailyChallenge.year2024.april.april21.dsu

class DisjointSetUnion(
    val array: IntArray
) {

    fun union(x: Int, y: Int) {
        array[find(y)] = find(array[x])
    }

    // returns parent of representative of x
    private fun find(x: Int): Int {
        if (x == array[x]) {
            return x
        }
        return find(array[x])
    }

    fun isConnected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }

}
