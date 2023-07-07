package ch6;

import ch4.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ch5.main.Main5_1.*;

public class Main6_5 {
    private void useToListCollector() {
        List<Dish> dishes = menu.stream().collect(new ToListCollector<>());
        dishes = menu.stream().collect(Collectors.toList());
        dishes = menu.stream().collect(
                ArrayList::new,
                List::add,
                List::addAll);
    }
}
