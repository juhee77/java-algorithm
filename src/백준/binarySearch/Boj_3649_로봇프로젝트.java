package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_3649_로봇프로젝트 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) {
                break;
            }

            int goalLen = Integer.parseInt(s) * 10_000_000;
            int midGolLen = goalLen >> 1;
            int midGolLenCnt = 0;

            int blockCnt = Integer.parseInt(br.readLine());
            arr = new int[blockCnt];
            for (int i = 0; i < blockCnt; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                if (arr[i] == midGolLen) //무조건 짝수임
                    midGolLenCnt++;
            }


            Arrays.sort(arr);

            int l1 = -1, l2 = -1;
            for (int i = 0; i < blockCnt - 1; i++) {
                if (arr[i] == midGolLen) {
                    if (l1 == -1 && midGolLenCnt >= 2) {
                        l1 = l2 = midGolLen;
                    }
                }
                int nextIndex = findMatchLength(i + 1, goalLen - arr[i]);
                if (nextIndex != -1 && (l2 - l1 < arr[nextIndex] - arr[i])) {
                    l1 = arr[i];
                    l2 = arr[nextIndex];
                }
            }

            if (l1 == -1) {
                sb.append("danger \n");
            } else {
                sb.append("yes " + l1 + " " + l2 + "\n");
            }
        }
        System.out.println(sb);

    }

    private static int findMatchLength(int startIndex, int targetLen) {
        int start = startIndex;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) >> 1;
            if (arr[mid] == targetLen) {
                return mid;
            } else if (arr[mid] < targetLen) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
