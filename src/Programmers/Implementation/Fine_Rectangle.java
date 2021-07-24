package Programmers.Implementation;
/*
    프로그래머스 - 멀쩡한 사각형
    *PS
    규칙찾기 - 1차 함수 기울기 이용
    기울기를 구해서 0부터 w-1까지를 기울기와 곱한 값을 더한다.
 */
public class Fine_Rectangle {
    public long solution(long w, long h) {
        long answer = 0;

        for(int i=0 ; i<w ; i++) {
            answer += h*i/w;
        }

        return answer * 2;
    }
    public static void main(String[] args) {
        Fine_Rectangle F = new Fine_Rectangle();
        System.out.println(F.solution(8, 12));
    }
}
