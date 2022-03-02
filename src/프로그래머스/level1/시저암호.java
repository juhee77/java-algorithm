package 프로그래머스.level1;

public class 시저암호 {
    public String solution(String s, int n) {
        String answer = "";
        String a[]=s.split("");
        for(int i=0;i<a.length;i++){
            if(a[i].equals(" ")) answer+= a[i];
            else {
                int temp = a[i].charAt(0) + n;
                if (65 <= temp - n && temp - n <= 90) {
                    if (temp > 90) temp = 65 + (temp - 91);
                } else if (97 <= temp - n && temp - n <= 122) {
                    if (temp > 122) temp = 97 + (temp - 123);
                }
                answer += Character.toString(temp);
            }
        }
        return answer;
    }
    public String solution2(String s,int n ){
        String ans="";
        for(char element:s.toCharArray()){
            if(element==' ') ans += element;
            else if(element >= 'a' && element<='z')ans+=(char)('a'+(element-'a')%26);
            else ans+= (char)('A'+(element+n-'A')%26);
        }
        return ans;

    }

    public static void main(String args[]){
        시저암호 a =new 시저암호();
        System.out.println(a.solution("Z     Y",2));
        System.out.println(a.solution("z",3));

        시저암호 cc =new 시저암호();
        System.out.println(cc.solution("AB", 1));
        System.out.println(cc.solution("z", 1));
        System.out.println(cc.solution("Z", 10));
        System.out.println(cc.solution("a B z", 4));
        System.out.println(cc.solution(" aBZ", 20));
        System.out.println(cc.solution("y X Z", 4));
        System.out.println(cc.solution(" . h z", 20));

    }
}
