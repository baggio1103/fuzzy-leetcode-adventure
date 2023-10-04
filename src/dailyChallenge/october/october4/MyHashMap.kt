package dailyChallenge.october.october4

class MyHashMap {

    private val values = MutableList(10000) { _ ->
        -1
    }

    fun put(key: Int, value: Int) {
        values[key] = value
    }

    fun get(key: Int): Int {
        return values[key]
    }

    fun remove(key: Int) {
        values[key] = -1
    }

}

fun main() {
    val hashMap = MyHashMap()
    hashMap.put(10, 12312321)
    assert(hashMap.get(10) == 12312321)
    hashMap.remove(10)
    assert(hashMap.get(10) == -112)
}