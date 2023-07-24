package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1799_바숍 {

    private static List<int[]> whiteBisop;
    private static List<int[]> blackBisop;
    private static int whiteMax = Integer.MIN_VALUE;
    private static int blackMax = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        whiteBisop = new ArrayList<>();
        blackBisop = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.nextToken().charAt(0) == '1') {

                    if ((i + j) % 2 == 0) {
                        whiteBisop.add(new int[]{i, j});
                    } else {
                        blackBisop.add(new int[]{i, j});
                    }
                }
            }
        }

        blackDfs(new boolean[blackBisop.size()], 0, 0);
        whiteDfs(new boolean[whiteBisop.size()], 0, 0);
        System.out.println(blackMax + whiteMax);
    }

    public static void blackDfs(boolean[] visited, int depth, int checkBisop) {
        if (depth == blackBisop.size()) {
            blackMax = Math.max(checkBisop, blackMax);

        } else {
            //비숍은 2로 표기한다.
            int[] nowBisop = blackBisop.get(depth);

            blackDfs(visited, depth + 1, checkBisop);//그냥 가는것 하나

            if (isPossible(nowBisop, visited, blackBisop)) {
                visited[depth] = true;
                blackDfs(visited, depth + 1, checkBisop + 1);
                visited[depth] = false;
            }
        }
    }

    public static void whiteDfs(boolean[] visited, int depth, int checkBisop) {
        if (depth == whiteBisop.size()) {
            whiteMax = Math.max(whiteMax, checkBisop);

        } else {
            //비숍은 2로 표기한다.
            int[] nowBisop = whiteBisop.get(depth);

            whiteDfs(visited, depth + 1, checkBisop);//그냥 가는것 하나

            if (isPossible(nowBisop, visited, whiteBisop)) {
                visited[depth] = true;
                whiteDfs(visited, depth + 1, checkBisop + 1);
                visited[depth] = false;
            }
        }
    }

    private static boolean isPossible(int[] nowBisop, boolean[] visited, List<int[]> blackBisop) {
        for (int i = 0; i < blackBisop.size(); i++) {
            if (visited[i]) {
                if (Math.abs(nowBisop[0] - blackBisop.get(i)[0]) == Math.abs(nowBisop[1] - blackBisop.get(i)[1])) {
                    return false;
                }
            }
        }
        return true;
    }
}
