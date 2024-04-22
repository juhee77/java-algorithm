package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

class OpentheLock {
    public int openLock(String[] deadends, String target) {
        Queue<Integer> bfs = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];

        for (String deadend : deadends) {
            visited[Integer.valueOf(deadend)] = true;
        }
        if(visited[0]) return -1;

        bfs.add(0);
        visited[0] = true;
        int n = 0;

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            while (size-- > 0) {
                Integer poll = bfs.poll();
                System.out.println(poll);
                if (poll == Integer.parseInt(target)) {
                    return n;
                }

                for (int i = 1; i <= 1000; i *= 10) {
                    // 1 더하기
                    int range = (poll / i) % 10 + 1;
                    int hold;
                    if (range == 10) {
                        hold = -9 * i;
                    } else {
                        hold = i;
                    }

                    int newVal = poll + hold;
                    if (0 <= newVal && newVal < 10000 && !visited[newVal]) {
                        bfs.add(newVal);
                        visited[newVal] = true;
                    }

                    // 1 빼기
                    range = (poll / i) % 10 - 1;
                    if (range == -1) {
                        hold = 9 * i;
                    } else {
                        hold = -i;
                    }

                    newVal = poll + hold;
                    if (0 <= newVal && newVal < 10000 && !visited[newVal]) {
                        bfs.add(newVal);
                        visited[newVal] = true;
                    }
                }
            }
            n++;
        }
        return -1;
    }
}
