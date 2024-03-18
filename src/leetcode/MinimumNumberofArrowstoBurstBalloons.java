package leetcode;

import java.util.PriorityQueue;

public class MinimumNumberofArrowstoBurstBalloons {
    private static class Point implements Comparable<Point> {
        int startX;
        int endX;

        Point(int startX, int endX) {
            this.startX = startX;
            this.endX = endX;
        }

        @Override
        public int compareTo(Point other) {
            if (this.startX == other.startX) {
                return Long.compare(this.endX, other.endX);
            }
            return Long.compare(this.startX, other.startX);
        }

        public String toString() {
            return startX + " " + endX;
        }
    }

    public int findMinArrowShots(int[][] points) {
        PriorityQueue<Point> pointList = new PriorityQueue<>();
        for (int[] point : points) {
            pointList.add(new Point(point[0], point[1]));
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int shot = 0;
        queue.add(pointList.poll().endX);
        while (!pointList.isEmpty()) {
            if (!queue.isEmpty() && queue.peek() < pointList.peek().startX) {
                queue.clear();
                shot++;
            }

            queue.add(pointList.poll().endX);
        }
        if (!queue.isEmpty())
            shot++;

        return shot;
    }
}
