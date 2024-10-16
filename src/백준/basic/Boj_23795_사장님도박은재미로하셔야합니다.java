package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_23795_사장님도박은재미로하셔야합니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n;
        int ans = 0;
        while ((n = Integer.parseInt(br.readLine())) != -1) {
            ans += n;
        }
        System.out.println(ans);
    }
}
