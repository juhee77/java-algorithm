package 프로그래머스.level2;

import java.util.Stack;

public class programmers_60058_괄호변환 {
    public String solution(String p) {
        return  find(p);
    }

    public String find(String p){
        if(check(p)) return p;//1단계
        int nowpoint= divide(p); // u,v 갈라지는 지점(2단계)
        //System.out.println(nowpoint);
        String u = p.substring(0,nowpoint+1);
        String v= p.substring(nowpoint+1);
        //System.out.println(p+"        "+ u+" "+v);

        if(check(u)) return u+find(v);
        else{
            String temp = "("+find(v)+")";
            String reversu = "";
            for(int i=1;i<u.length()-1;i++) {
                if(u.charAt(i)==')') reversu+='(';
                else reversu+=")";
            }
            return temp + reversu;
        }
    }

    private int divide(String p){
        int cnt[] = new int[2];
        int point = 1;
        for(;point<=p.length();point++){
            if(p.charAt(point-1)=='(') cnt[0]++;
            else if(p.charAt(point-1)==')') cnt[1]++;
            if(cnt[0]==cnt[1])return point-1;
        }
        return -1;//오류
    }



    private boolean check(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack.push('(');
            else if( s.charAt(i)==')'){
                if(stack.size()==0)return false;
                else stack.pop();
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new programmers_60058_괄호변환().solution("(()())()"));
        System.out.println(new programmers_60058_괄호변환().solution(""));
        System.out.println(new programmers_60058_괄호변환().solution("()))((()"));
        System.out.println(new programmers_60058_괄호변환().solution(")()()()("));
    }
}
