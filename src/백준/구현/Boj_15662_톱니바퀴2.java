package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15662_톱니바퀴2 {
    private static char[][] array;
    private static int[] nowUpPoints;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        array = new char[n][8];
        nowUpPoints = new int[n];
        Arrays.fill(nowUpPoints, 0);
        for (int i = 0; i < n; i++)
            array[i] = br.readLine().toCharArray();

        int turn = Integer.parseInt(br.readLine());
        for (int i = 0; i < turn; i++) {
            st = new StringTokenizer(br.readLine());
            int shell = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            moved(shell, -direction, 0);

//            for (char[] chars : array) {
//                System.out.println(Arrays.toString(chars));
//            }
//            System.out.println(Arrays.toString(nowUpPoints));
//            System.out.println("----------------");
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (array[i][nowUpPoints[i]] == '1') cnt++;
        }
        System.out.println(cnt);

    }

    private static void moved(int shell, int direction, int flag) {
        if (flag == 0 || flag == 1) {
            // 나는 2 오른쪽은 6 // 오른쪽것 이동
            if (shell + 1 < n) {
                int me = getMvPoints(nowUpPoints[shell] + 2);
                int right = getMvPoints(nowUpPoints[shell + 1] + 6);
                if (array[shell][me] != array[shell + 1][right]) {
                    moved(shell + 1, -direction, 1);
                }
            }
        }

        if (flag == 0 || flag == -1) {
            // 왼쪽은 2 나 6 //왼쪽것 이동
            if (0 <= shell - 1) {
                int me = getMvPoints(nowUpPoints[shell] + 6);
                int left = getMvPoints(nowUpPoints[shell - 1] + 2);
                if (array[shell][me] != array[shell - 1][left]) {
                    moved(shell - 1, -direction, -1);
                }
            }
        }

        //나 이동
        nowUpPoints[shell] = getMvPoints(nowUpPoints[shell] + direction);
    }

    private static int getMvPoints(int now) {
        return (now + 8) % 8;
    }

}
