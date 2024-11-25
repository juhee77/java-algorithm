package 백준.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11328_Strfry {
    private static int[] alphabets = new int[27];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            char[] aChars = st.nextToken().toCharArray();
            char[] bChars = st.nextToken().toCharArray();

            Arrays.fill(alphabets, 0);
            if (strfry(aChars, bChars)) sb.append("Possible").append("\n");
            else sb.append("Impossible").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean strfry(char[] aChars, char[] bChars) {
        if (aChars.length != bChars.length) return false;
        for (char aChar : aChars)
            alphabets[aChar - 'a']++;

        for (char bChar : bChars) {
            if (alphabets[bChar - 'a']-- == 0) return false;
        }
        return true;
    }
}
