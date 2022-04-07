package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/12951 -- JadenCase 문자열 만들기 <0407>
public class JadenCase {
    public String solution(String s) {
        //맨 처음
        if(97<=s.charAt(0) && s.charAt(0)<=122)
            s = s.substring(0,1).toUpperCase()+s.substring(1);
        //그 이후
        int state =0;// -1이면 전글자 공백, 0이면 전글자 글자 ,
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==' ') state = -1;
            else if(state==-1){
                s = s.substring(0,i)+s.substring(i,i+1).toUpperCase()+s.substring(i+1);
                state =0;
            }
            else if(state==0){
                s = s.substring(0, i) + s.substring(i, i + 1).toLowerCase() + s.substring(i + 1);
                state =0;
            }
        }

        return s;
    }

    public String solution2(String s){
        //프로그래머스 풀이
        String answer = "";
        String[] ans = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : ans) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }
    public static void main(String args[]){
        System.out.println(new JadenCase().solution("3people unFollowed me"));
    }
}
