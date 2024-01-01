package 백준.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17863_FYI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        if (s.startsWith("555")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
