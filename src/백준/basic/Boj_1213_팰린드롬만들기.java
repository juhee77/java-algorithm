package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1213_팰린드롬만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] set = new int[26];
        for (char c : br.readLine().toCharArray()) {
            set[c - 'A']++;
        }

        if (lessOneOdd(set)) {
            int oddChar = -1;
            StringBuilder tempSb = new StringBuilder();
            for (int i = 0; i < set.length; i++) {
                if (set[i] % 2 != 0) oddChar = i;
                tempSb.append(((char) ('A' + i) + "").repeat(set[i] / 2));
            }

            sb.append(tempSb);
            if (oddChar != -1) sb.append((char) ('A' + oddChar));
            sb.append(tempSb.reverse());
            System.out.println(sb);
        } else {
            System.out.println("I'm Sorry Hansoo");
        }
    }

    private static boolean lessOneOdd(int[] set) {
        int cnt = 0;
        for (int c : set) {
            if (c % 2 == 0) continue;
            if (c % 2 == 1) {
                if (cnt == 1) return false;
                else cnt++;
            }
        }
        return true;
    }
}
