package Programmers.Bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    프로그래머스 - 모의고사 (level 1 - 완전탐색)
 */
public class Mock_Exam {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] s1 = new int[]{1, 2, 3, 4, 5}; // 5
        int[] s2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] s3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;

        for(int i=0 ; i < answers.length ; i++) {
            if (s1[i%5] == answers[i]) cnt1 ++;
            if (s2[i%8] == answers[i]) cnt2 ++;
            if (s3[i%10] == answers[i]) cnt3 ++;
        }

        int max = Math.max(Math.max(cnt1,cnt2),cnt3);
        if (max == cnt1) answer.add(1);
        if (max == cnt2) answer.add(2);
        if (max == cnt3) answer.add(3);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Mock_Exam M = new Mock_Exam();
        System.out.println(Arrays.toString(M.solution(new int[]{1,3,2,4,2})));
    }
}
