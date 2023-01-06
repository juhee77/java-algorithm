package inflearn.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class D_모든아나그램찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] find = br.readLine().toCharArray();

        System.out.println(solution2(new String(arr), new String(find)));
        System.out.println(solution(arr, find));
    }

    public static int solution2(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        for (char x : b.toCharArray()) bm.put(x, bm.getOrDefault(x, 0) + 1);
        int L = b.length() - 1;
        for (int i = 0; i < L; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        int lt = 0;
        for (int rt = L; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);
            if (am.equals(bm)) answer++;
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if (am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
            lt++;
        }
        return answer;
    }

    private static int solution(char[] arr, char[] find) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : find) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        int cnt = 0;
        int lt = 0;
        for (int rt = 0; rt < find.length - 1; rt++) {
            hash.put(arr[rt], hash.getOrDefault(arr[rt], 0) - 1);
            if (hash.get(arr[rt]) == 0) hash.remove(arr[rt]);
        }

        for (int rt = find.length - 1; rt < arr.length; rt++, lt++) {
            hash.put(arr[rt], hash.getOrDefault(arr[rt], 0) - 1);
            if (hash.get(arr[rt]) == 0) hash.remove(arr[rt]);
            if (hash.size() == 0) cnt++;

            hash.put(arr[lt], hash.getOrDefault(arr[lt], 0) + 1);
            if (hash.get(arr[lt]) == 0) hash.remove(arr[lt]);
        }
        return cnt;
    }
}
