package ch5.main;

import ch4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main5_3 {

    private static void map() {
        List<Integer> dishNames = Main5_1.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
    }

    private static void mapWithDistinct() {
        List<String> words = Arrays.asList("Hello", "World");

        List<String[]> list1 = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());

        List<Stream<String>> list2 = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        // flatMap: 각 배열을 스트림의 콘텐츠로 매핑
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
    }
}
