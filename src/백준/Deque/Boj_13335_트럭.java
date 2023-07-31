package 백준.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_13335_트럭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int busCnt = Integer.parseInt(st.nextToken());//버스 수
        int bridgeLength = Integer.parseInt(st.nextToken());//다리 길이
        int bridgeMaxWeight = Integer.parseInt(st.nextToken());//최대 하중

        int nowTotalWeight = 0; //현재 다리위에 올라왔있는 버스들의 무게의 합
        Deque<int[]> onBridge = new ArrayDeque<>(); //[시간, 무게] 다리위에 올라와있는 버스들
        st = new StringTokenizer(br.readLine());
        int time = 0;
        while (busCnt-- > 0) {
            int weight = Integer.parseInt(st.nextToken()); //이번에 들어갈 버스

            //만약 현재 시간이면 나왔어야 할 차가 있는 경우에는 빼준다.
            //이번에 차가 들어가야하는데 무게가 이미 초과 되었다면 이번 차를 넣을 수 있을때까지 이전에 있던 차를 뺀다.
            while (!onBridge.isEmpty() && (bridgeMaxWeight < weight + nowTotalWeight || onBridge.peek()[0] <= time)) { //가능한 시간까지 뺀다.
                int[] nowCar = onBridge.pollFirst(); //앞의 한 차가 빠져나온다.
                time = nowCar[0]; //가장 마지막 차가 나온시간
                nowTotalWeight -= nowCar[1]; //가장 마지막 차가 나왔으므로 다리에 최대 하중에서 빼준다.
            }

            onBridge.addLast(new int[]{time + bridgeLength, weight}); //해당 차가 나올 시간과, 해당 타의 무게
            nowTotalWeight += weight;//해당 차가 다리위로 올라갔다.
            time++; //한 타임이 지났다(한 타임에는 하나의 차만 보낼 수 있다)
        }
        System.out.println(onBridge.pollLast()[0] + 1); //다리에 있던 차가 모두 빠져나간 순간이기에 1을 더한다.
    }
}
