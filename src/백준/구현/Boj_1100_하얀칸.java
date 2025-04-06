package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1100_하얀칸 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 0;
        int k = 0;
        for (int x = 0; x < 8; x++) {
            char[] charArray = br.readLine().toCharArray();
            for (int y = 0; y < 8; y++) {
                if (i % 2 == 0 && y % 2 == 0) {
                    if (charArray[y] == 'F') k++;
                } else if (i % 2 == 1 && y % 2 == 1) {
                    if (charArray[y] == 'F') k++;
                }
            }
            i++;
        }
        System.out.println(k);
    }
}
