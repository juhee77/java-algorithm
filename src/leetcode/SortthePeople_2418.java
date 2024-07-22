package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SortthePeople_2418 {
    private static class People implements Comparable<People> {
        String name;
        int height;

        public People(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(People o) {
            return o.height - height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        List<People> peoples = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            peoples.add(new People(names[i], heights[i]));
        }

        Collections.sort(peoples);
        return peoples.stream().map(People::getName).toArray(String[]::new);
    }

}