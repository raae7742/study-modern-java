package ch5.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Main5_6 {

    static List<Transaction> transactions;

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milano");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    private static List<Integer> getAllTransactionAt2011() {
        return transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .map(t -> t.getValue())
                .sorted()
                .collect(toList());
    }

    private static List<String> findAllCities() {
        return transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(toList());
    }

    private static List<Trader> findAllTraderAtCambridge() {
        return transactions.stream()
                .map(t -> t.getTrader())
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
    }

    private static List<String> findAllNames() {
        return transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .collect(toList());
    }

    private static boolean existedTraderAtMilano() {
        return transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milano"));
    }

    private static void getValueAtCambridge() {
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    private static Optional<Integer> findMasValue() {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Math::max);
    }

    private static Optional<Integer> findMinValue() {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Math::min);
    }
}
