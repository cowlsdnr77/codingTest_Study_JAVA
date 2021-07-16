package Java_Grammar.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Sparta_Main01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("서울");
        list.add("부산");
        list.add("대구");
        list.add("서울");
        System.out.println("list = " + list);

        List<String> result = list.stream()
                .limit(2) // 앞에 2개만 가져올건데
                .collect(Collectors.toList()); // 리스트로 만들어서 가져온다.
        System.out.println("result = " + result);

        System.out.println("list -> transformation -> set");
        Set<String> set = list.stream() // list에서 하나씩 꺼내고
                .filter("서울"::equals) // "서울"이라는 글자랑 같은 것만 남겨서
//                .filter(it -> "서울".equals(it)) // 위와 같은 구문임
                .collect(Collectors.toSet()); // Set으로 만든다.
        System.out.println("set = " + set);
    }
}
