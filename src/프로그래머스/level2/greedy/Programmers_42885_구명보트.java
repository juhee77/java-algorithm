package 프로그래머스.level2.greedy;

import java.util.Arrays;

public class Programmers_42885_구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;

        int boatCnt = 0;
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                boatCnt++;
                start++;
                end--;
            } else if (people[end] <= limit) {
                boatCnt++;
                end--;
            }
        }
        return boatCnt;
    }

    public static void main(String[] args) {
        Programmers_42885_구명보트 programmers42885_구명보트 = new Programmers_42885_구명보트();
        System.out.println(programmers42885_구명보트.solution(new int[]{70, 50, 80, 50}, 100));
    }
}
