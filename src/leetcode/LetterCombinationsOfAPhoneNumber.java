package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    private final List<String> combinations = new ArrayList<>();
    private final Map<Character, char[]> phoneMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        phoneMap.put('2', new char[]{'a', 'b', 'c'});
        phoneMap.put('3', new char[]{'d', 'e', 'f'});
        phoneMap.put('4', new char[]{'g', 'h', 'i'});
        phoneMap.put('5', new char[]{'j', 'k', 'l'});
        phoneMap.put('6', new char[]{'m', 'n', 'o'});
        phoneMap.put('7', new char[]{'p', 'q', 'r', 's'});
        phoneMap.put('8', new char[]{'t', 'u', 'v'});
        phoneMap.put('9', new char[]{'w', 'x', 'y', 'z'});

        generateCombinations(digits, 0, new StringBuilder());
        return combinations;
    }

    private void generateCombinations(String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        if (!phoneMap.containsKey(digit)) {
            return;
        }

        char[] letters = phoneMap.get(digit);
        for (char letter : letters) {
            current.append(letter);
            generateCombinations(digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
