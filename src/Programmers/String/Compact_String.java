package Programmers.String;

import java.util.ArrayList;
import java.util.List;

/*
    프로그래머스 - 문자열 압축 (2020 카카오)
    *PS
    1부터 s/2까지로 단위 자르기 가능? => s/2+1까지 해줘야됨 (s 길이가 1인 경우 때문)
    반복문 돌면서 min으로 answer 계속 업데이트 해줌
 */
public class Compact_String {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        List<String> parsed_str = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i  <= s.length()/2 + 1; i++) { // s의 길이가 1인 경우까지 고려하기위해 s.length()/2+1 까지 탐색
            int start = 0;
            int end = s.length();
            int count = 1;
            while (end > start) {
                // i개 씩 문자열 파싱
                if (start + i > end) { // 마지막 파싱 부분
                    parsed_str.add(s.substring(start));
                } else {
                    parsed_str.add(s.substring(start, start + i));
                }
                start += i; // i 개씩 더해주면서 파싱 범위를 조정
            }
            // i개씩 파싱한 문자열 압축 모양 만들기
            for (int j=0 ; j< parsed_str.size()-1;j++) {
                if (parsed_str.get(j).equals(parsed_str.get(j+1))) {
                    count ++;
                } else {
                    if(count > 1) {
                        sb.append(count);
                    }
                    sb.append(parsed_str.get(j));
                    count = 1;
                }
            }
            // 마지막에 파싱된 문자열 붙이기
            if(count > 1) {
                sb.append(count);
            }
            sb.append(parsed_str.get(parsed_str.size()-1));
            System.out.println("parsed_str = " + parsed_str);
            System.out.println("sb = " + sb);
            answer = Math.min(answer, sb.length());
            sb.setLength(0);
            parsed_str.clear();
        }
        return answer;
    }
    public static void main(String[] args) {
        Compact_String C = new Compact_String();
        System.out.println(C.solution("abcabcdede"));
    }
}
