package 프로그래머스.level2;

import java.util.Arrays;

public class 합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int arr[][] = new int[n+1][n+1];
        int INF = (int) 1e9;

        //배열 초기화 (자기자신 가는 방법은 0 )
        for (int i = 0; i <= n; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i]=0;
        }

        for (int i = 0; i < fares.length; i++) {
            int[] temp = fares[i];
            int e1 = temp[0];
            int e2 = temp[1];
            int w = temp[2];
            arr[e1][e2] = arr[e2][e1] = w;
        }

        StringBuilder sb = new StringBuilder();

        //플로이드 워셜
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Math.min(arr[i][p] + arr[p][j], arr[i][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                if (arr[i][j] == INF)  sb.append("INF ");
                else sb.append(arr[i][j] + " ");
            sb.append("\n");
        }

        System.out.println(sb);
        int answer = arr[s][a]+arr[s][b];
        for(int i=1;i<=n;i++){
            int tempMin = arr[s][i]+arr[i][a]+arr[i][b];
            if(tempMin<=0) continue;
            answer = Math.min(tempMin,answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new 합승택시요금().solution(6,4,6,2,new int[][]{{4,1,10},{3,5,24},{5,6,2},{3,1,41},{5,1,24},{4,6,50},{2,4,66},{2,3,22},{1,6,25}}));
        System.out.println(new 합승택시요금().solution(7,3,4,1,new int[][]{{5,7,9},{4,6,4},{3,6,1},{3,2,3},{2,1,6}}));
        System.out.println(new 합승택시요금().solution(6,4,5,6,new int[][]{{2,6,6},{6,3,7},{4,6,7},{6,5,11},{2,5,12},{5,3,20},{2,4,8},{4,3,9}}));

    }
}
