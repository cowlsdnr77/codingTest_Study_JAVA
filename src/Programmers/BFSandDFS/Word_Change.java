package Programmers.BFSandDFS;

import java.util.LinkedList;
import java.util.Queue;

/*
    프로그래머스 단어변환
    *PS
    BFS로 푸는게 문제 취지에 더 맞는듯
    1. words 안에 target이 없다면 return 0
    2. begin 부터 큐 ("hit" => 현재 단어, 0 => 횟수)에 넣는다.
    3. 큐에서 pop(0) 한 뒤 words 중 pop한 단어로부터 한 글자만 바뀐 word를 큐 (word, 횟수 +1)에 넣는다.
    3-1. 이미 pop 했던 단어는 큐에 넣지 않는다. -> pop 한 단어를 넣어 놓는 리스트 만든다. (X)
    3-1. visited 배열을 통해 false인 (아직 비교한적 없는 단어)를 파악 (O)
    4. 3번 연산을 수행하면서 target이 pop 되면 종료
 */
public class Word_Change {
    public class Node { // 클래스를 만들어서 마치 튜플처럼 사용 가능
        String word;
        int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    public boolean check(String s1, String s2) { // 두 문자열 비교해서 단어가 하나만 다른지 체크
        int count = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count == 1;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));
        boolean[] visited = new boolean[words.length];

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.word.equals(target)) return node.count;
            for(int i=0; i < words.length; i++) {
                if (!visited[i] && check(node.word, words[i])) {
                    visited[i] = true;
                    q.offer(new Node(words[i], node.count + 1));
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Word_Change W = new Word_Change();
        System.out.println(W.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}
