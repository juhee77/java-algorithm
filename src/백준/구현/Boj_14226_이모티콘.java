package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj_14226_이모티콘 {
    private static int[][] visited;
    private static Queue<int[]> emojis = new ArrayDeque<>();
    private static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(br.readLine());
        System.out.println(getMinTime());

    }

    private static int getMinTime() {
        visited = new int[target + 1][target + 1];

        emojis.add(new int[]{1, 0}); //이모지 개수, 클립보드에 복사된 개수
        visited[1][0] = 1;

        int time = 1;
        while (!emojis.isEmpty()) {
            time++;
            int size = emojis.size();
            for (int i = 0; i < size; i++) {
                int[] nowStatus = emojis.poll();

                if (nowStatus[0] == target) {
                    return time - 2;
                }


                //1
                int[] nextStatue1 = new int[2];
                nextStatue1[0] = nowStatus[0];
                nextStatue1[1] = nowStatus[0];
                setNextTime(time, nextStatue1);

                //2
                int[] nextStatue2 = new int[2];
                nextStatue2[0] = nowStatus[0] + nowStatus[1];
                nextStatue2[1] = nowStatus[1];
                setNextTime(time, nextStatue2);


                //3
                int[] nextStatue3 = new int[2];
                nextStatue3[0] = nowStatus[0] - 1;
                nextStatue3[1] = nowStatus[1];
                setNextTime(time, nextStatue3);
            }
        }
        return -1;
    }

    private static void setNextTime(int time, int[] nextStatue) {
        if (0 <= nextStatue[0] && nextStatue[0] <= target
                && 0 <= nextStatue[1] && nextStatue[1] <= target
                && visited[nextStatue[0]][nextStatue[1]] == 0) {
            //방문 하지 않은 경우에만
            visited[nextStatue[0]][nextStatue[1]] = time;
            emojis.add(nextStatue);
        }
    }

}
