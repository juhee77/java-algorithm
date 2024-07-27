package leetcode;

import java.util.Arrays;
import java.util.HashMap;

class MinimumCosttoConvertI_2976 {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int max = (int) 1e7;

        //인덱스 생성
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            if (!map.containsKey(original[i])) map.put(original[i], map.size());
            if (!map.containsKey(changed[i])) map.put(changed[i], map.size());
        }

        int[][] dir = new int[map.size()][map.size()];
        for (int i = 0; i < map.size(); i++) {
            Arrays.fill(dir[i], max);
            dir[i][i] = 0;
        }


        for (int i = 0; i < original.length; i++) {
            int start = map.get(original[i]);
            int end = map.get(changed[i]);
            dir[start][end] = Math.min(dir[start][end], cost[i]);
        }

        for (int p = 0; p < map.size(); p++) {
            for (int i = 0; i < map.size(); i++) {
                for (int j = 0; j < map.size(); j++) {
                    dir[i][j] = Math.min(dir[i][j], dir[i][p] + dir[p][j]);
                }
            }
        }
        // System.out.println(map.keySet());

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            // System.out.println(source.charAt(i)+" "+map.get(source.charAt(i)));
            int start = map.getOrDefault(source.charAt(i), -1);
            int end = map.getOrDefault(target.charAt(i), -1);

            if (start == -1 || end == -1 || dir[start][end] == max) return -1;
            ans += dir[start][end];
        }
        return ans;
    }
}