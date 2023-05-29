package yandex.java;

import java.util.List;

import static yandex.java.Note.*;

public class Demo {

    public static void main(String[] args) {
        var atmOne = new ATM(
                List.of(FIFTY,
                        FIVE_THOUSAND,
                        THOUSAND,
                        HUNDRED,
                        FIVE_HUNDRED,
                        FIFTY,
                        FIVE_THOUSAND
                        )
        );
        atmOne.getCash(100000L);
        atmOne.getCash(1050L);

        var atmTwo = new ATM(
                List.of(HUNDRED, HUNDRED,FIFTY, FIFTY, FIFTY, FIFTY, FIVE_HUNDRED, HUNDRED)
        );
        atmTwo.getCash(200L);
        atmTwo.getCash(250L);
        atmTwo.getCash(250L);

        var atmThree = new ATM(
                List.of(HUNDRED, HUNDRED,HUNDRED, HUNDRED, HUNDRED, HUNDRED)
        );
        atmThree.getCash(600L);
    }

}
