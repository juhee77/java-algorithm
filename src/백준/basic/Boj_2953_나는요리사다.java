package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2953_나는요리사다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] scores = new int[5];
        int maxScoreStudent = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                scores[i] += Integer.parseInt(st.nextToken());
            }

            if (scores[i] > scores[maxScoreStudent]) {
                maxScoreStudent = i;
            }
        }
        System.out.println((maxScoreStudent + 1) + " " + scores[maxScoreStudent]);

    }
}
