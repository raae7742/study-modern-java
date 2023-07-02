package content;

import quiz.Apple;

import java.util.ArrayList;import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.*;
import static quiz.Color.GREEN;
import static quiz.Color.RED;

public class Main3_8 {
    static List<Apple> inventory = new ArrayList<>();

    public static void main(String[] args) {
        inventory.add(new Apple(500, GREEN));
        inventory.add(new Apple(100, RED));
    }

    private static void sortReversed() {
        inventory.sort(comparing(Apple::getWeight).reversed());
    }

    private static void sortByConnectingTwoComparators() {
        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));
    }

    private static boolean isNotRedApple(Apple a) {
        Predicate<Apple> redApple = apple -> apple.getColor().equals("RED");
        Predicate<Apple> notRedApple = redApple.negate();

        return notRedApple.test(a);
    }

    private static boolean isRedOrGreenAndHeavyApple(Apple a) {
        Predicate<Apple> redApple = apple -> !apple.getColor().equals("RED");
        Predicate<Apple> redAndHeavyAppleOrGreen =
                redApple.and(apple -> apple.getWeight() > 150)
                .or(apple -> GREEN.equals(apple.getColor()));

        return redAndHeavyAppleOrGreen.test(a);
    }

    private static int useFunctions() {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        // g(f(x))
        Function<Integer, Integer> h = f.andThen(g);
        // f(g(x))
        h = f.compose(g);

        return h.apply(1);
    }
}
