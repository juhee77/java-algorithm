import java.util.*;

class Binary0205  {
    public static int solution(int n) {
        int answer = 0;
        String dec = "";
        while(3<=n){
            String temp = Integer.toString(n%3);
            n = n/3;
            dec = dec.concat(temp);
        }
        String temp = Integer.toString(n%3);
        dec = dec.concat(temp);
        int decN = Integer.parseInt(dec);

        int i=1;
        while(10<=decN){
            answer += (decN % 10)*i;
            decN = decN / 10;
            i*=3;
        }
        answer += decN*i;
        return answer;
    }

    public static void main(String args[]){
        int numbers= 45;
        System.out.println(solution(numbers));
        int numbers1= 125;
        System.out.println(solution(numbers1));
    }
}