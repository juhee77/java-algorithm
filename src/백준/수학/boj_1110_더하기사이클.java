package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1110_더하기사이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int initNum = Integer.parseInt(br.readLine());
        int nowNum = initNum;
        int cnt = 0;

        do {
            cnt++;
            int tempNum = nowNum / 10 + nowNum % 10;
            nowNum = (nowNum % 10) * 10 + tempNum % 10;
        } while (nowNum != initNum);
        System.out.println(cnt);
    }
}
