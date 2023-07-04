package ch5.quiz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Quiz5_2 {

    private static List<Integer> answer1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        return numbers.stream()
                .map(num -> num * num)
                .collect(toList());
    }

    private static List<int[]> answer2() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5);

        return list1.stream()
                .flatMap(i -> list2.stream()
                        .map(j -> new int[]{i, j})
                )
                .collect(toList());
    }

    private static List<int[]> answer3() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5);

        return list1.stream()
                .flatMap(i -> list2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .collect(toList());
    }
}
