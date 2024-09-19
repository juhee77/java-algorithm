package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10102_개표 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int aCnt = 0, bCnt = 0;
        for (char c : br.readLine().toCharArray()) {
            if (c == 'A') {
                aCnt++;
            } else {
                bCnt++;
            }
        }

        if (aCnt == bCnt) System.out.println("Tie");
        else if (aCnt < bCnt) System.out.println("B");
        else System.out.println("A");
    }
}
