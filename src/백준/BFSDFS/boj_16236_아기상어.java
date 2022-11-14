package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16236_아기상어 {
    private static class point {
        int x, y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int sharkx,sharky,min_dist, min_x, min_y, result, eat_cnt = 0,sharkSize = 2;

    private static void bfs(int[][] arr, int[][] check, int sharkx, int sharky) {
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(sharkx, sharky));
        check[sharkx][sharky] = 0;

        int[] dirx = new int[]{-1, 1, 0, 0};
        int[] diry = new int[]{0, 0, -1, 1};

        while (!queue.isEmpty()) {
            point temp = queue.poll();
            int px = temp.x;
            int py = temp.y;


            for (int i = 0; i < 4; i++) {
                int nx = px + dirx[i];
                int ny = py + diry[i];

                //벗어남
                if (nx >= arr.length || nx < 0 || ny < 0 || ny >= arr[0].length) continue;

                //방문 한 노드이거나, 상어 사이즈 보다 작으면
                if (check[nx][ny] != -1 || arr[nx][ny] > sharkSize) continue;

                check[nx][ny] = check[px][py] + 1;

                //방문안한 노드이면
                if (arr[nx][ny] < sharkSize && arr[nx][ny] != 0) {
                    if (min_dist > check[nx][ny]) {
                        min_x = nx;
                        min_y = ny;
                        min_dist = check[nx][ny];
                    } else if (min_dist == check[nx][ny]) {
                        if (min_x == nx) { //가장 위에 있는것
                            if (min_y > ny) {
                                min_y = ny;
                            }
                        } else if (min_x > nx) { //가장 왼쪽
                            min_x = nx;
                            min_y = ny;
                        }
                    }
                }
                queue.add(new point(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int line = Integer.parseInt(br.readLine());

        int[][] arr = new int[line][line];
        int[][] minDist = new int[line][line];

        //입력구간
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < line; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    sharkx = i;
                    sharky = j;
                    arr[i][j] = 0;
                }
            }
        }

        while (true) {
            //가장 최단 거리인가
            min_dist = 401;
            min_x = min_y = 21;
            for (int i = 0; i < line; i++) {
                for (int j = 0; j < line; j++)
                    minDist[i][j] = -1;
            }

            bfs(arr, minDist, sharkx, sharky);

            if(min_x!=21 && min_y!=21){
                result += minDist[min_x][min_y];
                eat_cnt++;

                if(eat_cnt == sharkSize){
                    sharkSize++;
                    eat_cnt=0;
                }
                arr[min_x][min_y]=0;
                sharkx=min_x;
                sharky= min_y;
            }
            else {
                break;
            }

        }
        System.out.println(result);

    }
}
