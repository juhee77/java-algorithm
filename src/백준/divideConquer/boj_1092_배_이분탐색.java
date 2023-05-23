package 백준.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1092_배_이분탐색 {
    private static final List<Integer> cargos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int craneCnt = Integer.parseInt(br.readLine());
        List<Integer> cranes = new ArrayList<>();

        //input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < craneCnt; i++) {
            int now = Integer.parseInt(st.nextToken());
            cranes.add(now);
        }

        int cargoCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cargoCnt; i++) {
            cargos.add(Integer.parseInt(st.nextToken()));
        }

        //sort
        Collections.sort(cranes);
        Collections.sort(cargos);

        //solution
        if (cranes.get(craneCnt - 1) < cargos.get(cargoCnt - 1)) System.out.println(-1); //크래인이 실을 수 있는 무게보다 무거움
        else {
            int cnt = 0;
            while (!cargos.isEmpty()) {
                cnt++;
                for (int i = 0; i < craneCnt && !cargos.isEmpty(); i++) {
                    removeCargo(cranes.get(i));
                }
            }
            System.out.println(cnt);
        }
    }

    private static void removeCargo(int nowCrane) {
        int idx = finMaxLower(nowCrane);
        if (idx != -1) {
            //해당 크래인으로 옮길 수 있는 화물이 있는 경우
            cargos.remove(idx);
        }
    }

    //작은것중 가장 큰것
    private static int finMaxLower(int nowCrane) {
        int start = 0;
        int end = cargos.size() - 1;
        int result = -1; //작은것중에 가장 큰 값

        while (start <= end) {
            int mid = (start + end) >> 1;
            if (cargos.get(mid) <= nowCrane) {
                result = mid; //작은것을 저장한다.
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
