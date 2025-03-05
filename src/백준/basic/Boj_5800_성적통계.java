package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_5800_성적통계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int now = 1;

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int scores = Integer.parseInt(st.nextToken());
            List<Integer> scoresList = new ArrayList<>();

            for (int i = 0; i < scores; i++)
                scoresList.add(Integer.parseInt(st.nextToken()));
            Collections.sort(scoresList);
            int diffMax = 0;
            for (int i = 0; i < scores - 1; i++)
                diffMax = Math.max(diffMax, scoresList.get(i + 1) - scoresList.get(i));
            sb.append("Class ").append(now++).append("\n");
            sb.append("Max ").append((int) scoresList.get(scoresList.size() - 1))
                    .append(", Min ").append((int) scoresList.get(0))
                    .append(", Largest gap ").append(diffMax).append("\n");
        }
        System.out.println(sb);
    }
}
