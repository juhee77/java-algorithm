package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/12935
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class removeSmallnum {
    public int[] solution(int[] arr) {
        int min=0;
        if(arr.length == 1)
            return new int[] {-1};
        else{
            for(int i=1;i<arr.length;i++){
                if(arr[min]>arr[i])
                    min= i;
            }
        }

        ArrayList<Integer> list = (ArrayList<Integer>)Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.remove(min);

        return list.stream().mapToInt(i->i).toArray();
    }
    public int[] solution2(int[] arr) {
        int min=0;
        if(arr.length == 1)
            return new int[] {-1};
        else
            for(int i=1;i<arr.length;i++){
                if(arr[min]>arr[i])
                    min= i;
            }

        int answer[] = new int[arr.length-1];
        for(int i=0;i<arr.length;i++){
            if(min==i) continue;
            else if(min<i) answer[i-1]=arr[i];
            else answer[i]=arr[i];
        }
        return answer;
    }

    //short
    public int[] solution4(int[] arr) {
        if (arr.length <= 1) return new int[]{ -1 };
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }

    public static void main(String args[]){
        removeSmallnum ex = new removeSmallnum();
        int[] arr={4,3,2,1};
        System.out.println(Arrays.toString(ex.solution(arr)));
    }
}
