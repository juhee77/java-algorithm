package contest.보라매컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int max = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int sum=0;
        for (int i = 0; i < 3; i++) {
            sum += Math.min(max, Integer.parseInt(st.nextToken()));
        }
        System.out.println(sum);

    }
}
