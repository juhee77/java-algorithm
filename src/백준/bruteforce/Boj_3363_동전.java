package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3363_동전 {
    private static final int[][][] map = new int[3][2][4];
    private static final char[] comp = new char[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            if (str == null || str.equals("")) {
                str = br.readLine();
            }
            st = new StringTokenizer(str);

            for (int j = 0; j < 4; j++) {
                map[i][0][j] = Integer.parseInt(st.nextToken());
            }

            comp[i] = st.nextToken().charAt(0);

            for (int j = 0; j < 4; j++) {
                map[i][1][j] = Integer.parseInt(st.nextToken());
            }
        }


        int find = -1;
        boolean hasManyAns = false;
        for (int i = 0; i < 12; i++) {

            //작은 경우
            if (getIsPossible(i, -1)) {
                if (find == -1) find = -i;
                else hasManyAns = true;
            }

            //큰 경우
            if (getIsPossible(i, 1)) {
                if (find == -1) find = i;
                else hasManyAns = true;
            }
        }

        if (hasManyAns) {
            sb.append("indefinite");
        } else if (find == -1) {
            sb.append("impossible");
        } else {
            sb.append((find < 0) ? -find + "-" : find + "+");
        }

        System.out.println(sb);
    }

    private static boolean getIsPossible(int hold, int diff) {
        for (int i = 0; i < 3; i++) {

            int leftSum = getSum(hold, 0, diff, i);
            int rightSum = getSum(hold, 1, diff, i);

            if (comp[i] == '<') {
                if (leftSum >= rightSum) return false;
            } else if (comp[i] == '>') {
                if (leftSum <= rightSum) return false;
            } else {
                if (leftSum != rightSum) return false;
            }
        }

        return true;
    }

    private static int getSum(int hold, int direction, int diff, int depth) {
        int sum = 0;
        for (int j = 0; j < 4; j++) {
            if (map[depth][direction][j] == hold) {
                sum += diff;
            }
        }
        return sum;
    }
}
