package Programmers.Binary_Search;

import java.util.Arrays;
/*
    프로그래머스 - 입국심사
    *PS
    전형적인 이분탐색 문제이지만 어떤걸 기준으로 탐색을 해야할지가 중요
    -> 시간을 기준으로 탐색
 */

public class ImmigrationCheck {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 0, end = (long) times[times.length - 1] * n; // 시간의 최대값은 가장 오래걸리는 심사대에서 모든 인원을 검사하는 경우
        long mid ;
        long sum = 0;
        while (start <= end) {
            mid = (start+end)/2;
            for(int i=0 ; i<times.length ; i++) {
                sum += mid/times[i]; // 각 심사대가 해당 시간동안 심사 가능한 인원
            }
            if (sum < n) { //심사 가능한 인원이 n보다 작은경우 -> 시간이 더 필요하다
                start = mid+1;
            } else { //심사 가능한 인원이 n보다 크거나 같은 경우 -> 시간을 줄여도 된다.
                end = mid-1;
                answer = mid;
            }
            sum = 0;
        }
        return answer;
    }
    public static void main(String[] args) {
        ImmigrationCheck I = new ImmigrationCheck();
        System.out.println(I.solution(6, new int[]{7, 10}));
    }
}
