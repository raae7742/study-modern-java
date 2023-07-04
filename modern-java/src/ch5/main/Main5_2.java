package ch5.main;

import ch4.Dish;

import java.util.Arrays;
import java.util.List;

import static ch4.Dish.Type.*;
import static java.util.stream.Collectors.*;

public class Main5_2 {
    private static List<Dish> specialMenu;

    public static void main(String[] args) {
        specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, OTHER),
                new Dish("prawns", false, 300, FISH),
                new Dish("rice", true, 350, OTHER),
                new Dish("chicken", false, 400, MEAT),
                new Dish("french fries", true, 530, OTHER));
    }

    // 일전의 filter 사용 예시
    private static void filter() {
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(toList());
    }

    // 이미 칼로리 순으로 정렬되어 있으므로 320보다 크거나 같은 요리가 나오면 반복을 중단
    private static void sliceWithTakeWhile() {
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
    }

    // 320보다 칼로리가 큰 요소 탐색
    private static void sliceWithDropWhile() {
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
    }

    private static void limit() {
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList());
    }

    // 처음 n개 요소를 제외한 스트림 반환
    private static void skip() {
        List<Dish> dishes = specialMenu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
    }
}
