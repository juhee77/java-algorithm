package 프로그래머스.level2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class greedyBoatAll {
    //https://programmers.co.kr/learn/courses/30/lessons/42885?language=java -- 구명보트
    //이건 여려명인 경우에도 가능함

    public int zeroCnt(int []arr){ // 배에 탄 인원수
        int zero=0;
        for(int i : arr){
            if(i==0) zero++;
        }
        return zero;
    }
    public int[] maxCnt(int []people,int index,int remain,int cnt){
        if(index>=people.length)return people; //종료 포인트

        int max=0; // 카운트 비교용
        int remainPeople[] = people.clone(); //남은 사람들
        remainPeople[index]=0;

        if(remain>=people[index]) {
            int[] nonCheckArr = maxCnt(people,index+1, remain, cnt);
            int nonCheck=zeroCnt(nonCheckArr);
            int[] checkArr = maxCnt(remainPeople, index+1,remain - people[index], cnt + 1);
            int check=zeroCnt(checkArr);
            return nonCheck>check?nonCheckArr:checkArr;
        }
        else {
            return maxCnt(people,index+1, remain, cnt);
        }
        //System.out.println(max);
    }

    public int solution(int[] people, int limit) {
        int cnt=0;
        while(true){
            if(zeroCnt(people)==people.length)break;
            people = maxCnt(people,0,limit,0);
            //System.out.println(Arrays.toString(people));
            cnt ++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        System.out.println(new greedyBoatAll().solution(new int[] {70,50,80,50},100));
    }

}
