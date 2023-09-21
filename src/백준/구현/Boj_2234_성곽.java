package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2234_성곽 {
    public static int row, col;
    private static int[][] map;
    private static int[][] visitedRoom;
    private static final HashMap<Integer, Integer> coloredRoom = new HashMap<>();
    private static final int[][] dirs = new int[][]{{1, 0, -1}, {4, 0, 1}, {2, -1, 0}, {8, 1, 0}};
    private static int maxRoomSize = 0, maxNearRoomSize = 0;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        visitedRoom = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solution() {
        StringBuilder sb = new StringBuilder();

        int roomCnt = 0;
        int color = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visitedRoom[i][j] == 0) {
                    coloringRoom(color++, i, j);
                    roomCnt++;
                }
            }
        }

        sb.append(roomCnt).append("\n").append(maxRoomSize).append("\n").append(maxNearRoomSize);
        System.out.println(sb);
    }

    private static void coloringRoom(int color, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visitedRoom[x][y] = color;

        int colorCnt = 1;
        List<Integer> otherNearColor = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            int nowX = poll[0];
            int nowY = poll[1];
            for (int[] dir : dirs) {

                int mvX = nowX + dir[1];
                int mvY = nowY + dir[2];

                if (mvX < 0 || mvY < 0 || row <= mvX || col <= mvY) {
                    //영역 넘어감
                    continue;
                }
                if (visitedRoom[mvX][mvY] != 0) {
                    //만약 벽이 있는데 이미 방문 된 경우
                    if (visitedRoom[mvX][mvY] != color) {
                        //현재 색이 아닌경우 (인접 방 리스트에 해당 색 저장)
                        otherNearColor.add(visitedRoom[mvX][mvY]);
                    }
                    continue;
                }

                if ((dir[0] & map[nowX][nowY]) == 0) {
                    //벽이 없는 경우만이동 가능
                    q.add(new int[]{mvX, mvY});
                    visitedRoom[mvX][mvY] = color;
                    colorCnt++;
                }
            }
        }

        //벽 하나를 부시는 경우
        for (Integer otherColor : otherNearColor) {
            Integer otherColorRoomSize = coloredRoom.get(otherColor);
            maxNearRoomSize = Math.max(maxNearRoomSize, colorCnt + otherColorRoomSize);
        }

        maxRoomSize = Math.max(maxRoomSize, colorCnt);
        coloredRoom.put(color, colorCnt);
    }
}
