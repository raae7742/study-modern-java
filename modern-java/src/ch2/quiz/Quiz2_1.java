package ch2.quiz;

import ch2.Apple;
import ch2.formatter.AppleFancyFormatter;
import ch2.formatter.AppleFormatter;
import ch2.formatter.AppleSimpleFormatter;

import java.util.ArrayList;
import java.util.List;

import static ch2.Color.*;

/**
 * 다양한 방법으로 문자열을 생성할 수 있도록 파라미터화된 prettyPrintApple 메서드 구현하기
 */
public class Quiz2_1 {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(500, GREEN));
        inventory.add(new Apple(100, RED));

        prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleSimpleFormatter());
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple: inventory) {
            String output = formatter.format(apple);
            System.out.println(output);
        }
    }
}
