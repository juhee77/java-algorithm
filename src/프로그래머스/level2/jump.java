//https://programmers.co.kr/learn/courses/30/lessons/12980 -- 점프와 순간이동 <0408>
package 프로그래머스.level2;
import java.util.*;

public class jump {

    public int solution(int n) {
        int ans = 1;
        while(n>=2){
            if(n%2==0) n/=2;
            else {
                n=(n-1)/2;
                ans++;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        System.out.println(new jump().solution(5));
    }
}
