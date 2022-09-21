package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1167_트리의지름2 {
    private static boolean visited[];
    private static ArrayList<ArrayList<Integer[]>> arr;
    private static int answer = 0;
    private static int id = 0;

    public static void dfs(int x, int cnt) {
        if (answer < cnt) {
            answer = cnt;
            id = x;
        }

        ArrayList<Integer[]> temp = arr.get(x);
        for (int k = 0; k < temp.size(); k++) {
            int e = temp.get(k)[0];
            int w = temp.get(k)[1];
            if (!visited[e]) { //p가 전에 방문 했던
                visited[e] = true;
                int tempcnt = cnt + w;
                dfs(e, tempcnt);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i < line; i++) {
            arr.add(new ArrayList<Integer[]>());
        }

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            while (true) {
                int temp = Integer.parseInt(st.nextToken()) -1 ;
                if (temp == -2) break;
                int w = Integer.parseInt(st.nextToken());
                arr.get(parent).add(new Integer[]{temp, w});
            }
        }
// --> 이 방법으로 하면 시간 초과남
//        for (int i = 0; i < line; i++) {
//            visited = new boolean[line];
//            visited[i] = true;
//            dfs(i, 0);
//
//        }

        visited = new boolean[line];
        visited[0] = true;
        dfs(0, 0);

        visited = new boolean[line];
        visited[id] = true;
        dfs(id, 0);

        System.out.println(answer);

    }
}
/*
4
1 2 5 3 9 -1
2 1 5 -1
3 1 9 4 8 -1
4 3 8 -1

답 : 22

6
1 2 3 -1
2 1 3 5 3 3 5 -1
3 2 5 4 7 -1
4 3 7 -1
5 2 3 6 5 -1
6 5 5 -1

답 : 20

4
1 2 7 3 2 -1
2 1 7 -1
3 1 2 4 3 -1
4 3 3 -1

답 : 12

5
1 2 7 3 2 5 10 -1
2 1 7 -1
3 1 2 4 3 -1
4 3 3 -1
5 1 10 -1

답 : 17

<https://www.acmicpc.net/board/view/83695>
--> 트리의 노드를 구슬로, 간선들을 구슬끼리 잇는 실로, 간선의 가중치를 그 실의 길이라고 생각하고 이 실로 연결된 구슬들 사이의 최장거리(트리의 지름)를 구해봅시다.
구슬 중에서 아무 구슬(노드1)이나 골라 위로 들어올리면 실이 축 늘어지며 가장 길게 떨어진 구슬(노드2)이 나올 것입니다(처음 선택한 노드1에서 가장 먼 노드2).
이 구슬(노드2)을 잡은 후, 이 구슬(노드2)에서 실로 가장 길게 연결된 구슬(노드3)을 잡고 양쪽으로 잡아당기면 실로 연결된 구슬들의 최장거리가 나올 것입니다.
 */