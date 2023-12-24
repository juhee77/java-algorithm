package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_20303_할로윈의양아치 {
    public static int n, m, k;
    public static int[] candy, parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //거리아이들
        m = Integer.parseInt(st.nextToken()); //친구관계
        k = Integer.parseInt(st.nextToken()); //공명하기 위한 최소아이수

        candy = new int[n];
        parents = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }

        HashMap<Integer, int[]> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = findParents(parents[i]);
            int[] value = hashMap.getOrDefault(key, new int[]{0, 0}); //인원수, 캔디수
            value[0]++;
            value[1] += candy[i];
            hashMap.put(key, value);
        }


        List<int[]> values = new ArrayList<>();
        for (Integer key : hashMap.keySet()) {
            values.add(hashMap.get(key));
        }


        int[][] dp = new int[values.size() + 1][k];
        for (int j = 0; j < values.size(); j++) {
            for (int i = 0; i < k; i++) {
                dp[j + 1][i] = dp[j][i];
                if (0 < i) {
                    dp[j + 1][i] = Math.max(dp[j + 1][i], dp[j + 1][i - 1]);
                }
                if (values.get(j)[0] <= i) {
                    dp[j + 1][i] = Math.max(dp[j + 1][i], dp[j][i - values.get(j)[0]] + values.get(j)[1]);
                }
            }
        }

        System.out.println(dp[values.size()][k - 1]);
    }

    public static void union(int a, int b) {
        a = findParents(a);
        b = findParents(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    public static int findParents(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = findParents(parents[x]);
    }
}
