package 리트코드;

import java.util.ArrayDeque;
import java.util.Deque;

class MaximumScoreFromRemovingSubstrings_1717 {
    public StringBuilder sb = new StringBuilder();

    public int maximumGain(String s, int x, int y) {
        // 점수가 높은 패턴 먼저 처리
        sb = new StringBuilder(s);
        if (x > y) {
            return removeAndCount(sb.toString(), 'a', 'b', x) + removeAndCount(sb.toString(), 'b', 'a', y);
        } else {
            return removeAndCount(sb.toString(), 'b', 'a', y) + removeAndCount(sb.toString(), 'a', 'b', x);
        }
    }

    private int removeAndCount(String s, char first, char second, int value) {
        int gain = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop();
                gain += value;
            } else {
                stack.push(c);
            }
        }

        // 남은 문자열
        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return gain;
    }
}
