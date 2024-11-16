package 백준.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_19700_수업 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<int[]> students = new ArrayList<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            students.add(new int[]{a, b});
        }
        students.sort(Comparator.comparingInt(o -> -o[0]));

        TreeMap<Integer, Integer> groups = new TreeMap<>();
        for (int[] student : students) {
            if (groups.lowerKey(student[1]) == null) {
                //자신이 들어갈 수 있는 그룹이 없는 경우 새로 그룹을 만든다 이때 1명인 그룹이 N개의 집합으로 처리한다.
                groups.put(1, groups.getOrDefault(1, 0) + 1);
            } else {
                int key = groups.lowerKey(student[1]);
                groups.put(key + 1, groups.getOrDefault(key + 1, 0) + 1);

                if (groups.get(key) == 1)
                    groups.remove(key);
                else
                    groups.put(key, groups.get(key) - 1);
            }
        }
        System.out.println(groups.values().stream().mapToInt(value -> value).sum());
    }
}
