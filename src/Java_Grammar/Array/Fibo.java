package Java_Grammar.Array;

import java.util.Scanner;

public class Fibo {
    // 배열로 구현
    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }
        return answer;
    }
    public static void main(String[] args) {
        Fibo F = new Fibo();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int x : F.solution(n)) System.out.print(x + " ");
    }
}
