package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/17682
import java.util.ArrayList;

public class dartgame {
    public int solution(String dartResult) {
        int answer = 0;
        int index = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);

         while(index!=dartResult.length()){
            if(Character.isDigit(dartResult.charAt(index))){
                int num =  Character.getNumericValue(dartResult.charAt(index));
                index++;
                while(index<dartResult.length()){
                    if(Character.isDigit(dartResult.charAt(index))){
                        if(num==1 && Character.getNumericValue(dartResult.charAt(index))==0){
                            num=10;
                            index++;
                        }
                        else break;
                    }
                    switch (dartResult.charAt(index)){
                        case 'S':
                            ans.add(num);
                            break;
                        case 'D':
                            ans.add(num*num);
                            break;
                        case 'T':
                            ans.add(num*num*num);
                            break;
                        case '*':
                            int size=ans.size()-1;
                            ans.set(size,ans.get(size)*2);
                            ans.set(size-1,ans.get(size-1)*2);
                            break;
                        case '#':
                            ans.set(ans.size()-1,ans.get(ans.size()-1)*-1);
                            break;
                        default:
                            //System.out.println(index +" "+ num+" " +dartResult.charAt(index)+"default");
                            break;
                    }
                    index++;
                }
            }
        }
         //System.out.println(ans);
        return ans.stream().mapToInt(Integer::intValue).sum();
    }
    public static void main(String args[]){
        dartgame ex = new dartgame();
        System.out.println(ex.solution("1S2D*3T"));
        System.out.println(ex.solution("1D2S#10S"));
    }
}
