package 백준.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_13334_철로_sweeping {

    private static final List<int[]> map = new ArrayList<>();
    private static final PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        while (line-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.add(new int[]{Math.min(start, end), Math.max(start, end)});
        }
        int railLength = Integer.parseInt(br.readLine());

        //기준점을 잘 찾아야 한다 (정렬 기준!!!)
        map.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int max = 0;

        for (int[] now : map) {
            //System.out.println(now[0] + " " + now[1]);
            int start = now[0];
            int end = now[1];
            if (railLength < end - start) continue; //길이가 넘어가는 경우

            while (!queue.isEmpty() && end > queue.peek() + railLength) {
                queue.poll();
            }

            queue.add(start);
            max = Math.max(queue.size(), max);
        }
        System.out.println(max);
    }
}

