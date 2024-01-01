package 백준.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_6549_히스토그램에서가장큰직사각형2 {
    private static int cnt;
    private static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        cnt = Integer.parseInt(st.nextToken());

        //왼쪽부터 오른쪽 n개
        while (cnt != 0) {
            Stack<Integer> stack = new Stack<>();
            //위로 쌓일 수록 큰 사이즈 (점점 커지는 사이즈로 넣기 때문에 현재 인덱스에서 표시된 위치까지의 min은 들어있는 height[index] 의 값이다
            long max = 0;

            height = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                height[i] = Integer.parseInt(st.nextToken());

                int pop = -1;
                while (!stack.isEmpty() && height[stack.peek()] > height[i]) {

                    pop = stack.pop();
                    max = Math.max(max, (long) height[pop] * (i - pop));
                    height[pop] = height[i];
                    //앞에것의 인덱스의 높이를 바꾼다.
                }

                if (pop != -1) stack.push(pop);
                else stack.push(i);

            }

            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                max = Math.max(max, (long) height[pop] * (cnt - pop));
            }

            sb.append(max).append("\n");
            st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);

    }
}
