package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_21608_상어초등학교 {
    private static class Seat implements Comparable<Seat> {
        int x, y, likeN, emptyN;

        public Seat(int x, int y, int likeN, int emptyN) {
            this.x = x;
            this.y = y;
            this.likeN = likeN;
            this.emptyN = emptyN;
        }

        @Override
        public int compareTo(Seat o) {
            if (likeN == o.likeN) {
                if (emptyN == o.emptyN) {
                    if (x == o.x) {
                        return y - o.y;
                    }
                    return x - o.x;
                }
                return o.emptyN - emptyN;
            }
            return o.likeN - likeN;
        }
    }

    private static class MapSeat {
        int idx;
        List<Integer> nearSeat = new ArrayList<>();

        public MapSeat(int idx) {
            this.idx = idx;
        }
    }

    private static int sz;
    private static MapSeat[][] map;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int[] happy = {0, 1, 10, 100, 1000};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sz = Integer.parseInt(br.readLine());
        map = new MapSeat[sz][sz];
        ArrayList<Integer>[] like = new ArrayList[(sz * sz) + 1];
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                map[i][j] = new MapSeat(0);
                like[(sz * i) + j + 1] = new ArrayList<>();
            }
        }

        for (int i = 0; i < sz * sz; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                like[now].add(Integer.parseInt(st.nextToken()));
            }

            Seat findSeat = findMySeat(like[now]);//자리 찾기
            map[findSeat.x][findSeat.y].idx = now;// 찾은 자리에 앉는다.
            checkNearSeat(now, findSeat);//주변 4방위 자리에 자신의 번호를 추가한다.
        }

        //계산
        int sum = 0;
        for (MapSeat[] mapSeats : map) {
            for (MapSeat mapSeat : mapSeats) {
                int cnt = getLikeCnt(like[mapSeat.idx], mapSeat);
                sum += Math.pow(10, cnt - 1);
            }
        }

        System.out.println(sum);
    }

    private static void checkNearSeat(int now, Seat findSeat) {
        for (int[] mv : move) {
            int movedX = findSeat.x + mv[0];
            int movedY = findSeat.y + mv[1];
            if (movedX < 0 || movedY < 0 || sz <= movedX || sz <= movedY) continue;
            map[movedX][movedY].nearSeat.add(now);
        }
    }

    private static Seat findMySeat(ArrayList<Integer> like) {
        List<Seat> seats = new ArrayList<>();

        for (int p = 0; p < sz; p++) {
            for (int q = 0; q < sz; q++) {
                if (map[p][q].idx != 0) continue;
                //해당 자리와 내가 좋아 하는 사람의 중복수
                int cnt = getLikeCnt(like, map[p][q]);
                seats.add(new Seat(p, q, cnt, findEmptySeat(p, q, map[p][q].nearSeat.size())));
            }
        }
        Collections.sort(seats); //정렬
        return seats.get(0);
    }

    private static int getLikeCnt(ArrayList<Integer> like, MapSeat near) {
        int cnt = 0;
        for (Integer tempS : near.nearSeat) {
            if (like.contains(tempS)) cnt++;
        }
        return cnt;
    }

    private static int findEmptySeat(int p, int q, int size) {
        if (p == sz - 1 || p == 0) {
            if (q == 0 || q == sz - 1) return 2 - size;
            return 3 - size;
        }
        if (q == sz - 1 || q == 0) {
            if (p == sz - 1) return 2 - size;
            return 3 - size;
        }
        return 4 - size;
    }
}
