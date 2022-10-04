package 백준.bruteforce;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2638_치즈 {
    private static Queue<Point> queue = new LinkedList<>();
    private static int dirx[] = new int[]{-1, 1, 0, 0};
    private static int diry[] = new int[]{0, 0, -1, 1};

    private static int arr[][];
    private static int arr2[][];

    private static boolean init(){
        arr2 = new int[arr.length][arr[0].length];
        boolean flag = true;
        queue.clear();
        queue.add(new Point(0,0));
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            int px = (int) temp.getX();
            int py = (int) temp.getY();
            for (int i = 0; i < 4; i++) {
                int nx = px + dirx[i];
                int ny = py + diry[i];
                //벗어남
                if (nx >= arr.length || nx < 0 || ny < 0 || ny >= arr[0].length) continue;
                //벽이면
                if (arr[nx][ny] == 1) {
                    flag = false; //부서지지 않은 치즈가 있다면 계속 진행 해야함
                    continue;
                }
                //방문안한 노드이면
                if (arr[nx][ny] == 0 && arr2[nx][ny] != -1) {
                    arr2[nx][ny] = -1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        return flag;
    }

    private static void remove(){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){// 치즈가 있다면
                    int temp =0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dirx[k];
                        int ny = j + diry[k];
                        //벗어남
                        if (nx >= arr.length || nx < 0 || ny < 0 || ny >= arr[0].length) continue;
                        //방문안한 노드이면
                        if (arr2[nx][ny] == -1) temp++;
                    }
                    if(temp>=2) arr[i][j]=0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while(true){
            if(init())break;
            day++;
            remove();
        }

        System.out.println(day);

    }
}

/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0
 */