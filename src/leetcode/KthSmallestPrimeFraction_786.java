package leetcode;

import java.util.ArrayList;
import java.util.Collections;

class KthSmallestPrimeFraction_786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        ArrayList<double[]> doubles = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                doubles.add(new double[]{((double) arr[i] / arr[j]), (double) arr[i], (double) arr[j]});
            }
        }


        Collections.sort(doubles, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return 1;
            }else{
                return -1;
            }
        });

        int mid = (doubles.size()) / 2;

        return new int[]{(int)doubles.get(mid)[0], (int)doubles.get(mid)[1]};



    }
}