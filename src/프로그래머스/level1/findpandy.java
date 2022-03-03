package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/12916
import java.util.Locale;

public class findpandy {
    boolean solution(String s) {
        /*
        s=s.toLowerCase();
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='p') cnt++;
            else if(s.charAt(i)=='y') cnt--;
        }
        return cnt==0;
        */
        int cntp=0,cnty=0; //변수 하나로 처리하는 방법도 있다.  cnt=0;
        for(int i=0;i<s.length();i++){
            String temp=s.substring(i,i+1);
            if(temp.equals("p")|| temp.equals("P"))
                cntp++; //cnt++;
            else if (temp.equals("y")||temp.equals("Y"))
                cnty++; //cnt--;
        }
        return cnty==cntp ? true : false; //return cnt==0;
    }

    public static void main(String args[]){
        findpandy ex=new findpandy();
        System.out.println(ex.solution("pPoooyY"));
        //short coding
        String s="ddssffFYyy";
        s=s.toUpperCase();
        /*프로그래머스*/
        int i=5;

        System.out.println(Math.ceil((double)i/2));
        //System.out.println(s.chars().filter(e->'P'==e).count() == s.chars().filter(e->'Y'==e).count());
    }
}
