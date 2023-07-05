package ch5.main;

import ch4.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ch5.main.Main5_1.*;

public class Main5_7 {
    private void mapToInt() {
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }

    private void restoreToObjectStream() {
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
    }

    private void useOptionalInt() {
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        int max = maxCalories.orElse(1);
    }

    private void useRange() {
        IntStream evenNumbers = IntStream.range(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());
    }
}
