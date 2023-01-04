package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L_암호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String ans = "";
        String temp = "";
        String all = br.readLine();
        for (int i = 0; i < 7  * num; i++) {
            temp += (all.charAt(i) == '#') ? "1" : "0";
            if ((i + 1) % 7 == 0) {
                ans += (char) Integer.parseInt(temp,2);
                temp = "";
            }
        }
        System.out.println(ans);
    }
}
