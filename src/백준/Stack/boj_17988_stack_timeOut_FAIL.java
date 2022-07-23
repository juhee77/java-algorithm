package 백준.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_17988_stack_timeOut_FAIL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int line = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < line; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }


        int arr[]=new int[line];
        int k = line-1;
        int max = stack.peek();
        for (int i = 0; i < line; i++) {
            int temp = stack.pop();
            if(temp>=max) arr[k--]=-1;
            else {
                int x = -1;
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (list.get(j) > temp) {
                        x = list.get(j);
                        break;
                    }
                }
                if (x == -1) arr[k--]=-1;
                else arr[k--]=x;
            }
            max = Math.max(max,temp);
            list.add(temp);
        }

        for(int i=0;i<line;i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);

    }
}
