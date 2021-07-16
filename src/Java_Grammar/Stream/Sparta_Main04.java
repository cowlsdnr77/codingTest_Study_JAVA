package Java_Grammar.Stream;

import java.util.Arrays;
import java.util.List;

public class Sparta_Main04 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Stream의 데이터를 변환하지 않고, 더하거나 빼는 등의 연산을 수행하여 하나의 값으로 만든다면 reduce를 사용
        System.out.println(list.stream().reduce(0, Integer::sum)); // 0이라는 초기값에 list 을 차례로 더한다.

        List<String> names = Arrays.asList("김정우", "김호정", "이하늘", "이정희", "박정우", "박지현", "정우석", "이지수");
        System.out.println(names.stream().filter(name -> name.startsWith("이")).count());
    }
}
