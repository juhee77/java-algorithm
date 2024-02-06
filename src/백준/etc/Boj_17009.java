package 백준.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] score = new int[2];
        for (int i = 0; i < 2; i++) {
            for (int j = 3; 0 < j; j--) {
                int parseInt = Integer.parseInt(br.readLine());
                score[i] += parseInt*j;
            }
        }

        if (score[0] > score[1]) {
            System.out.println('A');
        } else if (score[0] == score[1]) {
            System.out.println('T');
        } else {
            System.out.println('B');
        }
    }
}
