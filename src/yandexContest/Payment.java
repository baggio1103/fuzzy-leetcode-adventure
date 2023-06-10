package yandexContest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Payment {

    public static void main(String[] args) {
        var pattern = DateTimeFormatter.ofPattern("yyyy.dd.MM");
        var diff = ChronoUnit.DAYS.between(LocalDate.parse("2022.10.02", pattern), LocalDate.parse("2022.11.05", pattern).plusDays(1));
        System.out.println(diff);
        System.out.println("Amount: " + 10.0 / diff);
        var temp = ChronoUnit.DAYS.between(LocalDate.parse("2022.10.02", pattern), LocalDate.parse("2022.01.04", pattern));
        System.out.println(temp);
        System.out.println(temp * 10.0 / diff);
        var value = BigDecimal.valueOf(10.0 / diff);
        System.out.println(value.setScale(2, RoundingMode.DOWN));
    }

}
