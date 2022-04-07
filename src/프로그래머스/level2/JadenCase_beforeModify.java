package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/12951 -- JadenCase 문자열 만들기 <0407>
//문제 공백을 통째로 제거함 "   "을 " "으로 바꾸는것과 같음
public class JadenCase_beforeModify {
    public String solution(String s) {
        String answer = "";
        String ans[] = s.split(" ");
        for(int i=0;i<ans.length;i++){
            if(97<=ans[i].charAt(0) && ans[i].charAt(0)<=122)
                ans[i] = ans[i].substring(0,1).toUpperCase()+ans[i].substring(1);

            for (int j = 1; j < ans[i].length(); j++)
                if (65 <= ans[i].charAt(j) && ans[i].charAt(j) <= 90)
                    ans[i] = ans[i].substring(0, j) + ans[i].substring(j, j + 1).toLowerCase() + ans[i].substring(j + 1);

            answer += ans[i]+" ";
        }
        return answer.trim();
    }
    public static void main(String args[]){
        System.out.println(new JadenCase_beforeModify().solution("3people unFollowed me"));
    }
}

