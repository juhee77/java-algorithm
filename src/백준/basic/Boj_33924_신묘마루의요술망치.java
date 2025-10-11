package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_33924_신묘마루의요술망치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int initX = Integer.parseInt(st.nextToken());
        int initY = Integer.parseInt(st.nextToken());

        int[] mapA = {5, 6, 7, 8, 1, 2, 3, 4};
        int[] mapB = {4, 3, 2, 1, 8, 7, 6, 5};
        int[] mapC = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] mapD = {3, 1, 5, 2, 7, 4, 8, 6};
        int holdIndex = (initX - 1) * 2 + (initY - 1);
        int commands = Integer.parseInt(br.readLine());
        char[] charArray = br.readLine().toCharArray();
        for (char command : charArray) {
            if (command == 'A') {
                holdIndex = getHoldIndex(mapA, holdIndex);
            } else if (command == 'B') {
                holdIndex = getHoldIndex(mapB, holdIndex);
            } else if (command == 'C') {
                holdIndex = getHoldIndex(mapC, holdIndex);
            } else if (command == 'D') {
                holdIndex = getHoldIndex(mapD, holdIndex);
            }
        }
        System.out.println(holdIndex / 2 + 1 + " " + (holdIndex % 2 + 1));
    }

    private static int getHoldIndex(int[] mapA, int holdIndex) {
        for (int i = 0; i < 8; i++) {
            if (mapA[i] - 1 == holdIndex) {
                holdIndex = i;
                break;
            }
        }
        return holdIndex;
    }
}
