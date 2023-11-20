package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1535_안녕 {
    public static void main(String[] args) throws IOException {


        //주어진 체력 내에서의 최대의 기쁨
        //체력이 0이 되면 안된다.


        //사람의 수가 들어온다.
        //잃는 체력
        // 얻는 기쁨

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] healthPerHappy = new int[101];

        StringTokenizer health = new StringTokenizer(br.readLine());
        StringTokenizer happy = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            int nowHealth = Integer.parseInt(health.nextToken());
            int nowHappy = Integer.parseInt(happy.nextToken());
            for (int j = 1; j < 100; j++) {
                if (j + nowHealth <= 100) {
                    healthPerHappy[j] = Math.max(nowHappy + healthPerHappy[j + nowHealth], healthPerHappy[j]);
                    max = Math.max(max, healthPerHappy[j]);
                }
            }
        }

        System.out.println(max);
    }
}
