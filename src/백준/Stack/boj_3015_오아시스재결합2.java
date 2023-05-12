package 백준.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_3015_오아시스재결합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        Stack<int[]> stack = new Stack<>(); //스택에는 점점 작아지는 순으로 사람을 넣는다

        for (int i = 1; i <= n; i++) {
            int now = Integer.parseInt(br.readLine());
            int[] temp = new int[]{now, 1};

            while (!stack.isEmpty() && stack.peek()[0] <= now) {
                //자신보다 작은 친구의 경우에는 볼 수 있음, 키가 자신과 같은 경우에도 볼 수 있음
                int[] pop = stack.pop();
                if (pop[0] == now) { // 같은 키의 사람인 경우를 체크
                    temp[1] += pop[1];
                }
                sum += pop[1];
            }
            if (!stack.isEmpty() && stack.peek()[0] > now) sum += 1;
            //앞에있는 사람이 자신보다 큰 경우 1명만 더한다 ( 앞에 더 큰사람들이 n명 있는 경우에는 한명만 볼 수 있음 )

            stack.push(temp); //자신을 넣는다
        }
        System.out.println(sum);
    }

}
