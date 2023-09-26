package 백준.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_3649_로봇프로젝트_Re {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) {
                break;
            }

            int goalLen = Integer.parseInt(s) * 10_000_000;

            int blockCnt = Integer.parseInt(br.readLine());
            int[] arr = new int[blockCnt];
            for (int i = 0; i < blockCnt; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int l1 = 0, l2 = arr.length - 1;
            while (l1 < l2) {
                int sum = arr[l1] + arr[l2];
                if (sum == goalLen) {
                    sb.append("yes " + arr[l1] + " " + arr[l2] + "\n");
                    break;
                } else if (sum < goalLen) {
                    l1++;
                } else {
                    l2--;
                }
            }

            if (l2 <= l1) {
                sb.append("danger\n");
            }
        }
        System.out.println(sb);
    }
}
