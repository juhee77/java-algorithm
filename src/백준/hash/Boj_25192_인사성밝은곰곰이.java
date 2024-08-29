package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Boj_25192_인사성밝은곰곰이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        int ans = 0;
        while (n-- > 0) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                ans += set.size();
                set.clear();
            } else {
                set.add(s);
            }
        }
        System.out.println(ans + set.size());
    }
}
