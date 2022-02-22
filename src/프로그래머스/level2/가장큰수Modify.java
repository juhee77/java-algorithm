package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/42746
import java.util.Arrays;
//시간 초과남
public class 가장큰수Modify {
    public static void swap(int[] arr,int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static String solution(int[] numbers) {
        String answer = "";
        for(int i=0;i<numbers.length;i++){
            for(int j=numbers.length-1;i+1<=j;j--){
                String beforenum=String.valueOf(numbers[j-1]);
                String backnum=String.valueOf(numbers[j]);
                if(Integer.parseInt(beforenum+backnum)<Integer.parseInt(backnum+beforenum))
                    swap(numbers,j-1,j);
            }
            answer+=Integer.toString(numbers[i]);
        }
        System.out.println(Arrays.toString(numbers));
        return answer;
    }
    public static void main(String args[]){
        int[] a={3, 30, 34, 5, 9};
        System.out.println(solution(a));
        int[] b={6, 10, 2};
        System.out.println(solution(b));
    }
}
