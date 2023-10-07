package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2437_저울 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int able = 0;
        //최소 n까지 가능하다면 x[i]+n에 대해서 가능하기 때문에
        for (int i=0;i<n;i++) {
            int now = arr[i];
            if (able < now && able+1!=now) {
                break;
            }
            able += now;
        }
        System.out.println(able+1);
    }
}
