package 프로그래머스.level2;

import java.util.Arrays;

public class 가장큰수 {
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
                int[] beforedigit= Arrays.stream(beforenum.split("(?<=.)")).mapToInt(Integer::parseInt).toArray();
                int[] backdigit= Arrays.stream(backnum.split("(?<=.)")).mapToInt(Integer::parseInt).toArray();
                if(beforedigit[0]<backdigit[0])
                    swap(numbers,j-1,j);
                else if(beforedigit[0]==backdigit[0]){
                    if(numbers[j-1]-beforedigit[0]*Math.pow(10,beforedigit.length-2)<numbers[j]-backdigit[0]*Math.pow(10,backdigit.length-2))
                        swap(numbers,j-1,j);
                }
            }
            answer+=Integer.toString(numbers[i]);
        }
        System.out.println(Arrays.toString(numbers));
        return answer;
    }
    public static void main(String args[]){
        int[] a={3, 30, 34, 5, 9};
        System.out.println(solution(a));
    }
}
