package dailyChallenge.may.may30

class MyHashSet {

    private val array = MutableList(1000000 + 1) {
        _ -> -1
    }

    fun add(key: Int) {
        array[key] = key
    }

    fun remove(key: Int) {
        array[key] = -1
    }

    fun contains(key: Int): Boolean {
        return array[key] != -1
    }

}

fun main() {
    val myHashSet = MyHashSet()
    myHashSet.remove(0)
    myHashSet.add(1)
    myHashSet.add(2)
    myHashSet.add(3)
    myHashSet.contains(3)
    myHashSet.add(22)
    myHashSet.add(2)
    myHashSet.add(2)
    myHashSet.add(1000000)
    myHashSet.remove(2)
    println(
        myHashSet.contains(2)
    )
}
