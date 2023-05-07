package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17103_골드바흐파티션 {
    public static final int MAX = 1_000_001;
    private static final boolean[] isNotPrime = new boolean[MAX];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        initPrime();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int now = Integer.parseInt(br.readLine());
            sb.append(findPartition(now)).append("\n");
        }
        System.out.println(sb);

    }

    private static int findPartition(int now) {
        int cnt = 0;
        for (int i = 2; i <= now / 2; i++) {
            if(!isNotPrime[i] && !isNotPrime[now-i]) {
                cnt++;
            }
        }
        return cnt;
    }

    private static void initPrime() {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i * i < MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * 2; j < MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}
