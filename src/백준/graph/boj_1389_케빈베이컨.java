package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1389_케빈베이컨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int[][] arr = new int[vertex][vertex];

        //자기자신은 cost 1, 다른것은 최대로
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                arr[i][j] = (i == j) ? 0 : 5001;
            }
        }

        //입력값 저장
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            arr[v1][v2] = arr[v2][v1] = 1;
        }

        //플로이드 워셜 알고리즘(p->q이동시에 i를 거쳐가는 경우)
        FloydWarshall(vertex, arr);

        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < vertex; i++) {
            int temp = 0;
            //System.out.println(Arrays.toString(arr[i]));
            for (int j = 0; j < vertex; j++)
                temp += arr[i][j];

            if (temp < min) {
                min = temp;
                ans = i;
            }
        }
        System.out.println(ans + 1);
    }

    static void FloydWarshall(int num, int[][] arr) {
        for (int i = 0; i < num; i++) {
            for (int p = 0; p < num; p++) {
                for (int q = 0; q < num; q++) {
                    arr[p][q] = Math.min(arr[p][q], arr[p][i] + arr[i][q]);
                }
            }
        }
    }
}
