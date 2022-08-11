package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1312_소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int ans =0;

        for(int i=0;i<=goal;i++){
            ans = (int) ((int)a/b);
            a = a%b*10;
        }
        System.out.println(ans);

    }

}
