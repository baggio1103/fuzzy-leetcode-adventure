package bytebytego.tree

import java.util.TreeMap

private class Container(private val k: Int) {

    // st1 keeps the k smallest values, st2 keeps the rest
    private val st1 = TreeMap<Int, Int>()
    private val st2 = TreeMap<Int, Int>()

    private var st1Size = 0
    private var st2Size = 0

    // sum of the k smallest elements
    private var sum = 0L

    private fun addOne(map: TreeMap<Int, Int>, key: Int) {
        map[key] = (map[key] ?: 0) + 1
    }

    private fun removeOne(map: TreeMap<Int, Int>, key: Int) {
        val count = map[key] ?: return
        if (count == 1) {
            map.remove(key)
        } else {
            map[key] = count - 1
        }
    }

    private fun rebalance() {
        // move smallest elements from st2 to st1 until st1 has k elements
        while (st1Size < k && st2.isNotEmpty()) {
            val x = st2.firstKey()
            addOne(st1, x)
            st1Size++
            sum += x

            removeOne(st2, x)
            st2Size--
        }

        // move largest elements from st1 to st2 if st1 exceeds k
        while (st1Size > k) {
            val x = st1.lastKey()
            addOne(st2, x)
            st2Size++

            removeOne(st1, x)
            st1Size--
            sum -= x
        }
    }

    fun add(x: Int) {
        if (st2.isNotEmpty() && x >= st2.firstKey()) {
            addOne(st2, x)
            st2Size++
        } else {
            addOne(st1, x)
            st1Size++
            sum += x
        }
        rebalance()
    }

    fun erase(x: Int) {
        when {
            st1.containsKey(x) -> {
                removeOne(st1, x)
                st1Size--
                sum -= x
            }
            st2.containsKey(x) -> {
                removeOne(st2, x)
                st2Size--
            }
        }
        rebalance()
    }

    fun currentSum(): Long = sum
}

