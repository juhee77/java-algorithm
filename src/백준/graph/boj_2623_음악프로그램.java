package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2623_음악프로그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n + 1];

        Queue<Integer> before = new LinkedList<>();
        boolean flag = false;

        for (int i = 0; i < m; i++) {
            int temp[] = new int[n + 1]; // 현재 순서 저장
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); //몇명의 순서를 정했는지

            int rank = 1;
            for (int j = 0; j < num; j++) {
                int cel = Integer.parseInt(st.nextToken());
                if (temp[cel] != 0) {
                    System.out.println(0);
                    flag = true;
                    break;
                }
                if (arr[cel] == 0) temp[cel] = rank++;//이전에 기록된적이 없는경우
                else {
                    while (!before.isEmpty() && before.peek() != cel) {
                        int pool = before.poll();
                        if (temp[pool] == 0) temp[pool] = rank ++;
                    }
                    before.poll();
                    if(temp[cel]==0) temp[cel]= rank ++;
                }
            }
            if (flag) break;
            while (!before.isEmpty()) {
                int pool = before.poll();
                temp[pool] = rank ++;
            }


            int sort[] = new int[n + 1];
            before.clear();
            arr = temp.clone();
            for (int j = 0; j <= n; j++) if (arr[j] != 0) sort[arr[j]] = j;
            //System.out.println(Arrays.toString(sort));
            for (int j = 0; j <= n; j++) if (sort[j] != 0) before.add(sort[j]);
            //System.out.println(Arrays.toString(before.toArray()));
        }

        if (!flag) {
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<=n;i++){
                if(before.contains(i))continue;
                else before.add(i);
            }
            while(!before.isEmpty()) sb.append(before.poll()).append("\n");

            System.out.println(sb);

        }
    }
}
/*
6 4
2 3 5
2 1 6
2 2 4
2 1 2 6
이런경우 안된다.
 */