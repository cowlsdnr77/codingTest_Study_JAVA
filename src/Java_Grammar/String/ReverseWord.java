package Java_Grammar.String;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseWord {
    public ArrayList<String> solution(int N, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String s : str) {
            // String은 불변 객체라 값이 바뀌지 않음
            // StringBuilder는 String과 문자열을 더할 때 새로운 객체를 생성하는 것이 아니라
            // 기존의 데이터에 더하는 방식을 사용함 => 속도도 빠르고 상대적으로 부하가 적다.
            String tmp = new StringBuilder(s).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }
    public static void main(String[] args) {
        ReverseWord R = new ReverseWord();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str = new String[N];
        for (int i = 0 ; i<N ; i++) {
            str[i] = sc.next();
        }
        for (String x : R.solution(N, str)) {
            System.out.println(x);
        }
    }
}
