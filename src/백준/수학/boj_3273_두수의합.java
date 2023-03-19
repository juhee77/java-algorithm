package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3273_두수의합 {
    public static final int MAX = 1_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[] check = new boolean[MAX]; //숫자를 확인하는 용도로
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            check[arr[i]] = true; //값이 있다고 체크
        }

        int x = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i : arr) {
            if (i <= x && x <= MAX + i && check[x - i]) {
                cnt++; //만들 수 있다면 더한다
            }
        }
        System.out.println(cnt / 2);
    }
}
