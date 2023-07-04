package ch5.quiz;

import ch4.Dish;
import ch5.main.Main5_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz5_1 {

    private static void answer() {
        List<Dish> dishes = Main5_1.menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
    }
}
