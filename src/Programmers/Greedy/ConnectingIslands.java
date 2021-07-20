package Programmers.Greedy;

import java.util.Arrays;

public class ConnectingIslands {
    static int[] parents;

    public int solution(int n, int[][] costs) {
        // 크루스칼 알고리즘을 사용하기 위한 가중치 기준 오름차순 정렬
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2[2]); // 람다식으로 간단하게 정렬

        // Union find를 사용하기 위한 parent 배열 선언
        parents = new int[n];

        for(int i=0; i<n ; i++) {
            parents[i] = i; // 처음에는 자기 자신으로 부모를 초기화
        }

        int total = 0;
        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            int fromParent = findParent(from);
            int toParent = findParent(to);

            // 부모노드가 같으면(두 노드가 같은 그래프에 속하면)
            // 해당 간선을 선택하지 않는다.
            if(fromParent == toParent) continue;

            total += cost;
            parents[toParent] = fromParent; // 간선을 연결해 두 노드가 같은 그래프에 속하게 되어있으므로 부모 노드를 갱신
        }

        return total;
    }

    // 부모 노드가 자기 자신과 같은 노드를 찾을 때까지 재귀호출 (Union Find)
    private int findParent(int node) {
        if(parents[node] == node) return node;
        return parents[node] = findParent(parents[node]);
    }
    public static void main(String[] args) {
        ConnectingIslands C = new ConnectingIslands();
        System.out.println(C.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
}
