package 프로그래머스.level1;

import java.util.ArrayList;
import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/77484?language=java --로또의 최고 순위와 최저 순위
public class lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        ArrayList<Integer> win= new ArrayList<>();
        for (int num:win_nums) win.add(num);
        int max=0,min=0;
        for(int i=0;i<lottos.length;i++)
            if(lottos[i]==0) max++;
            else if(win.contains(lottos[i])){
                max++;
                min++;
            }
        min=(min>=2)?min:6;
        max=(max>=2)?max:6;
        return new int[] {7-min,7-max}; //반대일 수도..
    }
    public static void main(String args[]){
        System.out.println(Arrays.toString(new lotto().solution(new int[]{44, 1, 0, 0, 31, 25},new int[] {31, 10, 45, 1, 6, 19})));
    }
}
