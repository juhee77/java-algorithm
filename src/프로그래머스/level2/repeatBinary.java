package 프로그래머스.level2;

//https://programmers.co.kr/learn/courses/30/lessons/70129 -- 이진 변환 반복하기 <0406>
import java.util.Arrays;

public class repeatBinary {
    public int[] solution(String s) {
        int repeatTime =0;
        int deleteZero=0;
        while(true){
            if(s.equals("1")) break;
            int oneCnt = oneCount(s);
            deleteZero += (s.length()-oneCnt);
            s =  Integer.toBinaryString(oneCnt);
            repeatTime++;
        }
        return new int[] {repeatTime,deleteZero};
    }
    public int oneCount(String s){
        int cnt=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='1')cnt++;
        return cnt;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(new repeatBinary().solution("110010101001")));
    }
}
