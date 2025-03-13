package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_7596_MP3Songs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n;
        int tc = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            List<String> sentences = new ArrayList<>();
            while (n-- > 0) {
                sentences.add(br.readLine());
            }

            Collections.sort(sentences);
            sb.append(tc++).append("\n");
            for (String sentence : sentences) {
                sb.append(sentence).append("\n");
            }
        }
        System.out.println(sb);
    }
}
