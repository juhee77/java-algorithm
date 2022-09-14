package 프로그래머스.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        LinkedList<String> q = new LinkedList<>();
        HashSet<String> h = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
            if (q.size() < cacheSize) {
                if (h.contains(cities[i])) {
                    //최근에 나온걸 큐의 가장 뒤로 밀어준다.
                    q.remove(cities[i]);
                    q.add(cities[i]);
                    answer += 1;
                } else {
                    answer += 5;
                    q.add(cities[i]);
                    h.add(cities[i]);
                }
            }
            else {
                if (h.contains(cities[i])) {
                    //최근에 나온걸 큐의 가장 뒤로 밀어준다.
                    q.remove(cities[i]);
                    q.add(cities[i]);
                    answer += 1;
                } else {
                    String rm = q.poll();
                    h.remove(rm);
                    q.add(cities[i]);
                    h.add(cities[i]);
                    answer += 5;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(new 캐시().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
//        System.out.println(new 캐시().solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(new 캐시().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
    }
}
