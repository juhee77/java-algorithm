package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1371_가장많은글자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] bucket = new int[26];
        String temp;
        int max = 0;

        while ((temp = br.readLine()) != null) {
            char[] charArray = temp.toCharArray();
            for (char c : charArray) {
                if (c == ' ') continue;
                bucket[c - 'a']++;
                if (bucket[c - 'a'] > max) max = bucket[c - 'a'];
            }
        }

        for (int i = 0; i < 26; i++) {
            if (bucket[i] == max) {
                sb.append((char) ('a' + i));
            }
        }
        System.out.println(sb);
    }
}
