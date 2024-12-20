package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11365_일급비밀 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String temp;
        while (!(temp = br.readLine()).equals("END")) {
            StringBuffer reverse = new StringBuffer().append(temp).reverse();
            sb.append(reverse).append("\n");
        }
        System.out.println(sb);

    }
}
