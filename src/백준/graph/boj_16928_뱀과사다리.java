package 백준.graph;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_16928_뱀과사다리 {
    private static  int arr[]=new int[101];
    private static int visited[]=new int[101];

    private static int bfs(int x, int y) {

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int dir[] = new int[]{1,2,3,4,5,6};
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            int px = (int) temp.getX();
            int ptime = (int) temp.getY();

            if(px==100){
                return ptime;
            }

            for (int i = 0; i < 6; i++) {
                int nx = px + dir[i];
                int ntime = ptime+1;
                //System.out.println(nx+" "+ntime);

                //벗어남
                if (nx > 100) continue;

                //방문안한 노드이면
                if (visited[nx] == 0) {
                    visited[nx]=1;

                    //사다리 연결 경우
                    if(arr[nx]!=0)
                        queue.add(new Point(arr[nx], ntime));

                    else queue.add(new Point(nx, ntime));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());

        for(int i=0;i<plus+minus;i++){
            st=new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            arr[v1]=v2;
        }

        System.out.println(bfs(1,0));

    }
}
