package ch5.main;

import ch4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static ch5.main.Main5_1.*;

/**
 * anyMatch(), allMatch(), noneMatch()는 모두 쇼트서킷을 사용한다.
 */
public class Main5_4 {
    public static void main(String[] args) {

    }

    // anyMatch(): 스트림에서 적어도 한 요소와 일치하는지 확인
    private static void anyMatch() {
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
    }

    // allMatch(): 스트림의 모든 요소가 일치하는지 검사
    private static void allMatch() {
        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
    }

    // noneMatch(): allMatch()와 반대 연산 수행
    private static void nonMatch() {
        boolean isHealthy = menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
    }

    // findAny(): 현재 스트림에서 임의 요소 반환
    private static void findAny() {
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));
    }

    // findFirst(): 첫 번째 요소 찾기
    private static void findFirst() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();
    }
}
