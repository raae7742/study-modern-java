package ch2.formatter;
import ch2.Apple;

public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String format(Apple apple) {
        String isHeavy = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + isHeavy + " " + apple.getColor() + " apple";
    }
}
