package leetcode;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<String, Integer> set = new HashMap<>();
        set.put("I", 1);
        set.put("IV", 4);
        set.put("V", 5);
        set.put("IX", 9);
        set.put("X", 10);
        set.put("XL", 40);
        set.put("L", 50);
        set.put("XC", 90);
        set.put("C", 100);
        set.put("CD", 400);
        set.put("D", 500);
        set.put("CM", 900);
        set.put("M", 1000);

        int sum = 0;
        int index = 0;
        while (s.length() > index + 1) {
            String temp = "" + s.charAt(index) + s.charAt(index + 1);

            if (set.containsKey(temp)) {
                sum += set.get(temp);
                index += 2;
            } else {
                sum += set.get("" + s.charAt(index));
                index++;
            }
        }

        if (index == s.length() - 1) {
            sum += set.get("" + s.charAt(index));
        }

        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("III")); //3
        System.out.println(romanToInteger.romanToInt("MCMXCIV")); //1994
    }
}
