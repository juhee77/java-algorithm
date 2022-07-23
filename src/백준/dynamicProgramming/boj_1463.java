package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        int arr[] = new int[line + 1];

        if(line ==1){
            System.out.println(0);
        }
        else {
            arr[1] = 0;

            for (int i = 2; i <= line; i++) {
                if (i % 2 == 0 && i % 3 == 0)
                    arr[i] = Math.min(Math.min(arr[i / 2] + 1, arr[i / 3] + 1), arr[i - 1] + 1);
                else if (i % 2 == 0)
                    arr[i] = Math.min(arr[i / 2] + 1, arr[i - 1] + 1);
                else if (i % 3 == 0)
                    arr[i] = Math.min(arr[i / 3] + 1, arr[i - 1] + 1);
                else arr[i] = arr[i - 1] + 1;
                System.out.println("#"+i+"   "+arr[i]);
            }
            sb.append(arr[line]);
            System.out.println(sb);
        }
    }
}
