package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
//문제를 잚못 이해함( 가장 깊은곳에서 가장 깊은곳까지의 가중치의 합

public class boj_1967_트리의지름 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer[]>> arr = new ArrayList<>();
        for (int i = 0; i < line; i++) {
            arr.add(new ArrayList<Integer[]>());
        }
        for (int i = 0; i < line - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            arr.get(parent).add(new Integer[]{parent, child, w});
            arr.get(child).add(new Integer[]{parent, child, w});
        }

        int answer = 0;
        for (int i = 0; i < line; i++) {
            boolean visited[] = new boolean[line];
            int pointans[] = new int[line];
            int tempmax = 0;
            Queue<ArrayList<Integer[]>> q = new LinkedList();
            q.add(arr.get(i));
            visited[i] = true;
            while (!q.isEmpty()) {
                ArrayList<Integer[]> temp = q.poll();
                for (int k = 0; k < temp.size(); k++) {
                    int p = temp.get(k)[0];
                    int c = temp.get(k)[1];
                    int w = temp.get(k)[2];

                    if(visited[p]&&visited[c]) continue;
                    else if(visited[p]){ //p가 전에 방문 했던
                        pointans[c] = pointans[p] + w;
                        q.add(arr.get(c));
                        visited[c] = true;
                        tempmax = Math.max(tempmax, pointans[c]);

                    }
                    else if(visited[c]){ //c가 전에 방문했던
                        pointans[p] = pointans[c] + w;
                        q.add(arr.get(p));
                        visited[p] = true;
                        tempmax = Math.max(tempmax, pointans[p]);
                    }
                }
            }
            answer = Math.max(tempmax,answer);
            //System.out.println(i + 1 + " " + Arrays.toString(pointans) + " " + tempmax + " ");
        }
        System.out.println(answer);

    }
}
