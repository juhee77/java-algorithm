package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_25206_너의평점은 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sumScore = 0;
        double sumSemester = 0;
        while (true) {
            String temp = br.readLine();
            if (temp == null || temp.equals("")) {
                break;
            }

            String[] s = temp.split(" ");

            double semester = Double.parseDouble(s[1]);

            switch (s[2]) {
                case "A+":
                    sumScore += 4.5 * semester;
                    sumSemester += semester;
                    break;
                case "A0":
                    sumScore += 4 * semester;
                    sumSemester += semester;
                    break;
                case "B+":
                    sumScore += 3.5 * semester;
                    sumSemester += semester;
                    break;
                case "B0":
                    sumScore += 3 * semester;
                    sumSemester += semester;
                    break;
                case "C+":
                    sumScore += 2.5 * semester;
                    sumSemester += semester;
                    break;
                case "C0":
                    sumScore += 2.0 * semester;
                    sumSemester += semester;
                    break;
                case "D+":
                    sumScore += 1.5 * semester;
                    sumSemester += semester;
                    break;
                case "D0":
                    sumScore += semester;
                    sumSemester += semester;
                    break;
                case "F":
                    sumSemester += semester;
                    break;
            }

        }
        System.out.printf("%.6f", (sumScore) / sumSemester);
    }
}
