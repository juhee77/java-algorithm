package 백준.BFSDFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class pointD  {
    int x,y,num,cnt; // x축, y축, 부신 개수

    public pointD(int x, int y, int num,int cnt) {
        this.x = x;
        this.y = y;
        this.num = num;
        this.cnt = cnt;
    }
}

public class boj_2206_벽부수고이동하기 {
    private static int arr[][];
    private static boolean visited[][][];
    private static int bfs(){
        Queue<pointD> queue = new LinkedList<>();
        queue.add(new pointD(0,0,0,1));
        arr[0][0]=2;
        int dirx[] = new int[]{1, 0, -1, 0};
        int diry[] = new int[]{0, 1, 0, -1};

        while(!queue.isEmpty()){
            pointD temp = queue.poll();
            int px = temp.x;
            int py= temp.y;
            int pnum = temp.num;
            int pcnt = temp.cnt;

            if(px == arr.length-1 && py == arr[0].length-1){
                return pcnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dirx[i];
                int ny = py + diry[i];
                int ncnt = pcnt + 1;
                //벗어남
                if (nx >= arr.length || nx < 0 || ny < 0 || ny >= arr[0].length) continue;

                //방문안한 노드이면
                if (arr[nx][ny] == 0) {
                    if(pnum==0 && !visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        queue.add(new pointD(nx, ny, pnum,ncnt));
                    }else if (pnum==1 && !visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        queue.add(new pointD(nx, ny,pnum,ncnt));
                    }

                }
                //벽이면
                else if (arr[nx][ny] == 1){
                    if (pnum==0){ //한번도 부신적이 없으면
                        queue.add(new pointD(nx, ny,1,ncnt));
                        visited[nx][ny][1]=true;
                    }
                }
            }

//            for(int i=0;i<arr.length;i++){
//                for(int j=0;j<arr[0].length;j ++)
//                    System.out.print(arr[i][j]+" ");
//                System.out.println();
//            }
//            System.out.println();
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        arr = new int[row][col];
        visited = new boolean[row][col][2];
        //입력구간
        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++){
                arr[i][j] = Integer.parseInt(temp.substring(j, j + 1));
            }
        }

        //bfs
        System.out.println(bfs());
    }
}
