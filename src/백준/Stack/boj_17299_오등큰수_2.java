package 백준.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_17299_오등큰수_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[size + 1];
        int[] numCnt = new int[1_000_001];

        //숫자의 개수를 센다 (기수 정렬과 같아 bucket에 담는 방법)
        for (int i = 1; i <= size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            numCnt[arr[i]]++;
        }

        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            int[] temp = new int[]{i, arr[i]}; //인덱스, 해당 숫자
            while (!stack.isEmpty() && numCnt[stack.peek()[1]] < numCnt[temp[1]]) {
                //개수가 더 많은 숫자가 들어오면 해당 값에 따라 앞의 인데스를 채워준다.
                int[] pop = stack.pop();
                ans[pop[0]] = temp[1]; //ans[가능 idx] = arr[i]
            }
            stack.push(temp);
        }

        for (int i = 1; i <= size; i++) {
            sb.append(ans[i] == 0 ? -1 : ans[i]).append(" "); //채워지지 않은 경우 -1
        }
        System.out.println(sb);

    }
}
