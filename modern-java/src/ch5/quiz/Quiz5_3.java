package ch5.quiz;


import ch5.main.Main5_1;

import java.util.Optional;

import static ch5.main.Main5_1.*;

public class Quiz5_3 {
    public static void main(String[] args) {

    }

    private static void answer() {
        Optional<Integer> cnt = menu.stream()
                .map(d -> 1)
                .reduce(Integer::sum);

        long cnt2 = menu.stream().count();
    }
}
