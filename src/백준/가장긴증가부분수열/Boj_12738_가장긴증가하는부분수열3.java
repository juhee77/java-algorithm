package 백준.가장긴증가부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_12738_가장긴증가하는부분수열3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer> graph = new ArrayList<>();
        graph.add(-1000000001);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (graph.get(graph.size() - 1) < next) {
                graph.add(next);
            } else {
                //자리를 찾아서 바꿔 넣어준다.
                int start = 0;
                int end = graph.size() - 1;
                int mid;
                int findIndex = 0;
                while (start <= end) {
                    mid = (start + end) >> 1;
                    if (graph.get(mid) < next) {
                        start = mid + 1;
                    } else {
                        findIndex = mid;
                        end = mid - 1;
                    }
                }
                graph.set(findIndex, next);
            }
//            System.out.println(graph);
        }
        System.out.println(graph.size() - 1);
    }
}
