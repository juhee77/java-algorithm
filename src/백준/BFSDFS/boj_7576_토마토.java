package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576_토마토 {
    private static Queue<Point> queue = new LinkedList<>();
    private static int box[][];

//    private static void pring(int row){
//        for (int i = 0; i < row; i++) {
//            System.out.println(Arrays.toString(box[i]));
//        }
//    }

    private static void bfs() {
        int dirx[] = new int[]{-1, 1, 0, 0};
        int diry[] = new int[]{0, 0, -1, 1};
        int day = 0;

        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            int px = (int) temp.getX();
            int py = (int) temp.getY();

            for (int i = 0; i < 4; i++) {
                int nx = px + dirx[i];
                int ny = py + diry[i];

                //벗어남
                if (nx >= box.length || nx < 0 || ny < 0 || ny >= box[0].length) continue;

                //벽이면
                if (box[nx][ny] == -1) continue;

                //방문안한 노드이면
                if (box[nx][ny] == 0) {
                    box[nx][ny] = box[px][py] + 1;
                    queue.add(new Point(nx, ny));
                    day = Math.max(day, box[nx][ny]);
                }
            }

//            pring(box.length);
//            System.out.println("\n"+"\n");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        box = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) queue.add(new Point(i, j));
            }
        }
        //bfs
        bfs();
        int day = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(box[i][j]==-1)continue;
                else if (box[i][j] == 0) {
                    day = -1;
                    break;
                }
                day=Math.max(day,box[i][j]);
            }
            if(day==-1)break;
        }
        if(day==-1)System.out.println(day);
        else System.out.println(day-1);
    }

}
