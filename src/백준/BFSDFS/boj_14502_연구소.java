package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_14502_연구소 {
    private static int arr[][];
    private static int cob[] = new int[3];
    private static boolean visit[];
    private static ArrayList<Point> none = new ArrayList<>();
    private static ArrayList<Point> virus = new ArrayList<>();
    private static int max = 0;

    public static void combination(int start, int d) {
        if (d == 3) {
            check();
            return;
        }
        for (int i = start; i < none.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                cob[d] = i;
                combination(i, d + 1);
                visit[i] = false;
            }
        }
    }

    private static void check() {
        int arrc[][] = new int[arr.length][arr[0].length];
        boolean visit[][] = new boolean [arr.length][arr[0].length];

        for(int i=0;i<arr.length;i++)
            arrc[i]=arr[i].clone();

        for(int k :cob){
            Point temp = none.get(k);
            arrc[temp.x][temp.y]=1;
        }


        int dirx[] = new int[]{-1, 1, 0, 0};
        int diry[] = new int[]{0, 0, -1, 1};
        Queue<Point> q = new LinkedList<>();
        for( Point a : virus) {
            q.add(a);
            visit[a.x][a.y]=true;
        }

        while (!q.isEmpty()) {
            Point temp = q.poll();
            int px = (int) temp.getX();
            int py = (int) temp.getY();

            for (int i = 0; i < 4; i++) {
                int nx = px + dirx[i];
                int ny = py + diry[i];

                //벗어남
                if (nx >= arrc.length || nx < 0 || ny < 0 || ny >= arrc[0].length) continue;

                //벽이면
                if (arrc[nx][ny] == 1 || arrc[nx][ny] == 2) continue;

                //방문안한 노드이면
                if (arrc[nx][ny] == 0 && !visit[nx][ny]) {
                    arrc[nx][ny] = 2;
                    q.add(new Point(nx, ny));
                    visit[nx][ny]=true;
                }
            }
        }


       int tmp=0;

       for(int i=0;i<arrc.length;i++){
           for(int j=0;j<arrc[0].length;j++){
               if(arrc[i][j]==0) tmp++;
           }
       }

       max = Math.max(tmp,max);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        arr = new int[row][col];
        //입력구간
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) none.add(new Point(i, j));
                else if(arr[i][j]==2) virus.add(new Point(i,j));
            }
        }
        //나올 수 있는 경우의 수
        visit = new boolean[none.size()];
        combination(0, 0);
        System.out.println(max);

    }
}
