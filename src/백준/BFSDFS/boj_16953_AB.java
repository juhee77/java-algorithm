package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point_num {
    long num;
    long time;

    public point_num(long num, long time) {
        this.num = num;
        this.time = time;
    }
}

public class boj_16953_AB {


    private static Queue<point_num> queue = new LinkedList<>();

    private static long bfs(long start, long goal) {
        queue.add(new point_num(start, 0));
        while (!queue.isEmpty()) {
            point_num temp = queue.poll();
            long num = temp.num;
            long time = temp.time;

            if (num == goal) return time + 1;

            //+1
            if (num * 10 + 1 <= goal) {
                queue.add(new point_num(num * 10 + 1, time + 1));
            }
            //*2
            if (num * 2 <= goal) {
                queue.add(new point_num(num * 2, time + 1));
            }


        }
        return -1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Integer.parseInt(st.nextToken());
        long goal = Integer.parseInt(st.nextToken());

        //bfs
        long ans = bfs(start, goal);
        System.out.println(ans);
    }
}
