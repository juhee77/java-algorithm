package 백준.Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj_1655_가운데를말해요 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());

        solution(br, line);
        System.out.println(sb);
    }

    private static void solution(BufferedReader br, int line) throws IOException {
        if (line == 1) {
            sb.append(Integer.parseInt(br.readLine()));
            return;
        }

        //두개의 큐를 이용한다.
        PriorityQueue<Integer> leftQue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightQue = new PriorityQueue<>();
        //앞두개의 값은 미리 계산한다.(왼쪽에 작은값이 들어가도록)
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        leftQue.add(Math.min(a, b));
        rightQue.add(Math.max(a, b));
        sb.append(a).append("\n");
        sb.append(Math.min(a, b)).append("\n");

        //값을 넣으면서 왼쪽의 가장 큰 값을 출력한다.
        for (int i = 2; i < line; i++) {
            int now = Integer.parseInt(br.readLine());
            move(leftQue, rightQue, now);
            //System.out.println(leftQue.toString()+" "+rightQue.toString());
            sb.append(leftQue.peek()).append("\n");
        }
    }

    private static void move(PriorityQueue<Integer> leftQue, PriorityQueue<Integer> rightQue, int now) {
        if (leftQue.size() == rightQue.size()) { //두 큐의 사이즈가 큰경우 왼쪽 큐에 값이 증가해야함
            if (rightQue.peek() < now) {  //해당 값이 오른쪽 큐에 들어가야하는 경우 오른쪽 값 하나 왼쪽으로 이동 시킴
                rightQue.add(now);
                leftQue.add(rightQue.poll());
            } else {
                leftQue.add(now);
            }
        } else {   // 두 큐의 사이즈가 다른경우는 왼쪽큐가 더 많은 경우임
            if (rightQue.peek() > now) { // 해당 값이 왼쪽에 들어가야하는 경우 왼쪽 값 하나를 오른쪽 이동시킴
                leftQue.add(now);
                rightQue.add(leftQue.poll());
            } else {
                rightQue.add(now);
            }
        }
    }
}
