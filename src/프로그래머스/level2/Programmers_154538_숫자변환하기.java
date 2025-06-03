package 프로그래머스.level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Programmers_154538_숫자변환하기 {
    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[y + 1];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(x);

        int turn = 0;
        boolean flag = false;
        while (!que.isEmpty()) {
            int size = que.size();
            flag = false;
            for (int i = 0; i < size; i++) {
                int temp = que.poll();
                if (temp == y) {
                    flag = true;
                    break;
                }

                int next = temp + n;
                if (isAble(next, y, visited)) {
                    que.add(next);
                    visited[next] = true;
                }

                next = temp * 2;
                if (isAble(next, y, visited)) {
                    que.add(next);
                    visited[next] = true;
                }

                next = temp * 3;
                if (isAble(next, y, visited)) {
                    que.add(next);
                    visited[next] = true;
                }
            }

            if (flag) break;

            turn++;
        }

        if (!flag) return -1;
        return turn;
    }

    public boolean isAble(int number, int limit, boolean[] visited) {
        if (number <= limit && !visited[number]) return true;
        return false;
    }

    public static void main(String[] args) {
        Programmers_154538_숫자변환하기 solution = new Programmers_154538_숫자변환하기();
        System.out.println(solution.solution(10, 40, 5));
        System.out.println(solution.solution(10, 40, 30));
        System.out.println(solution.solution(2, 5, 4));
    }
}
