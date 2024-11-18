package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10808_알파벳개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dic = new int['z' - 'a' + 1];
        for (char c : br.readLine().toCharArray()) {
            dic[c - 'a']++;
        }

        for (int cnt : dic) {
            sb.append(cnt).append(" ");
        }
        System.out.println(sb);
    }
}
