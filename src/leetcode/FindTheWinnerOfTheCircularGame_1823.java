package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class FindTheWinnerOfTheCircularGame_1823 {
    public int findTheWinner(int n, int k) {
        Deque<Integer> integerDeque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            integerDeque.addLast(i);
        }

        System.out.println(integerDeque);

        int last = -1;
        while (!integerDeque.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                Integer poll = integerDeque.pollFirst();
                integerDeque.addLast(poll);
            }
            last = integerDeque.pollFirst();
            System.out.println(last);
        }
        return last;

    }

    public int findTheWinner2(int n, int k) {
        boolean[] visited = new boolean[n];
        int last = 1;

        if(n==1){
            return 1;
        }

        // 큐에 넣고 빼는 방법 (두개의 큐
        for (int i = 0; i < n; i++) {
            int hold = 1;
            while (hold < k) {
                last++;

                if (last >= n)
                    last %= n;
                if (!visited[last])
                    hold++;
            }

            //System.out.println(last);
            visited[last] = true;
            //System.out.println(Arrays.toString(visited));

            while(i!=n-1 && visited[last]){
                last++;
                if (last >= n) last %= n;
            }
        }

        return (last == 0) ? n : last;
    }
}