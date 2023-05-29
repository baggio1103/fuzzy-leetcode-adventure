package yandex.kotlin

import yandex.kotlin.Note.*

fun main() {
    val atm = ATM(
        listOf(FIFTY,
            FIVE_THOUSAND,
            THOUSAND,
            HUNDRED,
            FIVE_HUNDRED,
            FIFTY,
            FIVE_THOUSAND)
    )
    atm.getCash(100000L)
    atm.getCash(1060L)

    val atmTwo = ATM(
        listOf(
            FIVE_THOUSAND,
            FIFTY,
            FIFTY,
            FIFTY,
            FIFTY,
            HUNDRED
        )
    )
    atmTwo.getCash(200L)
}