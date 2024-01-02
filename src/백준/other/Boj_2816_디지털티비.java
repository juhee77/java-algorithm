package 백준.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2816_디지털티비 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] channel = new String[n];
        int kbs1 = 0, kbs2 = 0;
        for (int i = 0; i < n; i++) {
            channel[i] = br.readLine();
            if (channel[i].equals("KBS1")) kbs1 = i;
            if (channel[i].equals("KBS2")) kbs2 = i;
        }

        //~~ kbs1, kbs2 ~~
        if (kbs1 > kbs2) {
            kbs2++;
        }

        sb.append("1".repeat(kbs1)).append("4".repeat(kbs1))
                .append("1".repeat(kbs2)).append("4".repeat(kbs2 - 1));
        System.out.println(sb);

    }
}
