package 프로그래머스.level1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class 이상한문자만들기 {
    public String solution(String s) {
        String[] a=s.split(" ",-1); //-1제한없이 나눌수 있을때까지 나눈다
        //1이거나 2.이런식으로 하면 1번 ,2번 나눠짐
        for(int j=0;j<a.length;j++) {
            String[] temp=a[j].split("");
            for (int i = 0; i <temp.length; i++){
                if(i%2==0)temp[i] = temp[i].toUpperCase();
                else temp[i]=temp[i].toLowerCase();
            }
            a[j]= Arrays.stream(temp).collect(Collectors.joining());
        }
        return Arrays.stream(a).collect(Collectors.joining(" "));
    }

    
    public String solution2(String s){
        String[] a=s.split(""); //-1제한없이 나눌수 있을때까지 나눈다
        //1이거나 2.이런식으로 하면 1번 ,2번 나눠짐
        String answer="";
        int cnt=0;

        for(String element: a){
            cnt = element.equals(" ")?0:cnt+1;
            answer += cnt%2==0 ? element.toLowerCase():element.toUpperCase();
        }
        return answer;

    }


    public static void main(String args[]){
        이상한문자만들기 ex=new 이상한문자만들기();
        System.out.println(ex.solution2("try hello world"));
    }
}
