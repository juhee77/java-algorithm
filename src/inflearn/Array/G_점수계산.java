package inflearn.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_점수계산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int score = 1;
        int ans =0;
        for(int i=0;i<num;i++) {
            if(st.nextToken().equals("0")) score = 1;
            else {
                ans += score;
                score ++;
            }
        }
        System.out.println(ans);
    }
}
