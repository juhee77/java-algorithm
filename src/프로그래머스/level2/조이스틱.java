package 프로그래머스.level2;

public class 조이스틱 {
    public static int solution(String name) {
        int answer = 0;
        char[] charName=name.toCharArray();
        int tp=0;//이전위치 저장용
        for(int i=0;i<charName.length;i++){
            int charId=Character.getNumericValue(charName[i]);

            int greed_A;
            if(tp==0) greed_A=charId-10;//A부터 시작하는경우
            else greed_A=charId-10+1;//A위치로 이동시켜서 다시 세는경우

            int greed_Z;
            if(tp==35) greed_Z=35-charId;
            else greed_Z=35-charId+1;

            int greed;
            if(tp<charId) greed=charId-tp;
            else if (tp==charId) greed = 0;
            else greed = tp-charId;

            answer = answer + Math.min(Math.min(greed_A,greed_Z),greed);
            tp=charId;
        }
        return answer;
    }
    public static void main(String args[]){
        System.out.println(Character.getNumericValue('A'));
        String a="JEROEN";
        System.out.println(solution(a));
        String b="JAN";
        System.out.println(solution(b));
    }
}

