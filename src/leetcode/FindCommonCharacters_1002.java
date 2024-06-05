package leetcode;

import java.util.ArrayList;
import java.util.List;

class FindCommonCharacters_1002 {
    private final int alphabetSize = 26;

    public List<String> commonChars(String[] words) {
        int wordSize = words.length;
        int[][] count = new int[wordSize][alphabetSize];

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < wordSize; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                count[i][c - 'a']++;
            }
            // System.out.println(Arrays.toString(count[i]));
        }

        for (int i = 0; i < alphabetSize; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < wordSize; j++) {
                min = Math.min(min, count[j][i]);
            }

            if (min > 0) {
                String input = String.valueOf((char) (i + 'a'));
                for (int j = 0; j < min; j++)
                    ans.add(input);
            }
        }
        return ans;
    }
}