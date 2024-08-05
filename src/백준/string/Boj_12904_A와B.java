package 백준.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_12904_A와B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        String end = br.readLine();

        while (start.length() < end.length()) {
            if (end.charAt(end.length() - 1) == 'A') {
                end = end.substring(0, end.length() - 1);
            } else if (end.charAt(end.length() - 1) == 'B') {
                end = end.substring(0, end.length() - 1);
                end = new StringBuilder(end).reverse().toString();
            } else {
                break;
            }
        }
        System.out.println(start.equals(end) ? 1 : 0);
    }

}
