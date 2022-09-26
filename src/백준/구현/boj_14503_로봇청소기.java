package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
청소하는 영여그이 개수를 구해라
 칸은 벽,빈칸

 로봇청소기 작동법
1.현재 위치를 청소한다.
2.현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
    왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
    왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
    네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
    네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.

 d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라봄
 */

public class boj_14503_로봇청소기 {
    private static int arr[][];
    private static int cnt = 0;
    private static boolean visit[][];
    private static int[] dirx = {-1, 0, 1, 0};
    private static int[] diry = {0, 1, 0, -1};

    private static void solution(int x, int y, int dir) {
        int nowleft = dir;
        int nowx = x;
        int nowy = y;

        boolean f = true;
        for (int i = 0; i < 4; i++) {
            nowleft = (nowleft - 1 == -1) ? 3 : nowleft - 1; //현재 위치에서 -1하면 왼쪽의 dir이 나온다.
            nowx = x + dirx[nowleft];
            nowy = y + diry[nowleft];

            if (nowx < 0 || arr.length <= nowx || nowy < 0 || arr[0].length <= nowy) continue;//범위를 넘어감(벽)
            if (arr[nowx][nowy] == 0 && !visit[nowx][nowy]) {  //벽이 아닌데 청소가 되어있지 않은경우
                f = false;
                break;
            }
        }

        if (!f) { //벽이 아닌데 청소가 되어있지 않은경우
            visit[nowx][nowy] = true;
            cnt++;
            solution(nowx, nowy, nowleft);
        } else {
            nowx = x - dirx[dir];
            nowy = y - diry[dir];
            if (nowx < 0 || arr.length <= nowx || nowy < 0 || arr[0].length <= nowy || arr[nowx][nowy] == 1) return;
                //범위를 벗어나는 경우(벽), 자신의 길로 돌아가는 길이 벽이면 멈춤
            else solution(nowx, nowy, dir);
            //후진해서 돌아가서 확인
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit[x][y] = true;
        cnt = 1;
        solution(x, y, dir);

        System.out.println(cnt);
    }
}

//        for (int i = 0; i < arr.length; i++) {
//            for(int j=0;j<arr[0].length;j++){
//                if(visit[i][j]) System.out.print(1+" ");
//                else System.out.print(0+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println();