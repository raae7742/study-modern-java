package quiz.formatter;

import quiz.Apple;

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String format(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
