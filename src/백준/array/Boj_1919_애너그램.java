package 백준.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1919_애너그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String input2 = br.readLine();

        int[] alphabet = new int[26];
        for (char c : input1.toCharArray()) {
            alphabet[c - 'a']++;
        }

        for (char c : input2.toCharArray()) {
            alphabet[c - 'a']--;
        }

        int sum = 0;
        for (int i : alphabet) {
            if (i < 0) sum -= i;
            else sum += i;
        }
        System.out.println(sum);
    }
}
