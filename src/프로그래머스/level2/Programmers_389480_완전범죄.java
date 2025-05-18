package 프로그래머스.level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Programmers_389480_완전범죄 {
    public int solution(int[][] info, int n, int m) {
        int min = Integer.MAX_VALUE;
        boolean[][] saved;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        for (int[] in : info) {
            int now = queue.size();
            saved = new boolean[n][m];

            for (int j = 0; j < now; j++) {
                int[] poll = queue.poll();
                int nowA = poll[0];
                int nowB = poll[1];
                int mvA = nowA + in[0];
                int mvB = nowB + in[1];
                if (mvA < n && !saved[mvA][nowB]) {
                    queue.add(new int[]{mvA, nowB});
                    saved[mvA][nowB] = true;
                }
                if (mvB < m && !saved[nowA][mvB]) {
                    queue.add(new int[]{nowA, mvB});
                    saved[nowA][mvB] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            min = Math.min(poll[0], min);
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    public static void main(String[] args) {
        Programmers_389480_완전범죄 programmers389480_완전범죄 = new Programmers_389480_완전범죄();
        System.out.println(programmers389480_완전범죄.solution(new int[][]{{1, 2}, {2, 3}, {2, 1}}, 4, 4));
    }

}
