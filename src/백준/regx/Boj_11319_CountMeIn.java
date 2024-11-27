package 백준.regx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_11319_CountMeIn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashSet<Character> vowelsSet = new HashSet<>(List.of('A','E','I','O','U','a','e','i','o','u'));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int vowels = 0;
            int consonants = 0;
            char[] chars = br.readLine().toCharArray();
            for (char aChar : chars) {
                if(aChar==' ')continue;
                if (vowelsSet.contains(aChar)) vowels++;
                else consonants++;
            }
            sb.append(consonants + " " + vowels).append("\n");
        }
        System.out.println(sb);
    }
}
