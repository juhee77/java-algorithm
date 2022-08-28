package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11403_경로찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int vertex = Integer.parseInt(st.nextToken());
        int arr[][] = new int[vertex][vertex];

        //자기자신은 cost 1, 다른것은 최대로
        for (int i = 0; i < vertex; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < vertex; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        //플로이드 워셜 알고리즘(p->q이동시에 i를 거쳐가는 경우)
        for (int i = 0; i < vertex; i++) {
            for (int p = 0; p < vertex; p++) {
                for (int q = 0; q < vertex; q++) {
                    if(arr[p][q]==1) continue;
                    if(arr[p][i] + arr[i][q]>=2)
                        arr[p][q] =1;
                }
            }
        }


        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++)
                sb.append(arr[i][j]+" ");
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
