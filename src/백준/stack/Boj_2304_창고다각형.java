package 백준.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2304_창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<int[]> buildings = new ArrayList<>();
        int maxH = 0, maxLoc = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            if (maxH <= height) {
                if (height == maxH) maxLoc = Math.max(maxLoc, loc);
                else {
                    maxH = height;
                    maxLoc = loc;
                }
            }
            buildings.add(new int[]{loc, height});
        }
        buildings.sort(Comparator.comparingInt(o -> o[0])); //loc기준 정렬


        int ans = 0;
        //왼쪽
        ans += getAnsLeft(buildings, maxLoc);

        //오른쪽(왼쪽에서 온다)
        ans += getRight(buildings, maxLoc);

        System.out.println(ans);
    }

    private static int getAnsLeft(List<int[]> buildings, int maxLoc) {
        int ans = 0;
        int index = 0;
        Stack<int[]> stack = new Stack<>();
        stack.add(buildings.get(index));
        index++;

        while (index < buildings.size() && buildings.get(index)[0] <= maxLoc) {
            int[] now1 = buildings.get(index);
            if (stack.peek()[1] < now1[1]) { //현재값이 스택보다 크다면!
                int[] pop1 = stack.pop();
                ans += (now1[0] - pop1[0]) * pop1[1];
                stack.add(now1);
            }
            index++;
        }

        int[] lastPop = stack.pop();
        ans += (maxLoc - lastPop[0] + 1) * lastPop[1];
        return ans;
    }

    private static int getRight(List<int[]> buildings, int maxLoc) {
        int ans = 0;
        int index = buildings.size() - 1;
        Stack<int[]> stack2 = new Stack<>();
        stack2.add(buildings.get(index));
        index--;

        while (0 <= index && maxLoc < buildings.get(index)[0]) {
            int[] now = buildings.get(index);
            if (stack2.peek()[1] < now[1]) {
                int[] pop = stack2.pop();
                ans += (pop[0] - now[0]) * pop[1];
                stack2.add(now);
            }
            index--;
        }
        int[] lastPop = stack2.pop();
        ans += (lastPop[0] - maxLoc) * lastPop[1];
        return ans;
    }

}
