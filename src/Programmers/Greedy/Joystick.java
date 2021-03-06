package Programmers.Greedy;

import java.util.ArrayList;

/*
    프로그래머스 - 조이스틱

 */
public class Joystick {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();

        // 제일 짧은 좌, 우 이동은 그냥 맨 오른쪽으로 이동할 때
        int min = len - 1;

        for (int i = 0; i < len; i++) {
            // 조이스틱 상, 하 이동
            char c = name.charAt(i);
            int mov = Math.min(c - 'A', 'Z' - c + 1);
            answer += mov;

            // 조이스틱 좌, 우 이동
            int nextIndex = i + 1;
            // 다음 단어가 A이고, 단어가 끝나기 전까지 nextIndex 증가
            while (nextIndex < len && name.charAt(nextIndex) == 'A')
                nextIndex++;

            min = Math.min(min, (i * 2) + len - nextIndex);
            // len - next :
            // 총 길이에서 현재 바로 다음에 연속된 A가 지나고 남은 문자 갯수
            // i : 오른쪽으로의 현재까지의 이동횟수
            // i + len - next + i : 현재까지 왔다가 다시 돌아가서 남은 거 까지 가는 이동 횟수
            // min(i,len-next)에서,
            // i 보다 len-next 값이 작은 경우에 len-next를 선택하는데
            // 이는, 마지막 문자가 A인 경우를 제외 하면
            // 무조건 len-1 보다 크게 된다 (len-next >=1)
            // 따라서,i가 len-next(남은 문자)보다 큰 경우는
            // 굳이 왼쪽으로 다시 돌아갈 필요가 없다.
            // 대신 끝이 A인 경우는, len-next가 0이 되므로,
            // 무조건 len-1 보다 작은 i 가 최소 이동횟수가 된다.
            // 따라서 Math.min(i,len-next) 이 부분은 식에서 필요하게 된다.
        }

        answer += min;

        return answer;

    }
    public static void main(String[] args) {
        Joystick C = new Joystick();
        String name = "JEROEN";
        System.out.println(C.solution(name));
    }
}
