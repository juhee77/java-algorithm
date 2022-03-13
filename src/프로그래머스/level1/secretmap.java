package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/17681
import java.util.Arrays;

public class secretmap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            int temp1=arr1[i],temp2=arr2[i];
            String tempAns="";

            for(int j=0;j<n;j++){
                System.out.println(temp1%2+"   "+temp2%2);
                if(temp1%2+temp2%2>=1)tempAns="#"+tempAns;
                else tempAns=" "+tempAns;
                temp1/=2;
                temp2/=2;
            }
            System.out.println(tempAns);
            answer[i]=tempAns;
        }
        return answer;
    }
    public static void main(String args[]){
        secretmap ex=new secretmap();
        int[] a={9, 20, 28, 18, 11};
        int[] b={30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(ex.solution(5,a,b)));
    }
}
