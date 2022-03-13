package 프로그래머스.level1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class hadlingString {
    public boolean solution(String s) {
        if((s.length()==4 || s.length()==6) && s.matches("^[0-9]*$") ) return true;
        else return false;
    }
    public static void main(String args[]){
        hadlingString ex= new hadlingString();
        System.out.println(ex.solution("a234"));
    }
}
