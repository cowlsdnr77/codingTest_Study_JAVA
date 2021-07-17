package Programmers.Greedy;

import java.util.Arrays;
/*
    프로그래머스 등굣길
    *PS
    학교 다닐때 풀던 수학문제랑 비슷하게 접근 -> 출발지점부터 가장자리마다 1을 주고 나머지 좌표는 왼쪽과 위쪽 더한 값이 최단거리
    단, 효율성 때문에 매 최단거리를 구할 때 마다 %1000000007 연산을 해줘야됨
 */
public class RoadToSchool {
    public int solution(int m, int n, int[][] puddles) {
        int answer;
        int[][] cord = new int[n][m];
        for(int i = 0; i < puddles.length ; i++) {
            cord[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        for(int i=1 ; i<m ; i++) {
            if(cord[0][i-1] == -1) {
                cord[0][i] = -1;
            } else if (cord[0][i] != -1) {
                cord[0][i] += 1;
            }
        }
        for(int i=1 ; i<n ; i++) {
            if (cord[i-1][0] == -1) {
                cord[i][0] = -1;
            } else if(cord[i][0] != -1) {
                cord[i][0] += 1;
            }
        }

        for(int i=1 ; i<n ; i++) {
            for(int j=1 ; j<m; j++) {
                if (cord[i][j] == -1) continue;
                if(cord[i-1][j] == -1 && cord[i][j-1] == -1) {
                    cord[i][j] = -1;
                } else if (cord[i-1][j] == -1 && cord[i][j-1] != -1) {
                    cord[i][j] += cord[i][j-1];
                } else if (cord[i-1][j] != -1 && cord[i][j-1] == -1) {
                    cord[i][j] += cord[i-1][j];
                } else {
                    cord[i][j] += cord[i-1][j] + cord[i][j-1];
                }
                cord[i][j] %= 1000000007; // 최단거리 개수가 int의 범위를 넘어갈 수 있으므로 각 좌표의 최단거리마다 나머지 연산을 수행해야함
                // 나머지 연산하지 않으면 효율성 테스트케이스 통과 못함
            }
        }
        System.out.println("cord = " + Arrays.deepToString(cord));
        answer = cord[n-1][m-1] != -1 ? cord[n-1][m-1] : 0;
        return answer;
    }
    public static void main(String[] args) {
        RoadToSchool R = new RoadToSchool();
        System.out.println(R.solution(4, 3, new int[][]{{2, 2},{3,2}}));
    }
}
