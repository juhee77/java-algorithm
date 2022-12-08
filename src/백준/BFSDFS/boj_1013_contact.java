package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1013_contact {
    private static boolean totalFlag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());

        while (line-- > 0) {
            totalFlag = false;
            String s = br.readLine();
            dfs(s);
            if (totalFlag) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(String s) {
        if (s.length() <= 0) {
            totalFlag = true;
            return;
        }
        int idx = 0;

        if (s.charAt(idx) == '1') {
            if (s.length() < 4) return;
            if (s.charAt(++idx) != '0' || s.charAt(++idx) != '0') return;
            while (idx < s.length()) {
                if (s.charAt(idx) != '0') break;
                idx++;
            }
            if (idx==s.length()||s.charAt(idx) != '1') return;
            while (idx < s.length()) {
                if (s.charAt(idx) != '1') break;
                dfs(s.substring(idx+1));
                idx++;
                //System.out.println(s.substring(idx));
            }


        } else {
            if (s.length() < 2) return;
            if (s.charAt(++idx) != '1') return;
            //System.out.println(s.substring(idx+1));
            dfs(s.substring(idx + 1));
        }
    }
}
