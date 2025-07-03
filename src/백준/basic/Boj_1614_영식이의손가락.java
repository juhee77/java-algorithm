package 백준.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1614_영식이의손가락 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long hurt = Long.parseLong(br.readLine());
        long num = Long.parseLong(br.readLine());
        long result;
        if (hurt == 1) {
            result = num * 8;
        } else if (hurt == 2) {
            result = 1 + (num / 2) * 8 + (num % 2) * 6;
        } else if (hurt == 3) {
            result = 2 + (num / 2) * 8 + (num % 2) * 4;
        } else if (hurt == 4) {
            result = 3 + (num / 2) * 8 + (num % 2) * 2;
        } else {
            result = 4 + num * 8;
        }
        System.out.println(result);
    }
}
