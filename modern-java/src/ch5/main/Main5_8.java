package ch5.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main5_8 {

    private void useStreamOf() {
        Stream<String> stream = Stream.of("Modern", "Java", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();
    }

    /**
     * getProperty: 제공된 키에 대응하는 값이 없으면 null 반환
     */
    private void useStreamOfNullable() {
        Stream<String> values = Stream.of("config", "home", "user")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));
    }

    private void useArraysStream() {
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
    }

    private void useFileStream() {
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) { }
    }

    private void useIterate() {
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    private void useGenerate() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
