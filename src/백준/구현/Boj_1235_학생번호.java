package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1235_학생번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<String> ans = new ArrayList<>();
        int minLen = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            String e = br.readLine();
            minLen = Math.min(e.length(), minLen);
            ans.add(e);
        }

        HashSet<String> set = new HashSet<>();
        for (int j = 1; j <= minLen; j++) {
            if (find(n, ans, set, j)) {
                System.out.println(j);
                break;
            }
        }
    }

    private static boolean find(int n, List<String> ans, HashSet<String> set, int len) {
        for (int k = 0; k < n; k++) {
            String s = ans.get(k);
            String substring = s.substring(s.length() - len);
            if (set.contains(substring)) {
                return false;
            } else {
                set.add(substring);
            }
        }
        return true;
    }
}
