package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj_1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Character> hash = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            hash.clear();
            char[] chars = br.readLine().toCharArray();
            char before = chars[0];
            hash.add(before);
            boolean flag = true;
            for (int j = 1; j < chars.length && flag; j++) {

                if (chars[j] != before){
                    if (hash.contains(chars[j])) {
                        flag = false;
                    } else {
                        before = chars[j];
                        hash.add(chars[j]);
                    }
                }
            }
            if (flag) ans++;
        }
        System.out.println(ans);
    }
}
