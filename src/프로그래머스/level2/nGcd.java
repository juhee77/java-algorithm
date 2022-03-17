package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/12953 -- N개의 최소공배수
import java.lang.reflect.Array;
import java.util.Arrays;

public class nGcd {
    public int gcd(int n,int m){
        if(m==0) return n;
        else return gcd(m,n%m);
    }
    public int solution(int[] arr) {
        int answer = 0;
        //System.out.println(arr.length+Arrays.toString(arr));
        int p1=0,p2=0;
        if(arr.length>2){
            p1=solution(Arrays.copyOfRange(arr,0,arr.length/2));
            p2=solution(Arrays.copyOfRange(arr,arr.length/2,arr.length));
            return p1*p2/gcd(p1,p2); //자료형 범위 넘어갈수 있음 (나누기 먼저 하면 가능함)
        }
        else if(arr.length==2){
            return arr[0]*arr[1]/gcd(arr[0],arr[1]);
        }
        else if(arr.length==1){
            return arr[0];
        }

        return answer;
    }
    public static void main(String args[]){
        nGcd ex=new nGcd();
        int a[]={1,2,3};
        System.out.println(ex.solution(a));
    }

}
