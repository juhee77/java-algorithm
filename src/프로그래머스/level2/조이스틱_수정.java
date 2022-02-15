package 프로그래머스.level2;

import java.util.ArrayList;

public class 조이스틱_수정 {
    public static int solution(String name) {
        int answer = 0;

        char[] charName=name.toCharArray();
        ArrayList<Integer> whe=new ArrayList();
        /*문자에 대한*/
        for(int i=0;i<charName.length;i++){
            int charId=Character.getNumericValue(charName[i]);
            //System.out.print(charName[i]+" "+charId+"   ");
            //A부터 시작하는경우
            int greed_A=charId-10;
            int greed_Z=35-charId+1;
            //if(i>0 && Character.getNumericValue(charName[i-1])==10){
            //    greed_Z=35-charId;
            //}
            //System.out.println(Math.min(greed_A,greed_Z));
            answer = answer + Math.min(greed_A,greed_Z);

            if(charId!=10)
                whe.add(i);

        }
        //System.out.println("answer "+answer+" length "+charName.length+" sieze "+whe.size());

        /*위치에 대한*/
        /*
        int ret=0;
        for(int i=0;i< whe.size();i++){
            int forward=whe.get(i)-ret;
            int backward=charName.length-whe.get(i);
            answer+=Math.min(forward,backward);
            ret=whe.get(i);
        }
        */

        if(whe.size()!= charName.length) {
            int maxStart = -1;
            int maxEnd = charName.length + 1;
            int max = 0;
            for (int i = 0; i < whe.size() - 1; i++) {
                if (whe.get(i + 1) - whe.get(i) > max && whe.get(i + 1) - whe.get(i) > 1) {
                    max = whe.get(i + 1) - whe.get(i);
                    maxStart = whe.get(i);
                    maxEnd = whe.get(i + 1);
                    //System.out.println(maxStart+":"+maxEnd);
                }
            }
            answer = answer + Math.min(charName.length - 1, 2 * maxStart + 1 + charName.length-1 - maxEnd);
        }
        else
            answer = answer + charName.length - 1;
        //System.out.println();
        return answer;
    }
    public static void main(String args[]){
        //System.out.println(Character.getNumericValue('A'));
        String a="JEROEN";
        System.out.println(solution(a));
        String b="JAZ";
        System.out.println(solution(b));
    }
}
