package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_12100_2048 {
    private static int sz;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sz = Integer.parseInt(br.readLine());
        int[][] arr = new int[sz][sz];

        for (int i = 0; i < sz; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < sz; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        allCombination(arr, 0);
        System.out.println(max);
    }

    private static void allCombination(int[][] nowArr, int d) {
        if (d < 5) {
            int[][] arr;

            //기본 왼쪽
            move(d, nowArr);

            //오른쪽 이동
            arr = right(nowArr);
            move(d, arr);

            //아래쪽 이동
            arr = down(nowArr);
            move(d, arr);

            //위쪽 이동
            arr = up(nowArr);
            move(d, arr);

        }
    }

    private static void move(int d, int[][] arr) {
        arr = move(arr);
        allCombination(arr, d + 1);
    }


    //y값을 반대로
    private static int[][] right(int[][] nowArr) {
        int[][] temp = new int[sz][sz];
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                temp[i][j] = nowArr[i][sz - 1 - j];
            }
        }
        return temp;
    }


    //y축 값을 x축 값으로
    private static int[][] up(int[][] nowArr) {
        int[][] temp = new int[sz][sz];
        for (int j = 0; j < sz; j++) {
            for (int i = 0; i < sz; i++) {
                temp[i][j] = nowArr[j][i];
            }
        }
        return temp;
    }

    //y축 값을 x축 값으로, y값 반대로
    private static int[][] down(int[][] nowArr) {
        int[][] temp = new int[sz][sz];
        for (int j = 0; j < sz; j++) {
            for (int i = 0; i < sz; i++) {
                temp[i][j] = nowArr[sz - 1 - j][i];
            }
        }
        return temp;
    }

    //모든 동작을 왼쪽으로 이동하는것처럼 설정
    private static int[][] move(int[][] nowArr) {
        int[][] temp = new int[sz][sz];

        for (int i = 0; i < sz; i++) {
            int nowPoint = 0;

            int[] tmp = Arrays.stream(nowArr[i]).filter(x -> x > 0).toArray();

            int j = 0;
            while (j < tmp.length) {

                if (j < tmp.length - 1 && tmp[j] == tmp[j + 1]) {
                    temp[i][nowPoint++] = tmp[j] * 2;
                    j++;
                }
                else
                    temp[i][nowPoint++] = tmp[j];

                j++;
                max = Math.max(max, temp[i][nowPoint - 1]);
            }
        }
        return temp;
    }

}
