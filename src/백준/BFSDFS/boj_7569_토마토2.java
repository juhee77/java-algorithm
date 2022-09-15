package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class porintxyz {
    int x, y, z;

    public porintxyz(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}

public class boj_7569_토마토2 {


    private static Queue<porintxyz> queue = new LinkedList<>();
    private static int box[][][];

    private static void bfs() {
        int dirx[] = new int[]{-1, 1, 0, 0};
        int diry[] = new int[]{0, 0, -1, 1};
        int dirz[] = new int[]{-1, 1};
        int day = 0;

        while (!queue.isEmpty()) {
            porintxyz temp = queue.poll();
            int px = temp.getX();
            int py = temp.getY();
            int pz = temp.getZ();

            //상하좌우
            for (int i = 0; i < 4; i++) {
                int nx = px + dirx[i];
                int ny = py + diry[i];

                //벗어남
                if (nx >= box[0].length || nx < 0 || ny < 0 || ny >= box[0][0].length) continue;

                //벽이면
                if (box[pz][nx][ny] == -1) continue;

                //방문안한 노드이면
                if (box[pz][nx][ny] == 0) {
                    box[pz][nx][ny] = box[pz][px][py] + 1;
                    queue.add(new porintxyz(nx, ny, pz));
                    day = Math.max(day, box[pz][nx][ny]);
                }
            }

            //z축 위아래
            for (int i = 0; i < 2; i++) {
                int nz = pz + dirz[i];

                //높이를 벗어남
                if (nz >= box.length || nz < 0) continue;

                //벽이면
                if (box[nz][px][py] == -1) continue;

                //방문안한 노드이면
                if (box[nz][px][py] == 0) {
                    box[nz][px][py] = box[pz][px][py] + 1;
                    queue.add(new porintxyz(px, py, nz));
                    day = Math.max(day, box[nz][px][py]);
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        box = new int[height][row][col];

        for (int k = 0; k < height; k++) {
            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                    if (box[k][i][j] == 1) queue.add(new porintxyz(i, j, k));
                }
            }
        }

        //bfs
        bfs();

        int day = 0;
        for (int k = 0; k < height; k++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (box[k][i][j] == -1) continue; //벽
                    else if (box[k][i][j] == 0) { //벽이 아닌데 익지 못함
                        day = -1;
                        break;
                    }
                    day = Math.max(day, box[k][i][j]);
                }
                if (day == -1) break;
            }
            if (day == -1) break;
        }

        if (day == -1) System.out.println(day);
        else System.out.println(day - 1);
    }
}
