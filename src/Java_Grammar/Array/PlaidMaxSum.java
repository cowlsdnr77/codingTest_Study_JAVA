package Java_Grammar.Array;

import java.util.Arrays;
import java.util.Scanner;

/*
격자판 최대합
N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력
*/

public class PlaidMaxSum {
    public int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        // 각 행의 합
        for(int i=0 ; i<n ; i++) {
            // stream을 통해서 행의 요소들을 배열에 쉽게 담을 수 있음
            int sum = Arrays.stream(arr[i]).sum();
            int[] array = Arrays.stream(arr[i]).toArray();
            // 출력할때: Arrays.toString(array)
            System.out.println("array = " + Arrays.toString(array));
//            if (sum > answer) {
//                answer = sum;
//            }
            answer = Math.max(sum,answer);
        }
        // 각 열의 합
        for(int i=0 ; i<n; i++) {
            int sum = 0;
            for(int j=0; j<n ; j++) {
                sum += arr[i][j];
            }
            answer = Math.max(sum,answer);
        }
        // 양 대각선의 합
        int sum = 0;
        for(int i=0 ; i<n ; i++) {
            sum += arr[i][i];
        }
        answer = Math.max(sum,answer);

        sum = 0;
        for (int i = n-1 ; i >= 0; i--) {
            sum += arr[n-1-i][i];
        }
        answer = Math.max(sum,answer);

        return answer;
    }
    public static void main(String[] args) {
        PlaidMaxSum P = new PlaidMaxSum();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n ; i++) {
            for (int j=0 ; j<n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(P.solution(n,arr));
    }
}
