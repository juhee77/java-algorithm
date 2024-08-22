package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16562_친구비 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        //전체 인원, 친구 관계, 예산
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        List<List<Integer>> graph = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (l-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n && ans <= k; i++) {
            int minMoney = arr[i];
            if (!visited[i]) {
                if (graph.get(i).size() == 0) {
                    visited[i] = true;
                } else {
                    Queue<Integer> q = new ArrayDeque<>(graph.get(i));
                    while (!q.isEmpty()) {
                        int qSize = q.size();
                        while (qSize-- > 0) {
                            Integer nextFriend = q.poll();
                            if (!visited[nextFriend] || arr[nextFriend] < minMoney) {
                                visited[nextFriend] = true;
                                minMoney = Math.min(minMoney, arr[nextFriend]);
                                q.addAll(graph.get(nextFriend));
                            }
                        }
                    }
                }
                ans += minMoney;
            }
        }

        System.out.println(ans > k ? "Oh no" : ans);
    }
}
