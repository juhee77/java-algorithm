package 프로그래머스.level2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class 가장큰수Final {
    /*public static void swap(int[] arr,int a, int b){
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
                {
                    int temp=numbers[j-1];
                    numbers[j-1]=numbers[j];
                    numbers[j]=temp;
                }
            }
            answer+=Integer.toString(numbers[i]);
        }

        System.out.println(Arrays.toString(numbers));
        if(answer.substring(0)=="0") return "0";

        //if(answer.substring(0)=="0") return "0";
        //return answer;

        return Integer.toString(Integer.parseInt(answer));
    }*/

    public static String solution(int[] numbers) {
        String[] nums = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(nums, Collections.reverseOrder());
        System.out.println(Arrays.toString(nums));
        String answer="";

        for(int j=0;j<numbers.length-1;j++){
            if(j<=numbers.length-2 && nums[j].substring(0,1).equals(nums[j+1].substring(0,1))){
                for(int i=numbers.length-1;j<i;i--) {
                    if (Integer.parseInt(nums[i] + nums[i - 1]) > Integer.parseInt(nums[i - 1] + nums[i])) {
                        String temp = nums[i - 1];
                        nums[i - 1] = nums[i];
                        nums[i] = temp;
                    }
                }
            }
            //answer+=nums[numbers.length-j-1];
        }

        /*
        for(int i=0;i<nums.length-1;i++){
            if(nums[i].substring(0,1).equals(nums[i+1].substring(0,1))){
                //System.out.println(nums[i].substring(0,1)+nums[i+1].substring(0,1));
                if(Integer.parseInt(nums[i]+nums[i+1])<Integer.parseInt(nums[i+1]+nums[i])){
                    //System.out.println(nums[i].substring(0)+nums[i+1].substring(0));
                    String temp=nums[i+1];
                    nums[i+1]=nums[i];
                    nums[i]=temp;
                }
            }
        }
         */
        //System.out.println(Arrays.toString(nums));
        //String answer=String.join("",nums);
        answer=String.join("",nums);
        if(answer.substring(0,1).equals("0")) return "0";
        return answer;

    }


        public static void main(String args[]){
        int[] a={3, 30, 34, 5, 9};
        System.out.println(solution(a));
        int[] b={2,20,200};
        System.out.println(solution(b));
            int[] c={6, 10, 2};
            System.out.println(solution(c));
    }
}
