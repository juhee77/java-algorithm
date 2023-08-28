package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_1351_무한수열 {
    private static final HashMap<Long, Long> hash = new HashMap<>();
    private static long p;
    private static long q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());

        hash.put(0L, 1L);
        dfs(n);
        System.out.println(hash.get(n));

    }

    private static void dfs(long i) {
        if (hash.containsKey(i)) {
            return;
        }

        long l1 = i / p;
        long l2 = i / q;

        if (!hash.containsKey(l1)) {
            dfs(l1);
        }

        if (!hash.containsKey(l2)) {
            dfs(l2);
        }

        hash.put(i, hash.get(l1) + hash.get(l2));
    }
}
