package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1515_수이어쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = br.readLine().toCharArray();
        int index = 0;

        System.out.println(findMinN(charArray, index));
    }

    private static int findMinN(char[] charArray, int index) {
        int i = 1;
        while (true) {
            char[] nowNum = String.valueOf(i).toCharArray();
            for (char c : nowNum) {
                if (charArray[index] == c) index++;
                if (index == charArray.length) return i;
            }
            i++;
        }
    }
}