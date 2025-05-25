package 프로그래머스.level2;

import java.util.HashSet;

public class Programmers_131701_연속부분수열합의개수 {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();

        int numSize = elements.length;
        for (int i = 1; i <= numSize; i++) {
            int tempSum = 0;
            for (int j = 0; j < i; j++)
                tempSum += elements[j];

            set.add(tempSum);
            //System.out.println("HOLD "+tempSum);
            for (int j = 0; j < numSize - 1; j++) {
                tempSum += elements[(i + j) % numSize];
                tempSum -= elements[(j + numSize) % numSize];
                //System.out.println(((i+j)%numSize)+" "+((j+numSize)%numSize)+" "+tempSum);
                set.add(tempSum);
            }
        }

//        System.out.println(set);
        return set.size();
    }

    public static void main(String[] args) {
        Programmers_131701_연속부분수열합의개수 programmers131701_연속부분수열합의개수 = new Programmers_131701_연속부분수열합의개수();
        System.out.println(programmers131701_연속부분수열합의개수.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
