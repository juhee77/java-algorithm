package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_10825_국영수 {
    private static class Score implements Comparable<Score> {
        String name;
        int korea;
        int math;
        int eng;

        public Score(String name, int korea, int eng, int math) {
            this.name = name;
            this.korea = korea;
            this.math = math;
            this.eng = eng;
        }

        @Override
        public int compareTo(Score o) {
            if (korea == o.korea) {
                if (o.eng == eng) {
                    if (math == o.math) {
                        return name.compareTo(o.name);
                    }
                    return o.math - math;
                }
                return eng - o.eng;
            }
            return o.korea - korea;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Score> scores = new ArrayList<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            scores.add(new Score(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(scores);

        for (Score score : scores) {
            sb.append(score.getName()).append("\n");
        }
        System.out.println(sb);
    }
}
