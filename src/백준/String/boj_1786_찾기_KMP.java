package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1786_찾기_KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String find = br.readLine();
        kmp(input, find);
    }

    private static void kmp(String input, String find) {
        int[] kmpTable = makeKMPTable(find);
        System.out.println(Arrays.toString(kmpTable));
        int inputLen = input.length();
        int findLen = find.length();
        int findCount = 0;
        StringBuilder findLocation = new StringBuilder();

        int idx = 0;
        for (int i = 0; i < inputLen; i++) {
            while (idx > 0 && input.charAt(i) != find.charAt(idx)) {
                idx = kmpTable[idx - 1];
            }
            if (input.charAt(i) == find.charAt(idx)) {
                if (idx == findLen - 1) {
                    findLocation.append(i - findLen + 2).append(" ");
                    findCount++;
                    idx = kmpTable[idx] ;
                } else {
                    idx++;
                }
            }
        }
        System.out.println(findCount);
        System.out.println(findLocation);
    }

    private static int[] makeKMPTable(String find) {
        int strLen = find.length();
        int[] table = new int[strLen];
        int idx = 0;
        for (int i = 1; i < strLen; i++) {
            while (idx > 0 && find.charAt(i) != find.charAt(idx)) {
                idx = table[idx - 1];
            }
            if (find.charAt(i) == find.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }
        return table;
    }
}
