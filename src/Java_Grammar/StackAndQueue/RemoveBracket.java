package Java_Grammar.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

/*
    입력된 문자열에서 소괄호 () 사이에 존재하는
    모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하시오

    - 입력예제: (A(BC)D)EF(G(H)(IJ)K)LM(N)
    - 출력예제: EFLM
 */
public class RemoveBracket {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if (x == ')') {
                while(stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }
//        두 가지 방법으로 answer에 stack의 값 저장 가능
//        for(int i=0 ; i<stack.size() ; i++) answer += stack.get(i);
        for (Character c : stack) answer += c;

        return answer;
    }
    public static void main(String[] args) {
        RemoveBracket R = new RemoveBracket();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(R.solution(str));
    }
}
