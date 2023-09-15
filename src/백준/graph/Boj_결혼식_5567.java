package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_결혼식_5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();

        int m = Integer.parseInt(br.readLine());
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            ArrayList<Integer> aList = hash.getOrDefault(a, new ArrayList<>());
            aList.add(b);
            hash.put(a, aList);

            ArrayList<Integer> bList = hash.getOrDefault(b, new ArrayList<>());
            bList.add(a);
            hash.put(b, bList);
        }


        boolean[] visited = new boolean[n];
        visited[0] = true;
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        for (int i = 0; i < 2; i++) {
            int nowQueueSize = queue.size();
            for (int j = 0; j < nowQueueSize; j++) {
                Integer nowFriend = queue.poll();
                if (hash.containsKey(nowFriend)) {
                    ArrayList<Integer> integers = hash.get(nowFriend);

                    for (Integer nextFriend : integers) {
                        if (!visited[nextFriend]) {
                            cnt++;
                            visited[nextFriend] = true;
                            queue.add(nextFriend);
                        }
                    }
                }
            }
        }
        System.out.println(cnt);

    }
}
