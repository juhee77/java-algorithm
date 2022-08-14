package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int line = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        long right = (long) (Math.pow(2,31));
        int left = 1;
        int max= 0;
        int arr[] = new int[line];

        for (int i = 0; i < line; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int tmpMax = 0;
        while (true) {
            int tmpCnt = 0;
            tmpMax = (int) ((right + left) / 2);
            //System.out.println(tmpMax);
            for (int j = 0; j < line; j++) {
                if (tmpMax > arr[j]) continue;
                tmpCnt += (arr[j] / tmpMax);
            }

            if (tmpCnt < goal) {
                right = tmpMax;
            } else if (tmpCnt >= goal) {
                left = tmpMax;
            }
            if (tmpMax == max ) break;
            max =tmpMax;
        }
        System.out.println(max);

    }
}
