package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        int arr[] = new int[line + 1];
        int length[][][] = new int[line + 1][line + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        //0 length 1 max
        for (int i = 1; i <= line; i++) {
            length[i][i][1]=Integer.parseInt(st.nextToken());
            for (int j = 1; j <= i; j++) {
                if(length[i-1][j][1]<length[i][i][1]){
                    length[i][j][1]=length[i][i][1];
                    length[i][j][0] = length[i-1][j][0]+1;
                }else{
                    length[i][j][1]=length[i-1][j][1];
                    length[i][j][0] = length[i-1][j][0];
                }
                if (i == line) max = Math.max(max, length[i][j][0]);
                System.out.print(Arrays.toString(length[i][j])+"    ");
            }
            System.out.println();

        }
        sb.append(max);

        System.out.println(sb);
    }
}
