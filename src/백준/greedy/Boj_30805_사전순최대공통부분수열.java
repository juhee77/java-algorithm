package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_30805_사전순최대공통부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int aLen = Integer.parseInt(br.readLine());
        int[] aArr = new int[aLen];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aLen; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        int bLen = Integer.parseInt(br.readLine());
        int[] bArr = new int[bLen];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bLen; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        //사전순으로 앞선다. 큰 숫자가 앞에 있어야 한다.
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < aLen; i++) {
            for (int j = 0; j < bLen; j++) {
                //현재 숫자가 더 큰 경우는 앞에걸 뺀다.
                if (aArr[i] == bArr[j]) {
                    while (!stack.isEmpty() && stack.peek()[0] < bArr[i] && stack.peek()[1] > j) {
                        int[] pop = stack.pop();
                    }
                    stack.push(new int[]{bArr[j], j});
                }
            }
        }


        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            list.add(pop[0]);
        }

        Queue<String> sets = new ArrayDeque<>();
        sets.add("");
        for (int i = list.size() - 1; 0 <= i; i--) {
            int size = sets.size();
            for (int j = 0; j < size; j++) {
                String poll = sets.poll();
                sets.add(poll);
                sets.add(poll + list.get(i));
            }
        }
        List<String> dice = new ArrayList<>(sets);
        dice.sort(Collections.reverseOrder());

        String s = String.valueOf(dice.get(0));
        sb.append(s.length()).append("\n");
        for (char c : s.toCharArray()) {
            sb.append(c).append(" ");
        }
        System.out.println(sb);
    }
}
