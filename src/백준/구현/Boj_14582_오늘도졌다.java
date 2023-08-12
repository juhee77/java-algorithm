package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14582_오늘도졌다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int score1 = 0, score2 = 0;
        boolean reverse = false;
        for (int i = 0; i < 9; i++) {
            score1 += Integer.parseInt(st1.nextToken());
            if (score2 < score1) reverse = true;

            score2 += Integer.parseInt(st2.nextToken());
        }
        if (reverse && score1 < score2) {
            System.out.println("Yes");
        } else System.out.println("No");
    }
}
