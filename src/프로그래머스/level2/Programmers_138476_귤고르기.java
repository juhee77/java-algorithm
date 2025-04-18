package 프로그래머스.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Programmers_138476_귤고르기 {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int temp : tangerine) {
            set.put(temp, set.getOrDefault(temp, 0) + 1);
        }

        List<int[]> setList = new ArrayList<>();
        for (int key : set.keySet()) {
            setList.add(new int[]{key, set.get(key)});
        }
        setList.sort((o1, o2) -> o2[1] - o1[1]);

        int variety = 0;
        for (int[] tempFruit : setList) {
            k -= tempFruit[1];
            variety++;
            if (k <= 0) break;
        }

        return variety;
    }

    public static void main(String[] args) {
        Programmers_138476_귤고르기 programmers138476_귤고르기 = new Programmers_138476_귤고르기();
        System.out.println(programmers138476_귤고르기.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }
}
