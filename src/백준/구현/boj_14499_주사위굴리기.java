package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14499_주사위굴리기 {
    private static int arr[][];
    private static StringBuilder sb = new StringBuilder();
    private static int dice[];

    //동서북남
    private static int[] dirx = {0, 0, -1, 1};
    private static int[] diry = {1, -1, 0, 0};

    private static int nowx, nowy;

    private static void solution(int cmd) {
        int tempx = nowx + dirx[cmd];
        int tempy = nowy + diry[cmd];
        if (tempx < 0 || arr.length <= tempx || tempy < 0 || arr[0].length <= tempy) return;

        nowx = tempx;
        nowy = tempy;

        int up = dice[0], bo = dice[5], lf = dice[3], rt = dice[2],fr = dice[4],bk = dice[1];
        switch (cmd) {
            case 0: //동
                changedice(lf,bk,up,bo,fr,rt);
                break;
            case 1: //서
                changedice(rt,bk,bo,up,fr,lf);
                break;
            case 2: //북
                changedice(fr,up,rt,lf,bo,bk);
                break;
            case 3: // 남
                changedice(bk,bo,rt,lf,up,fr);
                break;
            default:
                break;

        }
        if(arr[nowx][nowy]==0)arr[nowx][nowy]=dice[5];
        else {
            dice[5]= arr[nowx][nowy];
            arr[nowx][nowy]=0;
        }

        sb.append(dice[0]+"\n");
    }
    private static void changedice(int a,int b, int c, int d, int e,int f){
        dice[0]=a;
        dice[1]=b;
        dice[2]=c;
        dice[3]=d;
        dice[4]=e;
        dice[5]=f;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nowx = Integer.parseInt(st.nextToken());
        nowy = Integer.parseInt(st.nextToken());
        int cmdline = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dice = new int[6];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cmdline; i++) {
            int cmd = Integer.parseInt(st.nextToken()) - 1;
            solution(cmd);
        }

        System.out.println(sb);
    }
}
