package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class FindCenterofStarGraph_1791 {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }

        List<int[]> entities = new ArrayList<>();
        for (Integer key : map.keySet()) {
            entities.add(new int[]{key, map.get(key)});
        }

        Collections.sort(entities, (o1, o2) -> o2[1] - o1[1]);
        return entities.get(0)[0];
    }

    public int findCenter2(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }

        List<int[]> entities = new ArrayList<>();
        for (Integer key : map.keySet()) {
            entities.add(new int[]{key, map.get(key)});
        }

        Collections.sort(entities, (o1, o2) -> o2[1] - o1[1]);
        return entities.get(0)[0];
    }
}