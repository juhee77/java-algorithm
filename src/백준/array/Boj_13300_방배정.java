package 백준.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13300_방배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //학생수
        int k = Integer.parseInt(st.nextToken()); //한방에 수용가능 인원

        int[] arr = new int[12]; //학년 , 성별
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken()) - 1;

            arr[age * 2 + s]++;
        }

        int ans = 0;
        for (int i : arr) {
            while (0 < i) {
                i -= k;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
