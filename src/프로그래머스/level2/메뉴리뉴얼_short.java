package 프로그래머스.level2;

import java.util.*;

public class 메뉴리뉴얼_short {

    private static HashMap<String, Integer> hash = new HashMap<>();
    static char[] arr;
    static boolean[] visit;
    static char[] temp;
    private static int max =0;

    private static void find(int n, int m, int d) {
        if (d == m) {
            String s = "";
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) return;
            }
            for (char a : arr) s += a;
            hash.put(s, hash.getOrDefault(s, 0) + 1);
            max = Math.max(max,hash.get(s));

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[d] = temp[i];
                find(n, m, d + 1);
                visit[i] = false;
            }
        }
        return;
    }

    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < course.length; i++) {
            hash.clear();
            max = 0;
            for (String str : orders) {
                temp = str.toCharArray();
                Arrays.sort(temp);
                arr = new char[course[i]];
                visit = new boolean[temp.length];
                find(temp.length, course[i], 0);
            }
            for (String key : hash.keySet()) {
                if (hash.get(key) == max && max >1)
                    pq.offer(key);
            }
        }

        String[] answer = pq.toArray(new String[pq.size()]);
        return answer;


    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 메뉴리뉴얼_short().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(new 메뉴리뉴얼_short().solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }
}
