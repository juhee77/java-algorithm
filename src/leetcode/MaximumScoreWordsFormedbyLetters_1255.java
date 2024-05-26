package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

class MaximumScoreWordsFormedbyLetters_1255 {
    HashMap<Character, Integer> scores = new HashMap<>();
    int[] dict = new int[26];
    String[] words;
    int maxScore = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        for (char letter : letters) {
            int temp = letter - 'a';
            scores.put(letter, score[temp]);
            dict[temp]++;
        }
        dfs(0, 0);
        return maxScore;
    }

    private void dfs(int depth, int score) {
        if (depth == words.length) {
            maxScore = Math.max(maxScore, score);
            return;
        }

        //이 단어를 하지 않은  경우
        dfs(depth + 1, score);

        //이 단어를 한 경우
        int tempScore = 0;
        boolean flag = false;
        ArrayList<Integer> list = new ArrayList<>();

        for (char c : words[depth].toCharArray()) {
            flag = false;
            int charIndex = c - 'a';
            if (scores.containsKey(c) && dict[charIndex] > 0) {
                tempScore += scores.get(c);
                dict[charIndex]--;
                list.add(charIndex);
                flag = true;
            } else {
                //안된다.
                break;
            }
        }

        //다 있으면 마지막에 true로 끝남
        if (flag) {
            dfs(depth + 1, score + tempScore);
        }
        for (Integer i : list) {
            dict[i]++;
        }

    }
}