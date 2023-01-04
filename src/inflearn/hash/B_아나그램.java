package inflearn.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B_아나그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : str1) {
            count.put(c,count.getOrDefault(c,0)+1);
        }

        for (char c : str2) {
            count.put(c,count.getOrDefault(c,0)-1);
        }

        System.out.println(checkingAnagram(count)?"YES":"NO");
        System.out.println(solution(str2,str1));
    }

    private static String solution(char[] str2, char[] str1) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : str1) {
            count.put(c,count.getOrDefault(c,0)+1);
        }


        for (char c : str2) {
            if (!count.containsKey(c) || count.get(c) == 0) {
                return "NO";
            }
            count.put(c,count.getOrDefault(c,0)-1);
        }
        return "YES";
    }

    private static boolean checkingAnagram(HashMap<Character, Integer> count) {
        for (Integer value : count.values()) {
            if(value!=0) return false;
        }
        return true;
    }
}
