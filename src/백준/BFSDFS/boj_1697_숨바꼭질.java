package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1697_숨바꼭질 {
    private static Queue<Integer> queue = new LinkedList<>();

    private static void check(int i, int visited[], int cnt) {
        if (i < 0 || 100000 < i || visited[i] != 0) return;
        visited[i] = cnt + 1;
        queue.add(i);

    }

    private static int bfs(int me, int goal) {
        queue.add(me);
        int visited[] = new int[100001];
        visited[me] = 1;
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            int cnt = visited[temp];

            if (temp == goal)
                break;

            check(temp - 1, visited, cnt);
            check(temp + 1, visited, cnt);
            check(temp * 2, visited, cnt);

        }

        return visited[goal] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

//        for (int i = 0; i < 22; i++) {

        st = new StringTokenizer(br.readLine());
        int me = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        //bfs
        int cnt = bfs(me, goal);
        System.out.println(cnt);
//            queue.clear();
//        }
    }
}


/*
100 0
6 16
8 20
15964 89498
3 43
4 27
5 35
6 43
7 43
100 1
10 19
5 19
1 20
100000 100000
0 100000
100000 0
0 1
3482 45592
2 4
9 5
5 5
5 17

100 0 # 100
6 16 # 3
8 20 # 3
15964 89498 # 4781
3 43 # 6
4 27 # 5
5 35 # 5
6 43 # 5
7 43 # 6
100 1 # 99
10 19 # 2
5 19 # 3
1 20 # 5
100000 100000 # 0
0 100000 # 22
100000 0 # 100000
0 1 # 1
3482 45592 # 637
2 4 # 1
9 5 # 4
5 5 # 0
5 17 # 4
 */