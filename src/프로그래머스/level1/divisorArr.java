package 프로그래머스.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class divisorArr {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        List<Integer> list = (ArrayList<Integer>)Arrays.stream(arr).boxed().collect(Collectors.toList());
        for(Integer e : arr)
            if(e%divisor!=0) list.remove(e);

        return list.size()>=1? list.stream().mapToInt(i->i).toArray():new int[] {-1};
    }
    public int[] solution_short(int[] arr, int divisor){
        return Arrays.stream(arr).filter(factor -> factor%divisor==0).toArray();
    }
    public static void main(String args[]){
        divisorArr ex= new divisorArr();
        int a[] = { 3,5,10,5};
        System.out.println(Arrays.toString(ex.solution(a,5)));
    }
}
