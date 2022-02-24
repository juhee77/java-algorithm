package 프로그래머스.level1;

public class _3진법뒤집기 {
    public static int solution(int n) {
        int answer = 0;
        String dec = "";
        while(0<n){
            dec= dec + (n%3);
            n = n/3;
        }

        /*
        string 형이라 그냥 +로 처리해도 된다.
        나는 처음부터 뒤집어 나오도록 코딩 했는데 이렇게 하지 않고
        일반적 모양으로 3진법 계산하고
        진법계산
        int x;//계산할 숫자
        String re="";
        while(x>0){
            re = (x % radix(진법계산할 수) +re;
            x /= radix(진법계산할 수)
        }
        로 가능하다.

        new StringBuilder(dec).reverse().toString(); 해서 뒤집을수도 있다.

         그리고 아래처럼 직접 10진법 계산하지 않고
         Integer.parseInt(dec,3)하면 3진법을 10진법으로 계산할 수 있다.
         radix는 기수로 숫자형의 문자열을 첫번째 값으로 받고 변환할 진수를 입력하여 integer형으로 진법에 맞게 반환해 줄 수 있다.

        Integer.parseInt("1000",3);*/

        System.out.println(dec);

        Long decN = Long.parseLong(dec);

        int i=1;
        while(0<decN){
            answer += (decN % 10)*i;
            decN = decN / 10;
            i*=3;
        }
        return answer;
    }
    public static void main(String args[]){
        System.out.println(solution(45));
        System.out.println(solution(125));
    }
}
