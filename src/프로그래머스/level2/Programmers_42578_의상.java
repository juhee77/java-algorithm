package 프로그래머스.level2;

import java.util.HashMap;

public class Programmers_42578_의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        for (String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }
        return answer - 1;
    }

    public static void main(String[] args) {
        Programmers_42578_의상 programmers42578_의상 = new Programmers_42578_의상();
        System.out.println(programmers42578_의상.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(programmers42578_의상.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "headgear"}, {"green_turban", "headgear"}}));
    }
}
