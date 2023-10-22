package 백준.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_4256_트리 {
    private static final Stack<Integer> stack = new Stack<>();
    private static int[] inOrder;
    private static int[] postOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            stack.clear();

            int n = Integer.parseInt(br.readLine());
            inOrder = new int[n];
            postOrder = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                postOrder[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                inOrder[i] = Integer.parseInt(st.nextToken());
            }

            dc(0, n - 1, 0, n -1);
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            sb.append("\n");

        }
        System.out.print(sb);
    }

    private static void dc(int iStart, int iEnd, int pNow,int pEnd) {
        if (iStart == iEnd) {
            stack.push(postOrder[pNow]);
            return;
        }

        int index = find(postOrder[pNow], iStart, iEnd);
        stack.push(postOrder[pNow]);

        //right
        if (index + 1 <= iEnd) {
            dc(index + 1, iEnd, pEnd-(iEnd-index)+1,pEnd);
        }
        //left
        if (iStart <= index - 1) {
            dc(iStart, index - 1, pNow+1,pEnd-(iEnd-index));
        }
    }

    private static int find(int find, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == find) {
                return i;
            }
        }
        throw new IllegalArgumentException(find+" 잘못된 문제");
    }
}
