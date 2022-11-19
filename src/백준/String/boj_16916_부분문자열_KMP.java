package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_16916_부분문자열_KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String find = br.readLine();
        kmp(input, find);
    }

    private static void kmp(String input, String find) {
        int[] kmpTable = kmpTable(find);
        System.out.println(Arrays.toString(kmpTable));
        int len1 = input.length();
        int len2 = find.length();

        int idx = 0;
        for (int i = 0; i < len1; i++) {
            while (idx > 0 && input.charAt(i) != find.charAt(idx)) {
                idx = kmpTable[idx - 1];
            }

            if (input.charAt(i) == find.charAt(idx)) {
                if (idx == len2 - 1) {
                    System.out.println(1);
                    return;
                } else {
                    idx += 1;
                }
            }
        }
        System.out.println(0);
    }


    private static int[] kmpTable(String input) {
        int n = input.length();
        int[] table = new int[n];

        int idx = 0;
        for (int i = 1; i < n; i++) {
            //각 테이블에는 해당 위치까지의 접두사,접미사의 동일 부분의 길이를 가지고 있는다.
            while (idx > 0 && input.charAt(i) != input.charAt(idx)) {
                idx = table[idx - 1];
            }

            if (input.charAt(i) == input.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }
        return table;
    }

}
