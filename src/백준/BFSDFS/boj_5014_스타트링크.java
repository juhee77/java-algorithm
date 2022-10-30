package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_5014_스타트링크 {

    private static int F,S,G,U,D;

    private static boolean[] visited;

    private static class Point implements Comparable<Point>{
        int now, time;

        public Point(int now, int time) {
            this.now = now;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {
            return this.time-o.time;
        }
    }

    private static int bfs(){

        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(S,0));
        visited[S]=true;

        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.now == G) return now.time;

            else{
                //U
                checkElevator((PriorityQueue<Point>) q, now, now.now + U);
                //D
                checkElevator(q, now, now.now-D);
            }

        }
        return -1;
    }

    private static void checkElevator(PriorityQueue<Point> q, Point now, int ifMoved) {
        if (ifMoved <= F && 1 <= ifMoved) {
            if (!visited[ifMoved]) {
                q.add(new Point(ifMoved, now.time + 1));
                visited[ifMoved] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F+1];
        int cnt =bfs();
        System.out.println((cnt==-1)?"use the stairs":cnt);
    }
}
