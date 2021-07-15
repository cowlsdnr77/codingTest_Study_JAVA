package Java_Grammar.Map;

import java.util.HashMap;
import java.util.Scanner;

/*
학급 회장을 뽑는데 후보로 기호 A,B,C,D,E 후보가 등록했다.
투표 용지에는 반 학생들이 자기가 선택한 후보의 기호가 쓰여있다.
반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정한다.

 반 학생 수 N
 N개의 투표용지에 쓰여있는 각 후보의 기호가 문자열로 입력됨
 15
 BACBACCACCBDEDE
 */
public class ClassPrincipal {
    public char solution(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            // getOrDefault: 맵에서 key값으로 value를 찾으면 value를 리턴하고
            // 없으면 defaultValue로 새로운 key값의 value를 만들고 defaultValue를 리턴한다.
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        // 맵의 키 값들(keySet())에 대한 반복문
        for(char key : map.keySet()) {
//            System.out.println("map.get(key) = " + map.get(key));
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        ClassPrincipal C = new ClassPrincipal();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(C.solution(n, str));
    }
}
