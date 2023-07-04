package ch5.main;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * (자바 스트림의) 리듀싱 연산 = (함수형 프로그래밍의) 폴드
 */
public class Main5_5 {
    static List<Integer> numbers;

    public static void main(String[] args) {
        numbers = Arrays.asList(1,2, 3, 4, 5);
    }

    private static void findSum() {
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        sum = numbers.stream().reduce(0, Integer::sum);
        Optional<Integer> sumNullable = numbers.stream().reduce((a, b) -> (a + b));
    }

    private static void findMaxAndMin() {
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
    }
}
