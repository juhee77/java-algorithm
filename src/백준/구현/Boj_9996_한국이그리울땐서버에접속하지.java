package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9996_한국이그리울땐서버에접속하지 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int n = Integer.parseInt(br.readLine());
//        String patterns = "";
//        char[] inputPattern = br.readLine().toCharArray();
//        for (char c : inputPattern) {
//            patterns += (c == '*') ? "(.*)" : c;
//        }
//
//        while (n-- > 0) {
//            sb.append(br.readLine().matches(patterns) ? "DA" : "NE").append("\n");
//        }
//        System.out.print(sb);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        int starIndex = pattern.indexOf('*');
        String prefix = pattern.substring(0, starIndex);
        String suffix = pattern.substring(starIndex + 1);

        while (n-- > 0) {
            String filename = br.readLine();
            if (filename.startsWith(prefix) && filename.endsWith(suffix) &&
                    filename.length() >= prefix.length() + suffix.length()) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }
        System.out.print(sb);
    }
}
