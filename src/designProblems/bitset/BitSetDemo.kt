package designProblems.bitset

fun main() {
    val bitset = Bitset(5)
    println("-=-=-=-=-=BitSetOne-=-=-=-=-=")
    bitset.fix(3)
    bitset.fix(1)
    bitset.flip()
    println(
        bitset.all()
    )
    bitset.unfix(0)
    bitset.flip()
    println(
        bitset.one()
    )
    bitset.unfix(0)
    println(bitset.count())
    println(bitset.toString())

    println("-=-=-=-=-=BitSetTwo-=-=-=-=-=")
    val bitsetTwo = Bitset(2)
    bitsetTwo.flip()
    bitsetTwo.unfix(1)
    println(
        bitsetTwo.all()
    )
    bitsetTwo.fix(1)
    bitsetTwo.fix(1)
    bitsetTwo.unfix(1)
    println(bitsetTwo.all())
    println(bitsetTwo.count())
    println(bitsetTwo.toString())
    println(bitsetTwo.toString())
    println(bitsetTwo.toString())

    bitsetTwo.unfix(0)
    bitsetTwo.flip()
    println(
        bitsetTwo.all()
    )
    bitsetTwo.unfix(0)
    println(
        bitsetTwo.one()
    )
    println(
        bitsetTwo.one()
    )
    println(
        bitsetTwo.all()
    )
    bitsetTwo.fix(0)
    bitsetTwo.unfix(0)

}