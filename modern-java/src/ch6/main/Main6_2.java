package ch6.main;


import ch4.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import static ch5.main.Main5_1.*;
import static java.util.stream.Collectors.*;

public class Main6_2 {

    public static void main(String[] args) {

    }

    private void useCounting() {
        long howManyDishes = menu.stream().collect(counting());

        howManyDishes = menu.stream().count();
    }

    private void getMinAndMaxCalories() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));

        // 범용 리듀싱 요약 연산
        mostCalorieDish = menu.stream().collect(reducing(
                (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
    }

    private void getSumOfCalories() {
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        // 범용 리듀싱 요약 연산
        totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));

        // sum 메서드 참조
        totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
    }

    private void getAvgOfCalories() {
        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
    }

    private void getAllOfCalories() {
        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    private void connectAllMenuName() {
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));

        // toString 메서드 지원 시 아래로 생략 가능
        //shortMenu = menu.stream().collect(joining(", "));
    }


}
