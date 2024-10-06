package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4948_베르트랑공준 {
    public static final int MAX = 500_000;
    private static int[] cnt = new int[MAX];
    private static boolean[] isNotPrime = new boolean[MAX];
    private static int hold = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int find;
        while ((find = Integer.parseInt(br.readLine())) != 0) {
            sb.append(getCnt(find)).append("\n");
        }
        System.out.println(sb);
    }

    private static int getCnt(int now) {
        int next = now * 2;
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = Math.max(2, hold + 1); i <= next; i++) {
            cnt[i] = cnt[i - 1];
            if (!isNotPrime[i]) {
                for (int j = i + i; j < MAX; j += i) {
                    isNotPrime[j] = true;
                }
                cnt[i]++;
            }
        }
        hold = next;
        return cnt[next] - cnt[now];
    }
}
