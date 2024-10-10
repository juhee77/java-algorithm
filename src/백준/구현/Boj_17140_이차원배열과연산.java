package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_17140_이차원배열과연산 {

    public static final int MAX_SIZE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[MAX_SIZE][MAX_SIZE];
        int nowRow = 3;
        int nowCol = 3;
        int maxRow = 3;
        int maxCol = 3;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        HashMap<Integer, Integer> set = new HashMap<>();
        PriorityQueue<int[]> temp = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {//개수 같으면 숫자 커지게
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for (int time = 0; time <= 100; time++) {
//            System.out.println("========" + time + "======================");
//            for (int[] ints : arr) {
//                System.out.println(Arrays.toString(ints));
//            }

            if (r < nowRow && c < nowCol && arr[r][c] == k) {
                System.out.println(time);
                return;
            }

            if (nowRow >= nowCol) {
                //R
                for (int i = 0; i < nowRow; i++) {
                    set.clear();
                    for (int j = 0; j < nowCol; j++) {
                        set.put(arr[i][j], set.getOrDefault(arr[i][j], 0) + 1);
                        arr[i][j] = 0;
                    }

                    set.remove(0);
                    for (Integer key : set.keySet()) {
                        temp.add(new int[]{key, set.get(key)});
                    }

                    int hold = 0;
                    while (!temp.isEmpty() && hold < MAX_SIZE) {
                        int[] poll = temp.poll();
                        arr[i][hold++] = poll[0];
                        arr[i][hold++] = poll[1];
                    }
                    maxCol = Math.max(maxCol, hold);
                }
                nowCol = maxCol;
            } else {
                //C
                for (int i = 0; i < nowCol; i++) {
                    set.clear();
                    for (int j = 0; j < nowRow; j++) {
                        set.put(arr[j][i], set.getOrDefault(arr[j][i], 0) + 1);
                        arr[j][i] = 0;
                    }
                    set.remove(0);

                    for (Integer key : set.keySet()) {
                        temp.add(new int[]{key, set.get(key)});
                    }

                    int hold = 0;
                    while (!temp.isEmpty() && hold < MAX_SIZE) {
                        int[] poll = temp.poll();
                        arr[hold++][i] = poll[0];
                        arr[hold++][i] = poll[1];
                    }
                    maxRow = Math.max(maxRow, hold);
                }
                nowRow = maxRow;
            }
        }
        System.out.println(-1);
    }
}
