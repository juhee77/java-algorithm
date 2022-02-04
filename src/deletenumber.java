import java.util.*;
/* https://programmers.co.kr/learn/courses/30/lessons/86051?language=java*/
class deletenumber {
    public static int solution(int[] numbers) {
        int answer = -1;
        int sum=1+2+3+4+5+6+7+8+9;
        for(int i=0;i<numbers.length;i++){
            sum-=numbers[i];
        }
        ///System.out.print(sum);
        return sum;
    }
    public static void main(String args[]){
        int[] numbers= {1,2,3,4,6,7,8,0};
        System.out.println(solution(numbers));
        int[] numbers1= {5,8,4,0,6,7,9};
        System.out.println(solution(numbers1));
    }
}

