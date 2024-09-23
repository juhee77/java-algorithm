package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_11656_접미사배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            ans.add(s.substring(i));
        }

        Collections.sort(ans);
        for (String an : ans) {
            sb.append(an).append("\n");
        }
        System.out.println(sb);
    }
}
