package leetcode;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

class RelativeRanks_506 {
    public String[] findRelativeRanks(int[] score) {
        ArrayList<Point> pointList = new ArrayList<>();
        for (int i = 0; i < score.length; i++)
            pointList.add(new Point(i, score[i]));


        pointList.sort(Comparator.comparingInt(o -> -o.y));
        String[] ans = new String[score.length];
        String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        int size = pointList.size();
        for (int i = 0; i < size; i++) {
            Point point = pointList.get(i);
            if (i < 3) {
                ans[point.x] = medals[i];
            } else {
                ans[point.x] = String.valueOf(i + 1);
            }
        }
        return ans;
    }
}