package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2004_조합0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        //뒤에 0의 영향을 주는것 각숫자에 포함된 2, 5이다.
        // nCk = n!/(k!(n−k)!)
        int count2 = countFactors(n, 2) - countFactors(k, 2) - countFactors(n - k, 2);
        int count5 = countFactors(n, 5) - countFactors(k, 5) - countFactors(n - k, 5);
        System.out.println(Math.min(count2, count5));
    }
    public static int countFactors(int n, int p) {
        int count = 0;
        while (n >= p) {
            count += n / p;
            n /= p;
        }
        return count;
    }
}
