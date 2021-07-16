package Programmers.Greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    프로그래머스 = 체육복

    *PS*
    먼저 lost 중에 reserve 값 중 같은 게 있는지 확인 - set으로 바꾸서 교집합 찾기
    있으면, lost와 reserve에서 해당 값 삭제
    lost를 오름차순으로 sort하고
    lost에 대해서 양 옆 번호가 reserve에 있다면 왼쪽 번호 먼저 빌리고 없다면 오른쪽 빌린다.
 */
public class Training_Uniform {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n+1];
        for (int i=1 ; i< students.length ; i++) {
            students[i] = 1;
        }
        for (int l : lost) {
            students[l] --;
        }
        for (int r : reserve) {
            students[r] ++;
        }
        for (int i=1 ; i< students.length ; i++) {
            if (students[i] == 0) {
                if (i-1 >= 1 && students[i-1] > 1) {
                    students[i] ++;
                    students[i-1] --;
                } else if (i + 1 < students.length && students[i + 1] > 1) {
                    students[i] ++;
                    students[i+1] --;
                }
            }
        }
        for (int i =1; i<students.length ; i++) {
            if(students[i] >= 1) {
                answer ++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Training_Uniform T = new Training_Uniform();
        System.out.println(T.solution(3, new int[]{3}, new int[]{1}));
    }
}
