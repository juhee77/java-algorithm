package 프로그래머스.level2;

import java.util.HashMap;

public class Programmers_131127_할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> dict = new HashMap<>();

        for (int i = 0; i < discount.length; i++) {
            dict.put(discount[i], dict.getOrDefault(discount[i], 0) + 1);

            if (i >= 10) {
                String out = discount[i - 10];
                dict.put(out, dict.get(out) - 1);
            }

            if (i >= 9) {
                boolean flag = true;
                for (int j = 0; j < want.length; j++) {
                    if (dict.getOrDefault(want[j], 0) < number[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_131127_할인행사 programmers131127_할인행사 = new Programmers_131127_할인행사();

        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {
                "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"
        };
        System.out.println(programmers131127_할인행사.solution(want, number, discount));
    }
}
