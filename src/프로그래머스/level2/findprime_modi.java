package 프로그래머스.level2;

import java.util.Arrays;
import java.util.Collections;

//https://programmers.co.kr/learn/courses/30/lessons/42839 -- 소수 찾기 <0323>
public class findprime_modi {

    public int solution(String numbers) {
        int answer = 0;
        String[] num = numbers.split("");
        Arrays.sort(num,Collections.reverseOrder());

        System.out.println(Arrays.toString(num));

        String[] allNum = new String[(int) Math.pow(2,num.length)*2];

        for(int i=0;i<allNum.length;i=i+2){
            String temp=Integer.toBinaryString(i/2);

            String tempString ="";
            String reverseString ="";
            for(int j=0;j<temp.length();j++)
                if(temp.charAt(j)=='1'){
                    tempString= tempString+num[j];
                    reverseString = num[j] + reverseString;
                }

            allNum[i] = (tempString=="")? "0":tempString;
            allNum[i+1] = (reverseString=="")? "0":reverseString;

        }
        String[] allN= Arrays.stream(allNum).distinct().toArray(String[] ::new);
        Arrays.sort(allN);
        System.out.println(Arrays.toString(allNum));


        //가장 큰 숫자 까지의 소수(에라토스 테네스의 체 이용-- 에라토스 테네스의 체는 배열에
        // n에 대한 수 까지의 소수인지 아닌지에 대한 배열이 있어서 이를 이용)
        int maxNum=Integer.parseInt(allN[allN.length-1]);
        int prime[] = new int[maxNum+1];
        prime[0]=prime[1]=1; //0인게 소수
        int cnt=0;//2

        for(int i=2;i<maxNum;i++){
            if(prime[i]==1) continue;
            for(int j=i*i;j<maxNum+1;j+=i) prime[j]=1; //에라토스 테네스의 체 사용
        }

        /*소수 구하는 부분 끝 */

        for(int i=0;i<allN.length;i++)
            if(prime[Integer.parseInt(allN[i])]==0)answer++;

        return answer;
    }

    public static void main(String args[]){
        System.out.println(new findprime_modi().solution("1231"));
    }

}
