package inflearn.recursive_tree_graph;

import java.util.Scanner;

public class K_경로탐색 {
    static int vertex, edges, answer = 0;
    static int[] visited;
    static int[][] graph;

    public void DFS(int v) {
        if (v == vertex) answer++; //경로하나 만들었다.
        else {
            for (int i = 1; i <= vertex; i++) {
                if (graph[v][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    DFS(i);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        //모든 경로를 탐색하였을때 1->goal 로 가는 가지수를 출력하라 (그래프는 한번 방문한 정점에 재 방문하지 않는다)
        K_경로탐색 T = new K_경로탐색();
        Scanner kb = new Scanner(System.in);
        vertex = kb.nextInt(); //정점
        edges = kb.nextInt(); //간선의 수
        graph = new int[vertex + 1][vertex + 1];
        visited = new int[vertex + 1];
        for (int i = 0; i < edges; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }
        visited[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}

//59 12 13 14 21 23 25 34 42 45