package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H_수열추측하기 {
    private static int[] arr;
    private static boolean flag;
    private static boolean[] visited;
    static int[][] dp = new int[34][34];
    static int[] memoryCombination = new int[34];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int line = Integer.parseInt(st.nextToken());
        int ans = Integer.parseInt(st.nextToken());

//        System.out.println("====== solution ======");
//        dfs(1, line, new int[]{ans});
//        System.out.println("====== solution ======");

        System.out.println("====== solution1 ======");
        arr = new int[line];
        visited = new boolean[line];
        flag = false;
        find(0, line, ans);
        if (flag) printArr();
        System.out.println();

        System.out.println("====== solution2 ======");
        for (int i = 0; i < line; i++) {
            memoryCombination[i] = combination(line - 1, i);
        }
        arr = new int[line];
        visited = new boolean[line];
        flag = false;
        find2(0, 0, line, ans);

    }

    private static void printArr() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void find2(int depth, int sum, int line, int ans) {
        if (flag) return;
        if (depth == line) {
            if (sum == ans) {
                System.out.println("H_수열추측하기.find2");
                System.out.println(Arrays.toString(arr));
                flag = true;
            }
        } else {
            for (int i = 1; i <= line; i++) {
                if (!visited[i - 1]) {
                    visited[i - 1] = true;
                    arr[depth] = i;
                    find2(depth + 1, sum + memoryCombination[depth] * arr[depth], line, ans);
                    visited[i - 1] = false;
                }
            }
        }
    }


    private static void find(int depth, int line, int ans) {
        if (flag) return;
        if (depth == line) {

            //check 를 combination 로 훨씬 빠르고 이후에도 이용 가능하다.
            if (check(line, ans)) {
                System.out.println("H_수열추측하기.find");
                System.out.println(Arrays.toString(arr));
                flag = true;
            }
        } else {
            for (int i = 1; i <= line; i++) {
                if (!visited[i - 1]) {
                    visited[i - 1] = true;
                    arr[depth] = i;
                    find(depth + 1, line, ans);
                    if (flag) return;
                    visited[i - 1] = false;
                }
            }
        }
    }

    private static boolean check(int line, int ans) {
        int nowL = line - 1;
        int[] temp = arr.clone();
        while (1 <= nowL) {
            int[] next = new int[nowL];
            for (int i = 0; i < nowL; i++) {
                next[i] = temp[i] + temp[i + 1];
            }
            nowL--;
            //System.out.println(Arrays.toString(next));
            temp = next.clone();
        }
        return temp[0] == ans;
    }

    private static int combination(int n, int r) {
        if (dp[n][r] != 0) return dp[n][r];
        if (n == r || r == 0) return dp[n][r] = 1;
        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }

//    private static void dfs(int nowDepth, int line, int[] ints) {
//        if (nowDepth == line) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        } else {
//            //System.out.println(Arrays.toString(ints));
//            int[] nextLine = new int[nowDepth + 1];
//
//            for (int i = 1; i < ints[0]; i++) {
//                nextLine[0] = i;
//
//                boolean flag = false;
//                for (int j = 1; j <= nowDepth; j++) {
//                    nextLine[j] = ints[j - 1] - nextLine[j - 1];
//                    if (nextLine[j] < 1) flag = true;
//                }
//                if (flag) continue;
//
//                dfs(nowDepth + 1, line, nextLine);
//            }
//        }
//    }
}
