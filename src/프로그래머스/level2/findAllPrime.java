package 프로그래머스.level2;

import java.util.Arrays;
import java.util.Collections;
//hash set으로 다시 풀어보기
//https://programmers.co.kr/learn/courses/30/lessons/42839 -- 소수 찾기 <0323>
public class findAllPrime {

    public int solution(String numbers) {
        int answer = 0;
        String[] num = numbers.split("");
        Arrays.sort(num,Collections.reverseOrder());

        System.out.println(Arrays.toString(num));
        int fac=1;
        for(int i=1;i<num.length+1;i++) fac*=i;
        int[] allNum = new int[(int) Math.pow(2,num.length)*fac];
        System.out.println(allNum.length);

        int i=0;
        int point=0;
        int k=0;
        for(int r=0;r<fac/2+1;r++) {
            if(k==num.length-1){
                point++;
                if(point == num.length-1)break;
                k=point+1;
            }else {
                k++;
            }
            String x = num[k];
            num[k] = num[point];
            num[point] = x;
            System.out.println(Arrays.toString(num));
            /*dddddd 수정...*/
            for (int q=0; q < Math.pow(2,num.length); q++) {
                String temp = Integer.toBinaryString(q);
                //System.out.println(temp+" "+temp.length());
                String tempString = "";
                String reverseString ="";
                for (int j = 0; j < temp.length(); j++)
                    if (temp.charAt(temp.length() - j - 1) == '1'){
                        tempString = tempString + num[j];
                        reverseString = num[j] + reverseString;
                    }
                allNum[i] = (tempString == "") ? 0 : Integer.parseInt(tempString);
                allNum[i+1] = (reverseString=="")? 0:Integer.parseInt(reverseString);
                i+=2;
            }
            System.out.println("  "+k);

            x=num[k];
            num[k]=num[point];
            num[point]=x;
            System.out.println("    "+Arrays.toString(num));
        }
        System.out.println(Arrays.toString(allNum));
        int[] allN= Arrays.stream(allNum).distinct().toArray();
        Arrays.sort(allN);
        System.out.println(Arrays.toString(allN));


        //가장 큰 숫자 까지의 소수(에라토스 테네스의 체 이용-- 에라토스 테네스의 체는 배열에
        // n에 대한 수 까지의 소수인지 아닌지에 대한 배열이 있어서 이를 이용)
        int maxNum=allN[allN.length-1];
        int prime[] = new int[maxNum+1];
        prime[0]=prime[1]=1; //0인게 소수

        for(double e=2;e<= maxNum;e++){
            if(prime[(int)e]==1) continue;
            for(double j=e*e;j<maxNum+1;j+=e) prime[(int)j]=1; //에라토스 테네스의 체 사용
        }

        /*소수 구하는 부분 끝 */

        for(int e=0;e<allN.length;e++)
            if(prime[allN[e]]==0){answer++;
            System.out.println(allN[e]);
            }


        return answer;
    }

    public static void main(String args[]){
        System.out.println(new findAllPrime().solution("1231"));
    }

}
