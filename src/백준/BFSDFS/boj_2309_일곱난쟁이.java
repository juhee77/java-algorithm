package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2309_일곱난쟁이 {
    public static final int ALL_SIZE = 9;
    public static final int FIND_SIZE = 7;
    public static final int MAX_HEIGHT = 100;
    private static int[] all = new int[ALL_SIZE];
    private static int[] ans = new int[FIND_SIZE];
    private static boolean isAlreadyFind = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ALL_SIZE; i++) {
            all[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(all);

        dfs(0, 0, MAX_HEIGHT);
        for (int i : ans) { // 찾았음
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int nowDepth, int nowStart, int remainHeight) {
        if (nowDepth == FIND_SIZE) {
            if (remainHeight == 0) { //찾음
                isAlreadyFind = true;
            }
            return;
        }

        for (int i = nowStart; i < ALL_SIZE; i++) {
            if (remainHeight < all[i]) return; //남은 키가 현재 사람을 넣을 수 없는 경우(정렬되어 있으므로)

            ans[nowDepth] = all[i];
            dfs(nowDepth + 1, i + 1, remainHeight - all[i]);
            if (isAlreadyFind) return;
        }

    }
}
