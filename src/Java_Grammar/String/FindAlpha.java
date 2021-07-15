package Java_Grammar.String;

import java.util.Scanner;

public class FindAlpha {
    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for (char x : str.toCharArray()) { // 반복 대상은 Array 또는 Collection 만 가능
            if (x == t) {
                answer ++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        FindAlpha S = new FindAlpha();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(S.solution(str, c));
    }
}
