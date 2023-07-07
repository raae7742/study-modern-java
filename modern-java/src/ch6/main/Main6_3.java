package ch6.main;

import ch4.Dish;

import java.util.*;

import static ch5.main.Main5_1.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Main6_3 {
    public static void main(String[] args) {

    }

    private void useGroupingBy() {
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
    }

    private void filterMoreThan500Calories() {
        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                        filtering(dish -> dish.getCalories() > 500, toList())));
    }

    private void multiGroupingBy() {
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
                groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700)
                                return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        }))
        );
    }

    private void useGroupingByWithCounting() {
        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting()));
    }

    private void useGroupingByWithMaxBy() {
        Map<Dish.Type, Optional<Dish>> mostCaloricByType1 = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));

        Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream()
                .collect(groupingBy(Dish::getType, collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
                        Optional::get)));
    }

    private void getTotalCaloriesByType() {
        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
    }

    private void getCaloricLevelsByType() {
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelByType = menu.stream().collect(
                        groupingBy(Dish::getType, mapping(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT; },
                        toSet())));

        caloricLevelByType = menu.stream().collect(
                groupingBy(Dish::getType, mapping(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT; },
                        toCollection(HashSet::new))));
    }

    enum CaloricLevel {
        FAT, DIET, NORMAL;
    }
}

