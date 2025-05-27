package 백준.graph;

//TODO : 재도전 필요
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//공통 조상 찾기 LCA
public class Boj_1761_정점들의거리 {
    private static int[] depth;
    private static int[] dist;
    private static List<int[]>[] childGraph;
    private static int[] parents;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        parents = new int[n + 1];
        depth = new int[n + 1];
        dist = new int[n + 1];
        childGraph = new List[n + 1];
        int[] parentGraph = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            parents[i] = i;
            childGraph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            childGraph[parent].add(new int[]{child, cost});
            childGraph[child].add(new int[]{parent, cost}); // 양방향 그래프 처리
            parentGraph[child]++;
            parentGraph[parent]++;
        }

        // 루트 노드 탐색 (parentGraph가 1인 노드 중 아무거나 루트로 설정)
        for (int i = 1; i <= n; i++) {
            if (parentGraph[i] == 1) {
                visited[i] = true;
                eachDepth(i, 0, 0); // 깊이와 거리 계산 시작
                break;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int lca = findLCA(a, b);
            int distance = dist[a] + dist[b] - 2 * dist[lca];
            sb.append(distance).append("\n");
        }

        System.out.println(sb);
    }

    // 공통 조상(LCA)을 찾는 메서드
    private static int findLCA(int a, int b) {
        int depthA = depth[a];
        int depthB = depth[b];

        // b가 더 깊도록 정렬
        if (depthA > depthB) {
            int temp = a;
            a = b;
            b = temp;
            temp = depthA;
            depthA = depthB;
            depthB = temp;
        }

        // b를 a와 같은 깊이로 맞추기
        while (depthA < depthB) {
            b = parents[b];
            depthB = depth[b];
        }

        // 공통 조상까지 올라감
        while (a != b) {
            a = parents[a];
            b = parents[b];
        }
        return a;
    }

    // 깊이 및 거리 설정 DFS
    private static void eachDepth(int now, int nowDepth, int nowDist) {
        depth[now] = nowDepth;
        dist[now] = nowDist;

        for (int[] next : childGraph[now]) {
            int nextNode = next[0];
            int cost = next[1];

            if (visited[nextNode]) continue;
            visited[nextNode] = true;
            parents[nextNode] = now;
            eachDepth(nextNode, nowDepth + 1, nowDist + cost);
        }
    }
}
