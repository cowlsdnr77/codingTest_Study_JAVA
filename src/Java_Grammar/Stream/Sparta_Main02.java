package Java_Grammar.Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Sparta_Main02 {
    public static void main(String[] args) {
        String[] arr = {"SQL", "Java", "Python"};
        Stream<String> stringStream = Arrays.stream(arr);
        stringStream.forEach(System.out::println);
    }
}
