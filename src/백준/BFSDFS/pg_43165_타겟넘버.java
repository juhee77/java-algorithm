package 백준.BFSDFS;

import java.util.Arrays;

public class pg_43165_타겟넘버 {
    private static boolean visited[];
    private static int nums[];
    private static int cnt = 0;
    private static int goal;

    private static void dfs(int n, int d, int tmpsum) {
        if (n == d) {
            if (tmpsum == goal) cnt++;
        } else {
            dfs(n,  d + 1, tmpsum + nums[d]);
            dfs(n, d + 1, tmpsum - nums[d]);
        }
    }


    public int solution(int[] numbers, int target) {
        goal = target;
        nums = numbers.clone();
        visited = new boolean[numbers.length];
        int sum = 0;
        for (int e : numbers) sum += e;
        if (sum == target) return 1;
        else if (sum < target) return 0;
        dfs(numbers.length, 0, 0);

        return cnt;
    }

    public static void main(String[] args) {
        pg_43165_타겟넘버 problem = new pg_43165_타겟넘버();
        System.out.println(problem.solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 10));
        cnt = 0;
        System.out.println(problem.solution(new int[]{4, 1, 2, 1}, 4));
    }
}
