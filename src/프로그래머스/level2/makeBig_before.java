package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/42883 -- 큰 수 만들기 <0410>
import java.util.ArrayList;

public class makeBig_before {
    ArrayList<String> allC= new ArrayList<>();
    public void combination (int k, char[] temp,char[] arr, int current, int start){
        if (k == current) {
            String tmp="";
            for(int i=0;i<k;i++)tmp+=temp[i];
            allC.add(tmp);
        } else {
            for (int i = start; i < arr.length; i++) {
                temp[current] = arr[i];
                combination(k, temp, arr, current + 1, i + 1);
            }
        }
    }

    public String solution(String number, int k) {
        String answer = "0";
        char[] numberC = number.toCharArray();
        combination(number.length()-k,new char[number.length()-k],numberC,0,0);

        for(int i=0;i<allC.size();i++){
            String combi = allC.get(i);
            if(Integer.parseInt(answer) <= Integer.parseInt(combi)) answer = combi;
        }

        return answer;

    }
    public static void main(String args[]){
        System.out.println(new makeBig_before().solution("1231234",3));
        System.out.println(new makeBig_before().solution("4177252841",4));
    }
}
