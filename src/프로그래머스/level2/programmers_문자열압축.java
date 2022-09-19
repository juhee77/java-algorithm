package 프로그래머스.level2;


public class programmers_문자열압축 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if(s.length()==1) return 1;
        for (int i = 1; i < s.length() ; i++) { // 문자열의 길이
            int tmpmin = 0;
            String temp = " ";
            String tempmin_s=" ";
            int flag = 0;

            for (int k = 0; k < s.length(); k = k + i) {
                if (k + i > s.length()) break;
                if (temp.equals(s.substring(k, k + i))) {
                    if (flag==0) tmpmin += 1;
                    flag++;
                    tempmin_s = String.valueOf(flag);

                    int tenf=0;
                    for(int q=0;q<tempmin_s.length();q++){
                        if(tempmin_s.substring(q,q+1).equals("9"))tenf = 1;
                        else {
                            tenf=0;
                            break;
                        }
                    }
                    if(tenf==1)tmpmin++;
                     //개수가 10,100,1000 자리수를 넘어가는경우
                } else {
                    tmpmin += i;
                    temp = s.substring(k, k + i);
                    flag = 0;
                }
            }
            tmpmin += s.length() % i; //뒤의 남은 문자열
            answer = Math.min(tmpmin, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new programmers_문자열압축().solution("aabbaccc"));
        System.out.println(new programmers_문자열압축().solution("ababcdcdababcdcd"));
        System.out.println(new programmers_문자열압축().solution("abcabcdede"));
        System.out.println(new programmers_문자열압축().solution("abcabcabcabcdededededede"));
        System.out.println(new programmers_문자열압축().solution("ababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdabababcdcdab"));
        System.out.println(new programmers_문자열압축().solution("xababcdcdababcdcd"));

        /*
        "aabbaccc"	7
"ababcdcdababcdcd"	9
"abcabcdede"	8
"abcabcabcabcdededededede"	14
"xababcdcdababcdcd 17
         */
    }
}
