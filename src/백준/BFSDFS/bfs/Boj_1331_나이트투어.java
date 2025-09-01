package 백준.BFSDFS.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Boj_1331_나이트투어 {
    private static int[][] mvs = new int[][]{
            {-2, -1}, {-2, 1}, // 위로 두 칸, 좌/우 한 칸
            {-1, -2}, {-1, 2}, // 위/아래 한 칸, 좌/우 두 칸
            {1, -2}, {1, 2},   // 아래로 한 칸, 좌/우 두 칸
            {2, -1}, {2, 1}    // 아래로 두 칸, 좌/우 한 칸
    };

    private static HashSet<String> set = new HashSet<>();
    private static int beforeAlphabet, beforeNumber, alphabet, number;
    private static String startS;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        startS = br.readLine();
        char[] chars = startS.toCharArray();
        beforeAlphabet = chars[0] - 'A';
        beforeNumber = chars[1] - '1';
        set.add(startS);

        for (int i = 1; i < 36; i++) {
            if (!isAble(br.readLine(), false))
                break;
        }

        if (set.size() == 36 && isAble(startS, true))
            System.out.println("Valid");
        else System.out.println("Invalid");
    }

    private static boolean isAble(String inputString, boolean finalFlag) {
        char[] now = inputString.toCharArray();
        alphabet = now[0] - 'A';
        number = now[1] - '1';

        for (int[] mv : mvs) {
            int movedAlphabet = mv[0] + beforeAlphabet;
            int movedNumber = mv[1] + beforeNumber;
//            System.out.println( alphabet+" "+movedAlphabet+" "+number+" "+movedNumber);

            if (movedAlphabet < 0 || movedNumber < 0 || 6 <= movedAlphabet || 6 <= movedNumber)
                continue;
            if (!finalFlag && set.contains(inputString))
                return false;

            if (movedAlphabet == alphabet && movedNumber == number) {
                beforeAlphabet = alphabet;
                beforeNumber = number;

                set.add(inputString);
                return true;
            }
        }

        return false;
    }
}
