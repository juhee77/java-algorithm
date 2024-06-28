package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class MaximumTotalImportanceofRoads_2285 {
    private static class Road implements Comparable<Road> {
        int key;
        long value;

        public Road(int key, long value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Road o) {
            return Long.compare(o.value, value);
        }
    }

    public long maximumImportance(int n, int[][] roads) {
        HashMap<Integer, Long> map = new HashMap<>();
        for (int[] road : roads) {
            map.put(road[0], map.getOrDefault(road[0], 0L) + 1);
            map.put(road[1], map.getOrDefault(road[1], 0L) + 1);
        }


        List<Road> entities = new ArrayList<>();
        for (Integer key : map.keySet()) {
            entities.add(new Road(key, map.get(key)));
        }

        Collections.sort(entities);

        long sum = 0;
        int hold = n;
        for (Road road : entities) {
            sum += (hold--) * road.value;
        }
        return sum;
    }
}