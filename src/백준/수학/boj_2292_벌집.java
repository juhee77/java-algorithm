package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2292_벌집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int ans = 1;

        if (input == 1) System.out.println(ans);
        else {
            int now = 6;
            input --; //1 제외
            while (input > 0) {
                ans++;
                input -= now;
                if(input <=0){
                    System.out.println(ans);
                    break;
                }
                now += 6;
            }
        }
    }
}
