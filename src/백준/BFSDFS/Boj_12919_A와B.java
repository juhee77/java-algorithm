package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_12919_A와B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String start = br.readLine();
        String target = br.readLine();

        System.out.println(dfs(start, target));
    }

    private static int dfs(String start, String target) {
        if (start.length() == target.length()) {
            if (start.equals(target)) {
                return 1;
            }
            return 0;
        }

        int ans = 0;

        if (target.charAt(0) == 'B') {
            String substring = target.substring(1);
            StringBuilder reverse = new StringBuilder(substring);
            reverse.reverse();
            ans += dfs(start, reverse.toString());
        }

        if (target.charAt(target.length() - 1) == 'A') {
            String substring = target.substring(0, target.length() - 1);
            ans += dfs(start, substring);
        }

        return ans >= 1 ? 1 : 0;
    }

}
