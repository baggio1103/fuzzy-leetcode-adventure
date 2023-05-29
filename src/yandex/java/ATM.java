package yandex.java;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 *
 * <p>
 *
 * ATM.
 * ATM is being initialized with a set of notes and is able to issue notes of a given value or reject
 * While issuing the notes, the notes are subtracted from the balance of the ATM
 * Permissible note denominations: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 */
public class ATM {

      private final Map<Note, Long> noteMap;

      private Long overallCash;

      public ATM(List<Note> notes) {
            this.noteMap = new TreeMap<>(
                    Comparator.comparingLong(Note::value).reversed()
            );
            noteMap.putAll(
                    notes.stream().collect(Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()
                    ))
            );
            overallCash = notes.stream().reduce(0L, (a, b) -> a + b.value(), Long::sum);
            System.out.printf("""
                    ATM initialized -> overallSum: %d, currencies: %s
                    """, overallCash, noteMap);
      }

      public Long getCash(Long value) {
            var cash = 0L;
            if (overallCash < value) {
                  System.out.printf("""
                                  ATM has no required amount - overallCash: %d, required:%d
                                  """,
                          overallCash, value);
                  return 0L;
            }
            var withdrawnNotesMap = new HashMap<Note, Long>();
            for (Map.Entry<Note, Long> entry : noteMap.entrySet()) {
                  var note = entry.getKey();
                  var count = entry.getValue();
                  if (note.value() <= value) {
                        while (count != 0) {
                              if (note.value() > value - cash) {
                                    break;
                              }
                              cash += note.value();
                              count--;
                              noteMap.put(note, count);
                              withdrawnNotesMap.put(note, entry.getValue());
                              if (cash == value) {
                                    overallCash -= cash;
                                    System.out.printf("""
                                            Cash being withdrawn: %d
                                            Overall cash left: %d, notes left: %s                                   \s
                                            """, cash, overallCash, noteMap);
                                    return cash;
                              }
                        }
                  }
            }
            noteMap.putAll(withdrawnNotesMap);
            System.out.printf("""
                    ATM cannot issue the required amount: %d
                    Overall cash left: %d, notes left: %s
                    """, value, overallCash, noteMap);
            return 0L;
      }

}


