package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1459_걷기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());
        long oneBlockTime = Long.parseLong(st.nextToken());
        long oneCrossTIme = Long.parseLong(st.nextToken());

        int minD = Math.min(endX, endY);
        int maxD = Math.max(endX, endY);
        int totalD = endX + endY;

        //그냥 한 블럭씩 다 걸어가는 경우
        long justOneBlock = totalD * oneBlockTime;
        //(min,min)방향까지 가서 (max,min) or (min,max)남은 거리를 한블럭씩 걸어가는 경우
        long crossAndBlock = minD * oneCrossTIme + oneBlockTime * (maxD - minD);
        //대각선 비용이 더 싼경우 지그재그로 걸어가는 경우 (짝수이면 딱 맞게 갈 수 있지만 홀수이면 한블럭 전까지만 이동하고 걸어간다)
        long zigzag = ((totalD & 1) == 0) ? maxD * oneCrossTIme : (maxD - 1) * oneCrossTIme + oneBlockTime;

        sb.append(Math.min(zigzag, Math.min(justOneBlock, crossAndBlock)));
        System.out.println(sb);
    }
}
