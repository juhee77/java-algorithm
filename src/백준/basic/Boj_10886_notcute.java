package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10886_notcute {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cuteCnt = 0;
        while (n-- > 0) {
            if (Integer.parseInt(br.readLine()) == 1) cuteCnt++;
            else cuteCnt--;
        }
        System.out.println((cuteCnt < 0) ? "Junhee is not cute!" : "Junhee is cute!");
    }
}
