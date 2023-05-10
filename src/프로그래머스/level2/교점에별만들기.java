package 프로그래머스.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 교점에별만들기 {
    // 형 변환의 중요성, 문제에서 반례 케이스를 찾아내는 방법
    private static long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
    private static long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
    private static final List<long[]> points = new ArrayList<>();

    public String[] solution(int[][] line) {
        for (int i = 0; i < line.length; i++) {
            int[] nowLine = line[i];
            for (int j = i + 1; j < line.length; j++) {
                //두점의 교점을 찾아서 넣는다.
                int[] tempLine = line[j];
                double bottom = (double) nowLine[0] * tempLine[1] - nowLine[1] * tempLine[0];

                if (bottom == 0) {
                    continue; //평행또는 일치
                }

                double x = ((double) nowLine[1] * tempLine[2] - nowLine[2] * tempLine[1]) / bottom;
                double y = ((double) nowLine[2] * tempLine[0] - nowLine[0] * tempLine[2]) / bottom;

                if (x % 1 == 0 && y % 1 == 0) {
                    addPoint((long) x, (long) y);
                }
            }
        }

        if (maxY - minY + 1 > 1000 || maxX - minX + 1 > 1000) return new String[]{};
        char[][] map = new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];

        for (int i = 0; i < maxY - minY + 1; i++) {
            Arrays.fill(map[i], '.');
        }

        //x,y의 위치를 변경하여
        for (long[] tmp : points) {
            long x = tmp[1] - minY;
            long y = tmp[0] - minX;
            map[(int) x][(int) y] = '*';
        }

        String[] answer = new String[map.length];
        for (int i = 0; i < map.length; i++) {
            answer[i] = new String(map[map.length - i - 1]);
        }

        return answer;
    }

    private void addPoint(long x, long y) {
        points.add(new long[]{x, y});
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 교점에별만들기().solution(new int[][]{{5, 1, 4}, {2, -1, 4}
                , {2, -1, 4}
                , {3, -1, 4}
                , {4, -1, 4}
                , {5, -1, 4}
                , {6, -1, 4}
                , {7, 3, 4}
                , {5, 1, 4}
                , {123, -11, 4}
                , {2, -123, 45}})));
    }

}
