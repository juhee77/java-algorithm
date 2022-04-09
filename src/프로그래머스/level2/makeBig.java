package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/42883 -- 큰 수 만들기 <0410>

public class makeBig {
    String max ="0";
    /*런타임 에러*/
    public void combination (int k, char[] temp,char[] arr, int current, int start){
        if (k == current) {
            String tmp="";
            for(int i=0;i<k;i++)tmp+=temp[i];
            if(max.compareTo(tmp)<=0) max=tmp;
        } else {
            for (int i = start; i < arr.length; i++) {
                temp[current] = arr[i];
                combination(k, temp, arr, current + 1, i + 1);
            }
        }
    }

    public String solution(String number, int k) {
        String answer = "0";
        char[] numberC = number.toCharArray();
        combination(number.length()-k,new char[number.length()-k],numberC,0,0);
        //combination(number.length()-k,new char[number.length()-k+1],numberC,0,0);
        return max;
    }
    public static void main(String args[]){
        System.out.println(new makeBig().solution("1231234",3));
        System.out.println(new makeBig().solution("4177252841",4));
    }
}
