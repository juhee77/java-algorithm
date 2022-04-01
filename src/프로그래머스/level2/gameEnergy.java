package 프로그래머스.level2;

import java.util.Arrays;

public class gameEnergy {
    public int[][] permutation(int[][] arr, int[][] out, boolean[] visit, int d, int n, int r) {
        int max =0;
        if (d == r) {
            return out;
        }
        for (int i = 0; i < n; i++) {
            if (visit[i] != true) {
                visit[i] = true;
                out[d][0] = arr[i][0];
                out[d][1] = arr[i][1];
                permutation(arr, out, visit, d + 1, n, r);
                visit[i] = false;
            }
        }
        return new int[][] {{0}};
    }

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int n = 3;
        int[][] output = new int[n][2];
        boolean[] visited = new boolean[n];

      // int[][]permutation(dungeons, output, visited, 0, n, dungeons.length-1,k);

        return answer;
    }

    public static void main(String args[]){
        System.out.println(new gameEnergy().solution(80,new int[][] {{80,20},{50,40},{30,10}}));
    }
}
