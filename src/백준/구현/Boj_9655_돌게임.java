package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9655_돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int remain = Integer.parseInt(br.readLine()) % 4;
        if (remain == 1 || remain == 3) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

    }
}
