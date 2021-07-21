package Programmers.BFSandDFS;

/*
    프로그래머스 - 네트워크 (Level 3)
    *PS
    Union Find를 통해서 루트 노드 갯수 파악하면 될듯 -> 이 방법보다 DFS를 사용하는게 더 간단함
 */
public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] network = new boolean[n]; // boolean 기본값 = false

        for (int node = 0; node<n; node++ ) {
            if (!network[node]) { // 네트워크가 아직 연결되지 않았다면 (새로운 네트워크)
                dfs(computers, node, network);
                answer++;
            }
        }
        return answer;
    }

    private boolean[] dfs(int[][] computers, int node, boolean[] visited) {
        visited[node] = true;
        for(int i=0 ; i< computers.length; i++) {
            if (node != i && computers[node][i] == 1 && visited[i] == false) {
                visited = dfs(computers, i, visited); // 재귀를 통한 깊이 탐색 -> 연결된 노드 확인
            }
        }
        return visited;
    }
    public static void main(String[] args) {
        Network N = new Network();
        System.out.println(N.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));

    }
}
