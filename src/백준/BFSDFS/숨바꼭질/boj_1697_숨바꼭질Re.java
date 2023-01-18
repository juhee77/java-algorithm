package 백준.BFSDFS.숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1697_숨바꼭질Re {
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int me = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        //bfs
        System.out.println(bfs(me, goal));
    }

    private static int bfs(int me, int goal) {
        boolean[] visited = new boolean[100001];
        visited[me] = true;
        queue.add(me);
        int time = 0;

        while (!queue.isEmpty()) {
            time++;
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Integer now = queue.poll();

                if (extracted(visited, now, 1) == goal || extracted(visited, now, -1) == goal
                        || extracted(visited, now, now) == goal) {
                    return time;
                }
            }
        }

        return -1;
    }

    private static int extracted(boolean[] visited, int temp, int dir) {
        int moved = temp + dir;
        if (0 <= moved && moved <= 100000 && !visited[moved]) {
            queue.add(moved);
            visited[moved] = true;
        }
        return moved;
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