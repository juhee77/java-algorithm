package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_5543_상근날드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int menuMin = Integer.MAX_VALUE;
        int n = 3;
        while (n-- > 0) {
            menuMin = Math.min(menuMin, Integer.parseInt(br.readLine()));
        }

        n = 2;
        int drinkMin = Integer.MAX_VALUE;
        while (n-- > 0) {
            drinkMin = Math.min(drinkMin, Integer.parseInt(br.readLine()));
        }
        System.out.println(drinkMin + menuMin - 50);
    }
}
