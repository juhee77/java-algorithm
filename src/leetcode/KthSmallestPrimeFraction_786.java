package leetcode;

import java.util.ArrayList;
import java.util.Collections;

class KthSmallestPrimeFraction_786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        ArrayList<double[]> doubles = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                doubles.add(new double[]{((double) arr[i] / arr[j]), (double) arr[i], (double) arr[j]});
            }
        }

        Collections.sort(doubles, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            }else{
                return 1;
            }
        });
        return new int[]{(int)doubles.get(k-1)[1], (int)doubles.get(k-1)[2]};
    }
}