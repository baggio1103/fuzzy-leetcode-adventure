package dailyChallenge.may.may31

fun main() {
    val undergroundSystem = UndergroundSystem()
    println("-=-=-=-=-=-=-=-=-UndergroundOne-=-=-=-=-=-=-=-=-")
    undergroundSystem.checkIn(45, "Leyton", 3)
    undergroundSystem.checkIn(32, "Paradise", 8)
    undergroundSystem.checkIn(27, "Leyton", 10)
    undergroundSystem.checkOut(45, "Waterloo", 15)
    undergroundSystem.checkOut(27, "Waterloo", 20)
    undergroundSystem.checkOut(32, "Cambridge", 22)
    println("AverageTime: ${undergroundSystem.getAverageTime("Paradise", "Cambridge")}")
    println("AverageTime: ${undergroundSystem.getAverageTime("Leyton", "Waterloo")}")
    undergroundSystem.checkIn(10, "Leyton", 24)
    println("AverageTime: ${undergroundSystem.getAverageTime("Leyton", "Waterloo")}")
    undergroundSystem.checkOut(10, "Waterloo", 38)
    println("AverageTime: ${undergroundSystem.getAverageTime("Leyton", "Waterloo")}")

    println("-=-=-=-=-=-=-=-=-UndergroundTwo-=-=-=-=-=-=-=-=-")

    val undergroundSystemTwo = UndergroundSystem()
    undergroundSystemTwo.checkIn(10,"Leyton",3)
    undergroundSystemTwo.checkOut(10,"Paradise",8)
    println("AverageTime: ${undergroundSystemTwo.getAverageTime("Leyton", "Paradise")}")

    undergroundSystemTwo.checkIn(5,"Leyton",10)
    undergroundSystemTwo.checkOut(5,"Paradise",16)
    println("AverageTime: ${undergroundSystemTwo.getAverageTime("Leyton", "Paradise")}")

    undergroundSystemTwo.checkIn(2,"Leyton",21)
    undergroundSystemTwo.checkOut(2,"Paradise",30)
    println("AverageTime: ${undergroundSystemTwo.getAverageTime("Leyton", "Paradise")}")
}