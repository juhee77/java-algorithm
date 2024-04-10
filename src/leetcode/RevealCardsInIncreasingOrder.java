package leetcode;

import java.util.*;

class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!queue.isEmpty()) {
                queue.addFirst(queue.removeLast());
            }
            queue.addFirst(deck[i]);
        }

        int[] ans = new int[deck.length];
        int index = 0;
        for (int num : queue) {
            ans[index++] = num;
        }
        return ans;

    }
}