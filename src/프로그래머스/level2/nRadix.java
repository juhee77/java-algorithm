package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/17687 -- [3차]n진수 게임 <0409>
public class nRadix {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String allAns = "0";

        for(int i=1;allAns.length()<m*t;i++){
            StringBuilder sb = new StringBuilder();
            int temp =i;
            while(temp>0){
                if(temp % n < 10) sb.append(temp%n);
                else sb.append((char)(temp%n-10+'A'));
                temp/=n;
            }
            allAns += sb.reverse().toString();
        }

        for(int j=p-1;j<allAns.length() ;j=j+m) {
            answer += Character.toString(allAns.charAt(j));
            if(answer.length()==t) break;
        }
        return answer;
    }
    public static void main(String args[]){
        System.out.println(new nRadix().solution(2,4,2,1));
        System.out.println(new nRadix().solution(16,16,2,1));
        System.out.println(new nRadix().solution(16,16,2,2));

    }
}
