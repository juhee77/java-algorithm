package boj.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Boj_30403_무지개만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        Set<Character> lowerNeeded = new HashSet<>(
            Arrays.asList('r', 'o', 'y', 'g', 'b', 'i', 'v')
        );
        Set<Character> upperNeeded = new HashSet<>(
            Arrays.asList('R', 'O', 'Y', 'G', 'B', 'I', 'V')
        );

        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);

            lowerNeeded.remove(c);
            upperNeeded.remove(c);
        }

        boolean canMakeLower = lowerNeeded.isEmpty();
        boolean canMakeUpper = upperNeeded.isEmpty();

        if (canMakeLower && canMakeUpper) {
            System.out.println("YeS");
        } else if (canMakeLower) {
            System.out.println("yes");
        } else if (canMakeUpper) {
            System.out.println("YES");
        } else {
            System.out.println("NO!");
        }

        br.close();
    }
}