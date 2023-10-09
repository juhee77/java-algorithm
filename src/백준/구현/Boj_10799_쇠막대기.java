package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] all = br.readLine().toCharArray();
        long boxCnt = 0;
        long sum = 0;
        int i = 0;
        while (i < all.length) {
            if (all[i] == '(') {
                if (i != all.length - 1 && all[i + 1] == ')') {
                    //레이저 발생
                    sum += boxCnt;
                    i++;
                } else {
                    boxCnt++;
                }
            } else {
                sum++;
                boxCnt--;
            }
            i++;
        }
        System.out.println(sum);

    }
}
