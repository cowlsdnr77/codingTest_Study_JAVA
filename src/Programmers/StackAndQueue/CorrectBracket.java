package Programmers.StackAndQueue;

import java.util.Stack;

public class CorrectBracket {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        CorrectBracket C = new CorrectBracket();
        System.out.println(C.solution(")()("));
    }
}
