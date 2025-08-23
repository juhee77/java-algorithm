package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_19940_피자오븐 {
    static final int[] times = {60, 10, -10, 1, -1};

    static class State {
        int t;       // 현재 시간
        int[] cnt;   // 버튼 횟수
        State(int t, int[] cnt) {
            this.t = t;
            this.cnt = cnt;
        }
    }

    // 0~59 사이의 시간을 만드는 최적 버튼 조합을 BFS로 구한다.
    static int[][] bfsCache = new int[60][];
    static void preprocess() {
        for (int target = 0; target < 60; target++) {
            boolean[] visited = new boolean[60];
            Queue<State> q = new ArrayDeque<>();

            q.add(new State(0, new int[5]));
            visited[0] = true;
            int[] ans = null;

            while (!q.isEmpty() && ans == null) {
                State cur = q.poll();
                if (cur.t == target) {
                    ans = cur.cnt;
                    break;
                }
                for (int i = 0; i < 5; i++) {
                    int nt = cur.t + times[i];
                    // 0~59 사이에서만 탐색
                    if (nt < 0 || nt >= 60) continue;
                    if (visited[nt]) continue;
                    visited[nt] = true;
                    int[] nextCnt = cur.cnt.clone();
                    nextCnt[i]++;
                    q.add(new State(nt, nextCnt));
                }
            }
            bfsCache[target] = ans;
        }
    }

    public static void main(String[] args) throws IOException {
        preprocess(); // 0~59 모든 경우 미리 BFS 돌려서 캐싱

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int base = N / 60;   // ADDH 기본 횟수
            int r = N % 60;      // 나머지 시간 (0~59)

            int[] ans = bfsCache[r].clone();
            ans[0] += base; // ADDH 횟수 더해줌

            for (int x : ans) sb.append(x).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
