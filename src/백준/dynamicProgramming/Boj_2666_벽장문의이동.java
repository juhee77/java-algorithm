package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2666_벽장문의이동 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); //벽작의 개수
        //초기에 열려있는 두개의 벽장(1부터 시작)
        st = new StringTokenizer(br.readLine());
        int door1 = Integer.parseInt(st.nextToken());
        int door2 = Integer.parseInt(st.nextToken());
        int doorCnt = Integer.parseInt(br.readLine());//사용할 벽장의 순서

        int[] doors = new int[doorCnt];
        for (int i = 0; i < doorCnt; i++) {
            doors[i] = Integer.parseInt(br.readLine());
        }

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        queue.add(new int[]{Math.min(door1, door2), Math.max(door1, door2), 0, 0}); //도어1, 도어2의 위치, 현재 이동한 횟수, 현재 움직여야 할 번호

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[3] == doorCnt) {
                System.out.println(now[2]);
                return;
            }

            //벽장을 안 움직여도 되는 경우
            int nowOpenDoor = doors[now[3]];
            if (now[0] == nowOpenDoor || now[1] == nowOpenDoor) {
                queue.add(new int[]{now[0], now[1], now[2], now[3] + 1});
            } else {
                int minDoor = now[0];
                int maxDoor = now[1];
                if (nowOpenDoor < minDoor) {
                    queue.add(new int[]{nowOpenDoor, maxDoor, now[2] + (minDoor - nowOpenDoor), now[3] + 1});
                } else if (nowOpenDoor < maxDoor) { //중간에 낀 경우 (둥 다 해보기)
                    queue.add(new int[]{nowOpenDoor, maxDoor, now[2] + (nowOpenDoor-minDoor), now[3] + 1});
                    queue.add(new int[]{minDoor, nowOpenDoor, now[2] + (maxDoor-nowOpenDoor), now[3] + 1});
                } else { //maxDoor<nowOpendoor
                    queue.add(new int[]{minDoor, nowOpenDoor, now[2] + (nowOpenDoor - maxDoor), now[3] + 1});
                }
            }
        }

    }
}
