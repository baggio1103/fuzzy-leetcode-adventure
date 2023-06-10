package yandexContest.java;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.close();
        writer.close();
        var quarter = quarter(LocalDate.now());
        System.out.println(quarter.order);
        System.out.println(quarter(LocalDate.now()));
    }

    static Quarter quarter(LocalDate date) {
        return switch (date.getMonth()) {
            case JANUARY, FEBRUARY, MARCH ->
                    new Quarter(
                    1,
                    LocalDateTime.of(LocalDate.of(date.getYear(), Month.JANUARY, 1), LocalTime.MIN),
                    LocalDateTime.of(LocalDate.of(date.getYear(), Month.MARCH, Month.MARCH.maxLength()), LocalTime.MAX)

            );
            case APRIL, MAY, JUNE -> new Quarter(
                    2,
                    LocalDateTime.of(LocalDate.of(date.getYear(), Month.APRIL, 1), LocalTime.MIN),
                    LocalDateTime.of(LocalDate.of(date.getYear(), Month.JUNE, Month.JUNE.maxLength()), LocalTime.MAX)
            );
            case JULY, AUGUST, SEPTEMBER -> new Quarter(
                    3,
                    LocalDateTime.of(LocalDate.of(date.getYear(), Month.JULY, 1), LocalTime.MIN),
                    LocalDateTime.of(LocalDate.of(date.getYear(), Month.SEPTEMBER, Month.SEPTEMBER.maxLength()), LocalTime.MAX)

            );
            case OCTOBER, NOVEMBER, DECEMBER -> new Quarter(
                    4,
                    LocalDateTime.of(LocalDate.of(date.getYear(), Month.OCTOBER, 1), LocalTime.MIN),
                    LocalDateTime.of(LocalDate.of(date.getYear(), Month.DECEMBER, Month.DECEMBER.maxLength()), LocalTime.MAX)
            );
        };
    }

}

class Quarter {

    Integer order;

    LocalDateTime start;

    LocalDateTime end;

    public Quarter(Integer order, LocalDateTime start, LocalDateTime end) {
        this.order = order;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "super.toString()";
    }
}