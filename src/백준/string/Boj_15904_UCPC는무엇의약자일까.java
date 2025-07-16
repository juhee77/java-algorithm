package 백준.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_15904_UCPC는무엇의약자일까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] found = {'U', 'C', 'P', 'C'};
        int hold = 0;
        for (char c : br.readLine().toCharArray()) {
            if (hold < found.length && c == found[hold]) {
                hold++;
            }
        }

        if (hold == found.length) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }

    }
}
