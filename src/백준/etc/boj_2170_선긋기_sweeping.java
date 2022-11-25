package 백준.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2170_선긋기_sweeping {
    private static class Line {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Line> allLine = new ArrayList<>();

        int line = Integer.parseInt(br.readLine());
        while (line-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            allLine.add(new Line(start, end));
        }

        allLine.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        int start = allLine.get(0).start;
        int end = allLine.get(0).end;
        int ans = 0;
        //종료 시점을 옮긴다
        for (Line now : allLine) {
            if (now.start < end) {
                end = Math.max(end, now.end);
            } else {
                //만약 시작점이 이전의 종료 시점보다 뒤에 있다면 선분을 새로 시작해야한다.
                ans += end - start;
                start = now.start;
                end = now.end;
            }
        }
        ans += end - start; //마지막 값 계산

        System.out.println(ans);
    }
}
