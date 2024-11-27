package 백준.regx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_11319_CountMeIn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        HashSet<Character> characters = new HashSet<>();
        characters.add('a','e','i','o','u','y')
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            char[] chars = br.readLine().toCharArray();
            for (char aChar : chars) {
                if(aChar == 'a')
            }
        }
    }
}
