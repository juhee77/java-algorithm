package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17070_파이프옮기기 {
    static class nowState {
        int x, y, shape;

        public nowState(int x, int y, int shape) {
            this.x = x;
            this.y = y;
            this.shape = shape;
            //0 가로, 1 세로, 2 대각선
        }
    }

    private static int map[][];

    private static int solution() {
        int ans = 0;
        Queue<nowState> q = new LinkedList();
        q.add(new nowState(0, 0, 0));

        while (!q.isEmpty()) {
            nowState temp = q.poll();
            int sx = temp.x;
            int sy = temp.y;
            int ex = (temp.shape == 0) ? sx : sx+1;
            int ey = (temp.shape == 1) ? sy : sy+1;

            //System.out.println(sx+" "+sy+" "+ex+" "+ey+" "+temp.shape);


            if (ex == map.length-1 && ey == map.length-1) {
                ans++;
                continue;
            }

            //세로로 가는경우
            if (temp.shape == 1 || temp.shape == 2) {
                int tempendx = ex+1;
                int tempendy = ey;
                if (tempendx < map.length && tempendy < map.length && map[tempendx][tempendy] == 0)
                    q.add(new nowState(ex, ey, 1));
            }
            //가로로 가는 경우
            if (temp.shape == 0 || temp.shape == 2) {
                int tempendx = ex ;
                int tempendy = ey+1;
                if (tempendx < map.length && tempendy < map.length && map[tempendx][tempendy] == 0)
                    q.add(new nowState(ex, ey, 0));
            }
            //대각선으로 가는경우
            int tempendx = ex + 1;
            int tempendy = ey + 1;
            if (tempendx < map.length && tempendy < map.length)
                if(map[tempendx][tempendy] == 0&&map[tempendx-1][tempendy] == 0&&map[tempendx][tempendy-1] == 0)
                q.add(new nowState(ex, ey, 2));

        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());

        map = new int[line][line];
        //입력구간
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < line; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(map[line-1][line-1]==1) System.out.println(0);
        else System.out.println(solution());



        /*iwant test somethicn(*/
    }
}
