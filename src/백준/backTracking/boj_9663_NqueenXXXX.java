package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj_9663_NqueenXXXX {
    static int[] arr;
    static boolean[] visit;
    static HashSet<String> hash = new HashSet<>();

    private static void dfs(int n, int m, int d) {
        if (d == m) {
            String temp = "";
            for (int a : arr) temp += a + " ";
            //if (!hash.contains(temp)) {
            System.out.println(temp);
            //     hash.add(temp);
            //z }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (d == 1) {
                visit[i] = true;
                arr[d] = i;
                dfs(n, m, d + 1);
                visit[i] = false;
            } else {
                if (!visit[i]) {
                    int j = 1;
                    for (; j <= n; j++) {
                        boolean flag = false;
                        for (int depth = 0; depth < d - 1; depth++) {
                            if (d - 1 - depth <= 0 || d - 1 - depth >= arr.length)
                                continue;
                            else if (arr[d - 1 - depth] == j - 1 - depth || arr[d - 1 - depth] == j + 1 + depth) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) continue;
                        if (visit[j]) continue;
                        else {
                            visit[j] = true;
                            arr[d] = j;
                            dfs(n, m, d + 1);
                            visit[j] = false;
                        }
                    }
                }
            }

        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int queen = Integer.parseInt(br.readLine());
        arr = new int[queen + 1];
        visit = new boolean[queen + 1];
        dfs(queen, queen + 1, 1);
        System.out.print(hash.size());

    }
}
