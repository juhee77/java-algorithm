package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1963_소수경로 {
    private static boolean[] isPrime = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        findPrime();
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 4자리 소수 두 개를 입력 받아서 바꾸는 데 몇 단계가 필요한가
            int ans = solution(a, b);
            sb.append(ans == -1 ? "Impossible" : ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void findPrime() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    private static int solution(int a, int b) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[10001];
        char[] bNums = String.valueOf(b).toCharArray();

        //init
        visited[a] = true;
        queue.add(a);
        int depth = 0;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Integer now = queue.poll();
//                System.out.println(now);
                if (now == b) return depth;

                char[] nowNums = String.valueOf(now).toCharArray();
                for (int j = 0; j < 4; j++) {
                    if (nowNums[j] != bNums[j]) {
                        char hold = nowNums[j];
                        for (char k = '0'; k <= '9'; k++) {
                            if (j == 0 && k == '0') continue;
                            nowNums[j] = k;
                            int next = Integer.parseInt(new String(nowNums));
                            if (isPrime[next] && !visited[next]) {
                                queue.add(next);
                                visited[next] = true;
                            }
                        }
                        nowNums[j] = hold;
                    }
                }
            }

            depth++;
        }
        return -1;
    }
}
