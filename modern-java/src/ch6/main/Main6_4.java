package ch6.main;

import ch4.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import static ch5.main.Main5_1.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Main6_4 {
    private void usePartition() {
        Map<Boolean, List<Dish>> partitionMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
    }

    private void getVegetarianDishesByType() {
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
                .collect(
                        partitioningBy(Dish::isVegetarian,
                                groupingBy(Dish::getType)));
    }

    private void getMostCaloricPartitionedByVegetarian() {
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream().collect(
                partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double)candidate);
        return IntStream.range(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }
}
