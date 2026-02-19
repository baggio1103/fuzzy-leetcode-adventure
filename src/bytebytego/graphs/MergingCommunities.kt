package bytebytego.graphs

fun main() {
    val community = Community(5)
    require(community.find(0) == 0)
    community.connect(0, 1)
    require(community.find(0) == 1)
    require(community.find(1) == 1)
    community.connect(0, 2)
    require(community.find(1) == 2)
    require(community.communitySize(0) == 3)

    community.connect(3, 4)
    require(community.communitySize(3) == 2)
    require(community.communitySize(4) == 2)

    community.connect(0, 4)
    community.connect(0, 4)
    require(community.communitySize(0) == 5)
}

class Community(
    val n: Int
) {

    private val community = IntArray(n) { it }
    private val size = IntArray(n) { 1 }

    fun connect(x: Int, y: Int) {
        // x belongs to y
        val xRep = find(x)
        val yRep = find(y)
        if (xRep == yRep) return
        size[yRep] += size[xRep]
        community[xRep] = community[yRep]
    }

    fun communitySize(i: Int): Int {
        return size[find(i)]
    }

    fun find(x: Int): Int {
        if (x == community[x]) return x
        return find(community[x])
    }

}
