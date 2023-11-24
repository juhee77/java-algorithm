package 백준.graph.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2668_숫자고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        int[] visited = new int[n];
        HashSet<Integer> ansHash = new HashSet<>();
        int cnt = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            if (ansHash.contains(visited[i])) continue; //이미 사이클을 이룬 경우가 아니라면

            ++cnt;
            int now = i;
            visited[i] = cnt;
            int depth =1;
            while (true) {
                int poll = arr[now];

                if (visited[poll] == cnt) {
                    if (poll == i) {
                        total += depth;
                        ansHash.add(cnt);
                    }
                    break;
                }
                if (visited[poll] != 0) break;
                now = poll;
                visited[poll] = cnt;
                depth++;
            }
        }


        sb.append(total).append("\n");
        for (int i = 0; i < n; i++) {
            if (ansHash.contains(visited[i])) {
                sb.append(i+1).append("\n");
            }
        }
        System.out.println(sb);
    }

}
