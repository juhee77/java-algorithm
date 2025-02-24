package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_30802_웰컴키트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st2.nextToken());
        int p = Integer.parseInt(st2.nextToken());

        int cloth = 0;
        for (int i = 0; i < 6; i++) {
            int tempStudents = Integer.parseInt(st.nextToken());
            cloth += (tempStudents % t == 0) ? tempStudents / t : tempStudents / t + 1;
        }

        sb.append(cloth).append("\n");
        sb.append(n / p).append(" ").append(n % p);
        System.out.println(sb);
    }
}
