package ch5.quiz;

import java.util.stream.Stream;

public class Quiz5_4 {
    private void answer() {
        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));
    }
}
