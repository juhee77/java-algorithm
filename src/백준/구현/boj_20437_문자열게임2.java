package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_20437_문자열게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            char[] charArray = br.readLine().toCharArray();
            int goalCnt = Integer.parseInt(br.readLine());
            int minLen = Integer.MAX_VALUE;
            int maxLen = 0;
            ArrayList<Integer>[] cnt = new ArrayList['z' - 'a' + 1];

            for (int i = 0; i < cnt.length; i++) {
                cnt[i] = new ArrayList<>();
            }

            for (int s = 0; s < charArray.length; s++) {
                cnt[charArray[s] - 'a'].add(s);
            }

            for (ArrayList<Integer> integers : cnt) {
                if (integers.size() >= goalCnt) {
                    for (int p = 0; p <= integers.size() - goalCnt; p++) {
                        int diff = integers.get(p + goalCnt - 1) - integers.get(p) + 1;
                        minLen = Math.min(minLen, diff);
                        maxLen = Math.max(maxLen, diff);
                    }

                }
            }


            if (minLen == Integer.MAX_VALUE) sb.append("-1").append("\n");
            else sb.append(minLen).append(" ").append(maxLen).append("\n");

        }
        System.out.println(sb);
    }
}
